package io.boodskap.iot.plugin;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * Maven Central Jar dependencies
 * 
 * @author Jegan Vincent
 *
 */
public class PluginDependency implements Serializable {
	
	private static final long serialVersionUID = -8501315489317129479L;
	
	private List<Dependency> deps = new ArrayList<>();
	
	public PluginDependency() {
	}
	
	public static Builder builder() {
		return new Builder();
	}

	public List<Dependency> getDeps() {
		return deps;
	}

	public void add(Dependency... deps) {
		this.deps.addAll(Arrays.asList(deps));
	}
	
	/**
	 * Method to convert to JSON String
	 * @return {@link String} in JSON format or null on failure
	 */
	public String toJson() {
		try {
			return JsonUtil.toJSON(this);
		} catch (JsonProcessingException e) {
		}
		return null;
	}
	
	@Override
	public String toString() {
		String json = toJson();
		if(null == json) return super.toString();
		return json;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((deps == null) ? 0 : deps.hashCode());
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
		PluginDependency other = (PluginDependency) obj;
		if (deps == null) {
			if (other.deps != null)
				return false;
		} else if (!deps.equals(other.deps))
			return false;
		return true;
	}
	
	public static class Builder{
		
		private final PluginDependency deps = new PluginDependency();
		
		private Builder() {
		}
		
		public Builder add(String group, String artifact, String version) {
			deps.add(new Dependency(group, artifact, version));
			return this;
		}
		
		public Builder add(Dependency dep) {
			this.deps.add(dep);
			return this;
		}
		
		public String build() {
			return deps.toJson();
		}
	}
}
