package io.boodskap.iot.plugin;

/**
 * An annotation to declare on plugins of type {@link PluginType#SERVICE}
 * <pre>
 * Service startup/shutdown sequence is not guaranteed
 * Plugins must not perform any action until {@link DomainSettings#isInited()} is returned true
 * </pre>
 * @author Jegan Vincent
 *
 */
public @interface PluginService {
	
	/**
	 * Type of the plugin service
	 * @return
	 */
	ServiceType type();
	
	/**
	 * Minimum number of instances spawned the cluster
	 * <pre>
	 * Ignored if <code>type</code> is not {@link ServiceType#SCALABLE}
	 * </pre>
	 * @return
	 */
	int min() default 1;
	
	/**
	 * Maximum number of instances spawned the cluster
	 * <pre>
	 * Ignored if <code>type</code> is not {@link ServiceType#SCALABLE}
	 * </pre>
	 * @return
	 */
	int max() default 1;
}
