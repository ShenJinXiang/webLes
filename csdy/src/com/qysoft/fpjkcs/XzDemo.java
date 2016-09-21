package com.qysoft.fpjkcs;

import java.io.File;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;

import javax.xml.rpc.ServiceException;

import coreservice.Coreservice;
import coreservice.CoreserviceLocator;
import coreservice.CoreservicePortType;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class XzDemo {

	public static void main(String[] args) throws Exception {
		String xml = getXML();
		CoreserviceLocator service = new CoreserviceLocator();
		service.setcoreserviceHttpPortEndpointAddress("http://218.26.181.92:8080/dzfpjk/services/coreservice");
		CoreservicePortType pt = service.getcoreserviceHttpPort();
		String result = pt.invoke(xml);
		System.out.println("-----------------返回报文---------------------");
		System.out.println(result);	// 返回报文
		
		// 获取内层报文
		String content = result.substring(result.indexOf("<content>") + "<content>".length(), result.indexOf("</content>"));
		
		System.out.println("------------------返回的内层报文-----------------------");
		String response = new String(new BASE64Decoder().decodeBuffer(content));
		System.out.println(response);
		
		// 获取pdf_file
		String pdf_file = response.substring(response.indexOf("<pdf_file>") + "<pdf_file>".length(), response.indexOf("</pdf_file>"));
		File file = new File("001.pdf");
		FileOutputStream fos = new FileOutputStream(file);
		fos.write(new BASE64Decoder().decodeBuffer(pdf_file));
		fos.flush();
		fos.close();
		System.out.println("生成pdf文件:" + file.getAbsolutePath());
	}
	
	private static String getXML() throws UnsupportedEncodingException {
		String fpdm = "1400083620";
		String fphm = "00347877";
		String content =
				"<dzfp_download>\r\n" +
				"<fpdm>" + fpdm + "</fpdm>\r\n" +
				"<fphm>" + fphm + "</fphm>\r\n" +
				"<kprq></kprq>\r\n" +
				"</dzfp_download>\r\n";

		String invoice_Open_xml = 
				"<?xml version='1.0' encoding='utf-8' ?>\r\n" +
				"<invoice_open>\r\n" +
				"	<globalInfo>\r\n" +
				"		<interfaceCode>Electronic_Document_DownLoad</interfaceCode>\r\n" +
				"		<username>123456</username>\r\n" +
				"		<password>456456546</password>\r\n" +
				"		<taxpayerId>140114999999062</taxpayerId>\r\n" +
				"		<authorizationCode>140114999999062</authorizationCode >\r\n" +
				"		<requestCode>144</requestCode>\r\n" +
				"		<requestTime>2016-08-16 17:54:22 231</requestTime>\r\n" +
				"		<responseCode>155</responseCode>\r\n" +
				"		<dataExchangeId>d35skpyd11173405kd33</dataExchangeId>\r\n" +
				"		<kpddm>222</kpddm>\r\n" +
				"		<kpdmc>222</kpdmc>\r\n" +
				"	</globalInfo>\r\n" +
				"	<returnStateInfo>\r\n"+
				"		<returnCode/>\r\n" +
				"		<returnMessage/>\r\n" +
				"	</returnStateInfo>\r\n"+
				"	<data>\r\n" +
				"		<content>" + new BASE64Encoder().encode(content.getBytes("utf-8")) + "</content>\r\n" +
				"	</data>\r\n" +
				"</invoice_open>";

		return invoice_Open_xml;
	}
}
