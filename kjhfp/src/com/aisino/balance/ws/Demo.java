package com.aisino.balance.ws;

import sun.misc.BASE64Encoder;

public class Demo {
	
	public static void main(String[] args) {
		IEInvWebService service = new IEInvWebServiceLocator();
		IEInvWebServicePortType s = service.getIEInvWebServiceHttpPort();
//		s.fpkjInterface(in0)
		
	}

	private static String getXML1(){
		String content =
		"<REQUEST_FPKJ class=\"REQUEST_FPKJ\">"+
			"<GHFMC>购方名称</GHFMC>"+
			"<GHF_NSRSBH>140114999999062</GHF_NSRSBH>"+
			"<FKFKHYH_FKFYHZH>付款方银行及账号</FKFKHYH_FKFYHZH>"+
			"<FKFDZ_FKFDH>付款方地址电话</FKFDZ_FKFDH>"+
			"<XHFKHYH_SKFYHZH>销货方银行及账号</XHFKHYH_SKFYHZH>"+
			"<XHFDZ_XHFDH>销货方地址电话</XHFDZ_XHFDH>"+
			"<FPZL_DM>0</FPZL_DM>"+
			"<YFP_DM></YFP_DM>"+
			"<YFP_HM></YFP_HM>"+
			"<BZ>备注</BZ>"+
			"<KPY>开票人</KPY>"+
			"<FHR>复核人</FHR>"+
			"<SKY>收款人</SKY>"+
			"<XHQD></XHQD>"+
			"<FPQQLSH></FPQQLSH>"+
			"<KPLX>0</KPLX>"+
			"<JSHJ>58.5</JSHJ>"+
			"<HJJE>50</HJJE>"+
			"<HJSE>8.5</HJSE>"+
			"<FP_KJMXS class=\"FP_KJMX;\" size=\"1\">"+
				"<FP_KJMX>"+
					"<SPMC>商品名称1</SPMC>"+
					"<SM></SM>"+
					"<SL>0.17</SL>"+
					"<GGXH>号</GGXH>"+
					"<JLDW>量</JLDW>"+
					"<SPSL>1</SPSL>"+
					"<SPDJ>50</SPDJ>"+
					"<SPJE>50</SPJE>"+
					"<FPHXZ>0</FPHXZ>"+
					"<HSJBZ>0</HSJBZ>"+
					"<SE>8.5</SE>"+
				"</FP_KJMX>"+
			"</FP_KJMXS>"+
		"</REQUEST_FPKJ>";
		String xml = 
			"<?xml version=\"1.0\" encoding=\"utf-8\" ?>" + 
			"<interface>" + 
				"<globalInfo>" + 
					"<appId>ZZSDZFP</appId>" + 
					"<interfaceCode>EI.FPKJ.U.EC.INTRA</interfaceCode>" +
					"<userName>140114999999062</userName>" + 
					"<passWord></passWord>" + 
					"<requestCode></requestCode>" + 
					"<requestTime>2016-08-16 15:20:55 123</requestTime>" + 
					"<responseCode></responseCode>" + 
					"<dataExchangeId></dataExchangeId>"+
					"<fjh></fjh>"+
					"<jqbh></jqbh>"+
				"</globalInfo>" + 
				"<returnStateInfo>"+
					"<returnCode/>" +
					"<returnMessage/>" +
				"</returnStateInfo>"+
				"<Data>" +
					"<dataDescription>" + 
						"<zipCode>0</zipCode>"+
						"<encryptCode>0</encryptCode>" +
						"<codeType>0</codeType>"+
					"</dataDescription>" + 
					"<content>" + new BASE64Encoder().encode(content.getBytes()) + "</content>"+
				"</Data>" +
			"</interface>";
		return xml;
	}
}
