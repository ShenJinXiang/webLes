package com.shenjinxiang.demo;

public class Demo2 {

	public static void main(String[] args) {
		Person p = new Person();
		p.registerListener(new MListener());
		p.eat();
		p.run();
	}
}

class MListener implements PersonListener {

	@Override
	public void doRun(Event event) {
		System.out.println(event.getPerson() + "listener run");
	}

	@Override
	public void doEat(Event event) {
		System.out.println(event.getPerson() + "listener eat");		
	}
	
}


class Person {
	private PersonListener listener;
	public void registerListener(PersonListener listener) {
		this.listener = listener;
	}
	
	public void run() {
		if(listener != null) {
			Event event = new Event(this);
			this.listener.doRun(event);
		}
		System.out.println("run~~~");
	}
	
	public void eat() {
		if(listener != null) {
			Event event = new Event(this);
			this.listener.doEat(event);
		}
		System.out.println("eat~~~");
	}
}

interface PersonListener {
	public void doRun(Event event);
	
	public void doEat(Event event);
}

class Event {
	
	private Person person;
	
	public Event(Person person) {
		this.person = person;
	}
	
	public Person getPerson() {
		return person;
	}
	
	public void setPerson() {
		this.person = person;
	}
}