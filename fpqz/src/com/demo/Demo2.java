package com.demo;

import java.io.UnsupportedEncodingException;
import java.rmi.RemoteException;

import com.aisino.ws.IEInvWebService;
import com.aisino.ws.IEInvWebServiceLocator;
import com.aisino.ws.IEInvWebServicePortType;

import sun.misc.BASE64Encoder;

public class Demo2 {

	public static void main(String[] args) throws Exception {
		String xml = getXML();
		IEInvWebService service = new IEInvWebServiceLocator();
		IEInvWebServicePortType pt = service.getIEInvWebServiceHttpPort();
		String result = pt.eiInterface(xml);
		System.out.println(result);
	}
	
	private static String getXML() throws UnsupportedEncodingException {
		String content = 
		"<REQUEST_FPQZ class=\"REQUEST_FPQZ\">\r\n" + 
		"  <FPQZ_INFO>U0pMWQIwNgNGUExYAjE=</FPQZ_INFO>\r\n" + 
		"  <FPQZ_FPT class=\"FPQZ_FPT\">\r\n" + 
		"    <FPQQLSH>d123dfsf1k2578</FPQQLSH>\r\n" + 
		"    <KPLX>0</KPLX>\r\n" + 
		"    <BMB_BBH>1.0</BMB_BBH>\r\n" + 
		"    <QD_BZ>0</QD_BZ>\r\n" + 
		"    <QDXMMC></QDXMMC>\r\n" + 
		"    <XSF_NSRSBH>110101MXB6CK9Q6</XSF_NSRSBH>\r\n" + 
		"    <XSF_MC>销售方公司</XSF_MC>\r\n" + 
		"    <XSF_DZDH>太原02121515</XSF_DZDH>\r\n" + 
		"    <XSF_YHZH>454646</XSF_YHZH>\r\n" + 
		"    <GMF_NSRSBH>110101MXB6CK9Q6</GMF_NSRSBH>\r\n" + 
		"    <GMF_MC>购方名称</GMF_MC>\r\n" + 
		"    <GMF_DZDH>12345678914</GMF_DZDH>\r\n" + 
		"    <GMF_YHZH>12345</GMF_YHZH>\r\n" + 
		"    <KPR>开票人</KPR>\r\n" + 
		"    <SKR>收款人</SKR>\r\n" + 
		"    <FHR>复核人</FHR>\r\n" + 
		"    <YFP_DM></YFP_DM>\r\n" + 
		"    <YFP_HM></YFP_HM>\r\n" + 
		"    <JSHJ>351.0</JSHJ>\r\n" + 
		"    <HJJE>300.0</HJJE>\r\n" + 
		"    <HJSE>51.0</HJSE>\r\n" + 
		"    <BZ>备注</BZ>\r\n" + 
		"    <FPZT>0</FPZT>\r\n" + 
		"    <JQBH>661545614617</JQBH>\r\n" + 
		"    <FP_DM>1400083621</FP_DM>\r\n" + 
		"    <FP_HM>00347704</FP_HM>\r\n" + 
		"    <KPRQ>20160818114247000</KPRQ>\r\n" + 
		"    <FP_MW>1901&lt;561/++1&lt;6/14*8&gt;2-920-25028812+/77+9*/3+8&lt;33+&gt;152/63&lt;14-22+760/-+5&lt;74068*6-9-68-04&gt;/*812+/77+9*/3+8&lt;5+5-</FP_MW>\r\n" + 
		"    <JYM>72982236222360217100</JYM>\r\n" + 
		"    <EWM>Qk3CAwAAAAAAAD4AAAAoAAAASwAAAEsAAAABAAEAAAAAAIQDAAAAAAAAAAAAAAAAAAACAAAAAAAA///////////////////gAAAAAzz8APzMzDAgAAAAAzz8APzMzDAgAAA/88ADPzMA/PPgAAA/88ADPzMA/PPgAAAwMzP/DDzDMzPgAAAwMzP/DDzDMzPgAAAwMw/88wA88A8gAAAwMw/88wA88A8gAAAwM8wA8/M/ADwgAAAwM8wA8/M/ADwgAAA/8zP//PAzPzzgAAA/8zP//PAzPzzgAAAAAzA8z88/Mw8gAAAAAzA8z88/Mw8gAAD//wzAA/zAPzAgAAD//wzAA/zAPzAgAAAMADAMP8wDAADgAAAMADAMP8wDAADgAADADPDDM8//M8zgAADADPDDM8//M8zgAAA8w/DwADMPPz/gAAA8w/DwADMPPz/gAAAzDAMDAzw88z8gAAAzDAMDAzw88z8gAADMA8wM8wMMMDAgAADMA8wM8wMMMDAgAAAPzwADMMAMMPAgAAAPzwADMMAMMPAgAAA/Mw8/DwAzDAzgAAA/Mw8/DwAzDAzgAADDzz8z/PAzz8zgAADDzz8z/PAzz8zgAADwAP/PzwM//w/gAADwAP/PzwM//w/gAAA//PwzwPPzzDzgAAA//PwzwPPzzDzgAAAwM//MMP/88w8gAAAwM//MMP/88w8gAAAzPD8DPDzAAPwgAAAzPD8DPDzAAPwgAAAPAAP8AzwDDMDgAAAPAAP8AzwDDMDgAADDzMPww8DzPM/gAADDzMPww8DzPM/gAAA8AwzDAPMPPPPgAAA8AwzDAPMPPPPgAAD8/Pzw8DP88wMgAAD8/Pzw8DP88wMgAADwAPMDw/zMMDMgAADwAPMDw/zMMDMgAAAADzzA/PPMPPDgAAAADzzA/PPMPPDgAAAAMAMwz/A/z8zgAAAAMAMwz/A/z8zgAAAA/wP8P/wDz8PgAAAA/wP8P/wDz8PgAAAwwM8DPz8/88wgAAAwwM8DPz8/88wgAAD//z/Dw8z8///gAAD//z/Dw8z8///gAAAAAzMzMzMzMAAgAAAAAzMzMzMzMAAgAAA/88//PM/zM/8gAAA/88//PM/zM/8gAAAwM8DzwA/w8wMgAAAwM8DzwA/w8wMgAAAwMw8AwD/MMwMgAAAwMw8AwD/MMwMgAAAwM8PPPzPPMwMgAAAwM8PPPzPPMwMgAAA/8wMwPDDzM/8gAAA/8wMwPDDzM/8gAAAAAz8AMw8z8AAgAAAAAz8AMw8z8AAgAAA=</EWM>\r\n" + 
		"    <PDF_XZFS>3</PDF_XZFS>\r\n" + 
		"  </FPQZ_FPT>\r\n" + 
		"  <FPQZ_XMXXS class=\"FPQZ_XMXX;\" size=\"2\">\r\n" + 
		"    <FPQZ_XMXX>\r\n" + 
		"      <XMMC>项目名称1</XMMC>\r\n" + 
		"      <GGXH>个</GGXH>\r\n" + 
		"      <DW>个</DW>\r\n" + 
		"      <XMSL>1.0</XMSL>\r\n" + 
		"      <XMDJ>100.0</XMDJ>\r\n" + 
		"      <XMJE>100.0</XMJE>\r\n" + 
		"      <SL>0.17</SL>\r\n" + 
		"      <SE>17.0</SE>\r\n" + 
		"      <HSBZ>0</HSBZ>\r\n" + 
		"      <FPHXZ>0</FPHXZ>\r\n" + 
		"      <SPBM>1212 </SPBM>\r\n" + 
		"      <ZXBM>企业自编码 </ZXBM>\r\n" + 
		"      <YHZCBS>0</YHZCBS>\r\n" + 
		"      <LSLBS></LSLBS>\r\n" + 
		"      <KCE>0.12</KCE>\r\n" + 
		"    </FPQZ_XMXX>\r\n" + 
		"    <FPQZ_XMXX>\r\n" + 
		"      <XMMC>项目名称2</XMMC>\r\n" + 
		"      <GGXH>台</GGXH>\r\n" + 
		"      <DW>台</DW>\r\n" + 
		"      <XMSL>2.0</XMSL>\r\n" + 
		"      <XMDJ>100.0</XMDJ>\r\n" + 
		"      <XMJE>200.0</XMJE>\r\n" + 
		"      <SL>0.17</SL>\r\n" + 
		"      <SE>34.0</SE>\r\n" + 
		"      <HSBZ>0</HSBZ>\r\n" + 
		"      <FPHXZ>0</FPHXZ>\r\n" + 
		"      <SPBM>1 </SPBM>\r\n" + 
		"      <ZXBM>企业自编码 </ZXBM>\r\n" + 
		"      <YHZCBS>0</YHZCBS>\r\n" + 
		"      <LSLBS></LSLBS>\r\n" + 
		"      <KCE>0.23</KCE>\r\n" + 
		"    </FPQZ_XMXX>\r\n" + 
		"  </FPQZ_XMXXS>\r\n" + 
		"</REQUEST_FPQZ>\r\n";
		
		String xml = 
		"<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\r\n" + 
		"<interface>\r\n" + 
		"  <globalInfo>\r\n" + 
		"    <terminalCode>0</terminalCode>\r\n" + 
		"    <appId>A16D8DBD18EDDD80</appId>\r\n" + 
		"    <version>2</version>\r\n" + 
		"    <interfaceCode>ECXML.FPQZ.BC.E.INV</interfaceCode>\r\n" + 
		"    <userName>14410101</userName>\r\n" + 
		"    <passWord>0981202609xFBzKNdCxSuCZP2TjDD2fA==</passWord>\r\n" + 
		"    <taxpayerId>110101MXB6CK9Q6</taxpayerId>\r\n" + 
		"    <authorizationCode>6270892641</authorizationCode>\r\n" + 
		"    <requestCode>14410101</requestCode>\r\n" + 
		"    <requestTime>2015-08-06 10:30:42 978</requestTime>\r\n" + 
		"    <responseCode>144</responseCode>\r\n" + 
		"    <dataExchangeId>1441010120160825987456123</dataExchangeId>\r\n" + 
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
		"    <content>" + new BASE64Encoder().encode(content.getBytes("utf-8")) + "</content>\r\n" + 
		"  </Data>\r\n" + 
		"</interface>\r\n";
		
		return xml;
	}
}
