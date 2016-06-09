package com.likestar.enumeration;

/**
 * �����ȼ� ģ��ö��
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
	
	public static Grade A = new Grade("90 - 100", "����");
	public static Grade B = new Grade("80 - 90", "����");
	public static Grade C = new Grade("70 - 80", "һ��");
	public static Grade D = new Grade("60 - 70", "��");
	public static Grade E = new Grade("0 - 60", "������");
	
	public String getDesc() {
		return this.desc;
	}
	
	public String getZhDesc() {
		return this.zh_desc;
	}
	
}
