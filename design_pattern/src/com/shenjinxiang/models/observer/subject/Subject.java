package com.shenjinxiang.models.observer.subject;

import com.shenjinxiang.models.observer.observer.Observer;

public interface Subject {

	public void registerObserver(Observer o);
	public void removeObserver(Observer o);
	public void notifyObserver();
}
