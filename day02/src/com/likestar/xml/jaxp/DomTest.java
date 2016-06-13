package com.likestar.xml.jaxp;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomTest {

	@Test
	public void test1() throws ParserConfigurationException, FileNotFoundException, SAXException, IOException{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = factory.newDocumentBuilder();
		File file = new File("src/xml", "books.xml");
		Document document = documentBuilder.parse(new FileInputStream(file));
		Node rootNode = document.getElementsByTagName("books").item(0);
		NodeList bookNodes = rootNode.getChildNodes();
		for(int i = 0; i < bookNodes.getLength(); i++) {
			System.out.println("********************************");
			Node bookNode = bookNodes.item(i);
			NodeList nodes = bookNode.getChildNodes();
			for(int j = 0; j < nodes.getLength(); j++) {
				System.out.println("------------------------------");
				Node nodeJ = nodes.item(j);
				System.out.println("NodeName -> " + nodeJ.getNodeName());
				System.out.println("NodeValue -> " + nodeJ.getNodeValue());
				System.out.println("LocalName -> " + nodeJ.getLocalName());
				System.out.println("TextContent --> " + nodeJ.getTextContent());
				System.out.println("NodeType -> " + nodeJ.getNodeType());
				System.out.println("------------------------------");
			}
			System.out.println("********************************");
		}
		
	}
	
	@Test
	public void test2() throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = factory.newDocumentBuilder();
		Document document = documentBuilder.parse("src/xml/books.xml");
		Element root = document.getDocumentElement();
		list(root);
	}

	private void list(Node ele) {
		if(ele.getNodeType() == 1) {
			System.out.println(ele.getNodeName());
			NodeList list = ele.getChildNodes();
			for(int i = 0; i < list.getLength(); i++) {
				list(list.item(i));
			}
		}
	}
	
}
