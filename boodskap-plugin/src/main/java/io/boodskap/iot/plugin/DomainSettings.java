package io.boodskap.iot.plugin;

import org.apache.ignite.IgniteCache;
import org.apache.ignite.IgniteException;
import org.apache.ignite.IgniteQueue;
import org.apache.ignite.configuration.CollectionConfiguration;
import org.jetbrains.annotations.Nullable;

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
	
	public <K, V> IgniteCache<K, V> getCache(String cacheName) throws IgniteException;
	
	public <T> IgniteQueue<T> getQueue(String name, int cap, @Nullable CollectionConfiguration cfg) throws IgniteException;
}
