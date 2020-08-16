package com.oop.controllers;

import com.oop.entities.SensorLocation;
import com.oop.services.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author orestis
 */
@RestController
public class MailController {

    @Autowired
    private MailService emailService;

    @RequestMapping(value = "/sendmail", method = RequestMethod.GET)
    public String sendMail() {
//        String from = "orestis.raspberry@gmail.com";
        String subject = "Dickpics from your awesome springboot app";
        String toAddresses = "orestispanago@gmail.com";
        String body = "<html> <body><h1>Rendered HTML, plain text is for boootsam </h1> </body></html>";
        emailService.sendMail(subject, toAddresses, body);
        return "mail sent";
    }

}
// TODO check here for html paths:
// https://stackoverflow.com/questions/37163553/sending-html-with-message-in-email-using-file-path