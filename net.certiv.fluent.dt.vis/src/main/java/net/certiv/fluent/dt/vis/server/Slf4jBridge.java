package net.certiv.fluent.dt.vis.server;

import java.lang.StackWalker.Option;
import java.lang.StackWalker.StackFrame;
import java.util.EnumSet;
import java.util.stream.Stream;

import org.slf4j.helpers.AbstractLogger;

import net.certiv.common.log.Level;
import net.certiv.common.log.Log;

public class Slf4jBridge extends AbstractLogger {

	// private Object source;

	public Slf4jBridge(Object name) {
		// this.source = name;
	}

	@Override
	public void debug(String message) {
		Log.debug(message);
	}

	@Override
	public void debug(String message, Object... params) {
		Log.debug(message, params);
	}

	@Override
	public void debug(String message, Throwable t) {
		Log.debug(message, t);
	}

	@Override
	public void debug(String message, Object p0) {
		Log.debug(message, p0);
	}

	@Override
	public void debug(String message, Object p0, Object p1) {
		Log.debug(message, p0, p1);
	}

	@Override
	public void info(String message) {
		Log.info(message);
	}

	@Override
	public void info(String message, Object... params) {
		Log.info(message, params);
	}

	@Override
	public void info(String message, Throwable t) {
		Log.info(message, t);
	}

	@Override
	public void info(String message, Object p0) {
		Log.info(message, p0);
	}

	@Override
	public void info(String message, Object p0, Object p1) {
		Log.info(message, p0, p1);
	}

	@Override
	public void warn(String message) {
		Log.warn(message);
	}

	@Override
	public void warn(String message, Object... params) {
		Log.warn(message, params);
	}

	@Override
	public void warn(String message, Throwable t) {
		Log.warn(message, t);
	}

	@Override
	public void warn(String message, Object p0) {
		Log.warn(message, p0);
	}

	@Override
	public void warn(String message, Object p0, Object p1) {
		Log.warn(message, p0, p1);
	}

	@Override
	public void error(String message) {
		Log.error(message);
	}

	@Override
	public void error(String message, Object... params) {
		Log.error(message, params);
	}

	@Override
	public void error(String message, Throwable t) {
		Log.error(message, t);
	}

	@Override
	public void error(String message, Object p0) {
		Log.error(message, p0);
	}

	@Override
	public void error(String message, Object p0, Object p1) {
		Log.error(message, p0, p1);
	}

	@Override
	public void trace(String message) {
		Log.trace(message);
	}

	@Override
	public void trace(String message, Object... params) {
		Log.trace(message, params);
	}

	@Override
	public void trace(String message, Throwable t) {
		Log.trace(message, t);
	}

	@Override
	public void trace(String message, Object p0) {
		Log.trace(message, p0);
	}

	@Override
	public void trace(String message, Object p0, Object p1) {
		Log.trace(message, p0, p1);
	}

	@Override
	public boolean isDebugEnabled() {
		return true;
	}

	@Override
	public boolean isDebugEnabled(org.slf4j.Marker marker) {
		return true;
	}

	@Override
	public boolean isInfoEnabled() {
		return true;
	}

	@Override
	public boolean isInfoEnabled(org.slf4j.Marker marker) {
		return true;
	}

	@Override
	public boolean isWarnEnabled() {
		return true;
	}

	@Override
	public boolean isWarnEnabled(org.slf4j.Marker marker) {
		return true;
	}

	@Override
	public boolean isErrorEnabled() {
		return true;
	}

	@Override
	public boolean isErrorEnabled(org.slf4j.Marker marker) {
		return true;
	}

	@Override
	public boolean isTraceEnabled() {
		return true;
	}

	@Override
	public boolean isTraceEnabled(org.slf4j.Marker marker) {
		return true;
	}

	@Override
	protected String getFullyQualifiedCallerName() {
		return caller().getName();
	}

	@Override
	protected void handleNormalizedLoggingCall(org.slf4j.event.Level lvl, org.slf4j.Marker marker, String fmt,
			Object[] args, Throwable t) {

		Level level = Level.toLevel(lvl.name());
		String msg = String.format(fmt, args);
		Log.log(level, msg, t);
	}

	// ================================

	private static final String FQCN = Slf4jBridge.class.getName();

	private static final EnumSet<Option> OPTIONS = EnumSet.of(StackWalker.Option.SHOW_HIDDEN_FRAMES,
			StackWalker.Option.RETAIN_CLASS_REFERENCE);

	/** @return the the class that called Slf4jBridge, or {@code Slf4jBridge.class} */
	private static Class<?> caller() {
		StackFrame frame = StackWalker.getInstance(OPTIONS).walk(Slf4jBridge::caller);
		return frame != null ? frame.getDeclaringClass() : Slf4jBridge.class;
	}

	// find the stack frame for the class that called Slf4jBridge
	private static StackFrame caller(Stream<StackFrame> frames) {
		return frames //
				.filter(f -> !f.getClassName().equals(FQCN)) //
				.findFirst() //
				.orElse(null);
	}
}
