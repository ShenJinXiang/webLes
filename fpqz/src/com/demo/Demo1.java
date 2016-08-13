package com.demo;

import java.io.UnsupportedEncodingException;
import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import com.aisino.ws.IEInvWebService;
import com.aisino.ws.IEInvWebServiceLocator;
import com.aisino.ws.IEInvWebServicePortType;

import sun.misc.BASE64Encoder;

public class Demo1 {

	public static void main(String[] args) throws ServiceException, RemoteException, UnsupportedEncodingException {
		String xml = getXML();
		IEInvWebService service = new IEInvWebServiceLocator();
		IEInvWebServicePortType pt = service.getIEInvWebServiceHttpPort();
		String result = pt.eiInterface(xml);
		System.out.println(result);
	}
	
	public static String getXML() throws UnsupportedEncodingException {
		String content = 
				"<REQUEST_FPQZ class=\"REQUEST_FPQZ\">" + 
				"	<FPQZ_INFO>" +
					new BASE64Encoder().encode(("SJLY" + (char)2 + "06" + (char)3 + "FPLX" + (char)2 + "1").getBytes())+
			    "</FPQZ_INFO>" + 
				"	<FPQZ_FPT class=\"FPQZ_FPT\">" + 
				"		<FPQQLSH>110101TRDX8RQU1</FPQQLSH>" + 
				"		<KPLX>0</KPLX>" + 
				"		<XSF_NSRSBH>110101MXB6CK9Q6</XSF_NSRSBH>" + 
				"		<XSF_MC>xxx股份有限公司</XSF_MC>" + 
				"		<XSF_DZDH>北京010-001201</XSF_DZDH>" + 
				"		<XSF_YHZH>622001281291921</XSF_YHZH>" + 
				"		<GMF_NSRSBH>110101MXB6CK9Q6</GMF_NSRSBH>" + 
				"		<GMF_MC>xxx有限公司</GMF_MC>" + 
				"		<GMF_DZDH>北京010-001201</GMF_DZDH>" + 
				"		<GMF_YHZH>621101021921</GMF_YHZH>" + 
				"		<KPR>开票人</KPR>" + 
				"		<SKR>收款人</SKR>" + 
				"		<FHR>复核人</FHR>" + 
				"		<YFP_DM></YFP_DM>" + 
				"		<YFP_HM></YFP_HM>" + 
				"		<JSHJ>58.50</JSHJ>" + 
				"		<HJJE>50.00</HJJE>" + 
				"		<HJSE>8.50</HJSE>" + 
				"		<BZ>备注</BZ>" + 
				"		<FPZT>0</FPZT>" + 
				"		<JQBH></JQBH>" +	
				"		<FP_DM></FP_DM>" +	
				"		<FP_HM></FP_HM>" +	
				"		<KPRQ>20160712091403</KPRQ>" +	
				"		<FP_MW></FP_MW>" +	
				"		<JYM></JYM>" +	
				"		<EWM></EWM>" +	
//				"		<JQBH>661561681668</JQBH>" + 
//				"		<FP_DM>031241570151</FP_DM>" + 
//				"		<FP_HM>10000005</FP_HM>" + 
//				"		<KPRQ>20160712091403</KPRQ>" + 
//				"		<FP_MW>/&gt;772&gt;&lt;0-3/&gt;-7/50/73&lt;&lt;0&gt;477+&lt;/*&lt;1+6+&lt;0&lt;976-&gt;&gt;&lt;*&gt;&lt;-0&gt;+8&lt;537*+/96&lt;+1-3/-&gt;705603&lt;6663//6/12474+72+2/966&gt;6+&lt;+65&gt;</FP_MW>" + 
//				"		<JYM>58571459203009417954</JYM>" + 
//				"		<EWM>Qk3CAwAAAAAAAD4AAAAoAAAASwAAAEsAAAABAAEAAAAAAIQDAAAAAAAAAAAAAAAAAAACAAAAAAAAgAAAAAzwDwMPDMMwgAAAAAzwDwMPDMMwgAAA/88zMwwADDMzgAAA/88zMwwADDMzgAAAwMzPP8DPzDwwgAAAwMzPP8DPzDwwgAAAwM8wAzAPDzzzgAAAwM8wAzAPDzzzgAAAwMz8D/zPDAD8gAAAwMz8D/zPDAD8gAAA/8/PzPMDAPw/gAAA/8/PzPMDAPw/gAAAAA8AzDzMwMzMgAAAAA8AzDzMwMzMgAAD//w//88PzPw8gAAD//w//88PzPw8gAADDw8wAw8PDAAwgAADDw8wAw8PDAAwgAAA/z8PzDMwPzM/gAAA/z8PzDMwPzM/gAADPw88wM/8/wAMgAADPw88wM/8/wAMgAAAPPPPAAP/z8P8gAAAPPPPAAP/z8P8gAAA8AwwPM/8D8M8gAAA8AwwPM/8D8M8gAADwzAMMwPzAAMwgAADwzAMMwPzAAMwgAAA/ADw/Mw8P8wMgAAA/ADw/Mw8P8wMgAAAzzADPw//P8MwgAAAzzADPw//P8MwgAADwwD8PwADD8M8gAADwwD8PwADD8M8gAAAzPMwwzwAAw8zgAAAzPMwwzwAAw8zgAADwwzMPwD8zMzMgAADwwzMPwD8zMzMgAADzzDAMzA/D8MMgAADzzDAMzA/D8MMgAAAMAwz//DPD8MzgAAAMAwz//DPD8MzgAADwzD8zPwzDPMzgAADwzD8zPwzDPMzgAAADwMw/zw8z/PMgAAADwMw/zw8z/PMgAADD/A8z88PD8PMgAADD/A8z88PD8PMgAADzwDPMw8PD8M8gAADzwDPMw8PD8M8gAADDz/M/DM/A/8/gAADDz/M/DM/A/8/gAAA/Mz/AP/M/MAMgAAA/Mz/AP/M/MAMgAADMzADAMMPD8PwgAADMzADAMMPD8PwgAAAzM/PzM8PD/zzgAAAzM/PzM8PD/zzgAAD///DPwMzM///gAAD///DPwMzM///gAAAAAzMzMzMzMAAgAAAAAzMzMzMzMAAgAAA/88zDDPDA8/8gAAA/88zDDPDA8/8gAAAwMwMM8Dw8MwMgAAAwMwMM8Dw8MwMgAAAwM8M8Pzw/MwMgAAAwM8M8Pzw/MwMgAAAwM8Az8PP/MwMgAAAwM8Az8PP/MwMgAAA/8wPMD8zMM/8gAAA/8wPMD8zMM/8gAAAAA/PPM/P8MAAgAAAAA/PPM/P8MAAgAAA=</EWM>" + 
				"		<PDF_XZFS>3</PDF_XZFS>" + 
				"	</FPQZ_FPT>" + 
				"	<FPQZ_XMXXS class=\"FPQZ_XMXX;\" size=\"1\">" + 
				"		<FPQZ_XMXX>" + 
				"			<FPHXZ>0</FPHXZ>" + 
				"			<XMMC>项目名称</XMMC>" + 
				"			<GGXH>台</GGXH>" + 
				"			<DW>台</DW>" + 
				"			<XMSL>1</XMSL>" + 
				"			<XMDJ>100.00</XMDJ>" + 
				"			<XMJE>100.00</XMJE>" + 
				"			<SL>0.17</SL>" + 
				"			<SE>17.00</SE>" + 
				"			<HSBZ>1</HSBZ>" + 
				"		</FPQZ_XMXX>" + 
				"	</FPQZ_XMXXS>" + 
				"	<FPQZ_TSFSXX class=\"FPQZ_TSFSXX\">" + 
				"		<COMMON_NODES class=\"COMMON_NODE;\" size=\"2\">" + 
				"			<COMMON_NODE>" + 
				"				<NAME>TSFS</NAME>" + 
				"				<VALUE>0</VALUE>" + 
				"			</COMMON_NODE>" + 
				"			<COMMON_NODE>" + 
				"				<NAME>EMAIL</NAME>" + 
				"				<VALUE>sjx-sword@163.com</VALUE>" + 
				"			</COMMON_NODE>" + 
				"		</COMMON_NODES>" + 
				"	</FPQZ_TSFSXX>" + 
				"</REQUEST_FPQZ>";
		String xml = "<?xml version=\"1.0\" encoding=\"utf-8\" ?>" +
				"<interface xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.chinatax.gov.cn/tirip/dataspec/interfaces.xsd\" version=\"DZFP1.0\">" +
				"  <globalInfo>" +
				"    <terminalCode>0</terminalCode>" +
				"    <appId>A16D8DBD18EDDD80</appId>" +
				"    <version>2.0</version>" +
				"    <interfaceCode>ECXML.FPKJ.BC.E_INV</interfaceCode>" +
				"    <requestCode>14410101</requestCode>" +
				"    <requestTime>2015-08-06 10:30:42 978</requestTime>" +
				"    <responseCode>144</responseCode>" +
				"    <dataExchangeId>1441010120160104270892641</dataExchangeId>" +
				"    <userName>14410101</userName>" +
				"    <passWord>0981202609xFBzKNdCxSuCZP2TjDD2fA==</passWord>" +
				"    <taxpayerId>110101MXB6CK9Q6</taxpayerId>" +
				"    <authorizationCode>6270892641</authorizationCode>" +
				"  </globalInfo>" +
				"  <returnStateInfo>" +
				"    <returnCode/>" +
				"    <returnMessage/>" +
				"  </returnStateInfo>" +
				"  <Data>" +
				"    <dataDescription> " +
				"      <zipCode>0</zipCode>" +
				"      <encryptCode>0</encryptCode>" +
				"      <codeType>0</codeType>" +
				"    </dataDescription>" +
				"    <content>" +
				new BASE64Encoder().encode(content.getBytes()) +
				"    </content>" +
				"  </Data>" +
				"</interface>";
		return xml;
	}
}
