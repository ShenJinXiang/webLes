package com.qysoft.fpjkcs;

import java.io.UnsupportedEncodingException;

import coreservice.CoreserviceLocator;
import coreservice.CoreservicePortType;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class KpDemo {

	public static void main(String[] args) throws Exception {
		String xml = getXML();
		CoreserviceLocator service = new CoreserviceLocator();
//		service.setcoreserviceHttpPortEndpointAddress("http://localhost:8080/dzfpjk/services/coreservice");
//		service.setcoreserviceHttpPortEndpointAddress("http://localhost:8080/fpgl_webservice/services/coreservice");
		service.setcoreserviceHttpPortEndpointAddress("http://218.26.181.92:8080/dzfpjk/services/coreservice");
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
		String lsh = "d41skpyd23918989kd33";
		String content = 
			"<dzfp_info>\r\n" +
			"	<dzfp_fpt>\r\n" +
			"		<billno>123456</billno>\r\n" +
			"		<billdate>2016-08-15 15:23:55 456</billdate>\r\n" +
			"		<invcode></invcode>\r\n" +
			"		<number></number>\r\n" +
			"		<fpqqlsh>" + lsh + "</fpqqlsh>\r\n" +
			"		<fplx>0</fplx>\r\n" +
			"		<kplx>0</kplx>\r\n" +
			"		<xsf_nsrsbh >140114999999062</xsf_nsrsbh >\r\n" +
			"		<xsf_mc>销方名称</xsf_mc>\r\n" +
			"		<xsf_dzdh>dd</xsf_dzdh>\r\n" +
			"		<xsf_yhzh>132313123</xsf_yhzh>\r\n" +
			"		<xsf_email>a123@163.com</xsf_email>\r\n" +
			"		<xsf_phone>12345678914</xsf_phone>\r\n" +
			"		<gmf_nsrsbh>140114999999062</gmf_nsrsbh>\r\n" +
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
			"		<jshj>2355</jshj>\r\n" +
			"		<hjje>2084.07</hjje>\r\n" +
			"		<hjse>270.93</hjse>\r\n" +
			"		<bz>用户编码：071802701007</bz>\r\n" +
			"		<hsbz>0</hsbz>\r\n" +
			"	</dzfp_fpt>\r\n" +
			"	<dzfp_fpmx>\r\n" +
			"		<fpmx>\r\n" +
			"			<fphxz>0</fphxz>\r\n" +
			"			<xmmc>项目名称1</xmmc>\r\n" +
			"			<ggxh>个</ggxh>\r\n" +
			"			<dw>个</dw>\r\n" +
			"			<xmsl>27.010832</xmsl>\r\n" +
			"			<xmdj>25.85</xmdj>\r\n" +
			"			<xmje>698.23</xmje>\r\n" +
			"			<sl>0.13</sl>\r\n" +
			"			<se>90.77</se>\r\n" +
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
			"			<xmsl>35.995844</xmsl>\r\n" +
			"			<xmdj>38.5</xmdj>\r\n" +
			"			<xmje>1385.84</xmje>\r\n" +
			"			<sl>0.13</sl>\r\n" +
			"			<se>180.16</se>\r\n" +
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
				/*"<dzfp_info>\r\n" +
				"	<dzfp_fpt>\r\n" +
				"		<billno>a568844b1bf640769f927af8b83b8245</billno>\r\n" +
				"		<billdate>2016-09-08 10:44:35</billdate>\r\n" +
				"		<invcode>123456789142</invcode>\r\n" +
				"		<number>65432178</number>\r\n" +
				"		<fpqqlsh>" + lsh + "</fpqqlsh>\r\n" +
				"		<fplx>0</fplx>\r\n" +
				"		<kplx>1</kplx>\r\n" +
				"		<xsf_nsrsbh>140114999999062</xsf_nsrsbh>\r\n" +
				"		<xsf_mc>大同市热力有限责任公司</xsf_mc>\r\n" +
				"		<xsf_dzdh>城区御河西路5号御馨花都；0352-5358105</xsf_dzdh>\r\n" +
				"		<xsf_yhzh>大同市建行住房支行</xsf_yhzh>\r\n" +
				"		<xsf_email></xsf_email>\r\n" +
				"		<xsf_phone></xsf_phone>\r\n" +
				"		<gmf_nsrsbh></gmf_nsrsbh>\r\n" +
				"		<gmf_mc>北辰花园-52-1-4</gmf_mc>\r\n" +
				"		<gmf_dzdh></gmf_dzdh>\r\n" +
				"		<gmf_yhzh></gmf_yhzh>\r\n" +
				"		<gmf_email></gmf_email>\r\n" +
				"		<gmf_phone></gmf_phone>\r\n" +
				"		<kpr>中国银行</kpr>\r\n" +
				"		<skr>中国银行</skr>\r\n" +
				"		<fhr></fhr>\r\n" +
				"		<yfp_dm>1400083620</yfp_dm>\r\n" +
				"		<yfp_hm>00347827</yfp_hm>\r\n" +
				"		<jshj>-1771</jshj>\r\n" +
				"		<hjje>-1540.77</hjje>\r\n" +
				"		<hjse>-230.23</hjse>\r\n" +
				"		<bz></bz>\r\n" +
				"		<hsbz>0</hsbz>\r\n" +
				"	</dzfp_fpt>\r\n" +
				"	<dzfp_fpmx>\r\n" +
				"		<fpmx>\r\n" +
				"			<fphxz>0</fphxz>\r\n" +
				"			<xmmc>采暖费</xmmc>\r\n" +
				"			<ggxh>元/平方米</ggxh>\r\n" +
				"			<dw>元/平方米</dw>\r\n" +
				"			<xmsl>-60.629014</xmsl>\r\n" +
				"			<xmdj>25.85</xmdj>\r\n" +
				"			<xmje>-1567.26</xmje>\r\n" +
				"			<sl>0.13</sl>\r\n" +
				"			<se>-203.74</se>\r\n" +
				"			<fpcominput>1100</fpcominput>\r\n" +
				"			<goodsnover>1</goodsnover>\r\n" +
				"			<goodstaxno>1212</goodstaxno>\r\n" +
				"			<taxpre>0</taxpre>\r\n" +
				"			<taxprecon></taxprecon>\r\n" +
				"			<zerotax></zerotax>\r\n" +
				"			<cropgoodsno>企业自编码</cropgoodsno>\r\n" +
				"			<taxdeduction>0.0</taxdeduction>\r\n" +
				"		</fpmx>\r\n" +
				"	</dzfp_fpmx>\r\n" +
				"</dzfp_info>\r\n";*/
		
		String content1 = 
				"<dzfp_info>\r\n" +
				"	<dzfp_fpt>\r\n" +
				"		<billno>123456</billno>\r\n" +
				"		<billdate>2016-08-15 15:23:55 456</billdate>\r\n" +
				"		<invcode></invcode>\r\n" +
				"		<number></number>\r\n" +
				"		<fpqqlsh>" + lsh + "</fpqqlsh>\r\n" +
				"		<fplx>0</fplx>\r\n" +
				"		<kplx>0</kplx>\r\n" +
				"		<xsf_nsrsbh >140114999999062</xsf_nsrsbh >\r\n" +
				"		<xsf_mc>销方名称</xsf_mc>\r\n" +
				"		<xsf_dzdh>dd</xsf_dzdh>\r\n" +
				"		<xsf_yhzh>132313123</xsf_yhzh>\r\n" +
				"		<xsf_email>a123@163.com</xsf_email>\r\n" +
				"		<xsf_phone>12345678914</xsf_phone>\r\n" +
				"		<gmf_nsrsbh>140114999999062</gmf_nsrsbh>\r\n" +
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
				"		<jshj>2355</jshj>\r\n" +
				"		<hjje>2084.07</hjje>\r\n" +
				"		<hjse>270.93</hjse>\r\n" +
				"		<bz>备注信息</bz>\r\n" +
				"		<hsbz>0</hsbz>\r\n" +
				"	</dzfp_fpt>\r\n" +
				"	<dzfp_fpmx>\r\n" +
				"		<fpmx>\r\n" +
				"			<fphxz>0</fphxz>\r\n" +
				"			<xmmc>项目名称1</xmmc>\r\n" +
				"			<ggxh>个</ggxh>\r\n" +
				"			<dw>个</dw>\r\n" +
				"			<xmsl>35.995844</xmsl>\r\n" +
				"			<xmdj>38.5</xmdj>\r\n" +
				"			<xmje>1385.84</xmje>\r\n" +
				"			<sl>0.13</sl>\r\n" +
				"			<se>180.16</se>\r\n" +
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
				"			<xmsl></xmsl>\r\n" +
				"			<xmdj></xmdj>\r\n" +
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
					/*"<dzfp_info>\r\n" +
					"	<dzfp_fpt>\r\n" +
					"		<billno>a568844b1bf640769f927af8b83b8245</billno>\r\n" +
					"		<billdate>2016-09-08 10:44:35</billdate>\r\n" +
					"		<invcode>123456789142</invcode>\r\n" +
					"		<number>65432178</number>\r\n" +
					"		<fpqqlsh>" + lsh + "</fpqqlsh>\r\n" +
					"		<fplx>0</fplx>\r\n" +
					"		<kplx>1</kplx>\r\n" +
					"		<xsf_nsrsbh>140114999999062</xsf_nsrsbh>\r\n" +
					"		<xsf_mc>大同市热力有限责任公司</xsf_mc>\r\n" +
					"		<xsf_dzdh>城区御河西路5号御馨花都；0352-5358105</xsf_dzdh>\r\n" +
					"		<xsf_yhzh>大同市建行住房支行</xsf_yhzh>\r\n" +
					"		<xsf_email></xsf_email>\r\n" +
					"		<xsf_phone></xsf_phone>\r\n" +
					"		<gmf_nsrsbh></gmf_nsrsbh>\r\n" +
					"		<gmf_mc>北辰花园-52-1-4</gmf_mc>\r\n" +
					"		<gmf_dzdh></gmf_dzdh>\r\n" +
					"		<gmf_yhzh></gmf_yhzh>\r\n" +
					"		<gmf_email></gmf_email>\r\n" +
					"		<gmf_phone></gmf_phone>\r\n" +
					"		<kpr>中国银行</kpr>\r\n" +
					"		<skr>中国银行</skr>\r\n" +
					"		<fhr></fhr>\r\n" +
					"		<yfp_dm>1400083620</yfp_dm>\r\n" +
					"		<yfp_hm>00347827</yfp_hm>\r\n" +
					"		<jshj>-1771</jshj>\r\n" +
					"		<hjje>-1540.77</hjje>\r\n" +
					"		<hjse>-230.23</hjse>\r\n" +
					"		<bz></bz>\r\n" +
					"		<hsbz>0</hsbz>\r\n" +
					"	</dzfp_fpt>\r\n" +
					"	<dzfp_fpmx>\r\n" +
					"		<fpmx>\r\n" +
					"			<fphxz>0</fphxz>\r\n" +
					"			<xmmc>采暖费</xmmc>\r\n" +
					"			<ggxh>元/平方米</ggxh>\r\n" +
					"			<dw>元/平方米</dw>\r\n" +
					"			<xmsl>-60.629014</xmsl>\r\n" +
					"			<xmdj>25.85</xmdj>\r\n" +
					"			<xmje>-1567.26</xmje>\r\n" +
					"			<sl>0.13</sl>\r\n" +
					"			<se>-203.74</se>\r\n" +
					"			<fpcominput>1100</fpcominput>\r\n" +
					"			<goodsnover>1</goodsnover>\r\n" +
					"			<goodstaxno>1212</goodstaxno>\r\n" +
					"			<taxpre>0</taxpre>\r\n" +
					"			<taxprecon></taxprecon>\r\n" +
					"			<zerotax></zerotax>\r\n" +
					"			<cropgoodsno>企业自编码</cropgoodsno>\r\n" +
					"			<taxdeduction>0.0</taxdeduction>\r\n" +
					"		</fpmx>\r\n" +
					"	</dzfp_fpmx>\r\n" +
					"</dzfp_info>\r\n";*/
		
		
		String xml = 
			"<?xml version='1.0' encoding='utf-8' ?>\r\n" +
			"<invoice_open>\r\n" +
			"	<globalInfo>\r\n" +
			"		<interfaceCode>Invoice_Open</interfaceCode>\r\n" +
			"		<username>11436202</username>\r\n" +
			"		<password>456456546</password>\r\n" +
			"		<taxpayerId>140114999999062</taxpayerId>\r\n" +
			"		<authorizationCode>140114999999062</authorizationCode >\r\n" +
			"		<requestCode>11436202</requestCode>\r\n" +
			"		<requestTime>2016-08-16 17:54:22 231</requestTime>\r\n" +
			"		<responseCode>144</responseCode>\r\n" +
			"		<dataExchangeId>" + lsh +"</dataExchangeId>\r\n" +
			"		<kpddm>222</kpddm>\r\n" +
			"		<kpdmc>222</kpdmc>\r\n" +
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
}
