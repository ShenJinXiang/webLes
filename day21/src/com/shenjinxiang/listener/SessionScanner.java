package com.shenjinxiang.listener;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionScanner implements HttpSessionListener, ServletContextListener{
	
	private List<HttpSession> list = Collections.synchronizedList(new LinkedList<HttpSession>());
	private Object lock = new Object();  

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		synchronized (lock) {	// 锁旗标
			list.add(session); 
		}
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		Timer timer = new Timer();
		timer.schedule(new MyTask(list, lock), 0, 5 * 60 * 1000);
	}
	
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

}

class MyTask extends TimerTask {
	
	private List<HttpSession> list;
	private Object lock;
	
	public MyTask(List<HttpSession> list, Object lock) {
		this.list = list;
		this.lock = lock;
	}
	
	@Override
	public void run() {
		synchronized (lock) {
			ListIterator<HttpSession> it = list.listIterator();
			while(it.hasNext()) {
				HttpSession session = (HttpSession) it.next();
				if(System.currentTimeMillis() - session.getLastAccessedTime() > 5 * 60 *  1000) {
					it.remove();
				}
				
			}
		}
	}
	
}
