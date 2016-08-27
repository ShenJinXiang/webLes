package com.demo;

import javax.xml.rpc.ServiceException;

import com.aisino.ws.IEInvWebService;
import com.aisino.ws.IEInvWebServiceLocator;
import com.aisino.ws.IEInvWebServicePortType;

import sun.misc.BASE64Encoder;

public class Demo3 {
	
	public static void main(String[] args) throws Exception {
		String xml = getXML();
		IEInvWebService service = new IEInvWebServiceLocator();
		IEInvWebServicePortType sp = service.getIEInvWebServiceHttpPort();
		String result = sp.eiInterface(xml);
		System.out.println(result);
	}
	
	private static String getXML(){
		String content = 
			"<REQUEST_FPKJ class=\"REQUEST_FPKJ\">\r\n" + 
			"  <GHFMC>购方名称</GHFMC>\r\n" + 
			"  <GHF_NSRSBH>140114999999062</GHF_NSRSBH>\r\n" + 
			"  <FKFKHYH_FKFYHZH>12345</FKFKHYH_FKFYHZH>\r\n" + 
			"  <FKFDZ_FKFDH>12345678914</FKFDZ_FKFDH>\r\n" + 
			"  <XHFKHYH_SKFYHZH>454646</XHFKHYH_SKFYHZH>\r\n" + 
			"  <XHFDZ_XHFDH>太原02121515</XHFDZ_XHFDH>\r\n" + 
			"  <FPZL_DM>0</FPZL_DM>\r\n" + 
			"  <YFP_DM></YFP_DM>\r\n" + 
			"  <YFP_HM></YFP_HM>\r\n" + 
			"  <BZ>备注</BZ>\r\n" + 
			"  <KPY>开票人</KPY>\r\n" + 
			"  <FHR>复核人</FHR>\r\n" + 
			"  <SKY>收款人</SKY>\r\n" + 
			"  <XHQD></XHQD>\r\n" + 
			"  <FPQQLSH>124578</FPQQLSH>\r\n" + 
			"  <KPLX>0</KPLX>\r\n" + 
			"  <JSHJ>351.0</JSHJ>\r\n" + 
			"  <HJJE>300.0</HJJE>\r\n" + 
			"  <HJSE>51.0</HJSE>\r\n" + 
			"  <FP_KJMXS class=\"FP_KJMX;\" size=\"2\">\r\n" + 
			"    <FP_KJMX>\r\n" + 
			"      <SPMC>项目名称</SPMC>\r\n" + 
			"      <SM></SM>\r\n" + 
			"      <SL>0.17</SL>\r\n" + 
			"      <GGXH>个</GGXH>\r\n" + 
			"      <JLDW>个</JLDW>\r\n" + 
			"      <SPSL>1.0</SPSL>\r\n" + 
			"      <SPDJ>100.0</SPDJ>\r\n" + 
			"	   <SPJE>100.0</SPJE>\r\n"+
			"      <FPHXZ>0</FPHXZ>\r\n" + 
			"      <HSJBZ>0</HSJBZ>\r\n" + 
			"      <SE>17.0</SE>\r\n" + 
			"    </FP_KJMX>\r\n" + 
			"    <FP_KJMX>\r\n" + 
			"      <SPMC>项目名称</SPMC>\r\n" + 
			"      <SM></SM>\r\n" + 
			"      <SL>0.17</SL>\r\n" + 
			"      <GGXH>台</GGXH>\r\n" + 
			"      <JLDW>台</JLDW>\r\n" + 
			"      <SPSL>2.0</SPSL>\r\n" + 
			"      <SPDJ>100.0</SPDJ>\r\n" + 
			"	   <SPJE>200.0</SPJE>\r\n"+
			"      <FPHXZ>0</FPHXZ>\r\n" + 
			"      <HSJBZ>0</HSJBZ>\r\n" + 
			"      <SE>34.0</SE>\r\n" + 
			"    </FP_KJMX>\r\n" + 
			"  </FP_KJMXS>\r\n" + 
			"</REQUEST_FPKJ>\r\n";
		System.out.println("-----------------------------------content-------------------------------------------");
		System.out.println(content);
		String xml = 
			"<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\r\n" + 
			"<interface>\r\n" + 
			"  <globalInfo>\r\n" + 
			"    <appId>ZZSDZFP</appId>\r\n" + 
			"    <interfaceCode>EI.FPKJ.U.EC.INTRA</interfaceCode>\r\n" + 
			"    <userName>140114999999062</userName>\r\n" + 
			"    <passWord>456456546</passWord>\r\n" + 
			"    <requestCode>144</requestCode>\r\n" + 
			"    <requestTime>2016-08-16 17:54:22 231</requestTime>\r\n" + 
			"    <responseCode>155</responseCode>\r\n" + 
			"    <dataExchangeId>124578</dataExchangeId>\r\n" + 
			"    <fjh></fjh>\r\n" + 
			"    <jqbh></jqbh>\r\n" + 
			"  </globalInfo>\r\n" + 
			"  <returnStateInfo>\r\n" + 
			"    <returnCode></returnCode>\r\n" + 
			"    <returnMessage></returnMessage>\r\n" + 
			"  </returnStateInfo>\r\n" + 
			"  <Data>\r\n" + 
			"    <dataDescription>\r\n" + 
			"      <zipCode>0</zipCode>\r\n" + 
			"      <encryptCode>0</encryptCode>\r\n" + 
			"      <codeType>0</codeType>\r\n" + 
			"    </dataDescription>\r\n" + 
			"    <content>" + new BASE64Encoder().encode(content.getBytes()) + "</content>\r\n" + 
			"  </Data>\r\n" + 
			"</interface>"; 
		System.out.println("-----------------------------------xml-------------------------------------------");
		System.out.println(xml);
		return xml;
	}
}
