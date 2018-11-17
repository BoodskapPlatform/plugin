package io.boodskap.iot.plugin;

/**
 * 
 * Different kinds of supported plugin services
 * 
 * @author Jegan Vincent
 *
 */
public enum ServiceType {
	
	/**
	 * Typically used when you want more than once instance serving in a cluster
	 * @see PluginService#min()
	 * @see PluginService#max()
	 */
	SCALABLE,
	
	/**
	 * Single instance of the service will be deployed in a cluster-node
	 */
	NODE_STINGLETON,
	
	/**
	 * Singleton instance cluster-wide
	 */
	CLUSTER_SINGLETON
}
