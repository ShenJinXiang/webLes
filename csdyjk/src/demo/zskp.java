package demo;

import java.io.UnsupportedEncodingException;


import coreservice.CoreserviceLocator;
import coreservice.CoreservicePortType;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class zskp {

	public static void main(String[] args) throws Exception {
		String xml = getXML();
		CoreserviceLocator service = new CoreserviceLocator();
		service.setcoreserviceHttpPortEndpointAddress("http://localhost:8080/fpgl_webservice/services/coreservice");
		CoreservicePortType pt = service.getcoreserviceHttpPort();
		String result = pt.invoke(xml);
		System.out.println("-----------------返回报文---------------------");
		System.out.println(result);
		// 返回报文中的content的内容
		String content = result.substring(result.indexOf("<content>") + "<content>".length(), result.indexOf("</content>"));
		System.out.println("------------------返回的内层报文-----------------------");
		System.out.println(new String(new BASE64Decoder().decodeBuffer(content)));
	}
	
	private static String getXML() throws UnsupportedEncodingException {
		
		String nsrsbh = "91140200715951811C"; // 纳税人识别号
		String ptbm = "11436202"; // 平台编码
		String lsh = "d35skpyd45873405kd33"; // 流水号
		String sqm = "915951811C"; // 授权码 
		String zcm = "31106756"; // 注册码
		
		String content = 
			"<dzfp_info>\r\n" +
			"	<dzfp_fpt>\r\n" +
			"		<billno>123456</billno>\r\n" +
			"		<billdate>2016-08-15 15:23:55 456</billdate>\r\n" +
			"		<invcode>123456789142</invcode>\r\n" +
			"		<number>65432178</number>\r\n" +
			"		<fpqqlsh>" + lsh + "</fpqqlsh>\r\n" +
			"		<fplx>0</fplx>\r\n" +
			"		<kplx>0</kplx>\r\n" +
			"		<xsf_nsrsbh >" + nsrsbh + "</xsf_nsrsbh >\r\n" +
			"		<xsf_mc>销方名称</xsf_mc>\r\n" +
			"		<xsf_dzdh>dd</xsf_dzdh>\r\n" +
			"		<xsf_yhzh>132313123</xsf_yhzh>\r\n" +
			"		<xsf_email>a123@163.com</xsf_email>\r\n" +
			"		<xsf_phone>12345678914</xsf_phone>\r\n" +
			"		<gmf_nsrsbh>" + nsrsbh + "</gmf_nsrsbh>\r\n" +
			"		<gmf_mc>购方名称</gmf_mc>\r\n" +
			"		<gmf_dzdh>12345678914</gmf_dzdh>\r\n" +
			"		<gmf_yhzh>12345</gmf_yhzh>\r\n" +
			"		<gmf_email>a123@163.com</gmf_email>\r\n" +
			"		<gmf_phone>12315646</gmf_phone>\r\n" +
			"		<kpr>热力公司</kpr>\r\n" +
			"		<skr>收款人</skr>\r\n" +
			"		<fhr>复核人</fhr>\r\n" +
			"		<yfp_dm></yfp_dm>\r\n" +
			"		<yfp_hm></yfp_hm>\r\n" +
			"		<jshj>117</jshj>\r\n" +
			"		<hjje>100</hjje>\r\n" +
			"		<hjse>17</hjse>\r\n" +
			"		<bz>备注信息</bz>\r\n" +
			"		<hsbz>0</hsbz>\r\n" +
			"	</dzfp_fpt>\r\n" +
			"	<dzfp_fpmx>\r\n" +
			"		<fpmx>\r\n" +
			"			<fphxz>0</fphxz>\r\n" +
			"			<xmmc>项目名称1</xmmc>\r\n" +
			"			<ggxh>个</ggxh>\r\n" +
			"			<dw>个</dw>\r\n" +
			"			<xmsl>1</xmsl>\r\n" +
			"			<xmdj>100</xmdj>\r\n" +
			"			<xmje>100</xmje>\r\n" +
			"			<sl>0.17</sl>\r\n" +
			"			<se>17</se>\r\n" +
			"			<fpcominput>1100</fpcominput>\r\n" +
			"			<goodsnover>1</goodsnover>\r\n" +
			"			<goodstaxno>1212 </goodstaxno>\r\n" +
			"			<taxpre>0</taxpre>\r\n" +
			"			<taxprecon> </taxprecon>\r\n" +
			"			<zerotax></zerotax>\r\n" +
			"			<cropgoodsno>企业自编码 </cropgoodsno>\r\n" +
			"			<taxdeduction>0.12</taxdeduction>\r\n" +
			"		</fpmx>\r\n" +
			"		<fpmx>\r\n" +
			"			<fphxz>0</fphxz>\r\n" +
			"			<xmmc>项目名称2</xmmc>\r\n" +
			"			<ggxh>台</ggxh>\r\n" +
			"			<dw>台</dw>\r\n" +
			"			<xmsl>2</xmsl>\r\n" +
			"			<xmdj>100</xmdj>\r\n" +
			"			<xmje>200</xmje>\r\n" +
			"			<sl>0.17</sl>\r\n" +
			"			<se>34</se>\r\n" +
			"			<fpcominput>1100</fpcominput>\r\n" +
			"			<goodsnover>1</goodsnover>\r\n" +
			"			<goodstaxno>1 </goodstaxno>\r\n" +
			"			<taxpre>0</taxpre>\r\n" +
			"			<taxprecon></taxprecon>\r\n" +
			"			<zerotax></zerotax>\r\n" +
			"			<cropgoodsno>企业自编码 </cropgoodsno>\r\n" +
			"			<taxdeduction>0.23</taxdeduction>\r\n" +
			"		</fpmx>\r\n" +
			"	</dzfp_fpmx>\r\n" +
			"</dzfp_info>";
		String xml = 
			"<?xml version='1.0' encoding='utf-8' ?>\r\n" +
			"<invoice_open>\r\n" +
			"	<globalInfo>\r\n" +
			"		<interfaceCode>Invoice_Open</interfaceCode>\r\n" +
			"		<username>" + ptbm + "</username>\r\n" +
			"		<password>" + getPassword(zcm) + "</password>\r\n" +
			"		<taxpayerId>" + nsrsbh + "</taxpayerId>\r\n" +
			"		<authorizationCode>" + sqm + "</authorizationCode >\r\n" +
			"		<requestCode>" + ptbm + "</requestCode>\r\n" +
			"		<requestTime>2016-08-16 17:54:22 231</requestTime>\r\n" +
			"		<responseCode>155</responseCode>\r\n" +
			"		<dataExchangeId>" + lsh + "</dataExchangeId>\r\n" +
			"		<kpddm>111</kpddm>\r\n" +
			"		<kpdmc>111</kpdmc>\r\n" +
			"	</globalInfo>\r\n" +
			"	<returnStateInfo>"+
			"		<returnCode/>" +
			"		<returnMessage/>" +
			"	</returnStateInfo>"+
			"	<data>\r\n" +
			"		<content>" + new BASE64Encoder().encode(content.getBytes("utf-8")) + "</content>\r\n" +
			"	</data>\r\n" +
			"</invoice_open>";
		return xml;
	}
	
	private static String getPassword(String zcm) throws UnsupportedEncodingException {
		String sjs = "3839850347";
		String str = sjs + new BASE64Encoder().encode(((MD5Util.MD5(sjs + zcm))).getBytes("utf-8"));
		return str;
	}
}
