package com.shenjinxiang.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class MyServletContextAttributeListener implements ServletContextAttributeListener {

	@Override
	public void attributeAdded(ServletContextAttributeEvent scab) {
		String name = scab.getName();
		Object value = scab.getValue();
		System.out.println("向ServletContext中存了： " + name + " = " + value);
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent scab) {
		System.out.println("从ServletContext中删除了： " + scab.getName());
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent scab) {
		System.out.println("ServeltContext中 " + scab.getName() + " 属性被替换了");
	}

}
