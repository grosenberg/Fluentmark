import {createStore} from 'vuex';

// Well-defined constants
const Kind = {
  NACK: -1,
  ACK: 0,
  REQUEST: 1,
  REPLY: 2,
};
const Request = {
  AUTH: 10,
  HELO: 12,
  REFRESH: 20,
  UPDATE: 22,
  HEARTBEAT: 200,
};

// Prototypical message envelope
const Envl = {
  code: Kind.NACK,
  request: Request.HELO,
  target: '',
  msg: {},
  status: '',
  timestamp: 0,
};

// Prototypical message
const Msg = {
  ref: 0,
  target: '',
  content: '',
  line: -1,
  total: -1,
};

export const store = createStore({
  state: {
    socket: {
      ws: null,
      isConnected: false,
      reconnectError: false,
      heartBeatInterval: 50000,
      heartBeatTimer: 0,
    },
    envl: {
      code: -1,
      request: -1,
      target: '',
      status: '',
    },
    msg: {
      content: '',
      line: -1,
      total: -1,
    },
  },

  getters: {
    websocket: (state) => state.socket.ws,
    connected: (state) => state.socket.isConnected,

    envelope: (state) => state.record,
    envlCode: (state) => state.record.code,
    envlRqst: (state) => state.record.request,
    content: (state) => state.record.msg.content,
    line: (state) => state.record.msg.line,
    total: (state) => state.record.msg.total,
  },

  actions: {
    refresh({state}) {
      const e = Object.assign({}, Envl);
      e.code = Kind.REQUEST;
      e.request = Request.REFRESH;
      e.target = state.envl.target;
      e.msg = Object.assign({}, Msg);
      e.timestamp = Date.now();
      state.socket.ws.send(JSON.stringify(e));
    },

    clear({state}) {
      state.msg.content = '';
    },

    send({state}, message) {
      state.socket.ws.send(message);
    },

    sendObj({state}, message) {
      state.socket.ws.sendObj(message);
    },
  },

  mutations: {
    SOCKET_ONMESSAGE(state, message) {
      console.log('Ws message received', message);
      state.envl.code = message.code;
      state.envl.request = message.request;
      state.envl.target = message.target;
      state.envl.status = message.status;
      state.msg.content = message.msg.content;
      state.msg.line = message.msg.line;
      state.msg.total = message.msg.total;
    },

    SOCKET_ONOPEN(state, event) {
      state.socket.ws = event.currentTarget;
      state.socket.isConnected = true;
      console.log('Ws connected');

      state.socket.heartBeatTimer = setInterval(() => {
        state.socket.isConnected && state.socket.ws.sendObj({
          code: Kind.ACK,
          request: Request.HEARTBEAT,
          target: state.envl.target,
          status: 'Heartbeat',
        });
      }, state.socket.heartBeatInterval);
    },

    SOCKET_ONCLOSE(state, event) {
      state.socket.isConnected = false;
      clearInterval(state.socket.heartBeatTimer);
      state.socket.heartBeatTimer = 0;
      console.log('Ws disconnected: ' + new Date());
    },

    SOCKET_ONERROR(state, event) {
      console.error(state, event);
    },
    SOCKET_RECONNECT(state, count) {
      console.info('Ws reconnected...', state, count);
    },
    SOCKET_RECONNECT_ERROR(state) {
      console.error('Ws reconnect error:', state);
      state.socket.reconnectError = true;
    },
  },

  modules: {},
});
