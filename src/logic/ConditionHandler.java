package logic;

import org.apache.log4j.Logger;
import org.json.simple.parser.ParseException;

import logic.esystem.ConditionCalculator;
import model.Conditions;
import services.OWAService;
import services.RestService;

public class ConditionHandler {
	
	private static final Logger logger = Logger.getLogger(ConditionHandler.class);
	
	public void fetchConditions(String city, Conditions conditions){
		
		logger.info("Fetching codnitions, calling OWA service to get weather data");
		
		OWAService owaService = new OWAService();
		try {
			owaService.getConditionFromService(city,conditions);
		} catch (ParseException e) {
			logger.fatal("Error during parsing OWA response",e);
			e.printStackTrace();
		}
		logger.info("Calling condition esmtimator to estimate condition type");
		ConditionEstimator.estimateConditionsType(conditions);
		
	}
	
}
