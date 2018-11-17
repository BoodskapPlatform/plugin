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
	
	@ConfigResource
	private Map<String, Object> config;
	//url-"https://maps.googleapis.com/maps/api/geocode/json"
	
	public Object geocode(String address) throws UnirestException, JSONException, IOException {
		
		JsonNode node = Unirest.get((String)config.get("url"))
		.queryString("key", apiKey)
		.queryString("address", address)
		.asJson().getBody()
		;
		
		return transform(node);
		
	}
	
	public Object geocode(double latitude, double longitude) throws UnirestException, JsonParseException, JsonMappingException, IOException{
		
		JsonNode node = Unirest.get((String)config.get("url"))
		.queryString("key", apiKey)
		.queryString("latlng", String.format("%s,%s", latitude, longitude))
		.asJson().getBody()
		;
		
		return transform(node);
		
	}
	
	private Object transform(JsonNode value) throws JsonParseException, JsonMappingException, IOException {
		
		switch(format) {
		case "JSON":
			return value.getObject();
		default:
		case "MAP":
			return JsonUtil.jsonToMap(value.getObject().toString());
		}
		
	}

}
