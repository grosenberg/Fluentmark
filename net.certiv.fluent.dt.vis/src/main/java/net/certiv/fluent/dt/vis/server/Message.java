package net.certiv.fluent.dt.vis.server;

import net.certiv.common.util.FileUtils;

public class Message {

	/** An internal message reference. */
	public final long ref;
	/** The message target name. */
	public final String target;
	/** The message content. */
	public final String content;
	/** The line changed in the content. */
	public final int line;
	/** The total number of lines in the content. */
	public final int total;

	// ------------------------------------------

	/**
	 * Returns a new message with the given values.
	 *
	 * @param ref a message reference
	 * @param target the message target
	 * @param content the message content
	 * @param line line number of content change
	 * @param total total number lines in content
	 * @return a new message
	 */
	public static Message request(String target, String content, int line, int total) {
		return new Message(FileUtils.nextRandom(), target, content, line, total);
	}

	/**
	 * Returns a new message with the given values.
	 *
	 * @param ref a message reference
	 * @param target the message target
	 * @param content the message content
	 * @return a new message
	 */
	public static Message request(long ref, String target, String content) {
		return new Message(ref, target, content, -1, -1);
	}

	/**
	 * Returns a new message initialized from the given message and content.
	 *
	 * @param content the message content
	 * @return a new message
	 */
	public static Message request(Message msg, String content) {
		return new Message(msg.ref, msg.target, content, -1, -1);
	}

	/**
	 * Returns a new reply message initialized from the given message and content.
	 * Source and target names are reversed as is appropriate of a reply.
	 *
	 * @param content the message content
	 * @return a new message
	 */
	public static Message reply(Message msg, String content) {
		return new Message(msg.ref, msg.target, content, -1, -1);
	}

	private Message(long ref, String target, String content, int line, int total) {
		this.ref = ref;
		this.target = target;
		this.content = content;
		this.line = line;
		this.total = total;
	}
}
