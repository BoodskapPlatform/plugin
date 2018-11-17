package io.boodskap.iot.plugin;

import java.io.Serializable;
import java.util.List;

/**
 * Boodskap Plugin Configuration JSON Structure
 * <pre>
 * If a plugin needs configuration snippet in the domain settings screen
 * then the plugin must include a JSON file along with the bundled jar
 * The name of the file should match the exact path (package) of the plugin implementation
 * 
 * Example:
 * 	If your plugin is 
 * 		com.company.plugin.ml.FaceDetectPlugin.java
 * 	Then the config file should be
 * 		com.company.plugin.ml.FaceDetectPlugin.json
 * </pre>
 * @author Jegan Vincent
 *
 */
public class Config implements Serializable {
	
	private static final long serialVersionUID = -3836960251237724564L;
	
	/**
	 * Name that will be displayed on the configuration snippet
	 */
	private String name;
	
	/**
	 * One or more parameters
	 */
	private List<ConfigParam> params;

	public Config() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ConfigParam> getParams() {
		return params;
	}

	public void setParams(List<ConfigParam> params) {
		this.params = params;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((params == null) ? 0 : params.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Config other = (Config) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (params == null) {
			if (other.params != null)
				return false;
		} else if (!params.equals(other.params))
			return false;
		return true;
	}

}
