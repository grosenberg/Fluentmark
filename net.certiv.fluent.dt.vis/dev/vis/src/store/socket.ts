import { defineStore } from 'pinia';
import type { SocketStore /*, WebSocketExt */ } from '@/store/types/WsTypes';
import type { MsgEnvelope, MsgBody } from '@/store/types/WsTypes';
import { Kind, Request, Envl, Msg, ProtoMsg } from '@/store/types/WsTypes';

// duplicates the current Fluentmark store
export const useSocketStore = defineStore('socket', {
  state: (): SocketStore => ({
    wsSocket: <WebSocket>{},
    isConnected: false,
    message: '',
    reconnectError: false,
    heartBeatInterval: 50000,
    heartBeatTimer: 0,
    envl: ProtoMsg(),
  }),

  // =============================================

  getters: {
    websocket: (state: SocketStore) => state.wsSocket,
    connected: (state: SocketStore) => state.isConnected,

    envelope: (state: SocketStore) => state.envl,
    envlCode: (state: SocketStore) => state.envl.code,
    envlRqst: (state: SocketStore) => state.envl.request,
    content: (state: SocketStore) => state.envl.msg.content,
    line: (state: SocketStore) => state.envl.msg.line,
    total: (state: SocketStore) => state.envl.msg.total,
  },

  // =============================================

  actions: {
    refresh() {
      console.log('Sending refresh request for "%s"', this.envl.target);
      const e = Object.assign(<MsgEnvelope>{}, Envl);
      e.code = Kind.REQUEST;
      e.request = Request.REFRESH;
      e.target = this.envl.target;
      e.msg = Object.assign(<MsgBody>{}, Msg);
      e.msg.target = this.envl.target;
      e.timestamp = Date.now();
      this.wsSocket.send(JSON.stringify(e));
    },

    clear() {
      this.envl.msg.content = '';
    },

    send(message: string) {
      this.wsSocket.send(message);
    },

    sendObj(message: MsgEnvelope) {
      this.wsSocket.send(JSON.stringify(message));
    },

    // =============================================

    SOCKET_ONMESSAGE(event: MessageEvent) {
      this.message = event.data;

      const envl: MsgEnvelope = JSON.parse(event.data);
      this.envl = envl;
    },

    SOCKET_ONOPEN(event: Event) {
      this.wsSocket = event.target as WebSocket;
      this.isConnected = true;
      console.log('Ws connected');

      this.heartBeatTimer = window.setInterval(() => {
        this.isConnected &&
          this.wsSocket.send(
            JSON.stringify({
              code: Kind.ACK,
              request: Request.HEARTBEAT,
              target: this.envl.target,
              status: 'Heartbeat',
            })
          );
      }, this.heartBeatInterval);
    },

    SOCKET_ONCLOSE(event: CloseEvent) {
      this.isConnected = false;
      window.clearInterval(this.heartBeatTimer);
      this.heartBeatTimer = 0;

      const reason = event.reason.trim().length > 0 ? event.reason : 'No reason given';
      console.log('Ws disconnected: [%s] %s', event.type.toUpperCase(), reason);
    },

    SOCKET_ONERROR(event: Event) {
      console.error('Ws Error: %s', event.type);
    },

    SOCKET_RECONNECT(count: number) {
      console.info('Ws reconnect attempt %s', count);
    },

    SOCKET_RECONNECT_ERROR(err: boolean) {
      this.reconnectError = err;
      console.error('Ws reconnect error: %s', err);
    },
  },

  // pinia-plugin-persistedstate
  persist: false,
});
