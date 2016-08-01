package com.shenjinxiang.blog;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SimpleMail {

	public static void main(String[] args) throws AddressException, MessagingException {
		Properties prop = new Properties();
		prop.setProperty("mail.host", "smtp.163.com");
		prop.setProperty("mail.transport.protocol", "smtp");
		prop.setProperty("mail.smtp.auth", "true");
		
		// 创建session
		Session session = Session.getInstance(prop);
		// 开启Session的debug模式，这样就可以查看到程序发送Email的运行状态
		session.setDebug(true);
		
		// 创建邮件
		Message message = createSimpleMessage(session);
		
		// 通过session得到transport对象
		Transport ts = session.getTransport();
		
		// 连上邮件服务器
		ts.connect("user@163.com", "password");
		
		// 发送邮件
		ts.sendMessage(message, message.getAllRecipients());
		ts.close();
	}

	/**
	 * 创建一封简单邮件
	 * @param session
	 * @return
	 * @throws shenjinxiang
	 * @throws MessagingException
	 */
	private static Message createSimpleMessage(Session session) throws AddressException, MessagingException {
		MimeMessage message = new MimeMessage(session);
		
		// 发件人
		message.setFrom(new InternetAddress("user@163.com"));
		
		// 收件人
		message.setRecipient(Message.RecipientType.TO, new InternetAddress("user@qq.com"));
		
		// 邮件标题
		message.setSubject("发送简单邮件");
		
		// 邮件内容
		message.setContent("这是一封简单邮件（只有这段话），没有多余的图片、附件之类的信息。能成功吗？", "text/html;charset=utf-8");
		
		return message;
	}
}
