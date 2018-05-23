package es.upm.dit.isst.docapp.handlers;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailHandler {
	
	private static EmailHandler instance;//Para modelo singleton
	private EmailHandler() {};
	public static EmailHandler getInstance() {
		if(null==instance) instance = new EmailHandler();
		return instance;
	}
	public static void sendEmail(String from, String to, String subject, String body) {
	
		final String username = "docapp.citas@gmail.com";
		final String password = "isst04..";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		

		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(to));
			message.setSubject(subject);
			message.setText(body);

			Transport.send(message);
			System.out.println("Done");

		} catch (MessagingException e) {
			System.out.println("aaaa");
			throw new RuntimeException(e);			
		}
		return;
	}
	
	
	/*public static void main(String[] args) {
		sendEmail("docapp.citas@gmail.com", "nachoguelor1996@gmail.com", "a", "b");
	}*/
		
}