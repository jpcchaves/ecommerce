package com.jpcchaves.ecommerce.service;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

public interface PasswordScheduledJob {
    void notifyUserChangePassword() throws MessagingException, UnsupportedEncodingException, InterruptedException;
}
