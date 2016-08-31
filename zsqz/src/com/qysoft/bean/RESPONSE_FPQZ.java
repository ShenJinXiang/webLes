package com.qysoft.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("RESPONSE_FPQZ")
public class RESPONSE_FPQZ {

	/**
	 * class 属性 RESPONSE_FPQZ
	 */
	@XStreamAsAttribute
	@XStreamAlias("class")
	private String clazz;
	
	/**
	 * 发票请求唯一流水号
	 */
	@XStreamAlias("FPQQLSH")
	private String fpqqlsh;
	
	/**
	 * 发票代码
	 */
	@XStreamAlias("FP_DM")
	private String fp_dm;
	
	/**
	 * 发票号码
	 */
	@XStreamAlias("FP_HM")
	private String fp_hm;
	
	/**
	 * Base64（ pdf文件）
	 */
	@XStreamAlias("PDF_FILE")
	private String pdf_file;
	
	/**
	 * PDF下载路径
	 */
	@XStreamAlias("PDF_URL")
	private String pdf_url;
	
	/**
	 * 结果代码
	 */
	@XStreamAlias("RETURNCODE")
	private String returncode;
	
	/**
	 * 结果描述
	 */
	@XStreamAlias("RETURNMESSAGE")
	private String returnmessage;

	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	public String getFpqqlsh() {
		return fpqqlsh;
	}

	public void setFpqqlsh(String fpqqlsh) {
		this.fpqqlsh = fpqqlsh;
	}

	public String getFp_dm() {
		return fp_dm;
	}

	public void setFp_dm(String fp_dm) {
		this.fp_dm = fp_dm;
	}

	public String getFp_hm() {
		return fp_hm;
	}

	public void setFp_hm(String fp_hm) {
		this.fp_hm = fp_hm;
	}


	public String getPdf_file() {
		return pdf_file;
	}

	public void setPdf_file(String pdf_file) {
		this.pdf_file = pdf_file;
	}

	public String getPdf_url() {
		return pdf_url;
	}

	public void setPdf_url(String pdf_url) {
		this.pdf_url = pdf_url;
	}

	public String getReturncode() {
		return returncode;
	}

	public void setReturncode(String returncode) {
		this.returncode = returncode;
	}

	public String getReturnmessage() {
		return returnmessage;
	}

	public void setReturnmessage(String returnmessage) {
		this.returnmessage = returnmessage;
	}
	
}
