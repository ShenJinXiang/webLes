package com.qysoft.bean;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("FPQZ_XMXXS")
public class FPQZ_XMXXS {

	/**
	 * class属性  FPQZ_XMXX;
	 */
	@XStreamAlias("class")
	@XStreamAsAttribute
	private String clazz;
	
	/**
	 * size 属性
	 */
	@XStreamAsAttribute
	private String size;
	
	/**
	 * 项目信息列表
	 */
	@XStreamImplicit(itemFieldName = "FPQZ_XMXX")
	private List<FPQZ_XMXX> fpqz_xmxxs;

	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public List<FPQZ_XMXX> getFpqz_xmxxs() {
		return fpqz_xmxxs;
	}

	public void setFpqz_xmxxs(List<FPQZ_XMXX> fpqz_xmxxs) {
		this.fpqz_xmxxs = fpqz_xmxxs;
	}
	
}
