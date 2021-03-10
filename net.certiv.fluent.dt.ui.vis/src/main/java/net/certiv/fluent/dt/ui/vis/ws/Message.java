package net.certiv.fluent.dt.ui.vis.ws;

public class Message {

	/** An internal message reference. */
	public final long ref;

	/** The message source name. */
	public final String source;

	/** The message destination name. */
	public final String target;

	/** The message content. */
	public final String content;

	// ------------------------------------------

	/**
	 * Returns a new message with the given values.
	 *
	 * @param ref a message reference
	 * @param src the message source
	 * @param dst thew message destination
	 * @param content the message content
	 * @return a new message
	 */
	public static Message request(long ref, String src, String dst, String content) {
		return new Message(ref, src, dst, content);
	}

	/**
	 * Returns a new message initialized from the given message and content.
	 *
	 * @param content the message content
	 * @return a new message
	 */
	public static Message request(Message msg, String content) {
		return new Message(msg.ref, msg.source, msg.target, content);
	}

	/**
	 * Returns a new reply message initialized from the given message and content. Source
	 * and destination names are reversed as is appropriate of a reply.
	 *
	 * @param content the message content
	 * @return a new message
	 */
	public static Message reply(Message msg, String content) {
		return new Message(msg.ref, msg.target, msg.source, content);
	}

	private Message(long ref, String src, String dst, String content) {
		this.ref = ref;
		this.source = src;
		this.target = dst;
		this.content = content;
	}
}
