package io.boodskap.iot;

import org.apache.commons.lang3.exception.ExceptionUtils;

public abstract class AbstractLogger {

	protected abstract void doLogging(String lineInfo, String level, String message);
	
	public void custom(String level, String msg) {
		doLogging("", level, msg);
	}

	public void custom(String level, String format, Object... args) {
		doLogging("", level, String.format(format, args));
	}

	public void debug(Throwable e) {
		String message = ExceptionUtils.getStackTrace(e);
		doLogging("", "debug", message);
	}
	
	public void trace(Throwable e) {
		String message = ExceptionUtils.getStackTrace(e);
		doLogging("", "trace", message);
	}
	
	public void trace(String msg) {
		doLogging("", "trace", msg);
	}

	public void trace(String format, Object... args) {
		doLogging("", "trace", String.format(format, args));
	}

	public void debug(String msg) {
		doLogging("", "debug", msg);
	}

	public void debug(String format, Object... args) {
		doLogging("", "debug", String.format(format, args));
	}

	public void info(Throwable e) {
		String message = ExceptionUtils.getStackTrace(e);
		doLogging("", "info", message);
	}
	
	public void info(String msg) {
		doLogging("", "info", msg);
	}

	public void info(String format, Object... args) {
		doLogging("", "info", String.format(format, args));
	}

	public void warn(Throwable e) {
		String message = ExceptionUtils.getStackTrace(e);
		doLogging("", "warn", message);
	}
	
	public void warn(String msg) {
		doLogging("", "warn", msg);
	}

	public void warn(String format, Object... args) {
		doLogging("", "warn", String.format(format, args));
	}

	public void error(Throwable e) {
		String message = ExceptionUtils.getStackTrace(e);
		doLogging("", "error", message);
	}
	
	public void error(String msg) {
		doLogging("", "error", msg);
	}

	public void error(String format, Object... args) {
		doLogging("", "error", String.format(format, args));
	}

}
