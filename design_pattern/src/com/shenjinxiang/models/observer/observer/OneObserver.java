package com.shenjinxiang.models.observer.observer;

import com.shenjinxiang.models.observer.subject.Subject;

public class OneObserver implements Observer, DisplayElement {
	
	private float temperature;
	private float humidity;
	private float pressure;
	private Subject weatherData;

	public OneObserver(Subject weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}
	@Override
	public void display() {
		System.out.println("first observer :  temperature = " + this.temperature + " humidity = " + this.humidity + " pressure = " + this.pressure);
	}

	@Override
	public void update(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		display();
	}

	public void delFromSubject() {
		this.weatherData.removeObserver(this);
	}
}
