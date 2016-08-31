package com.qysoft.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("FPQZ_XMXX")
public class FPQZ_XMXX {

	/**
	 * 项目名称
	 */
	@XStreamAlias("XMMC")
	private String xmmc;
	
	/**
	 * 规格型号
	 */
	@XStreamAlias("GGXH")
	private String ggxh;
	
	/**
	 * 计量单位
	 */
	@XStreamAlias("DW")
	private String dw;
	
	/**
	 * 项目数量
	 */
	@XStreamAlias("XMSL")
	private String xmsl;
	
	/**
	 * 项目单价
	 */
	@XStreamAlias("XMDJ")
	private String xmdj;
	
	/**
	 * 项目金额
	 */
	@XStreamAlias("XMJE")
	private String xmje;
	
	/**
	 * 税率
	 */
	@XStreamAlias("SL")
	private String sl;
	
	/**
	 * 税额
	 */
	@XStreamAlias("SE")
	private String se;
	
	/**
	 * 含税标志
	 */
	@XStreamAlias("HSBZ")
	private String hsbz;
	
	/**
	 * 发票行性质  0 正常行、 1 折扣行、 2 被折扣行
	 */
	@XStreamAlias("FPHXZ")
	private String fphxz;
	
	/**
	 * 商品编码
	 */
	@XStreamAlias("SPBM")
	private String spbm;
	
	/**
	 * 自行编码
	 */
	@XStreamAlias("ZXBM")
	private String zxbm;
	
	/**
	 * 优惠政策标识  0：不使用， 1：使用
	 */
	@XStreamAlias("YHZCBS")
	private String yhzcbs;
	
	/**
	 * 零税率标识
	 * 空：非零税率， 1：免税， 2：不征税， 3 普通零税率
	 */
	@XStreamAlias("LSLBS")
	private String lslbs;
	
	/**
	 * 增值税特殊管理	当 YHZCBS 为 1 时必填
	 */
	@XStreamAlias("ZZSTSGL")
	private String zzstsgl;
	
	/**
	 * 扣除额
	 */
	@XStreamAlias("KCE")
	private String kce;

	public String getXmmc() {
		return xmmc;
	}

	public void setXmmc(String xmmc) {
		this.xmmc = xmmc;
	}

	public String getGgxh() {
		return ggxh;
	}

	public void setGgxh(String ggxh) {
		this.ggxh = ggxh;
	}

	public String getDw() {
		return dw;
	}

	public void setDw(String dw) {
		this.dw = dw;
	}

	public String getXmsl() {
		return xmsl;
	}

	public void setXmsl(String xmsl) {
		this.xmsl = xmsl;
	}

	public String getXmdj() {
		return xmdj;
	}

	public void setXmdj(String xmdj) {
		this.xmdj = xmdj;
	}

	public String getXmje() {
		return xmje;
	}

	public void setXmje(String xmje) {
		this.xmje = xmje;
	}

	public String getSl() {
		return sl;
	}

	public void setSl(String sl) {
		this.sl = sl;
	}

	public String getSe() {
		return se;
	}

	public void setSe(String se) {
		this.se = se;
	}

	public String getHsbz() {
		return hsbz;
	}

	public void setHsbz(String hsbz) {
		this.hsbz = hsbz;
	}

	public String getFphxz() {
		return fphxz;
	}

	public void setFphxz(String fphxz) {
		this.fphxz = fphxz;
	}

	public String getSpbm() {
		return spbm;
	}

	public void setSpbm(String spbm) {
		this.spbm = spbm;
	}

	public String getZxbm() {
		return zxbm;
	}

	public void setZxbm(String zxbm) {
		this.zxbm = zxbm;
	}

	public String getYhzcbs() {
		return yhzcbs;
	}

	public void setYhzcbs(String yhzcbs) {
		this.yhzcbs = yhzcbs;
	}

	public String getLslbs() {
		return lslbs;
	}

	public void setLslbs(String lslbs) {
		this.lslbs = lslbs;
	}

	public String getZzstsgl() {
		return zzstsgl;
	}

	public void setZzstsgl(String zzstsgl) {
		this.zzstsgl = zzstsgl;
	}

	public String getKce() {
		return kce;
	}

	public void setKce(String kce) {
		this.kce = kce;
	}
	
}
