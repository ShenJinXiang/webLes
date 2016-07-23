package com.shenjinxiang.listener;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class SendMailTimer implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("listener init ...");
		Timer timer = new Timer();
		Calendar c = Calendar.getInstance();
		c.set(2016, 6, 24, 0, 20, 0);
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				System.out.println("发送mail～～～");
			}
		}, c.getTime());
	}

}
