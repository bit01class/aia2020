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
		// ���� ȯ�� ���� �����Դϴ�.
		Properties props = new Properties();
		// ���� ���������� gmail�� �̿��� ���̱� ������ smtp�� ����մϴ�.
		props.setProperty("mail.transport.protocol", "smtp");
		// ���� ȣ��Ʈ �ּҸ� �����մϴ�.
		props.setProperty("mail.host", "smtp.gmail.com");
		// ID, Password ������ �ʿ��մϴ�.
		props.put("mail.smtp.auth", "true");
		// port�� 465�Դϴ�.
		props.put("mail.smtp.port", "465");
		// ssl�� ����� ��� �����մϴ�.
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.fallback", "false");
		props.setProperty("mail.smtp.quitwait", "false");
		// id�� password�� �����ϰ� session�� �����մϴ�.
		Session session = Session.getInstance(props, new Authenticator() {
		protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication("id", "password");
		}
		});
		// ����� ����Դϴ�.
		session.setDebug(true);
		// ���� �޽����� ����� ���� Ŭ������ �����մϴ�.
		MimeMessage message = new MimeMessage(session);
		// �۽��� ����
		message.setFrom(new InternetAddress("id@gmail.com"));
		// ������ ����
		message.addRecipient(Message.RecipientType.TO, new InternetAddress("to@gmail.com"));
		// ���� ������ �����մϴ�.
		message.setSubject("Test Mail");
		// ���� ������ ������ ���� Ŭ������ �����մϴ�.
		message.setContent(new MimeMultipart());
		// ���� ������ ���� MultipartŬ������ �޾ƿ´�. (�� new MimeMultipart()�� ���� Ŭ�����Դϴ�.)
		Multipart mp = (Multipart) message.getContent();
		// html �������� ������ �ۼ��ؼ� �ٿ������ �ֽ��ϴ�.
		MimeBodyPart body = new MimeBodyPart();
		body.setContent("<html><head></head><body>Hello Test</body></html>","text/html; charset=utf-8");
		mp.addBodyPart(body);
		// ������ �����ϴ�.
		Transport.send(message);
	}

}
