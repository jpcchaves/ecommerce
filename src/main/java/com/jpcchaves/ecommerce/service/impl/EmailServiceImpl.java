package com.jpcchaves.ecommerce.service.impl;

import com.jpcchaves.ecommerce.service.EmailService;
import org.springframework.stereotype.Service;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Properties;

@Service
public class EmailServiceImpl implements EmailService {

  private static final String userName = "alexemailformacaojavaweb@gmail.com";
  private static final String pwd = "g}_dB,EVUt4T";

  @Override
  public void send(
      String subject,
      String body,
      String recipient
  ) throws MessagingException, UnsupportedEncodingException {

    Properties properties = new Properties();

    properties.putAll(
        Map.of(
            "mail.smtp.ssl.trust", "*",
            "mail.smtp.ssl.auth", "true",
            "mail.smtp.starttls", "false",
            "mail.smtp.host", "smtl.gmail.com",
            "mail.smtp.port", "465",
            "mail.smtp.socketFactory.port", "465",
            "mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"
        )
    );


    Session session = Session.getInstance(properties, new Authenticator() {
      @Override
      protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(userName, pwd);
      }
    });

    session.setDebug(true);

    Address[] toUser = InternetAddress.parse(recipient);

    Message message = new MimeMessage(session);

    message.setFrom(new InternetAddress(userName, "Ecommerce API", "UTF-8"));
    message.setRecipients(Message.RecipientType.TO, toUser);
    message.setSubject(subject);
    message.setContent(body, "text/html; charset=UTF-8");

    Transport.send(message);
  }
}
