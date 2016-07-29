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
import javax.mail.internet.MimeUtility;

public class ComplexMail {

	public static void main(String[] args) throws AddressException, MessagingException, FileNotFoundException, IOException {
		
		// 创建邮件
		Session session = Session.getDefaultInstance(new Properties());
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress("sjx-sword@163.com"));
		message.setRecipient(Message.RecipientType.TO, new InternetAddress("451161982@qq.com"));
		message.setSubject("test");
		
		// 创建bodypart正文
		MimeBodyPart text = new MimeBodyPart();
//		text.setContent("aaaaa<img src=''>", "text/html");
		text.setContent("aaaaa<img src=''>", "text/html;charset=utf-8");
		
		// 图片
		MimeBodyPart image = new MimeBodyPart();
		image.setDataHandler(new DataHandler(new FileDataSource("src/1.jpg")));
		image.setContentID("1.jpg");
		
		// 附件
		MimeBodyPart attach = new MimeBodyPart();
		DataHandler dh = new DataHandler(new FileDataSource("src/1.mp3"));
		attach.setDataHandler(dh);
//		attach.setFileName("1.mp3");
		attach.setFileName(MimeUtility.encodeText(dh.getName()));
		
		MimeMultipart content = new MimeMultipart();
		content.addBodyPart(text);
		content.addBodyPart(image);
		content.setSubType("related");
		
		MimeBodyPart mbp = new MimeBodyPart();
		mbp.setContent(content);
		
		MimeMultipart mm = new MimeMultipart();
		mm.addBodyPart(mbp);
		mm.addBodyPart(attach);
		mm.setSubType("mixed");
		
		message.setContent(mm);
		message.saveChanges();
		
		message.writeTo(new FileOutputStream("/Users/shenjinxiang/temp/test1.eml"));
		
	}
}
