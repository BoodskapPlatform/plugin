package io.boodskap.iot.plugin;

/**
 * Type of the plugin being implemented, declared in {@link Plugin#type()}
 * @author jegan
 */
public enum PluginType {

	/**
	 * Context plugins are instantiated every time the following actions are performed
	 * <pre>
	 * Rules Engine
	 * Script Console
	 * </pre>
	 */
	CONTEXT,
	
	/**
	 * Class plugins are instantiated every time the following actions are performed
	 * <pre>
	 * Rules Engine
	 * Script Console
	 * </pre>
	 */
	CLASS,
	
	SERVICE
}
