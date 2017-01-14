package model;

public class Conditions {

	double temperature;
	double wind;
	double realTemperature;
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

	public ConditionType getType() {
		return type;
	}

	public void setType(ConditionType type) {
		this.type = type;
	}

	public double getRealTemperature() {
		return realTemperature;
	}

	public void setRealTemperature(double realTemperature) {
		this.realTemperature = realTemperature;
	}

	@Override
	public String toString() {
		return "Conditions [temperature=" + temperature + ", wind=" + wind + ", realTemperature=" + realTemperature
				+ ", type=" + type + "]";
	}
	
	
	
}
