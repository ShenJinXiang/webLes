package com.likestar.xml.jaxp;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

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
	
	/**
	 * 遍历xml节点
	 * @throws Exception
	 */
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
	
	/**
	 * 添加一个book节点
	 * @throws Exception
	 */
	@Test
	public void test3() throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = factory.newDocumentBuilder();
		Document document = documentBuilder.parse("src/xml/books.xml");
		
		Element book1 = document.createElement("book");
		Element bookName1 = document.createElement("name");
		bookName1.setTextContent("JavaScript权威指南");
		Element bookAuthor = document.createElement("author");
		bookAuthor.setTextContent("LikeStar");
		Element bookPrice = document.createElement("price");
		bookPrice.setTextContent("119.10");
		book1.appendChild(bookName1);
		book1.appendChild(bookAuthor);
		book1.appendChild(bookPrice);
		
		Element book = (Element) document.getElementsByTagName("book").item(1);
		Element rootElement = document.getDocumentElement();
		rootElement.insertBefore(book1, book);
		
		TransformerFactory tfFactory = TransformerFactory.newInstance();
		Transformer tf = tfFactory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult("src/xml/books.xml"));
	}
	
	/**
	 * 删除 节点
	 * @throws Exception
	 */
	@Test
	public void test4() throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = factory.newDocumentBuilder();
		Document document = documentBuilder.parse("src/xml/books.xml");
		
		Element bookElement1 = (Element) document.getElementsByTagName("book").item(1);
		bookElement1.getParentNode().removeChild(bookElement1);
		
		TransformerFactory tfFactory = TransformerFactory.newInstance();
		Transformer tf = tfFactory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult("src/xml/books.xml"));
	}
	
}
