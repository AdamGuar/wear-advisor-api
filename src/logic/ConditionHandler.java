package logic;

import services.OWAService;

public class ConditionHandler {
	
	public void calculateConditions(){
		OWAService owaService = new OWAService();
		owaService.getConditionFromService("Krakow");
	}
	
}
