package com.qysoft.bean;

public class DataDescription {

	/**
	 * 压缩标识  0：不压缩 1：压缩 (用 GZip 压缩)
	 */
	private String zipCode;
	
	/**
	 * 加密标识  0:不加密 1: 3DES 加密 2:CA 加密
	 */
	private String encryptCode;
	
	/**
	 * 0 、 3DES 加密 、 CA 加密
	 */
	private String codeType;

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getEncryptCode() {
		return encryptCode;
	}

	public void setEncryptCode(String encryptCode) {
		this.encryptCode = encryptCode;
	}

	public String getCodeType() {
		return codeType;
	}

	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}
	
}
