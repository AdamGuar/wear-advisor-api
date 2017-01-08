package logic;

import org.json.simple.parser.ParseException;

import logic.esystem.ConditionCalculator;
import model.Conditions;
import services.OWAService;

public class ConditionHandler {
	
	public void calculateConditions(String city){
		OWAService owaService = new OWAService();
		try {
			owaService.getConditionFromService("Krakow");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ConditionCalculator condCalc = new ConditionCalculator();
		//condCalc.caluclateState(new Conditions());
		
	}
	
}
