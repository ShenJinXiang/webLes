package com.likestar.enumeration;

public enum Egrade {

	A("90 - 100", "优"),
	B("80 - 90", "良"), 
	C("70 - 80", "中"),
	D("60 - 70", "差"),
	E("0 - 60", "不及格");
	
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
