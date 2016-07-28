package com.shenjinxiang.flx;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class ImageMail {

	public static void main(String[] args) throws MessagingException, FileNotFoundException, IOException {
		Session session = Session.getDefaultInstance(new Properties());
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress("sjx-sword@163.com"));
		message.setRecipient(Message.RecipientType.TO, new InternetAddress("451161982@qq.com"));
		message.setSubject("test");
		
		MimeBodyPart text = new MimeBodyPart();
		text.setContent("aaaa<br/><img src='cid:1.jpg'><br/>aaaaaaaa", "text/html");
		
		MimeBodyPart image = new MimeBodyPart();
		DataHandler dh = new DataHandler(new FileDataSource("src/1.jpg"));    //jaf
		image.setDataHandler(dh);
		image.setContentID("1.jpg");
		
		MimeMultipart mm = new MimeMultipart();
		mm.addBodyPart(text);
		mm.addBodyPart(image);
		mm.setSubType("related");
		
		message.setContent(mm);
		message.saveChanges();
		
		message.writeTo(new FileOutputStream("/Users/shenjinxiang/temp/test.eml"));
		
		
	}
}
