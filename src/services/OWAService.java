package services;


import org.springframework.web.client.RestTemplate;

public class OWAService {
	
	public void getConditionFromService(String cityName){
		 
		 RestTemplate restTemplate = new RestTemplate();
		 final String uri = "http://api.openweathermap.org/data/2.5/weather?appid=8e4e048d2c720e871b6ee90268a40dae&units=metric&q="+cityName;
	     
		 String result = restTemplate.getForObject(uri, String.class);
		     
		 System.out.println(result);

	}

}
