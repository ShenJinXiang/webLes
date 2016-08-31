package com.qysoft.bean;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class Interface implements Serializable{

	private static final long serialVersionUID = 1L;

	/**
	 * 全局信息
	 */
	@XStreamAlias("globalInfo")
	private GlobalInfo globalInfo;
	
	/**
	 * 返回信息
	 */
	private ReturnStateInfo returnStateInfo;
	
	/**
	 * 交换数据
	 */
	@XStreamAlias("Data")
	private Data data;

	public GlobalInfo getGlobalInfo() {
		return globalInfo;
	}

	public void setGlobalInfo(GlobalInfo globalInfo) {
		this.globalInfo = globalInfo;
	}

	public ReturnStateInfo getReturnStateInfo() {
		return returnStateInfo;
	}

	public void setReturnStateInfo(ReturnStateInfo returnStateInfo) {
		this.returnStateInfo = returnStateInfo;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}
	
}
