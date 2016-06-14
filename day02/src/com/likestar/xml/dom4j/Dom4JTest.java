package com.likestar.xml.dom4j;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

public class Dom4JTest {

	@Test
	public void test1() throws Exception {
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/xml/books.xml"));
		
		Element root = document.getRootElement();
		System.out.println(root.getName());
	}
	
	/**
	 * 添加一个节点
	 * @throws Exception
	 */
	@Test
	public void test2() throws Exception {
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/xml/books.xml"));
		Element root = document.getRootElement();
		System.out.println("---------------");
		System.out.println(root.asXML());
		System.out.println("---------------");
		Element book = root.addElement("book").addAttribute("id", "three");
		book.addElement("name").setText("python");
		book.addElement("author").setText("申锦祥");
		book.addElement("primce").setText("99.12元");
		
		OutputFormat format = OutputFormat.createPrettyPrint();
//		XMLWriter write = new XMLWriter(new FileWriter("src/xml/books.xml"));
		XMLWriter write = new XMLWriter(new OutputStreamWriter(new FileOutputStream("src/xml/books.xml"), "utf-8"), format);
		write.write(document);
		write.close();
	}
}
