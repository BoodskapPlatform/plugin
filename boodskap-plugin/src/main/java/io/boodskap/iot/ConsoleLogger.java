package io.boodskap.iot;

public class ConsoleLogger extends AbstractLogger {

	public ConsoleLogger() {
	}

	@Override
	protected void doLogging(String lineInfo, String level, String message) {
		
		switch(level) {
		case "trace":
		case "debug":
		case "info":
			System.out.println(message);
			break;
		default:
			System.err.println(message);
			break;
		}
	}

}
