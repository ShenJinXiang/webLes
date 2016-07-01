package com.shenjinxiang.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

public class HideTag extends TagSupport {

	@Override
	public int doStartTag() throws JspException {
		System.out.println("doStartTag");
//		return Tag.EVAL_BODY_INCLUDE;		// 显示
		return Tag.SKIP_BODY;	// 隐藏
	}

}
