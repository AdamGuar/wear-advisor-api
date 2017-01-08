package services;

import java.util.HashSet;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import org.springframework.web.client.RestTemplate;



public class OWAService {
	
	JSONParser parser = new JSONParser();
	
	public void getConditionFromService(String cityName) throws ParseException{
		 
		 RestTemplate restTemplate = new RestTemplate();
		 final String uri = "http://api.openweathermap.org/data/2.5/weather?appid=8e4e048d2c720e871b6ee90268a40dae&units=metric&q="+cityName;
	     String result = restTemplate.getForObject(uri, String.class);
		 
		 Object obj = parser.parse(result);
		 
		 JSONObject jsonObject = (JSONObject) obj;
		 
		 boolean is = jsonObject.containsKey("main");
		 
		 JSONObject main = (JSONObject) jsonObject.get("main");
		 JSONObject wind = (JSONObject) jsonObject.get("wind");
		 
		 long temperature = (Long) main.get("temp");
		 double windSpeed = (Double) wind.get("speed");

	}

}
