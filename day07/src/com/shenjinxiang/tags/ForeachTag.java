package com.shenjinxiang.tags;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ForeachTag extends SimpleTagSupport {

	private Object items;
	private String var;
	private Collection collection;
	
	public void setItems(Object items) {
		this.items = items;
		if(items instanceof Collection) {
			System.out.println("Collection");
			collection = (Collection) items;
		}
		
		if(items instanceof Map) {
			System.out.println("Map");
			Map map = (Map) items;
			collection = map.entrySet();
		}
		
		if(items instanceof Object[]) {
			System.out.println("Array");
			Object obj[] = (Object[]) items;
			collection = Arrays.asList(obj);
		}
	}
	
	public void setVar(String var) {
		this.var = var;
	}

	@Override
	public void doTag() throws JspException, IOException {
		Iterator it = this.collection.iterator();
		while(it.hasNext()) {
			Object value = it.next();
			this.getJspContext().setAttribute(var, value);
			this.getJspBody().invoke(null);
		}
	}
	
	
}
