package com.shenjinxiang.demo;

import java.io.FileOutputStream;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendMail {

	public static void main(String[] args) throws MessagingException {
		Properties prop = new Properties();
		prop.setProperty("mail.smtp.host", "smtp.163.com");
		prop.setProperty("mail.transport.protocol", "smtp");
		prop.setProperty("mail.smtp.auth", "true");
		
		javax.mail.Session session = javax.mail.Session.getInstance(prop);
		session.setDebug(true);
		
		Message message = createMessage(session);
		Transport ts = session.getTransport();
		ts.connect("", "");
		ts.sendMessage(message,message.getAllRecipients());
		ts.close();
	}

	private static Message createMessage(Session session) throws MessagingException {
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress("sjx-sword@163.com"));
		message.setRecipient(Message.RecipientType.TO, new InternetAddress(""));
		message.setSubject("发送图片看看");
		
		MimeBodyPart textPart = new MimeBodyPart();
		textPart.setContent("<img src='cid:001.jpg'><br/>", "text/html;charset=utf-8");
		
		MimeBodyPart image = new MimeBodyPart();
		DataHandler dh = new DataHandler(new FileDataSource("src/1.jpg"));    //jaf
		image.setDataHandler(dh);
		image.setContentID("001.jpg");
		
		MimeMultipart mm = new MimeMultipart();
		mm.addBodyPart(textPart);
		mm.addBodyPart(image);
		mm.setSubType("related");
		
		message.setContent(mm);
		message.saveChanges();
		
		return message;
	}
	
	

}
