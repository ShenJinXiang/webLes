package com.likestar.enumeration;

/**
 * 分数等级 模仿枚举
 * @author shenjinxiang
 *
 */
public class Grade {
	
	private String desc;
	private String zh_desc;
	
	private Grade(String desc, String zh_desc) {
		this.desc = desc;
		this.zh_desc = zh_desc;
	}
	
	public static Grade A = new Grade("90 - 100", "优秀");
	public static Grade B = new Grade("80 - 90", "良好");
	public static Grade C = new Grade("70 - 80", "一般");
	public static Grade D = new Grade("60 - 70", "差");
	public static Grade E = new Grade("0 - 60", "不及格");
	
	public String getDesc() {
		return this.desc;
	}
	
	public String getZhDesc() {
		return this.zh_desc;
	}
	
}
