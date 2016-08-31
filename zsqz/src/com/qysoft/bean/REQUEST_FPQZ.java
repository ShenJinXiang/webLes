package com.qysoft.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("REQUEST_FPQZ")
public class REQUEST_FPQZ {
	
	/**
	 * REQUEST_FPQZ
	 */
	@XStreamAlias("class")
	@XStreamAsAttribute
	private String clazz;

	/**
	 * 发票签章信息  通过键值对的方式来扩展，键与值之间用(char)2 分隔，键值对之间用(char)3 分隔。组装好后，再加一层 base64，放在 FPQZ_INFO 标签内
	 * 举例： String s = "SJLY" + (char)2 +"05" + (char)3 + "FPLX" + (char)2 + "1";
	 * 06-服务器自开票版(对应外层appid 为 A16D8DBD18EDDD80) 09-税控组件开票（对应外层 appid为 AA0DDF541B152FBA）
	 */
	@XStreamAlias("FPQZ_INFO")
	private String fpqz_info;
	
	/**
	 * 发票头信息
	 */
	@XStreamAlias("FPQZ_FPT")
	public FPQZ_FPT fpqz_fpt;
	
	@XStreamAlias("FPQZ_XMXXS")
	public FPQZ_XMXXS fpqz_xmxxs;

	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	public String getFpqz_info() {
		return fpqz_info;
	}

	public void setFpqz_info(String fpqz_info) {
		this.fpqz_info = fpqz_info;
	}

	public FPQZ_FPT getFpqz_fpt() {
		return fpqz_fpt;
	}

	public void setFpqz_fpt(FPQZ_FPT fpqz_fpt) {
		this.fpqz_fpt = fpqz_fpt;
	}

	public FPQZ_XMXXS getFpqz_xmxxs() {
		return fpqz_xmxxs;
	}

	public void setFpqz_xmxxs(FPQZ_XMXXS fpqz_xmxxs) {
		this.fpqz_xmxxs = fpqz_xmxxs;
	}
	
}
