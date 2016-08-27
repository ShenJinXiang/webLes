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
//		String xml = "<?xml version='1.0' encoding='utf-8' ?><interface xmlns='' xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' xsi:schemaLocation='http://www.chinatax.gov.cn/tirip/dataspec/interfaces.xsd' version='DZFP1.0' ><globalInfo><terminalCode>0</terminalCode><appId>A16D8DBD18EDDD80</appId><version>2</version><interfaceCode>ECXML.FPQZ.BC.E.INV</interfaceCode><requestCode>14410101</requestCode><requestTime>2015-08-06 10:30:42 978</requestTime><responseCode>144</responseCode><dataExchangeId>P0000001ECXML.FPKJ.BC.E_INV20150807eXl4EymmJ</dataExchangeId><userName>14410101</userName><passWord>0981202609xFBzKNdCxSuCZP2TjDD2fA==</passWord><taxpayerId>110101MXB6CK9Q6</taxpayerId><authorizationCode>6270892641</authorizationCode></globalInfo><returnStateInfo><returnCode /><returnMessage /></returnStateInfo><Data><dataDescription> <zipCode>0</zipCode><encryptCode>0</encryptCode><codeType>0</codeType></dataDescription><content>PFJFUVVFU1RfRlBRWiBjbGFzcz0iUkVRVUVTVF9GUFFaIj4NCiAgPEZQUVpfSU5GTz5VMHBNV1FJd05nTkdVRXhZQWpFPTwvRlBRWl9JTkZPPg0KICA8RlBRWl9GUFQgY2xhc3M9IkZQUVpfRlBUIj4NCiAgICA8RlBRUUxTSD4wODIyaTF1dTl1Nnd0NTY3Njg5OTwvRlBRUUxTSD4NCiAgICA8S1BMWD4wPC9LUExYPg0KCTxCTUJfQkJIPjEuMDwvQk1CX0JCSD4NCgk8UURfQlo+MDwvUURfQlo+DQoJPFFEWE1NQz48L1FEWE1NQz4NCiAgICA8WFNGX05TUlNCSD4xMTAxMDFNWEI2Q0s5UTY8L1hTRl9OU1JTQkg+DQogICAgPFhTRl9NQz54eHjogqHku73mnInpmZDlhazlj7g8L1hTRl9NQz4NCiAgICA8WFNGX0RaREg+5YyX5LqsMDEwLTAwMTIwMTwvWFNGX0RaREg+DQogICAgPFhTRl9ZSFpIPjYyMjAwMTI4MTI5MTkyMTwvWFNGX1lIWkg+DQogICAgPEdNRl9OU1JTQkg+MTEwMTAxTVhCNkNLOVE2PC9HTUZfTlNSU0JIPg0KICAgIDxHTUZfTUM+eHh45pyJ6ZmQ5YWs5Y+4PC9HTUZfTUM+DQogICAgPEdNRl9EWkRIPuWMl+S6rDAxMC0xMDAxMjE8L0dNRl9EWkRIPg0KICAgIDxHTUZfWUhaSD42MjExMDEwMjE5MjE8L0dNRl9ZSFpIPg0KICAgIDxLUFI+5byA56Wo5Lq6PC9LUFI+DQogICAgPFNLUj7mlLbmrL7kuro8L1NLUj4NCiAgICA8RkhSPuWkjeaguOS6ujwvRkhSPg0KICAgIDxZRlBfRE0+PC9ZRlBfRE0+DQogICAgPFlGUF9ITT48L1lGUF9ITT4NCiAgICA8SlNISj41OC41PC9KU0hKPg0KICAgIDxISkpFPjUwPC9ISkpFPg0KICAgIDxISlNFPjguNTwvSEpTRT4NCiAgICA8Qlo+5aSH5rOoPC9CWj4NCiAgICA8RlBaVD4wPC9GUFpUPg0KICAgIDxKUUJIPjY2MTU0NTYxNDYxNzwvSlFCSD4NCiAgICA8RlBfRE0+NzQwOTE5MDEwOTExPC9GUF9ETT4NCiAgICA8RlBfSE0+OTU5NDM4MDE8L0ZQX0hNPg0KICAgIDxLUFJRPjIwMTYwOTIwMTQxMzU2PC9LUFJRPiA8RlBfTVc+MDcmZ3Q7Jmd0OzU3OTImZ3Q7NDUtNjEmbHQ7LSZsdDs5Jmd0OzcwMTAmbHQ7MS03Jmx0OyorLTkmbHQ7LzE1MzIqNzYmbHQ7Ni0qOTQyNSo5NTMmbHQ7KjQmbHQ7KzEyNTEwNjczJmx0OyZsdDs4Jmx0OzQmbHQ7Mjg4Jmd0OzM1MDcwJmx0OzEtNyZsdDs1MzcqNjUyNTcrKi82LTYtKjkyMyZndDsqPC9GUF9NVz4NCiAgICA8SllNPjc0MjY2NDk1MjcyMDg3ODk5OTUxPC9KWU0+DQogICAgPEVXTT48L0VXTT4NCiAgICA8UERGX1haRlM+MzwvUERGX1haRlM+DQogIDwvRlBRWl9GUFQ+DQogIDxGUFFaX1hNWFhTIGNsYXNzPSJGUFFaX1hNWFg7IiBzaXplPSIyIj4NCiAgICA8RlBRWl9YTVhYPg0KICAgICAgPEZQSFhaPjI8L0ZQSFhaPg0KICAgICAgPFhNTUM+5omT5Y2w5py6PC9YTU1DPg0KICAgICAgPEdHWEg+5Y+wPC9HR1hIPg0KICAgICAgPERXPuWPsDwvRFc+DQogICAgICA8WE1TTD4xPC9YTVNMPg0KICAgICAgPFhNREo+MTAwPC9YTURKPg0KICAgICAgPFhNSkU+MTAwPC9YTUpFPg0KICAgICAgPFNMPjAuMTc8L1NMPg0KICAgICAgPFNFPjE3PC9TRT4NCiAgICAgIDxIU0JaPjE8L0hTQlo+DQoJICA8RlBIWFo+MjwvRlBIWFo+DQoJICA8U1BCTT4wMDEyMDE8L1NQQk0+DQoJICA8WlhCTT48L1pYQk0+DQoJICA8WUhaQ0JTPjA8L1lIWkNCUz4NCgkgIDxMU0xCUz48L0xTTEJTPg0KCSAgPFpaU1RTR0w+PC9aWlNUU0dMPg0KICAgIDwvRlBRWl9YTVhYPg0KICAgICA8RlBRWl9YTVhYPg0KICAgICAgPEZQSFhaPjE8L0ZQSFhaPg0KICAgICAgPFhNTUM+5omT5Y2w5py6PC9YTU1DPg0KICAgICAgPEdHWEg+5Y+wPC9HR1hIPg0KICAgICAgPERXPuWPsDwvRFc+DQogICAgICA8WE1TTD4xPC9YTVNMPg0KICAgICAgPFhNREo+LTUwPC9YTURKPg0KICAgICAgPFhNSkU+LTIwPC9YTUpFPg0KICAgICAgPFNMPjAuMTc8L1NMPg0KICAgICAgPFNFPi04LjU8L1NFPg0KICAgICAgPEhTQlo+MTwvSFNCWj4NCgkgIDxGUEhYWj4xPC9GUEhYWj4NCgkgIDxTUEJNPjAwMTIwMTwvU1BCTT4NCgkgIDxaWEJNPjwvWlhCTT4NCgkgIDxZSFpDQlM+MDwvWUhaQ0JTPg0KCSAgPExTTEJTPjwvTFNMQlM+DQoJICA8WlpTVFNHTD48L1paU1RTR0w+DQogICAgPC9GUFFaX1hNWFg+DQogIDwvRlBRWl9YTVhYUz4NCiAgPEZQUVpfVFNGU1hYIGNsYXNzPSJGUFFaX1RTRlNYWCI+DQogICAgPENPTU1PTl9OT0RFUyBjbGFzcz0iQ09NTU9OX05PREU7IiBzaXplPSI0Ij4NCiAgICAgIDxDT01NT05fTk9ERT4gDQogICAgICAgIDxOQU1FPlRTRlM8L05BTUU+ICANCiAgICAgICAgPFZBTFVFPuaOqOmAgeaWueW8jzwvVkFMVUU+IA0KICAgICAgPC9DT01NT05fTk9ERT4gIA0KICAgICAgPENPTU1PTl9OT0RFPiANCiAgICAgICAgPE5BTUU+U0o8L05BTUU+ICANCiAgICAgICAgPFZBTFVFPuaJi+acujwvVkFMVUU+IA0KICAgICAgPC9DT01NT05fTk9ERT4gIA0KICAgICAgPENPTU1PTl9OT0RFPiANCiAgICAgICAgPE5BTUU+RU1BSUw8L05BTUU+ICANCiAgICAgICAgPFZBTFVFPumCrueusTwvVkFMVUU+IA0KICAgICAgPC9DT01NT05fTk9ERT4gIA0KICAgICAgPENPTU1PTl9OT0RFPiANCiAgICAgICAgPE5BTUU+5omp5bGV5a2X5q615ZCN56ewPC9OQU1FPg0KICAgICAgICA8VkFMVUU+5omp5bGV5a2X5q615YC8PC9WQUxVRT4gDQogICAgICA8L0NPTU1PTl9OT0RFPiANCiAgICA8L0NPTU1PTl9OT0RFUz4gDQogIDwvRlBRWl9UU0ZTWFg+IA0KPC9SRVFVRVNUX0ZQUVo+DQo=</content></Data></interface>";
		String xml = getXML1();
		IEInvWebService service = new IEInvWebServiceLocator();
		IEInvWebServicePortType pt = service.getIEInvWebServiceHttpPort();
		String result = pt.eiInterface(xml);
		System.out.println(result);
	}
	
	public static String getXML3(){
		String content = 
				"<REQUEST_FPQZ class=\"REQUEST_FPQZ\">"+
				"  <FPQZ_INFO>U0pMWQIwNgNGUExYAjE=</FPQZ_INFO>"+
				"  <FPQZ_FPT class=\"FPQZ_FPT\">"+
				"    <FPQQLSH>0822i1uu9u6wt5676899</FPQQLSH>"+
				"    <KPLX>0</KPLX>"+
				"    <BMB_BBH>1.0</BMB_BBH>"+
				"    <QD_BZ>0</QD_BZ>"+
				"    <QDXMMC></QDXMMC>"+
				"    <XSF_NSRSBH>110101MXB6CK9Q6</XSF_NSRSBH>"+
				"    <XSF_MC>xxx股份有限公司</XSF_MC>"+
				"    < XSF_DZDH>北京010-001201</ XSF_DZDH>"+
				"    <XSF_YHZH>622001281291921</XSF_YHZH>"+
				"    <GMF_NSRSBH>110101MXB6CK9Q6</GMF_NSRSBH>"+
				"    <GMF_MC>xxx有限公司</GMF_MC>"+
				"    <GMF_DZDH>北京010-100121</GMF_DZDH>"+
				"    <KPR>开票人</KPR>"+
				"    <SKR>收款人</SKR>"+
				"    <FHR>复核人</FHR>"+
				"    <YFP_DM></YFP_DM>"+
				"    <YFP_HM></YFP_HM>"+
				"    <JSHJ>58.5</JSHJ>"+
				"    <HJJE>50.0</HJJE>"+
				"    <HJSE>8.5</HJSE>"+
				"    <BZ>备注</BZ>"+
				"    <FPZT>0</FPZT>"+
				"    <JQBH>661545614617</JQBH>"+
				"    <FP_DM>740919010911</FP_DM>"+
				"    <FP_HM>95943801</FP_HM>"+
				"    <KPRQ>20160815183131000</KPRQ>"+
				"    <FP_MW>07&gt;&gt;5792&gt;45-61&lt;-&lt;9&gt;7010&lt;1-7&lt;*+-9&lt;/1532*76&lt;6-*9425*953&lt;*4&lt;+12510673&lt;&lt;8&lt;4&lt;288&gt;35070&lt;1-7&lt;537*65257+*/6-6-*923&gt;*</FP_MW>"+
				"    <JYM>74266495272087899951</JYM>"+
				"    <PDF_XZFS>3</PDF_XZFS>"+
				"  </FPQZ_FPT>"+
				"  <FPQZ_XMXXS class=\"FPQZ_XMXX;\" size=\"2\">"+
				"    <FPQZ_XMXX>"+
				"      <XMMC>打印机</XMMC>"+
				"      <GGXH>台</GGXH>"+
				"      <DW>台</DW>"+
				"      <XMSL>1.0</XMSL>"+
				"      <XMDJ>100.0</XMDJ>"+
				"      <XMJE>100.0</XMJE>"+
				"      <SL>0.17</SL>"+
				"      <SE>17.0</SE>"+
				"      <HSBZ>1</HSBZ>"+
				"      <FPHXZ>2</FPHXZ>"+
				"      <SPBM>001201</SPBM>"+
				"      <YHZCBS>0</YHZCBS>"+
				"      <KCE></KCE>"+
				"    </FPQZ_XMXX>"+
				"    <FPQZ_XMXX>"+
				"      <XMMC>电脑</XMMC>"+
				"      <GGXH>台</GGXH>"+
				"      <DW>台</DW>"+
				"      <XMSL>1.0</XMSL>"+
				"      <XMDJ>-50.0</XMDJ>"+
				"      <XMJE>-20.0</XMJE>"+
				"      <SL>0.17</SL>"+
				"      <SE>-8.5</SE>"+
				"      <HSBZ>1</HSBZ>"+
				"      <FPHXZ>1</FPHXZ>"+
				"      <SPBM>001201</SPBM>"+
				"      <YHZCBS>0</YHZCBS>"+
				"      <KCE></KCE>"+
				"    </FPQZ_XMXX>"+
				"  </FPQZ_XMXXS>"+
				"</REQUEST_FPQZ>";
		String xml = 
		"<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" +
		"<interface>" +
		"  <globalInfo>" +
		"    <terminalCode>0</terminalCode>" +
		"    <appId>A16D8DBD18EDDD80</appId>" +
		"    <version>2</version>" +
		"    <interfaceCode>ECXML.FPQZ.BC.E.INV</interfaceCode>" +
		"    <userName>14410101</userName>" +
		"    <passWord>0981202609xFBzKNdCxSuCZP2TjDD2fA==</passWord>" +
		"    <taxpayerId>110101MXB6CK9Q6</taxpayerId>" +
		"    <authorizationCode>6270892641</authorizationCode>" +
		"    <requestCode>14410101</requestCode>" +
		"    <requestTime>2015-08-06 10:30:42 978</requestTime>" +
		"    <responseCode>144</responseCode>" +
		"    <dataExchangeId>P0000001ECXML.FPKJ.BC.E_INV20150807eXl4EymmJ</dataExchangeId>" +
		"  </globalInfo>" +
		"  <returnStateInfo>" +
		"    <returnCode></returnCode>" +
		"    <returnMessage></returnMessage>" +
		"  </returnStateInfo>" +
		"  <Data>" +
		"    <dataDescription>" +
		"      <zipCode>0</zipCode>" +
		"      <encryptCode>0</encryptCode>" +
		"      <codeType>0</codeType>" +
		"    </dataDescription>" +
		"    <content>" + new BASE64Encoder().encode(content.getBytes()) + "</content>" +
		"  </Data>" +
		"</interface>";
		
		return xml;
	}
	
	public static String getXML2() {
		
		String xml = 
				"<?xml version='1.0' encoding='utf-8' ?> "+
		"<interface xmlns='' xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' xsi:schemaLocation='http://www.chinatax.gov.cn/tirip/dataspec/interfaces.xsd' version='DZFP1.0' >" +
		"	<globalInfo>" +
		"		<terminalCode>0</terminalCode>" +
		"		<appId>A16D8DBD18EDDD80</appId>" +
		"		<version>2</version>" +
		"		<interfaceCode>ECXML.FPQZ.BC.E.INV</interfaceCode>" +
		"		<requestCode>14410101</requestCode>" +
		"		<requestTime>2015-08-06 10:30:42 978</requestTime>" +
		"		<responseCode>144</responseCode>" +
		"		<dataExchangeId>P0000001ECXML.FPKJ.BC.E_INV20150807eXl4EymmJ</dataExchangeId>" +
		"		<userName>14410101</userName>" +
		"		<passWord>0981202609xFBzKNdCxSuCZP2TjDD2fA==</passWord>" +
		"		<taxpayerId>110101MXB6CK9Q6</taxpayerId>" +
		"		<authorizationCode>6270892641</authorizationCode>" +
		"	</globalInfo>" +
		"	<returnStateInfo>" +
		"		<returnCode />" +
		"		<returnMessage />" +
		"	</returnStateInfo>" +
		"	<Data>" +
		"		<dataDescription>" +
		"		<zipCode>0</zipCode>" +
		"		<encryptCode>0</encryptCode>" +
		"		<codeType>0</codeType>" +
		"		</dataDescription>" +
		"		<content>" + "</content>" +
		"	</Data>" +
		"</interface>";
		return xml;
	}
	public static String getXML1() {
		String content ="<REQUEST_FPQZ class='REQUEST_FPQZ'>" +
				  "<FPQZ_INFO>U0pMWQIwNgNGUExYAjE=</FPQZ_INFO>" +
				  "<FPQZ_FPT class='FPQZ_FPT'>" +
				    "<FPQQLSH>0822i1uu9u6wt5676899</FPQQLSH>" +
				    "<KPLX>0</KPLX>" +
					"<BMB_BBH>1.0</BMB_BBH>" +
					"<QD_BZ>0</QD_BZ>" +
					"<QDXMMC></QDXMMC>" +
				    "<XSF_NSRSBH>110101MXB6CK9Q6</XSF_NSRSBH>" +
				    "<XSF_MC>xxx股份有限公司</XSF_MC>" +
				    "<XSF_DZDH>北京010-001201</XSF_DZDH>" +
				    "<XSF_YHZH>622001281291921</XSF_YHZH>" +
				    "<GMF_NSRSBH>110101MXB6CK9Q6</GMF_NSRSBH>" +
				    "<GMF_MC>xxx有限公司</GMF_MC>" +
				    "<GMF_DZDH>北京010-100121</GMF_DZDH>" +
				    "<GMF_YHZH>621101021921</GMF_YHZH>" +
				    "<KPR>开票人</KPR>" +
				    "<SKR>收款人</SKR>" +
				    "<FHR>复核人</FHR>" +
				    "<YFP_DM></YFP_DM>" +
				    "<YFP_HM></YFP_HM>" +
				    "<JSHJ>58.5</JSHJ>" +
				    "<HJJE>50</HJJE>" +
				    "<HJSE>8.5</HJSE>" +
				    "<BZ>备注</BZ>" +
				    "<FPZT>0</FPZT>" +
				    "<JQBH>661545614617</JQBH>" +
				    "<FP_DM>740919010911</FP_DM>" +
				    "<FP_HM>95943801</FP_HM>" +
				    "<KPRQ>20160920141356</KPRQ>"+
					"<FP_MW>07&gt;&gt;5792&gt;45-61&lt;-&lt;9&gt;7010&lt;1-7&lt;*+-9&lt;/1532*76&lt;6-*9425*953&lt;*4&lt;+12510673&lt;&lt;8&lt;4&lt;288&gt;35070&lt;1-7&lt;537*65257+*/6-6-*923&gt;*</FP_MW>"+
				    "<JYM>74266495272087899951</JYM>" +
				    "<EWM></EWM>" +
				    "<PDF_XZFS>3</PDF_XZFS>" +
				  "</FPQZ_FPT>" +
				  "<FPQZ_XMXXS class='FPQZ_XMXX;' size='2'>" +
				    "<FPQZ_XMXX>" +
				      "<FPHXZ>2</FPHXZ>" +
				      "<XMMC>打印机</XMMC>" +
				      "<GGXH>台</GGXH>" +
				      "<DW>台</DW>" +
				      "<XMSL>1</XMSL>" +
				      "<XMDJ>100</XMDJ>" +
				      "<XMJE>100</XMJE>" +
				      "<SL>0.17</SL>" +
				      "<SE>17</SE>" +
				      "<HSBZ>1</HSBZ>" +
					  "<FPHXZ>2</FPHXZ>" +
					  "<SPBM>001201</SPBM>" +
					  "<ZXBM></ZXBM>" +
					  "<YHZCBS>0</YHZCBS>" +
					  "<LSLBS></LSLBS>" +
					  "<ZZSTSGL></ZZSTSGL>" +
				    "</FPQZ_XMXX>" +
				     "<FPQZ_XMXX>" +
				      "<FPHXZ>1</FPHXZ>" +
				      "<XMMC>打印机</XMMC>" +
				      "<GGXH>台</GGXH>" +
				      "<DW>台</DW>" +
				      "<XMSL>1</XMSL>" +
				      "<XMDJ>-50</XMDJ>" +
				      "<XMJE>-20</XMJE>" +
				      "<SL>0.17</SL>" +
				      "<SE>-8.5</SE>" +
				      "<HSBZ>1</HSBZ>" +
					  "<FPHXZ>1</FPHXZ>" +
					  "<SPBM>001201</SPBM>" +
					  "<ZXBM></ZXBM>" +
					  "<YHZCBS>0</YHZCBS>" +
					  "<LSLBS></LSLBS>" +
					  "<ZZSTSGL></ZZSTSGL>" +
				    "</FPQZ_XMXX>" +
				  "</FPQZ_XMXXS>" +
//				  "<FPQZ_TSFSXX class='FPQZ_TSFSXX'>" +
//				    "<COMMON_NODES class='COMMON_NODE;' size='4'>" +
//				      "<COMMON_NODE> " +
//				        "<NAME>TSFS</NAME>  " +
//				        "<VALUE>推送方式</VALUE> " +
//				      "</COMMON_NODE>  " +
//				      "<COMMON_NODE> " +
//				        "<NAME>SJ</NAME>  " +
//				        "<VALUE>手机</VALUE> " +
//				      "</COMMON_NODE>  " +
//				      "<COMMON_NODE> " +
//				        "<NAME>EMAIL</NAME>  " +
//				        "<VALUE>邮箱</VALUE> " +
//				      "</COMMON_NODE>  " +
//				      "<COMMON_NODE> " +
//				        "<NAME>扩展字段名称</NAME>" +
//				        "<VALUE>扩展字段值</VALUE> " +
//				      "</COMMON_NODE> " +
//				    "</COMMON_NODES> " +
//				  "</FPQZ_TSFSXX> " +
				"</REQUEST_FPQZ>";

		String xml = "<?xml version='1.0' encoding='utf-8' ?>\n" +
				"<interface >\n" +
				"<globalInfo>\n" +
					"<terminalCode>0</terminalCode>\n" +
					"<appId>A16D8DBD18EDDD80</appId>\n" +
					"<version>2</version>\n" +
					"<interfaceCode>ECXML.FPQZ.BC.E.INV</interfaceCode>\n" +
					"<requestCode>14410101</requestCode>\n" +
					"<requestTime>2015-08-06 10:30:42 978</requestTime>\n" +
					"<responseCode>144</responseCode>\n" +
					"<dataExchangeId>P0000001ECXML.FPKJ.BC.E_INV20150807eXl4EymmJ</dataExchangeId>\n"
					+
					"<userName>14410101</userName>\n" +
					"<passWord>0981202609xFBzKNdCxSuCZP2TjDD2fA==</passWord>\n" +
					"<taxpayerId>110101MXB6CK9Q6</taxpayerId>\n" +
					"<authorizationCode>6270892641</authorizationCode>\n" +
				"</globalInfo>\n" +
				"<returnStateInfo>\n" +
					"<returnCode />\n" +
					"<returnMessage />\n" +
					"</returnStateInfo>\n" +
				"<Data>\n" +
					"<dataDescription>\n" +
						"<zipCode>0</zipCode>\n" +
						"<encryptCode>0</encryptCode>\n" +
						"<codeType>0</codeType>\n" +
					"</dataDescription>\n" +
					"<content>" + new BASE64Encoder().encode(content.getBytes()) +"</content>\n" +
				"</Data>\n" +
			"</interface>\n";
		return xml;
		
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
//				"		<JQBH></JQBH>" +	
//				"		<FP_DM></FP_DM>" +	
//				"		<FP_HM></FP_HM>" +	
//				"		<KPRQ>20160712091403</KPRQ>" +	
//				"		<FP_MW></FP_MW>" +	
//				"		<JYM></JYM>" +	
//				"		<EWM></EWM>" +	
				"		<JQBH>661561681668</JQBH>" + 
				"		<FP_DM>031241570151</FP_DM>" + 
				"		<FP_HM>10000005</FP_HM>" + 
				"		<KPRQ>20160712091403</KPRQ>" + 
				"		<FP_MW>/&gt;772&gt;&lt;0-3/&gt;-7/50/73&lt;&lt;0&gt;477+&lt;/*&lt;1+6+&lt;0&lt;976-&gt;&gt;&lt;*&gt;&lt;-0&gt;+8&lt;537*+/96&lt;+1-3/-&gt;705603&lt;6663//6/12474+72+2/966&gt;6+&lt;+65&gt;</FP_MW>" + 
				"		<JYM>58571459203009417954</JYM>" + 
				"		<EWM>Qk3CAwAAAAAAAD4AAAAoAAAASwAAAEsAAAABAAEAAAAAAIQDAAAAAAAAAAAAAAAAAAACAAAAAAAAgAAAAAzwDwMPDMMwgAAAAAzwDwMPDMMwgAAA/88zMwwADDMzgAAA/88zMwwADDMzgAAAwMzPP8DPzDwwgAAAwMzPP8DPzDwwgAAAwM8wAzAPDzzzgAAAwM8wAzAPDzzzgAAAwMz8D/zPDAD8gAAAwMz8D/zPDAD8gAAA/8/PzPMDAPw/gAAA/8/PzPMDAPw/gAAAAA8AzDzMwMzMgAAAAA8AzDzMwMzMgAAD//w//88PzPw8gAAD//w//88PzPw8gAADDw8wAw8PDAAwgAADDw8wAw8PDAAwgAAA/z8PzDMwPzM/gAAA/z8PzDMwPzM/gAADPw88wM/8/wAMgAADPw88wM/8/wAMgAAAPPPPAAP/z8P8gAAAPPPPAAP/z8P8gAAA8AwwPM/8D8M8gAAA8AwwPM/8D8M8gAADwzAMMwPzAAMwgAADwzAMMwPzAAMwgAAA/ADw/Mw8P8wMgAAA/ADw/Mw8P8wMgAAAzzADPw//P8MwgAAAzzADPw//P8MwgAADwwD8PwADD8M8gAADwwD8PwADD8M8gAAAzPMwwzwAAw8zgAAAzPMwwzwAAw8zgAADwwzMPwD8zMzMgAADwwzMPwD8zMzMgAADzzDAMzA/D8MMgAADzzDAMzA/D8MMgAAAMAwz//DPD8MzgAAAMAwz//DPD8MzgAADwzD8zPwzDPMzgAADwzD8zPwzDPMzgAAADwMw/zw8z/PMgAAADwMw/zw8z/PMgAADD/A8z88PD8PMgAADD/A8z88PD8PMgAADzwDPMw8PD8M8gAADzwDPMw8PD8M8gAADDz/M/DM/A/8/gAADDz/M/DM/A/8/gAAA/Mz/AP/M/MAMgAAA/Mz/AP/M/MAMgAADMzADAMMPD8PwgAADMzADAMMPD8PwgAAAzM/PzM8PD/zzgAAAzM/PzM8PD/zzgAAD///DPwMzM///gAAD///DPwMzM///gAAAAAzMzMzMzMAAgAAAAAzMzMzMzMAAgAAA/88zDDPDA8/8gAAA/88zDDPDA8/8gAAAwMwMM8Dw8MwMgAAAwMwMM8Dw8MwMgAAAwM8M8Pzw/MwMgAAAwM8M8Pzw/MwMgAAAwM8Az8PP/MwMgAAAwM8Az8PP/MwMgAAA/8wPMD8zMM/8gAAA/8wPMD8zMM/8gAAAAA/PPM/P8MAAgAAAAA/PPM/P8MAAgAAA=</EWM>" + 
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
		String xml = "<?xml version=\"1.0\" encoding=\"utf-8\" ?>\n" +
				"<interface xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.chinatax.gov.cn/tirip/dataspec/interfaces.xsd\" version=\"DZFP1.0\">" +
				"  <globalInfo>\n" +
				"    <terminalCode>0</terminalCode>\n" +
				"    <appId>A16D8DBD18EDDD80</appId>\n" +
				"    <version>2.0</version>\n" +
				"    <interfaceCode>ECXML.FPQZ.BC.E.INV</interfaceCode>\n" +
				"    <requestCode>14410101</requestCode>\n" +
				"    <requestTime>2015-08-06 10:30:42 978</requestTime>\n" +
				"    <responseCode>144</responseCode>\n" +
				"    <dataExchangeId>1441010120160104270892641</dataExchangeId>\n" +
				"    <userName>14410101</userName>\n" +
				"    <passWord>0981202609xFBzKNdCxSuCZP2TjDD2fA==</passWord>\n" +
				"    <taxpayerId>110101MXB6CK9Q6</taxpayerId>\n" +
				"    <authorizationCode>6270892641</authorizationCode>\n" +
				"  </globalInfo>\n" +
				"  <returnStateInfo>\n" +
				"    <returnCode/>\n" +
				"    <returnMessage/>\n" +
				"  </returnStateInfo>\n" +
				"  <Data>\n" +
				"    <dataDescription> \n" +
				"      <zipCode>0</zipCode>\n" +
				"      <encryptCode>0</encryptCode>\n" +
				"      <codeType>0</codeType>\n" +
				"    </dataDescription>\n" +
				"    <content>" +
				new BASE64Encoder().encode(content.getBytes()) +
				"    </content>\n" +
				"  </Data>\n" +
				"</interface>\n";
		System.out.println(xml);
		return xml;
	}
}
