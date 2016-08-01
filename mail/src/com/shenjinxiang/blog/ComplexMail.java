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

public class ComplexMail {

	public static void main(String[] args) throws Exception{
		Properties prop = new Properties();
		prop.setProperty("mail.host", "smtp.163.com");
		prop.setProperty("mail.transport.protocol", "smtp");
		prop.setProperty("mail.smtp.auth", "true");
		
		// 创建session
		Session session = Session.getInstance(prop);
		// 开启Session的debug模式，这样就可以查看到程序发送Email的运行状态
		session.setDebug(true);
		
		// 创建邮件
		Message message = createComplexMessage(session);
		
		
		// 通过session得到transport对象
		Transport ts = session.getTransport();
		
		// 连上邮件服务器
		ts.connect("***@163.com", "邮箱密码");
		
		// 发送邮件
		ts.sendMessage(message, message.getAllRecipients());
		ts.close();
	}

	private static Message createComplexMessage(Session session) throws Exception {
MimeMessage message = new MimeMessage(session);
		
		// 发件人
		message.setFrom(new InternetAddress("***@163.com"));
		
		// 收件人
		message.setRecipient(Message.RecipientType.TO, new InternetAddress("***@qq.com"));
		
		// 邮件标题
		message.setSubject("复杂的邮件");
		
		// 邮件正文数据
		MimeBodyPart text = new MimeBodyPart();
		text.setContent("这里是邮件正文内容，下面是一张图片：<br><img src='cid:1.jpg'><br/>这个邮件还有一个附件，请查收！", "text/html;charset=utf-8");
		
		// 邮件图片数据
		MimeBodyPart image = new MimeBodyPart();
		image.setDataHandler(new DataHandler(new FileDataSource("src/1.jpg")));
		image.setContentID("1.jpg");
		
		// 正文和图片的关系
		MimeMultipart content = new MimeMultipart();
		content.addBodyPart(text);
		content.addBodyPart(image);
		content.setSubType("related");
		
		// 将正文和附件的MimeMultipart封装到MimeBodyPart中
		MimeBodyPart mbp = new MimeBodyPart();
		mbp.setContent(content);
		
		// 附件数据
		MimeBodyPart attach = new MimeBodyPart();
		DataHandler dh = new DataHandler(new FileDataSource("src/光辉岁月.mp3"));
		attach.setDataHandler(dh);
		attach.setFileName(MimeUtility.encodeText(dh.getName()));
		
		// 附件数据2
		MimeBodyPart attach1 = new MimeBodyPart();
		DataHandler dh1 = new DataHandler(new FileDataSource("src/游荡的野狼 - Opinions Of The Misinformed（盖伦特专属音乐）.mp3"));
		attach1.setDataHandler(dh1);
		attach1.setFileName(MimeUtility.encodeText(dh1.getName()));
		
		// 描述关系
		MimeMultipart mm = new MimeMultipart();
		mm.addBodyPart(mbp);
		mm.addBodyPart(attach);
		mm.addBodyPart(attach1);
		mm.setSubType("mixed");
		
		message.setContent(mm);
		message.saveChanges();
		return message;
	}
}
