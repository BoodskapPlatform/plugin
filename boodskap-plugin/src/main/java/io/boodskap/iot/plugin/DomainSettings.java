package io.boodskap.iot.plugin;

import java.util.concurrent.BlockingQueue;

import javax.cache.Cache;

/**
 * An injectable interface, plugin can interact with Boodskap system
 * 
 * @author Jegan Vincent
 * @see DomainSettingsResource
 */
public interface DomainSettings{
	
	public boolean isInited();
	
	public String getAuthToken();
	
	public String getApiUrl();
	
	public <K, V> Cache<K, V> getCache(String cacheName) throws Exception;
	
	public <T> BlockingQueue<T> getQueue(String name) throws Exception;
}
