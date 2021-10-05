package com.example.movieapp.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class MailSender {
    @Value("${spring.mail.username}")
    private String email;
    @Value("${spring.mail.password}")
    private String email_password;
    @Value("${spring.mail.host}")
    private String mail_host;
    @Value("${spring.mail.port}")
    private int mail_port;

    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(mail_host);
        mailSender.setPort(mail_port);

        mailSender.setUsername(email);
        mailSender.setPassword(email_password);

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }

    public String getOrigin() {
        return email;
    }
}
