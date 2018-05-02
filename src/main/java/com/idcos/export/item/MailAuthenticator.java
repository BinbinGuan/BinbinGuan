package com.idcos.export.item;

import org.springframework.beans.factory.annotation.Autowired;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * @author GuanBin
 * @version MailAuthenticator.java, v1 2018/5/2 下午2:13 GuanBin Exp $$
 */
public class MailAuthenticator extends Authenticator {

    private String username;

    private String password;

    public MailAuthenticator(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(username, password);
    }
}
