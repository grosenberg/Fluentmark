// export interface WebSocketExt extends WebSocket {
//   sendObj(data: MsgEnvelope): void;
// }

export type SocketStore = {
  wsSocket: WebSocket;
  isConnected: boolean;
  message: string;
  reconnectError: boolean;
  heartBeatInterval: number;
  heartBeatTimer: number;
  envl: MsgEnvelope;
};

export type MsgEnvelope = {
  code: number;
  request: number;
  target: string;
  msg: MsgBody;
  status: string;
  timestamp: number;
};

export type MsgBody = {
  ref: number;
  target: string;
  content: string;
  line: number;
  total: number;
};

// Well-defined constants
export const Kind = {
  NACK: -1,
  ACK: 0,
  REQUEST: 1,
  REPLY: 2,
};

export const Request = {
  AUTH: 10,
  HELO: 12,
  REFRESH: 20,
  UPDATE: 22,
  HEARTBEAT: 200,
};

// Prototypical message envelope
export const Envl: MsgEnvelope = {
  code: Kind.NACK,
  request: Request.HELO,
  target: '',
  msg: <MsgBody>{},
  status: '',
  timestamp: 0,
};

// Prototypical message body
export const Msg: MsgBody = {
  ref: 0,
  target: '',
  content: '',
  line: -1,
  total: -1,
};

// Composite Prototype message
export function ProtoMsg(): MsgEnvelope {
  const envl = Object.assign(<MsgEnvelope>{}, Envl);
  envl.msg = Object.assign(<MsgBody>{}, Msg);
  return envl;
}
