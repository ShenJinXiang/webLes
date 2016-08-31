package com;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.axis.encoding.Base64;

import com.aisino.ws.IEInvWebService;
import com.aisino.ws.IEInvWebServiceLocator;
import com.aisino.ws.IEInvWebServicePortType;
import com.qysoft.bean.Data;
import com.qysoft.bean.DataDescription;
import com.qysoft.bean.FPQZ_FPT;
import com.qysoft.bean.FPQZ_XMXX;
import com.qysoft.bean.FPQZ_XMXXS;
import com.qysoft.bean.GlobalInfo;
import com.qysoft.bean.Interface;
import com.qysoft.bean.REQUEST_FPQZ;
import com.qysoft.bean.ReturnStateInfo;
import com.qysoft.config.Config;
import com.qysoft.utils.Base64Util;
import com.qysoft.utils.DateUtil;
import com.qysoft.utils.GzipUtil;
import com.qysoft.utils.MD5Util;
import com.qysoft.utils.XMLUtil;

public class zsqz {

	public static void main(String[] args) throws Exception {
		String xml = getXML();
		IEInvWebServiceLocator service = new IEInvWebServiceLocator();
		service.setIEInvWebServiceHttpPortEndpointAddress(Config.FPQZ_URL);
		IEInvWebServicePortType pt = service.getIEInvWebServiceHttpPort();
		String result = pt.eiInterface(xml);
		System.out.println(result);
		
		
		Interface itf = (Interface) XMLUtil.xmlToObject(result, Interface.class);
		if("0000".equals(itf.getReturnStateInfo().getReturnCode())) {
			String content = itf.getData().getContent();
			String cnt = new String(GzipUtil.decompress(Base64.decode(content)), "utf-8");
//			System.out.println(cnt);
			String pdf_file = cnt.substring(cnt.indexOf("<PDF_FILE>") + "<PDF_FILE>".length(), cnt.indexOf("</PDF_FILE>"));
			File file = new File("0001.pdf");
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(Base64.decode(pdf_file));
			fos.flush();
			fos.close();
			System.out.println(file.getAbsolutePath());
		}
		
	}
	
	public static String getXML() {
		String nsrsbh = "91140200715951811C"; // 纳税人识别号
		String ptbm = "11436202"; // 平台编码
		String lsh = "d35skpyd45873405kd33"; // 流水号
		String sqm = "915951811C"; // 授权码 
		String zcm = "31106756"; // 注册码
		
		REQUEST_FPQZ request_fpqz = new REQUEST_FPQZ();
		request_fpqz.setClazz("REQUEST_FPQZ");
		
		FPQZ_FPT fpqz_fpt = new FPQZ_FPT();
		fpqz_fpt.setClazz("FPQZ_FPT");
		fpqz_fpt.setFpqqlsh(lsh);
		fpqz_fpt.setKplx("0");
		fpqz_fpt.setBmb_bbh("1.0");
		fpqz_fpt.setQd_bz("0");
		fpqz_fpt.setQdxmmc("");
		fpqz_fpt.setXsf_nsrsbh(Config.XSF_NSSBH);
		fpqz_fpt.setXsf_mc(Config.XSF_MC);
		fpqz_fpt.setXsf_dzdh(Config.XSF_DZDH);
		fpqz_fpt.setXsf_yhzh(Config.XSF_YHZH);
		fpqz_fpt.setGmf_nsrsbh(Config.XSF_NSSBH);
		fpqz_fpt.setGmf_mc("购买方");
		fpqz_fpt.setGmf_dzdh("北京 1232424242");
		fpqz_fpt.setGmf_yhzh("农行 12932949242499293");
		fpqz_fpt.setKpr("热力公司");
		fpqz_fpt.setSkr("复核人1");
		fpqz_fpt.setFhr("收款人1");
		fpqz_fpt.setYfp_dm("");
		fpqz_fpt.setYfp_hm("");
		fpqz_fpt.setJshj("117");
		fpqz_fpt.setHjje("100");
		fpqz_fpt.setHjse("17");
		fpqz_fpt.setBz("备注信息");
		fpqz_fpt.setFpzt("0");
		fpqz_fpt.setJqbh("661545614617");
		fpqz_fpt.setFp_dm("1400083620");
		fpqz_fpt.setFp_hm("00347721");
		fpqz_fpt.setKprq(DateUtil.format(new Date(), DateUtil.C_TIME_PATTON_OPTION));
		fpqz_fpt.setFp_mw("&lt;-&lt;2+87107-0&lt;8-&lt;972-2238&gt;--7-65&gt;/&gt;-12&gt;/*&gt;81*244*819/200784-9*1&lt;+7006-4&lt;92&gt;-362-01*7-96491&gt;/&gt;-12&gt;/*&gt;81*2425-5");
		fpqz_fpt.setJym("85503655322972401807");
		fpqz_fpt.setEwm("Qk3CAwAAAAAAAD4AAAAoAAAASwAAAEsAAAABAAEAAAAAAIQDAAAAAAAAAAAAAAAAAAACAAAAAAAA///////////////////gAAAAAwM/Awzzw8AgAAAAAwM/Awzzw8AgAAA/8/DwDAAzw8DgAAA/8/DwDAAzw8DgAAAwM8zMzMDM88/gAAAwM8zMzMDM88/gAAAwM88/8PPD888gAAAwM88/8PPD888gAAAwMwwwPz8zADDgAAAwMwwwPz8zADDgAAA/8/AMPAwwPwDgAAA/8/AMPAwwPwDgAAAAAwD8M8DDMwDgAAAAAwD8M8DDMwDgAAD//zAwzzAMPzzgAAD//zAwzzAMPzzgAAD88/88AM/zAAMgAAD88/88AM/zAAMgAAAPzz/Dz8A/zMMgAAAPzz/Dz8A/zMMgAAAPAPwPMwA8zPzgAAAPAPwPMwA8zPzgAADzDDAzPDwMzDzgAADzDDAzPDwMzDzgAAADMAAz8PPzM8PgAAADMAAz8PPzM8PgAAD/PAPDA/M/A8DgAAD/PAPDA/M/A8DgAADAwD/AD/w8zPDgAADAwD/AD/w8zPDgAAAw/wAw/wAMzDzgAAAw/wAw/wAMzDzgAADAwDDzA8/zM8MgAADAwDDzA8/zM8MgAADA/zA8AAw/DMDgAADA/zA8AAw/DMDgAADA8APwzPD8DMDgAADA8APwzPD8DMDgAAAA/Mwz8PAMzDzgAAAA/Mwz8PAMzDzgAAA8Mww8PD/zM8AgAAA8Mww8PD/zM8AgAADA//PMP88/wMPgAADA//PMP88/wMPgAAD/M/8MM8A8D8DgAAD/M/8MM8A8D8DgAAAwDDDMzzA8zADgAAAwDDDMzzA8zADgAADPM//wwAzzM8MgAADPM//wwAzzM8MgAAA8PDMzz8D8z8PgAAA8PDMzz8D8z8PgAAADAMz/DwwwDDDgAAADAMz/DwwwDDDgAAAAP88PPA/8zA/gAAAAP88PPA/8zA/gAAA/MAPD8/MzAA8gAAA/MAPD8/MzAA8gAAD//wAAwzDzP//gAAD//wAAwzDzP//gAAAAAzMzMzMzMAAgAAAAAzMzMzMzMAAgAAA/8w//8AMD8/8gAAA/8w//8AMD8/8gAAAwMwzM/wwA8wMgAAAwMwzM/wwA8wMgAAAwMzwDPDAM8wMgAAAwMzwDPDAM8wMgAAAwM8PwzAP8MwMgAAAwM8PwzAP8MwMgAAA/8/AwAz8D8/8gAAA/8/AwAz8D8/8gAAAAAwDD8M8M8AAgAAAAAwDD8M8M8AAgAAA=");
		fpqz_fpt.setPdf_xzfs("3");
		request_fpqz.setFpqz_fpt(fpqz_fpt);
		
		String fpqz_info = new String(Base64Util.encodeForByte(("SJLY" + (char)2 + "06" + (char)3 + "FPLX" + (char)2 + "1")));
		request_fpqz.setFpqz_info(fpqz_info);
		
		FPQZ_XMXXS fpqz_xmxxs = new FPQZ_XMXXS();
		fpqz_xmxxs.setClazz("FPQZ_XMXX;");
		List<FPQZ_XMXX> list = new ArrayList<>();
		FPQZ_XMXX xm = new FPQZ_XMXX();
		xm.setXmmc("项目名称123");
		xm.setDw("个");
		xm.setGgxh("lb6500");
		xm.setXmsl("1");
		xm.setXmdj("100");
		xm.setXmje("100");
		xm.setSl("0.17");
		xm.setSe("17");
		xm.setHsbz("0");
		xm.setFphxz("0");
		xm.setSpbm("");
		xm.setZxbm("");
		xm.setYhzcbs("");
		xm.setLslbs("");
		xm.setKce("0");
		list.add(xm);
		
		fpqz_xmxxs.setSize(list.size() + "");
		fpqz_xmxxs.setFpqz_xmxxs(list);
		request_fpqz.setFpqz_xmxxs(fpqz_xmxxs);
		
		String content = XMLUtil.objetToXml(request_fpqz, REQUEST_FPQZ.class);
		System.out.println(content);
		
		Interface itf = new Interface();
		
		Data data = new Data();
		data.setContent(Base64Util.encode(content));
		DataDescription dataDescription = new DataDescription();
		dataDescription.setCodeType("0");
		dataDescription.setEncryptCode("0");
		dataDescription.setZipCode("0");
		data.setDataDescription(dataDescription);
		itf.setData(data);
		
		GlobalInfo globalInfo = new GlobalInfo();
		globalInfo.setTerminalCode("0");
		globalInfo.setAppId("A16D8DBD18EDDD80");
		globalInfo.setVersion("2");
		globalInfo.setInterfaceCode(Config.FPQZCODE);
		globalInfo.setRequestCode(ptbm);
		globalInfo.setRequestTime("2015-08-06 10:30:42 978");
		globalInfo.setResponseCode("144");
		globalInfo.setDataExchangeId(lsh);
		globalInfo.setUserName(ptbm);
		globalInfo.setPassWord(getPassword(zcm));
		globalInfo.setTaxpayerId(nsrsbh);
		globalInfo.setAuthorizationCode(sqm);
		itf.setGlobalInfo(globalInfo);
		
		ReturnStateInfo returnStateInfo = new ReturnStateInfo();
		returnStateInfo.setReturnCode("");
		returnStateInfo.setReturnMessage("");
		itf.setReturnStateInfo(returnStateInfo);
		String xml = XMLUtil.objetToXml(itf, Interface.class);
		System.out.println(xml);
		return xml;
	}

	private static String getPassword(String zcm) {
		String sjs = "3839850347";
		String str = sjs + Base64Util.encode(MD5Util.MD5(sjs + zcm));
		return str;
	}
}
