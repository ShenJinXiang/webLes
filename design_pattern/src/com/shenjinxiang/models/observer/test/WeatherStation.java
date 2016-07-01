package com.shenjinxiang.models.observer.test;

import com.shenjinxiang.models.observer.observer.CurrentConditionsDisplay;
import com.shenjinxiang.models.observer.observer.Observer;
import com.shenjinxiang.models.observer.observer.OneObserver;
import com.shenjinxiang.models.observer.subject.WeatherData;

public class WeatherStation {

	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
		CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
		Observer first = new OneObserver(weatherData);
		weatherData.setMeasurements(80, 65, 30.4f);
		weatherData.setMeasurements(82, 70, 29.2f);
		currentDisplay.delFromSubject();
		weatherData.setMeasurements(78, 90, 29.2f);
	}
}
