package com.qysoft.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

public class FPQZ_FPT {
	
	/**
	 * class属性 FPQZ_FPT
	 */
	@XStreamAlias("class")
	@XStreamAsAttribute
	private String clazz;

	/**
	 * 发票请求流水号
	 */
	@XStreamAlias("FPQQLSH")
	private String fpqqlsh;
	
	/**
	 * 开票类型 0-蓝字发票  1-红字发票
	 */
	@XStreamAlias("KPLX")
	private String kplx;
	
	/**
	 * 编码表版本号，目前为 1.0
	 */
	@XStreamAlias("BMB_BBH")
	private String bmb_bbh;
	
	/**
	 *  清单标志 
	 *  0：根据项目名称字数，自动产生清单，保持目前逻辑不变 
	 *  1：取清单对应票面内容字段打印到发票票面上，将项目信息 XMXX打印到清单上。
	 *  默认为 0。
	 */
	@XStreamAlias("QD_BZ")
	private String qd_bz;
	
	/**
	 * 清单发票项目名称
	 * 需要打印清单时对应发票票面项目名称
	 * 清单标识（ QD_BZ）为 1 时必填。为 0 不进行处理。
	 */
	@XStreamAlias("QDXMMC")
	private String qdxmmc;
	
	/**
	 * 销售方纳税人识别号
	 */
	@XStreamAlias("XSF_NSRSBH")
	private String xsf_nsrsbh;
	
	/**
	 * 销售方名称
	 */
	@XStreamAlias("XSF_MC")
	private String xsf_mc;
	
	/**
	 * 销售方地址、 电话
	 */
	@XStreamAlias("XSF_DZDH")
	private String xsf_dzdh;
	
	/**
	 * 销售方银行账号
	 */
	@XStreamAlias("XSF_YHZH")
	private String xsf_yhzh;
	
	/**
	 * 购买方纳税人识别号
	 */
	@XStreamAlias("GMF_NSRSBH")
	private String gmf_nsrsbh;
	
	/**
	 * 购买方名称
	 */
	@XStreamAlias("GMF_MC")
	private String gmf_mc;
	
	/**
	 * 购买方地址、 电话 
	 */
	@XStreamAlias("GMF_DZDH")
	private String gmf_dzdh;
	
	/**
	 * 购买方银行账号 
	 */
	@XStreamAlias("GMF_YHZH")
	private String gmf_yhzh;
	
	/**
	 * 开票人
	 */
	@XStreamAlias("KPR")
	private String kpr;
	
	/**
	 * 收款人
	 */
	@XStreamAlias("SKR")
	private String skr;
	
	/**
	 * 复核人
	 */
	@XStreamAlias("FHR")
	private String fhr;
	
	/**
	 * 原发票代码 红字发票时必须
	 */
	@XStreamAlias("YFP_DM")
	private String yfp_dm;
	
	/**
	 * 原发票号码  红字发票时必须
	 */
	@XStreamAlias("YFP_HM")
	private String yfp_hm;
	
	/**
	 * 价税合计  单位：元（ 2 位小数）
	 */
	@XStreamAlias("JSHJ")
	private String jshj;
	
	/**
	 * 合计金额  不含税，单位：元（ 2 位小数）
	 */
	@XStreamAlias("HJJE")
	private String hjje;
	
	/**
	 * 合计税额  单位：元（ 2 位小数）
	 */
	@XStreamAlias("HJSE")
	private String hjse;
	
	/**
	 * 备注  
	 * 开具负数发票，必须在备注中注明“对应正数发票代码:XXXXXXXXX 号码:YYYYYYYY”字样，
	 * 其中“ X”为发票代码，“ Y”为发票号码
	 */
	@XStreamAlias("BZ")
	private String bz;
	
	/**
	 * 发票状态  0-正常发票； 1-作废发票
	 */
	@XStreamAlias("FPZT")
	private String fpzt;
	
	/**
	 * 税控设备编号  成功必填
	 */
	@XStreamAlias("JQBH")
	private String jqbh;
	
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
	 * 开票日期  YYYYMMDDHHMMSS
	 */
	@XStreamAlias("KPRQ")
	private String kprq;
	
	/**
	 * 发票密文
	 */
	@XStreamAlias("FP_MW")
	private String fp_mw;
	
	/**
	 * 发票校验码
	 */
	@XStreamAlias("JYM")
	private String jym;

	/**
	 * 二维码
	 */
	@XStreamAlias("EWM")
	private String ewm;
	
	/**
	 * PDF 下载方式 1 PDF 文件（ PDF_FILE）2 PDF 下载路径（ PDF_URL）
	 */
	@XStreamAlias("PDF_XZFS")
	private String pdf_xzfs;

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

	public String getKplx() {
		return kplx;
	}

	public void setKplx(String kplx) {
		this.kplx = kplx;
	}

	public String getBmb_bbh() {
		return bmb_bbh;
	}

	public void setBmb_bbh(String bmb_bbh) {
		this.bmb_bbh = bmb_bbh;
	}

	public String getQd_bz() {
		return qd_bz;
	}

	public void setQd_bz(String qd_bz) {
		this.qd_bz = qd_bz;
	}

	public String getQdxmmc() {
		return qdxmmc;
	}

	public void setQdxmmc(String qdxmmc) {
		this.qdxmmc = qdxmmc;
	}

	public String getXsf_nsrsbh() {
		return xsf_nsrsbh;
	}

	public void setXsf_nsrsbh(String xsf_nsrsbh) {
		this.xsf_nsrsbh = xsf_nsrsbh;
	}

	public String getXsf_mc() {
		return xsf_mc;
	}

	public void setXsf_mc(String xsf_mc) {
		this.xsf_mc = xsf_mc;
	}

	public String getXsf_dzdh() {
		return xsf_dzdh;
	}

	public void setXsf_dzdh(String xsf_dzdh) {
		this.xsf_dzdh = xsf_dzdh;
	}

	public String getXsf_yhzh() {
		return xsf_yhzh;
	}

	public void setXsf_yhzh(String xsf_yhzh) {
		this.xsf_yhzh = xsf_yhzh;
	}

	public String getGmf_nsrsbh() {
		return gmf_nsrsbh;
	}

	public void setGmf_nsrsbh(String gmf_nsrsbh) {
		this.gmf_nsrsbh = gmf_nsrsbh;
	}

	public String getGmf_mc() {
		return gmf_mc;
	}

	public void setGmf_mc(String gmf_mc) {
		this.gmf_mc = gmf_mc;
	}

	public String getGmf_dzdh() {
		return gmf_dzdh;
	}

	public void setGmf_dzdh(String gmf_dzdh) {
		this.gmf_dzdh = gmf_dzdh;
	}

	public String getGmf_yhzh() {
		return gmf_yhzh;
	}

	public void setGmf_yhzh(String gmf_yhzh) {
		this.gmf_yhzh = gmf_yhzh;
	}

	public String getKpr() {
		return kpr;
	}

	public void setKpr(String kpr) {
		this.kpr = kpr;
	}

	public String getSkr() {
		return skr;
	}

	public void setSkr(String skr) {
		this.skr = skr;
	}

	public String getFhr() {
		return fhr;
	}

	public void setFhr(String fhr) {
		this.fhr = fhr;
	}

	public String getYfp_dm() {
		return yfp_dm;
	}

	public void setYfp_dm(String yfp_dm) {
		this.yfp_dm = yfp_dm;
	}

	public String getYfp_hm() {
		return yfp_hm;
	}

	public void setYfp_hm(String yfp_hm) {
		this.yfp_hm = yfp_hm;
	}

	public String getJshj() {
		return jshj;
	}

	public void setJshj(String jshj) {
		this.jshj = jshj;
	}

	public String getHjje() {
		return hjje;
	}

	public void setHjje(String hjje) {
		this.hjje = hjje;
	}

	public String getHjse() {
		return hjse;
	}

	public void setHjse(String hjse) {
		this.hjse = hjse;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public String getFpzt() {
		return fpzt;
	}

	public void setFpzt(String fpzt) {
		this.fpzt = fpzt;
	}

	public String getJqbh() {
		return jqbh;
	}

	public void setJqbh(String jqbh) {
		this.jqbh = jqbh;
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

	public String getKprq() {
		return kprq;
	}

	public void setKprq(String kprq) {
		this.kprq = kprq;
	}

	public String getFp_mw() {
		return fp_mw;
	}

	public void setFp_mw(String fp_mw) {
		this.fp_mw = fp_mw;
	}

	public String getJym() {
		return jym;
	}

	public void setJym(String jym) {
		this.jym = jym;
	}

	public String getEwm() {
		return ewm;
	}

	public void setEwm(String ewm) {
		this.ewm = ewm;
	}

	public String getPdf_xzfs() {
		return pdf_xzfs;
	}

	public void setPdf_xzfs(String pdf_xzfs) {
		this.pdf_xzfs = pdf_xzfs;
	}
	
}
