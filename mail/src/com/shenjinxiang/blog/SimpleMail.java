package com.shenjinxiang.blog;

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
		Message message = createImageMessage(session);
		
		// 通过session得到transport对象
		Transport ts = session.getTransport();
		
		// 连上邮件服务器
		ts.connect("***@163.com", "邮箱密码");
		
		// 发送邮件
		ts.sendMessage(message, message.getAllRecipients());
		ts.close();
	}

	private static Message createImageMessage(Session session) throws AddressException, MessagingException {
		MimeMessage message = new MimeMessage(session);
		// 发件人
		message.setFrom(new InternetAddress("***@163.com"));
		
		// 收件人
		message.setRecipient(Message.RecipientType.TO, new InternetAddress("***@qq.com"));
		
		// 邮件标题
		message.setSubject("附带一张图片");
		
		// 准备邮件正文数据
		MimeBodyPart text = new MimeBodyPart();
		text.setContent("下面是一张图片：<br/><img src='cid:1.jpg'><br/>图片后边的文字信息", "text/html;charset=utf-8");
		
		// 准备邮件图片数据
		MimeBodyPart image = new MimeBodyPart();
		DataHandler dh = new DataHandler(new FileDataSource("src/1.jpg"));
		image.setDataHandler(dh);
		image.setContentID("1.jpg");
		
		// 描述数据关系
		MimeMultipart mm = new MimeMultipart();
		mm.addBodyPart(text);
		mm.addBodyPart(image);
		mm.setSubType("related");
		
		message.setContent(mm);
		message.saveChanges();
		return message;
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
		message.setFrom(new InternetAddress("sjx-sword@163.com"));
		
		// 收件人
		message.setRecipient(Message.RecipientType.TO, new InternetAddress("243886005@qq.com"));
		
		// 邮件标题
		message.setSubject("发送简单邮件");
		
		// 邮件内容
		message.setContent("这是一封简单邮件（只有这段话），没有多余的图片、附件之类的信息。能成功吗？", "text/html;charset=utf-8");
		
		return message;
	}
}
