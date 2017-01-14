package services;

import java.util.HashSet;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import org.springframework.web.client.RestTemplate;

import model.Conditions;



public class OWAService {
	
	JSONParser parser = new JSONParser();
	final static String API_URI = "http://api.openweathermap.org/data/2.5/weather?appid=8e4e048d2c720e871b6ee90268a40dae&units=metric&q=";
	
	
	public void getConditionFromService(String cityName,Conditions conditions) throws ParseException{
		 
		 RestTemplate restTemplate = new RestTemplate();
		 String uri = API_URI+cityName;
	     String result = restTemplate.getForObject(uri, String.class);
		 
		 Object obj = parser.parse(result);
		 
		 JSONObject jsonObject = (JSONObject) obj;
		 
		 boolean is = jsonObject.containsKey("main");
		 
		 JSONObject main = (JSONObject) jsonObject.get("main");
		 JSONObject wind = (JSONObject) jsonObject.get("wind");
		 
		 
		 //TODO: think about better solution for this
		 try
		 {
			 long temperature = (Long) main.get("temp");
			 conditions.setTemperature(temperature);
		 }
		 catch(ClassCastException ex){
			 double temperature = (Double) main.get("temp");
			 conditions.setTemperature(temperature);
			 
		 }
		 
		 
		 try
		 {
			 double windSpeed = (Double) wind.get("speed");
			 conditions.setWind(windSpeed);
		 }
		 catch(ClassCastException ex){
			 long windSpeed = (Long) wind.get("speed");
			 conditions.setWind(windSpeed);
			 
		 }
		 
		 

	}

}
