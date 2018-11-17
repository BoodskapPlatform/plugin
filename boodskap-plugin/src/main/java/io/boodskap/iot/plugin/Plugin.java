package io.boodskap.iot.plugin;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Every plugin must have this annotation declared
 * @author Jegan Vincent
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface Plugin {
	
	/**
	 * A unique identifier for this plugin, typically a UUID in string format
	 * @return {@link String}
	 */
	String id();
	
	/**
	 * Type of the plugin
	 * <pre>
	 * If the plugin type is {@link PluginType#SERVICE} then the plugin must 
	 * 	declare {@link PluginType} annotation and
	 * 	implement {@link PluginService} interface
	 * </pre>
	 * @return {@link PluginType}
	 */
	PluginType type();
	
	/**
	 * Plugin version, semver style versioning is strongly recommended
	 * @return {@link String}
	 */
	String version();
	
	/**
	 * If the plugin is a type of {@link PluginType#CONTEXT} then a unique context-id is required
	 * @return {@link String}
	 */
	String contextId() default "";
	
	/**
	 * A short description about the plugin
	 * @return {@link String}
	 */
	String desc() default "";
}
