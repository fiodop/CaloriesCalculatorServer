package ru.artemkliucharov.caroriescalcserver.caloriescalculatorserver.service.auth;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import ru.artemkliucharov.caroriescalcserver.caloriescalculatorserver.entity.Mail;

@Service
public class EmailService {
    private JavaMailSender mailSender;

    public void sendEmail(Mail mail){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(mail.getRecipient());
        message.setSubject(mail.getSubject());
        message.setText(mail.getText());

        mailSender.send(message);
    }
}
