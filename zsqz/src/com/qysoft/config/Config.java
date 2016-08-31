package com.qysoft.config;

public class Config {

	public static final String XML_HEAD;
	public static final String PDF_BASE_PATH;
	public static final String FPQZ_URL;
	public static final String FPKJ_LURL;
	public static final String FPKJ_HURL;
	public static final String FPQZCODE;
	public static final String MAXTHREADSIZE;
	public static final String FPKJCODE;
	public static final String XSF_NSSBH;
	public static final String XSF_MC;
	public static final String XSF_DZDH;
	public static final String XSF_YHZH;
	
	
	static {
		PDF_BASE_PATH = get("pdf_base_path");
		FPQZ_URL = get("fpqz_url");
		FPKJ_LURL = get("fpkj_lurl");
		FPKJ_HURL = get("fpkj_hurl");
		XML_HEAD = get("xml_head");
		FPQZCODE = get("fpqzcode");
		MAXTHREADSIZE = get("maxThreadSize");
		FPKJCODE = get("fpkjcode");
		XSF_NSSBH = get("xsf_nssbh");
		XSF_MC = get("xsf_mc");
		XSF_DZDH = get("xsf_dzdh");
		XSF_YHZH = get("xsf_yhzh");
		
	}

	private static String get(String key) {
		return ConfigReader.getConfigReader().get(key);
	}
	
}
