package io.boodskap.iot.plugin;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to access Boodskap system's Lookup table
 * 
 * <pre>
 * Boodskap platform will inject the actual lookup value during runtime if exists
 * </pre>
 * @author Jegan Vincent
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface LookupResource {
	
	/**
	 * Lookup name/key
	 * @return {@link String}
	 */
	String name();

	/**
	 * False if the lookup is Domain's value
	 * <pre>
	 * Can't be false if plugin type is {@link PluginType#SERVICE}
	 * </pre>
	 * @return {@link String}
	 */
	boolean system() default false;
}
