/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.imtahan.service;

import mailmanagement.beans.MailBean;
import mailmanagement.util.MailManager;
import management.configuration.MailConfigurationCenter;
import management.configuration.SMTPConfiguration;
import org.springframework.stereotype.Component;

/**
 *
 * @author sarkhanrasullu
 */
@Component
public class EmailService {

    //your mail server credentials
    private final String host = "smtp.gmail.com";
    private final String email = "serxanresullu@gmail.com";
    private final String password = "?7379267378558?bB";
    private final int smtpPort = 587;

    public void sendEmail(String subject, String message, String to) {
        SMTPConfiguration smtp = SMTPConfiguration.instance(host, smtpPort, email, password);
        MailConfigurationCenter conf = MailConfigurationCenter.builder().register(smtp).build();
        MailManager mailSender = MailManager.instance(conf);
        MailBean mail = new MailBean(subject, message, to);
        mailSender.sendEmail(mail);
    }

    public static void main(String[] args) {
        new EmailService().sendEmail("test subject", "test message", "serxanresullu@gmail.com");
    }
}
