package com.email.service;


import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.InternetAddress;
import java.util.Properties;

@Service
public class EmailService {

    public boolean senEmail(String message, String subject, String to, String from, String apppassword){
        //rest of the code

        boolean f = false;
        //from

        //variable for gmail
        String host = "smtp.gmail.com";

        //get the system properties
        Properties properties = System.getProperties();
        System.out.println("Properties "+ properties);

        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable","true");
        properties.put("mail.smtp.auth",true);

        //step 1: to get the session object...
        Session session = Session.getInstance(properties, new Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, apppassword);
            }
        });


        session.setDebug(true);

        //step 2: compose the message [text, multi media]
        MimeMessage m = new MimeMessage(session);

        try{

            //setting from email
            m.setFrom(from);

            //adding recipient to message
            m.addRecipients(Message.RecipientType.TO, String.valueOf(new InternetAddress(to)));

            m.setSubject(subject);

            m.setText(message);

            Transport.send(m);

            f=true;

        }catch (Exception e){
            e.getMessage();
        }

        return f;
    }
}
