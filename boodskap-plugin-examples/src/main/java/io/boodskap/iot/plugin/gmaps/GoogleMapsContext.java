package io.boodskap.iot.plugin.gmaps;

import java.io.IOException;
import java.util.Map;

import org.json.JSONException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import io.boodskap.iot.plugin.ConfigResource;
import io.boodskap.iot.plugin.Invokable;
import io.boodskap.iot.plugin.JsonUtil;
import io.boodskap.iot.plugin.Plugin;
import io.boodskap.iot.plugin.PluginType;
import io.boodskap.iot.plugin.PropertyResource;

@Plugin(
		type=PluginType.CONTEXT, 
		id="4ecfd6f6-ea7b-11e8-9f32-f2801f1b9fd1", 
		version="1.0.0",
		contextId="gmaps",
		desc="A simple tool to interact with Google Maps API through rules engine"
)
public class GoogleMapsContext {
	
	@PropertyResource(name="google.map.key")
	private String apiKey;
	
	@PropertyResource(name="google.map.format")
	private String format = "MAP";
	
	/**
	 * url-"https://maps.googleapis.com/maps/api/geocode/json"
	 */
	@ConfigResource
	private Map<String, Object> config;
	
	@Invokable(signature="Object geocode(String address)", help="Geocode an address and return as Map or JSONObject")
	public Object geocode(String address) throws UnirestException, JSONException, IOException {
		
		JsonNode node = Unirest.get((String)config.get("url"))
		.queryString("key", apiKey)
		.queryString("address", address)
		.asJson().getBody()
		;
		
		return transform(node);
		
	}
	
	@Invokable(signature="Object geocode(double latitude, double longitude)", help="Geocode a lat/lon and return as Map or JSONObject")
	public Object geocode(double latitude, double longitude) throws UnirestException, JsonParseException, JsonMappingException, IOException{
		
		JsonNode node = Unirest.get((String)config.get("url"))
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
		default:
		case "MAP":
			return JsonUtil.jsonToMap(value.getObject().toString());
		}
		
	}

}
