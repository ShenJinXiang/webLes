package com.shenjinxiang.demo;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;

public class Imagemail {

	public static void main(String[] args) throws AddressException, MessagingException {
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
		
		
		
	}
}
