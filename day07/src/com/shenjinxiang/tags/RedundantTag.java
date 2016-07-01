package com.shenjinxiang.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.IterationTag;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

public class RedundantTag extends TagSupport {
	
	private int count = 5;

	@Override
	public int doAfterBody() throws JspException {
		count--;
		if(count > 0) {
			return IterationTag.EVAL_BODY_AGAIN;
		} else {
			return IterationTag.SKIP_BODY;
		}
	}

	@Override
	public int doStartTag() throws JspException {
		return Tag.EVAL_BODY_INCLUDE;
	}

	
}
