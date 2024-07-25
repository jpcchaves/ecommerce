package com.jpcchaves.ecommerce.service;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

public interface EmailService {


  void send(
      String subject,
      String body,
      String recipient
  ) throws MessagingException, UnsupportedEncodingException;
}
