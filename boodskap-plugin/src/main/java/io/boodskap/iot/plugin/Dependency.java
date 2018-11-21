package io.boodskap.iot.plugin;

import java.io.Serializable;

/**
 * Maven style jar dependency
 * 
 * @author Jegan Vincent
 *
 */
public class Dependency implements Serializable {
	
	private static final long serialVersionUID = -2802212609296431056L;
	
	/**
	 * Group ID
	 * @return {@link String}
	 */
	private String group;
	
	/**
	 * Artifact ID
	 * @return {@link String}
	 */
	private String artifact;
	
	/**
	 * Version
	 * @return {@link String}
	 */
	private String version;

	public Dependency() {		
	}

	public Dependency(String group, String artifact, String version) {
		this.group = group;
		this.artifact = artifact;
		this.version = version;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getArtifact() {
		return artifact;
	}

	public void setArtifact(String artifact) {
		this.artifact = artifact;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artifact == null) ? 0 : artifact.hashCode());
		result = prime * result + ((group == null) ? 0 : group.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
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
		Dependency other = (Dependency) obj;
		if (artifact == null) {
			if (other.artifact != null)
				return false;
		} else if (!artifact.equals(other.artifact))
			return false;
		if (group == null) {
			if (other.group != null)
				return false;
		} else if (!group.equals(other.group))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}
	
}
