package com.project.foodbook.service;

import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.lang3.CharEncoding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import com.project.foodbook.domain.Recept;
import com.project.foodbook.domain.User;

@Service
public class MailService {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	private SpringTemplateEngine templateEngine;
	
	@Async
	public void sendMail(String toWho, String fromWho, String subject, String content) throws MessagingException{
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeHelper = new MimeMessageHelper(message, false, CharEncoding.UTF_8);
		mimeHelper.setFrom(fromWho);
		mimeHelper.setTo(toWho);
		mimeHelper.setSubject(subject);
		mimeHelper.setText(content, true);
		
		javaMailSender.send(message);
		
}
	
	@Async
	public void sendRecepieToAll(List<User> users, Recept recept) throws MessagingException {
		Context context = new Context();
		context.setVariable("recept", recept);
		
		String content = templateEngine.process("recepieToAll", context);
		
		for(User user: users){
			sendMail(user.getEmail(), "oliverab94@gmail.com", "recept", content);
		}
	}

}
