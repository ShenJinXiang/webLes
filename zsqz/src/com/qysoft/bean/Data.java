package com.qysoft.bean;

public class Data {

	/**
	 * 数据描述
	 */
	private DataDescription dataDescription;
	
	/**
	 * base64请求数据内容或返回数据内容
	 */
	private String content;

	public DataDescription getDataDescription() {
		return dataDescription;
	}

	public void setDataDescription(DataDescription dataDescription) {
		this.dataDescription = dataDescription;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
