package mailTest;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class MainSender {

	public static void main(String[] args) throws AddressException, MessagingException, IOException {
		// 메일 환경 변수 설정입니다.
		Properties props = new Properties();
		// 메일 프로토콜은 gmail를 이용할 것이기 때문에 smtp로 사용합니다.
		props.setProperty("mail.transport.protocol", "smtp");
		// 메일 호스트 주소를 설정합니다.
		props.setProperty("mail.host", "smtp.gmail.com");
		// ID, Password 설정이 필요합니다.
		props.put("mail.smtp.auth", "true");
		// port는 465입니다.
		props.put("mail.smtp.port", "465");
		// ssl를 사용할 경우 설정합니다.
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.fallback", "false");
		props.setProperty("mail.smtp.quitwait", "false");
		// id와 password를 설정하고 session을 생성합니다.
		Session session = Session.getInstance(props, new Authenticator() {
		protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication("id", "password");
		}
		});
		// 디버그 모드입니다.
		session.setDebug(true);
		// 메일 메시지를 만들기 위한 클래스를 생성합니다.
		MimeMessage message = new MimeMessage(session);
		// 송신자 설정
		message.setFrom(new InternetAddress("id@gmail.com"));
		// 수신자 설정
		message.addRecipient(Message.RecipientType.TO, new InternetAddress("to@gmail.com"));
		// 메일 제목을 설정합니다.
		message.setSubject("Test Mail");
		// 메일 내용을 설정을 위한 클래스를 설정합니다.
		message.setContent(new MimeMultipart());
		// 메일 내용을 위한 Multipart클래스를 받아온다. (위 new MimeMultipart()로 넣은 클래스입니다.)
		Multipart mp = (Multipart) message.getContent();
		// html 형식으로 본문을 작성해서 바운더리에 넣습니다.
		MimeBodyPart body = new MimeBodyPart();
		body.setContent("<html><head></head><body>Hello Test</body></html>","text/html; charset=utf-8");
		mp.addBodyPart(body);
		// 메일을 보냅니다.
		Transport.send(message);
	}

}
