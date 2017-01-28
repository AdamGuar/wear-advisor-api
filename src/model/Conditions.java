package model;

public class Conditions {

	double temperature;
	double wind;
	double windChill;
	ConditionType type;
	
	
	public double getTemperature() {
		return temperature;
	}
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
	public double getWind() {
		return wind;
	}
	public void setWind(double wind) {
		this.wind = wind;
	}
	public double getWindChill() {
		return windChill;
	}
	public void setWindChill(double windChill) {
		this.windChill = windChill;
	}
	public ConditionType getType() {
		return type;
	}
	public void setType(ConditionType type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Conditions [temperature=" + temperature + ", wind=" + wind + ", windChill=" + windChill + ", type="
				+ type + "]";
	}
	


	
	
	
}
