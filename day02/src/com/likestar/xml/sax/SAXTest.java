package com.likestar.xml.sax;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.junit.Test;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class SAXTest {

	@Test
	public void test1() throws Exception {
		// 创建解析工厂
		SAXParserFactory factory = SAXParserFactory.newInstance();
		
		// 创建解析器
		SAXParser parser = factory.newSAXParser();
		
		// 读取器
		XMLReader reader = parser.getXMLReader();
		
		reader.setContentHandler(new ListHandler());
		
		// 读取xml内容
		reader.parse("src/xml/books.xml");
	}
	
	class ListHandler extends DefaultHandler {

		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes)
				throws SAXException {
			System.out.println("startElement : uri -> " + uri + "\tlocalName -> " + localName + "\tqName -> " + qName);
		}

		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {
			System.out.println("endElement : uri -> " + uri + "\tlocalName -> " + localName + "\tqName -> " + qName);
		}

		@Override
		public void characters(char[] ch, int start, int length) throws SAXException {
			System.out.println("characters");
		}
		
	}
}
