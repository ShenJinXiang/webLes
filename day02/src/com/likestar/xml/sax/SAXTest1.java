package com.likestar.xml.sax;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.junit.Test;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class SAXTest1 {

	@Test
	public void test1() throws Exception {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		XMLReader reader = parser.getXMLReader();
		ListHandler handler = new ListHandler();
		reader.setContentHandler(handler);
		reader.parse("src/xml/books.xml");
		List<Map<String, String>> list = handler.getList();
		System.out.println("*********************************");
		for(Map<String, String> map : list) {
			System.out.println(map);
		}
	}
	
	class ListHandler extends DefaultHandler {
		
		private List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		private Map<String, String> book;
		private String currentName = null;

		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes)
				throws SAXException {
			currentName = qName;
			if("book".equals(qName)) {
				book = new HashMap<String, String>();
			}
		}

		@Override
		public void characters(char[] ch, int start, int length) throws SAXException {
			if("name".equals(currentName)) {
				book.put("name", new String(ch, start, length));
			}
			if("author".equals(currentName)) {
				book.put("author", new String(ch, start, length));
			}
			if("price".equals(currentName)) {
				book.put("price", new String(ch, start, length));
			}
		}


		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {
			if("book".equals(qName)) {
				list.add(book);
			}
			currentName = null;
		}

		public List<Map<String, String>> getList() {
			return list;
		}
		
	}
}
