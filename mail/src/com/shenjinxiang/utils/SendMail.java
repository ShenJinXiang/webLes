package com.shenjinxiang.utils;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.shenjinxiang.entity.User;

public class SendMail  extends Thread{
	
	private String host = "";
	private String email = "";
	private String username = "";
	private String password = "";
	private User user;
	
	public SendMail(User user) {
		super();
		this.user  = user;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(1000 * 30);
			send(user);
		} catch (MessagingException | InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void send(User user) throws AddressException, MessagingException {
		
		Properties prop = new Properties();
		prop.setProperty("mail.host", host);
		prop.setProperty("mail.transport.protocol", "smtp");
		Session session = Session.getInstance(prop);
		
		Message message = createMessage(session, user);
		
		Transport ts = session.getTransport();
		ts.connect(username, password);
		ts.sendMessage(message, message.getAllRecipients());
	}


	private Message createMessage(Session session, User user) throws AddressException, MessagingException {
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(email));
		message.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
		message.setSubject("邮件标题");
		
		String content = "";
		message.setContent(content, "text/html;charset=utf-8");
		message.saveChanges();
		
		return message;
	}
	

}