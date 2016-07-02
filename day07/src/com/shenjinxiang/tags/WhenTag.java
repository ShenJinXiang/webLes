package com.shenjinxiang.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class WhenTag extends SimpleTagSupport {

	private boolean test;

	public void setTest(boolean test) {
		this.test = test;
	}

	@Override
	public void doTag() throws JspException, IOException {
		ChooseTag parent = (ChooseTag) this.getParent();
		if(test && !parent.isDo()) {
			this.getJspBody().invoke(null);
			parent.setDo(true);
		}
	}
	
	
}
