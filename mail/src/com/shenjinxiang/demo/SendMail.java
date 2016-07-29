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
		prop.setProperty("mail.smtp.host", "smtp.qq.com");
		prop.setProperty("mail.transport.protocol", "smtp");
		prop.setProperty("mail.smtp.auth", "true");
		
		
		Session session = Session.getInstance(prop);
		session.setDebug(true);// 打印交互过程
		Message message = createMessage(session);
		
		
		Transport ts = session.getTransport();
		ts.connect("", "");
		ts.sendMessage(message, message.getAllRecipients());
		ts.close();
	}

	private static Message createMessage(Session session) throws AddressException, MessagingException {
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress("243886005@qq.com"));
		message.setRecipient(Message.RecipientType.TO, new InternetAddress("sjx-sword@163.com"));
		message.setSubject("test");
		
		message.setContent("这是一个好人，测试一下，是不是啊？", "text/html;charset=utf-8");
		message.saveChanges();
		
		return message;
		
	}
}
