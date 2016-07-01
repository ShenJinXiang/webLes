package com.shenjinxiang.models.observer.subject;

import java.util.ArrayList;

import com.shenjinxiang.models.observer.observer.Observer;

public class WeatherData implements Subject {
	
	private ArrayList<Observer> Observers;
	private float temperature;
	private float humidity;
	private float pressure;

	public WeatherData() {
		Observers = new ArrayList<Observer>();
	}
	
	@Override
	public void registerObserver(Observer o) {
		Observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		int i = Observers.indexOf(o);
		if(i >= 0) {
			Observers.remove(o);
		}
	}

	@Override
	public void notifyObserver() {
		for(Observer Observer : Observers) {
			Observer.update(temperature, humidity, pressure);
		}
	}
	
	public void measurementsChanged() {
		notifyObserver();
	}
	
	public void setMeasurements(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChanged();
	}

}
