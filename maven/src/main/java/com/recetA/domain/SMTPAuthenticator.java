package com.recetA.domain;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class SMTPAuthenticator extends Authenticator{
	
	@Override
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication("nikovella@naver.com","EK7QJCNCB4N4");
    }
}

