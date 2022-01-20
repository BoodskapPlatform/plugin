package io.boodskap.iot;

import org.apache.commons.lang3.exception.ExceptionUtils;

import io.boodskap.iot.plugin.Invokable;

public abstract class AbstractLogger {

	protected abstract void doLogging(String lineInfo, String level, String message);
	
	public void custom(String level, String msg) {
		doLogging("", level, msg);
	}

	public void custom(String level, String format, Object... args) {
		doLogging("", level, String.format(format, args));
	}

	@Invokable(signature = "void trace(String msg)", help = "")
	public void trace(String msg) {
		doLogging("", "trace", msg);
	}

	@Invokable(signature = "void trace(String format, Object... args)", help = "")
	public void trace(String format, Object... args) {
		doLogging("", "trace", String.format(format, args));
	}

	@Invokable(signature = "void trace(Throwable e)", help = "")
	public void trace(Throwable e) {
		String message = ExceptionUtils.getStackTrace(e);
		doLogging("", "trace", message);
	}
	
	@Invokable(signature = "void debug(String msg)", help = "")
	public void debug(String msg) {
		doLogging("", "debug", msg);
	}

	@Invokable(signature = "void debug(String format, Object... args)", help = "")
	public void debug(String format, Object... args) {
		doLogging("", "debug", String.format(format, args));
	}

	@Invokable(signature = "void debug(Throwable e)", help = "")
	public void debug(Throwable e) {
		String message = ExceptionUtils.getStackTrace(e);
		doLogging("", "debug", message);
	}
	
	@Invokable(signature = "void info(String msg)", help = "")
	public void info(String msg) {
		doLogging("", "info", msg);
	}

	@Invokable(signature = "void info(String format, Object... args)", help = "")
	public void info(String format, Object... args) {
		doLogging("", "info", String.format(format, args));
	}
	
	@Invokable(signature = "void info(Throwable e)", help = "")
	public void info(Throwable e) {
		String message = ExceptionUtils.getStackTrace(e);
		doLogging("", "info", message);
	}
	
	@Invokable(signature = "void warn(String msg)", help = "")
	public void warn(String msg) {
		doLogging("", "warn", msg);
	}

	@Invokable(signature = "void warn(String format, Object... args)", help = "")
	public void warn(String format, Object... args) {
		doLogging("", "warn", String.format(format, args));
	}

	@Invokable(signature = "void warn(Throwable e)", help = "")
	public void warn(Throwable e) {
		String message = ExceptionUtils.getStackTrace(e);
		doLogging("", "warn", message);
	}
	
	@Invokable(signature = "void error(String msg)", help = "")
	public void error(String msg) {
		doLogging("", "error", msg);
	}

	@Invokable(signature = "void error(String format, Object... args)", help = "")
	public void error(String format, Object... args) {
		doLogging("", "error", String.format(format, args));
	}

	@Invokable(signature = "void error(Throwable e)", help = "")
	public void error(Throwable e) {
		String message = ExceptionUtils.getStackTrace(e);
		doLogging("", "error", message);
	}
	
}
