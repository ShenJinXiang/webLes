package com.shenjinxiang.demo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Imagemail {

	public static void main(String[] args) throws AddressException, MessagingException, FileNotFoundException, IOException {
		// 创建邮件
		Session session = Session.getDefaultInstance(new Properties());
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress("sjx-sword@163.com")); // 451161982@qq.com
		message.setRecipient(Message.RecipientType.TO, new InternetAddress("451161982@qq.com"));
		message.setSubject("test");
		
		// 创建邮件中的数据
		
		// 创建正文
		MimeBodyPart text = new MimeBodyPart();
		text.setContent("aaaaaaa<br><img src='cid:1.jgp'><br>aaaaa", "text/html");
		
		// 创建图片
		MimeBodyPart image = new MimeBodyPart();
		DataHandler dh = new DataHandler(new FileDataSource("src/1.jpg")); // jaf
		image.setDataHandler(dh);
		image.setContentID("1.jpg");
		
		// 描述数据之间的关系
		MimeMultipart mm = new MimeMultipart();
		mm.addBodyPart(text);
		mm.addBodyPart(image);
		mm.setSubType("related"); // mixed
		
		message.setContent(mm);
		message.saveChanges();
		
		message.writeTo(new FileOutputStream("d:\\1.eml"));
	}
}
