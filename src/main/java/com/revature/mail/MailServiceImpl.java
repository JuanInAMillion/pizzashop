//package com.revature.mail;
//
//import java.io.UnsupportedEncodingException;
//
//import javax.mail.MessagingException;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.stereotype.Service;
//
//@Service("mailService")
//public class MailServiceImpl implements MailService {
//
//	@Autowired
//	JavaMailSender mailSender;
//	
//	@Override
//	public void sendEmail(Mail mail) {
//		MimeMessage mimeMessage = mailSender.createMimeMessage();
//		
//		try {
//			MimeMessageHelper mmh = new MimeMessageHelper(mimeMessage, true);
//			mmh.setSubject(mail.getMailSubject());
//			mmh.setFrom(new InternetAddress(mail.getMailFrom(), "smtp.gmail.com"));
//			mmh.setTo(mail.getMailTo());
//			mmh.setText(mail.getMailContent());
//			
//			mailSender.send(mmh.getMimeMessage());
//		} catch(MessagingException e) {
//			e.printStackTrace();
//		} catch(UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//		
//	}
//
//}
