package io.boodskap.iot.plugin;

/**
 * Annotation to declare maven style jar dependency
 * 
 * @author Jegan Vincent
 *
 */
public @interface Dependency {
	
	/**
	 * Group ID
	 * @return {@link String}
	 */
	String group();
	
	/**
	 * Artifact ID
	 * @return {@link String}
	 */
	String artifact();
	
	/**
	 * Version
	 * @return {@link String}
	 */
	String version();
	
	/**
	 * Maven jar download link
	 * <pre>
	 * Ex: https://search.maven.org/remotecontent?filepath=
	 * Ex: http://central.maven.org/maven2/
	 * </pre>
	 * @return {@link String}
	 */
	String repository() default "http://central.maven.org/maven2/";
}
