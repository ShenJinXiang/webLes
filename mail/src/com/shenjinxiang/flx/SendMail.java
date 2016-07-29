package com.shenjinxiang.flx;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {

	/**
	 * @param args
	 * @throws MessagingException 
	 * @throws UnsupportedEncodingException 
	 */
	public static void main(String[] args) throws MessagingException, UnsupportedEncodingException {
		
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

	private static Message createMessage(Session session) throws AddressException, MessagingException, UnsupportedEncodingException {
		//¥¥Ω®” º˛
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress("sjx-sword@163.com"));
		message.setRecipient(Message.RecipientType.TO, new InternetAddress("243886005@qq.com"));
		message.setSubject("test");
		
		
		message.setContent("aaaaaaaaaaaa", "text/html");
		message.saveChanges();
		
		return message;
	}
}
