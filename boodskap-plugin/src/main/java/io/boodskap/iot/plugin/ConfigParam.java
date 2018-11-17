package io.boodskap.iot.plugin;

import java.io.Serializable;

/**
 * Plugin configuration parameter
 * 
 * @author Jegan Vincent
 *
 */
public class ConfigParam implements Serializable {
	
	private static final long serialVersionUID = 3015413596780362259L;
	
	/**
	 * A name of the parameter
	 */
	private String name;
	
	/**
	 * Default value
	 */
	private String def;
	
	/**
	 * Parameter type
	 */
	private ConfigParamType type;
	
	/**
	 * A short title to display in the configuration snippet
	 * <pre>
	 * If not provided <code>name</code> will be used
	 * </pre>
	 */
	private String title;

	/**
	 * A help description to show it to the user in tool-tip 
	 */
	private String description;

	public ConfigParam() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ConfigParamType getType() {
		return type;
	}

	public void setType(ConfigParamType type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDef() {
		return def;
	}

	public void setDef(String def) {
		this.def = def;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((def == null) ? 0 : def.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		ConfigParam other = (ConfigParam) obj;
		if (def == null) {
			if (other.def != null)
				return false;
		} else if (!def.equals(other.def))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

}
