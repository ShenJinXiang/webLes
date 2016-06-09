package com.likestar.enumeration;

public enum Egrade {

	A("90 - 100", "��"),
	B("80 - 90", "��"), 
	C("70 - 80", "��"),
	D("60 - 70", "��"),
	E("0 - 60", "������");
	
	private String desc;
	private String zh_desc;
	
	private Egrade(String desc, String zh_desc) {
		this.desc = desc;
		this.zh_desc = zh_desc;
	}
	
	public String getDesc() {
		return this.desc;
	}
	
	public String getZhDesc() {
		return this.zh_desc;
	}
}
