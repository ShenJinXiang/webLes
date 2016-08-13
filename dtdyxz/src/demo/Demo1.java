package demo;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import coreservice_pkg.Coreservice;
import coreservice_pkg.CoreserviceLocator;
import coreservice_pkg.CoreservicePortType;
import sun.misc.BASE64Encoder;

public class Demo1 {

	public static void main(String[] args) throws ServiceException, RemoteException {
		String xml = getXzXml();
		Coreservice service = new CoreserviceLocator();
		CoreservicePortType cpt = service.getcoreserviceHttpPort();
		String result = cpt.handler(xml);
		System.out.println(result);
	}
	
	public static String getXzXml() {
		String content =
				"<dzfp_download>" +
				"<fpdm>123456</fpdm>" +
				"<fphm>123456</fphm>" +
				"<kprq>开票日期</kprq>" +
				"</dzfp_download>";

		String invoice_Open_xml = 
				"<?xml version=\"1.0\" encoding=\"utf-8\" ?>" +
				"<invoice_open>" +
				"<globalInfo>" +
				"<interfaceCode>Electronic_Document_DownLoad</interfaceCode>" +
				"<username>平台编码</username>" +
				"<password>10位随机数+Base64({(10位随机数+注册码) MD5})</password>" +
				"<taxpayerId>纳税人识别号</taxpayerId>" +
				"<authorizationCode>接入系统平台授权码(由平台提供)</authorizationCode >" +
				"<requestCode>数据交换请求发出方代码</requestCode>" +
				"<requestTime>数据交换请求方发出时间</requestTime>" +
				"<responseCode>数据交换请求接收方代码</responseCode>" +
				"<dataExchangeId>数据交换流水号</dataExchangeId>" +
				"<kpddm>开票点代码</kpddm>" +
				"<kpdmc>开票点名称</kpdmc>" +
				"</globalInfo>" +
				"<data>" +
				"<content>" + new BASE64Encoder().encode(content.getBytes()) + "</content>" +
				"</data>" +
				"</invoice_open>";

		return invoice_Open_xml;
	}
}
