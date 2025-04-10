package com.societyscore.authservice.Service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.societyscore.authservice.Util.Messages.EmailMessages;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendConfirmationEmail(String to, String token) {
        String link = EmailMessages.EMAIL_LINK_CONFIRMATION + token;
        SimpleMailMessage message = this.setMessage(to, link);
        mailSender.send(message);
    }

    private SimpleMailMessage setMessage(String to, String link) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(EmailMessages.SUBJECT_CONFIRMATION);
        message.setText(EmailMessages.textConfirmation(link));
        return message;
    }
}
