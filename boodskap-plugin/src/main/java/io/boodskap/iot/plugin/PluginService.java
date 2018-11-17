package io.boodskap.iot.plugin;

public @interface PluginService {
	ServiceType type();
	int min() default 1;
	int max() default 1;
}
