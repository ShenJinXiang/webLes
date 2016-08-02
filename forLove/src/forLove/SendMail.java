package forLove;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {
	
	private static String filename = "src/forlove.md";

	public static void main(String[] args) throws Exception {
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				try {
					sendMail();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}, 1000);
	}
	
	private static void sendMail() throws Exception {
		System.out.println("....");
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
		ts.connect("sjx-sword@163.com", "");
		
		// 发送邮件
		ts.sendMessage(message, message.getAllRecipients());
		ts.close();
	}
	
	private static Message createSimpleMessage(Session session) throws AddressException, MessagingException {
		MimeMessage message = new MimeMessage(session);
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日的爱恋");
		String text = Md2Html.asHtml(filename);
		
		// 发件人
		message.setFrom(new InternetAddress("sjx-sword@163.com"));
		
		// 收件人
		message.setRecipient(Message.RecipientType.TO, new InternetAddress("451161982@qq.com"));
		
		// 邮件标题
		message.setSubject(sdf.format(new Date()));
		
		// 邮件内容
		message.setContent(text, "text/html;charset=utf-8");
		
		return message;
	}
}
