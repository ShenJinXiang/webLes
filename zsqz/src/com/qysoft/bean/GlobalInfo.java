package com.qysoft.bean;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class GlobalInfo implements Serializable{
	
	private static final long serialVersionUID = 1L;

	/**
	 * 终端类型标识(0:B/S请求来源;1:C/S请求来源)  0
	 */
	private String terminalCode;
	
	/**
	 * DZFP 表示普通发票  ZZS_PT_DZFP表示增值税普通电子发票
	 */
	private String appId;
	
	/**
	 *  接口版本 2.0
	 */
	private String version;
	
	/**
	 * 接口编码
	 */
	private String interfaceCode;
	
	/**
	 * 平台编码 事先取得从管理端（请求前）
	 */
	private String userName;
	
	/**
	 * 密码  10位随机数+Base64({（ 10位随机数+注册码） MD5})
	 */
	private String passWord;
	
	/**
	 * 纳税人识别号   事先取得从平台系统获取（请求前）
	 */
	private String taxpayerId;
	
	/**
	 * 纳税人授权码  事先取得从平台系统获取（请求前）
	 */
	private String authorizationCode;
	
	/**
	 * 数据交换请求发起方代码  用平台编码
	 */
	private String requestCode;
	
	/**
	 * 数据交换请求发出时间  格式 YYYY-MM-DD HH:MI:SS SS
	 */
	private String requestTime;
	
	/**
	 * 数据交换请求接受方代码
	 */
	private String responseCode;
	
	/**
	 * 数据交换流水号（唯一）   requestCode+8 位日期(YYYYMMDD)+9 位序列号
	 */
	private String dataExchangeId;

	public String getTerminalCode() {
		return terminalCode;
	}

	public void setTerminalCode(String terminalCode) {
		this.terminalCode = terminalCode;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getInterfaceCode() {
		return interfaceCode;
	}

	public void setInterfaceCode(String interfaceCode) {
		this.interfaceCode = interfaceCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getTaxpayerId() {
		return taxpayerId;
	}

	public void setTaxpayerId(String taxpayerId) {
		this.taxpayerId = taxpayerId;
	}

	public String getAuthorizationCode() {
		return authorizationCode;
	}

	public void setAuthorizationCode(String authorizationCode) {
		this.authorizationCode = authorizationCode;
	}

	public String getRequestCode() {
		return requestCode;
	}

	public void setRequestCode(String requestCode) {
		this.requestCode = requestCode;
	}

	public String getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(String requestTime) {
		this.requestTime = requestTime;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getDataExchangeId() {
		return dataExchangeId;
	}

	public void setDataExchangeId(String dataExchangeId) {
		this.dataExchangeId = dataExchangeId;
	}
	
}
