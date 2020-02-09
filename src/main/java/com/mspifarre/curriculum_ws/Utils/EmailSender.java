package com.mspifarre.curriculum_ws.Utils;

import com.google.common.collect.Lists;
import it.ozimov.springboot.mail.model.Email;
import it.ozimov.springboot.mail.model.defaultimpl.DefaultEmail;
import it.ozimov.springboot.mail.service.EmailService;

import javax.mail.internet.InternetAddress;

public class EmailSender {

    public static void sendEmail(EmailService emailService,
                                 InternetAddress sender,
                                 InternetAddress receiver,
                                 String subject,
                                 String body) {
        new Thread(() -> {
            boolean send = false;
            int end = 0;
            while(end<10 && !send) {
                try {
                    final Email email;
                    email = DefaultEmail.builder()
                            .from(sender)
                            .to(Lists.newArrayList(receiver))
                            .subject(subject)
                            .body(body)
                            .encoding("UTF-8")
                            .build();
                    emailService.send(email);
                    send = true;
                }
                catch (Exception e) {
                    System.out.println("Error sending the mail to " + receiver.getAddress() + ". Retrying...");
                    end++;
                    try {
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException ignored) {}
                }
            }
        }).start();
    }


}
