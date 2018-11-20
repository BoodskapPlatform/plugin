package io.boodskap.iot.plugin;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to declare all Maven Central Jar dependencies
 * 
 * @author Jegan Vincent
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface PluginDependency {
	
	/**
	 * Array of {@link Dependency}
	 * @return {@link Dependency}
	 */
	Dependency[] dependencies();
	
}
