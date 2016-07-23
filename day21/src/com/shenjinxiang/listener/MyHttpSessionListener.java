package com.shenjinxiang.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyHttpSessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		System.out.println("**********************************");
		System.out.println("MyHttpSessionListener created");
		System.out.println("**********************************");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		System.out.println("**********************************");
		System.out.println("MyHttpSessionListener destroy");
		System.out.println("**********************************");
	}

}
