package io.boodskap.iot.plugin.gmaps;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import io.boodskap.iot.AbstractLogger;
import io.boodskap.iot.plugin.ConfigResource;
import io.boodskap.iot.plugin.Invokable;
import io.boodskap.iot.plugin.JsonUtil;
import io.boodskap.iot.plugin.LoggerResource;
import io.boodskap.iot.plugin.Plugin;
import io.boodskap.iot.plugin.PluginType;
import io.boodskap.iot.plugin.PropertyResource;

@Plugin(
		type=PluginType.CONTEXT, 
		id="4ecfd6f6-ea7b-11e8-9f32-f2801f1b9fd1", 
		version="1.0.2",
		contextId="gmaps",
		desc="A simple tool to interact with Google Maps API through rules engine"
)
public class GoogleMapsContext {
	
	@LoggerResource
	private AbstractLogger LOG;
	
	@PropertyResource(name="google.map.key")
	private String apiKey;
	
	@PropertyResource(name="google.map.format")
	private String format = "MAP";
	
	@ConfigResource
	private Map<String, Object> config = new HashMap<>();
	
	public GoogleMapsContext() {
		config.put("url", "https://maps.googleapis.com/maps/api/geocode/json");
	}
	
	@Invokable(signature="GoogleMapsContext apiKey(String apiKey)", help="Override API-KEY in domain settings")
	public GoogleMapsContext apiKey(String apiKey) {
		this.apiKey = apiKey;
		return this;
	}
	
	@Invokable(signature="GoogleMapsContext format(String format)", help="Output format [JSON | MAP | TEXT]")
	public GoogleMapsContext format(String format) {
		switch(format.toUpperCase()) {
		case "JSON":
		case "MAP":
		case "TEXT":
			break;
		default:
			throw new IllegalArgumentException("Format has to be one of [JSON | MAP | TEXT]");
		}
		this.format = format;
		return this;
	}
	
	@Invokable(signature="Object geocode(String address)", help="Geocode an address and return as Map or JSONObject")
	public Object geocode(String address) throws UnirestException, JSONException, IOException {
		
		String url = (String)config.get("url");
		LOG.debug("api-key:%s, format:%s, url:%s", apiKey, format, url);
		
		JsonNode node = Unirest.get(url)
		.queryString("key", apiKey)
		.queryString("address", address)
		.asJson().getBody()
		;
		
		return transform(node);
		
	}
	
	@Invokable(signature="Object geocode(double latitude, double longitude)", help="Geocode a lat/lon and return as Map or JSONObject")
	public Object geocode(double latitude, double longitude) throws UnirestException, JsonParseException, JsonMappingException, IOException{
		
		String url = (String)config.get("url");
		LOG.debug("api-key:%s, format:%s, url:%s", apiKey, format, url);
		
		JsonNode node = Unirest.get(url)
		.queryString("key", apiKey)
		.queryString("latlng", String.format("%s,%s", latitude, longitude))
		.asJson().getBody()
		;
		
		return transform(node);
		
	}
	
	protected Object transform(JsonNode value) throws JsonParseException, JsonMappingException, IOException {
		
		switch(format.toUpperCase()) {
		case "JSON":
			return value.getObject();
		case "TEXT":
			return value.getObject().toString();
		default:
		case "MAP":
			return JsonUtil.jsonToMap(value.getObject().toString());
		}
		
	}

}
