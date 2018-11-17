package io.boodskap.iot.plugin;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * An annotation that must be declared on all methods of the plugins that needs to be exposed for usage
 * 
 * @author Jegan Vincent
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Invokable {
	
	/**
	 * Signature of the method including return types and arguments
	 * @return {@link String}
	 */
	String signature();
	
	/**
	 * A simple help string
	 * @return {@link String}
	 */
	String help();
	
	/**
	 * List of one or more example code
	 * @return {@link String} array
	 */
	String[] examples() default {};
	
	/**
	 * List of one or more external resources
	 * @return {@link String} array
	 */
	String[] resources() default {};
}
