package net.certiv.fluent.dt.vis.server;

import java.util.Date;

import net.certiv.common.util.Strings;

/** Message envelope. */
public class MsgEnvl {

	// ------------------------------------------
	// Envelope kind codes

	public static final int NACK = -1;
	public static final int ACK = 0;

	public static final int REQUEST = 1;
	public static final int REPLY = 2;

	// ------------------------------------------
	// Envelope request codes

	/** Client->Server: client-session/scope/user registration. */
	public static final int AUTH = 10; // initial registration
	/** Client<->Server: hello?. */
	public static final int HELO = 12;

	/** Client->Server: client wants a refresh; e.g., pull an 'update', etc. */
	public static final int REFRESH = 20;
	/** Server->Client: server data-push to 'update' client. */
	public static final int UPDATE = 22;

	/** Client->Server: client heartbeat check. */
	public static final int HEARTBEAT = 200;

	// ------------------------------------------

	/** The connection kind code. */
	public final int code;

	/** The connection request code. */
	public final int request;

	/** The remote connection target/editor input filename. */
	public final String target;

	/** The current message content. */
	public final Message msg;

	/** The remote connection status message. */
	public final String status;

	/** The message timestamp. */
	public final long timestamp;

	// ------------------------------------------

	/** Returns a new request styled envelope initialized using the given values. */
	public static MsgEnvl request(int request, Message msg) {
		return new MsgEnvl(REQUEST, request, msg);
	}

	/** Returns a new request styled envelope initialized from the given values. */
	public static MsgEnvl request(MsgEnvl envl, String txt) {
		Message msg = Message.request(envl.msg, txt);
		return new MsgEnvl(REQUEST, envl.request, msg);
	}

	/** Returns a new reply styled envelope initialized from the given envelope. */
	public static MsgEnvl reply(MsgEnvl envl, String txt) {
		Message msg = Message.reply(envl.msg, txt);
		return new MsgEnvl(REPLY, envl.request, msg);
	}

	/** Returns a new ACK reply to the given envelope. */
	public static MsgEnvl ack(MsgEnvl envl) {
		Message msg = Message.reply(envl.msg, Strings.EMPTY);
		return new MsgEnvl(ACK, envl.request, msg);
	}

	/** Returns a new NACK reply to the given envelope. */
	public static MsgEnvl nack(MsgEnvl envl, String reason) {
		Message msg = Message.reply(envl.msg, reason);
		return new MsgEnvl(NACK, envl.request, msg);
	}

	/**
	 * Prepare a message envelope for the given message.
	 *
	 * @param kind the communication kind
	 * @param request the communication request op
	 * @param msg the message to deliver
	 */
	private MsgEnvl(int kind, int request, Message msg) {
		this.code = kind;
		this.request = request;
		this.msg = msg;
		this.status = Strings.EMPTY;

		target = msg.target;
		timestamp = (new Date()).getTime();
	}
}
