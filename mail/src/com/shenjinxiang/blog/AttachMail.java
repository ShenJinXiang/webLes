package com.shenjinxiang.blog;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

public class AttachMail {

	public static void main(String[] args) throws Exception {
		Properties prop = new Properties();
		prop.setProperty("mail.host", "smtp.163.com");
		prop.setProperty("mail.transport.protocol", "smtp");
		prop.setProperty("mail.smtp.auth", "true");
		
		// 创建session
		Session session = Session.getInstance(prop);
		// 开启Session的debug模式，这样就可以查看到程序发送Email的运行状态
		session.setDebug(true);
		
		// 创建邮件
		Message message = createAttachMessage(session);
		
		
		// 通过session得到transport对象
		Transport ts = session.getTransport();
		
		// 连上邮件服务器
		ts.connect("***@163.com", "邮箱密码");
		
		// 发送邮件
		ts.sendMessage(message, message.getAllRecipients());
		ts.close();
	}

	private static Message createAttachMessage(Session session) throws Exception {
		MimeMessage message = new MimeMessage(session);
		
		// 发件人
		message.setFrom(new InternetAddress("***@163.com"));
		
		// 收件人
		message.setRecipient(Message.RecipientType.TO, new InternetAddress("***@qq.com"));
		
		// 邮件标题
		message.setSubject("带附件的邮件");
		
		MimeBodyPart text = new MimeBodyPart();
		text.setContent("这里是邮件正文内容<br>这个邮件还有一个附件，请查收！", "text/html;charset=utf-8");
		
		MimeBodyPart attach = new MimeBodyPart();
		DataHandler dh = new DataHandler(new FileDataSource("src/光辉岁月.mp3"));
		attach.setDataHandler(dh);
		attach.setFileName(MimeUtility.encodeText(dh.getName()));
		
		MimeMultipart mm = new MimeMultipart();
		mm.addBodyPart(text);
		mm.addBodyPart(attach);
		mm.setSubType("mixed");
		
		message.setContent(mm);
		message.saveChanges();
		return message;
	}
}
