package logic;

import model.ConditionType;
import model.Conditions;

public class ConditionEstimator {
	
	public static final int FREEZING_TEMP = -10;
	public static final int COLD_TEMP = -5;
	public static final int MODERATE_TEMP = 10;
	public static final int WARM_TEMP = 25;
	
	

	private static double realTemperatureCalculator(double temperature, double windSpeed){		
		
		double realTemperature = 13.12 + 0.6215*temperature - 11.37*Math.pow(windSpeed, 0.16)+0.3965*temperature*Math.pow(windSpeed,0.16);
		
		return realTemperature;
		
	}
	
	
	public static void estimateConditionsType(Conditions conditions){
		
		double realTemperature = realTemperatureCalculator(conditions.getTemperature(),conditions.getWind());
		
		conditions.setRealTemperature(realTemperature);
		
		if(realTemperature<FREEZING_TEMP)
			conditions.setType(ConditionType.freezing);
		else if(realTemperature<COLD_TEMP)
			conditions.setType(ConditionType.cold);
		else if(realTemperature<MODERATE_TEMP)
			conditions.setType(ConditionType.moderate);
		else if(realTemperature<WARM_TEMP)
			conditions.setType(ConditionType.warm);
		else
			conditions.setType(ConditionType.hot);
		
	}
	
	
	
}
