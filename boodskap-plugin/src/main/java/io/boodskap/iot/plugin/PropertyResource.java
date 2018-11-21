package io.boodskap.iot.plugin;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to access Boodskap system's Property table
 * 
 * <pre>
 * Boodskap platform will inject the actual property value during runtime if exists
 * </pre>
 * @author Jegan Vincent
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface PropertyResource {
	
	/**
	 * Property name/key
	 * @return {@link String}
	 */
	String name();
	
	/**
	 * False if the property is Domain's property
	 * <pre>
	 * Can't be false if plugin type is {@link PluginType#SERVICE}
	 * </pre>
	 * @return {@link String}
	 */
	boolean system() default false;
	
	/**
	 * Default property value if not configured
	 * @return {@link String}
	 */
	String def() default "";
}
