package logic;

import model.ConditionType;
import model.Conditions;

public class ConditionEstimator {
	
	public static final int FREEZING_TEMP = -5;
	public static final int COLD_TEMP = 10;
	public static final int MODERATE_TEMP = 15;
	public static final int WARM_TEMP = 25;
	
	

	private static double windChillCalculator(double temperature, double windSpeed){		
		
		double windChill = 13.12 + 0.6215*temperature - 11.37*Math.pow(windSpeed, 0.16)+0.3965*temperature*Math.pow(windSpeed,0.16);
		if(windChill>temperature) windChill = temperature;
		else
			windChill = (double)Math.round(windChill * 10) / 10 ;
		
		return windChill;
		
	}
	
	
	public static void estimateConditionsType(Conditions conditions){
		
		double windChill = windChillCalculator(conditions.getTemperature(),conditions.getWind());
		
		conditions.setWindChill(windChill);
		
		if(windChill<FREEZING_TEMP)
			conditions.setType(ConditionType.freezing);
		else if(windChill<COLD_TEMP)
			conditions.setType(ConditionType.cold);
		else if(windChill<MODERATE_TEMP)
			conditions.setType(ConditionType.moderate);
		else if(windChill<WARM_TEMP)
			conditions.setType(ConditionType.warm);
		else
			conditions.setType(ConditionType.hot);
		
	}
	
	
	
}
