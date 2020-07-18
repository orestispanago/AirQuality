package com.oop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

/**
 *
 * @author orestis
 */
@Service
public class MailService {
    
    @Autowired
    @Qualifier("gmail")
    private JavaMailSender mailSender;
    
    public void sendMail(String subject, String toAddresses, String body) {
        MimeMessagePreparator preparator = mimeMessage -> {
            MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
            message.setTo(toAddresses.split("[,;]"));
//            message.setFrom(from);
            message.setSubject(subject);
//            if (StringUtils.isNotBlank(ccAddresses))
//                message.setCc(ccAddresses.split("[;,]"));
//            if (StringUtils.isNotBlank(bccAddresses))
//                message.setBcc(bccAddresses.split("[;,]"));

//            message.setText(body, false);
            message.setText(body, true);
        };
        mailSender.send(preparator);
    }
}
