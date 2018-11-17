package io.boodskap.iot.plugin;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to access <code>Config</code> at runtime
 * <pre>
 * Boodskap platform will inject the <code>Config</code> as {@link Map<String,Object>} at runtime
 * </pre>
 * @author Jegan Vincent
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface ConfigResource {

}
