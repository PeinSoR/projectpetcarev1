package com.projectframe.mx.petcare.dominio.service.Impl;

import com.projectframe.mx.petcare.dominio.service.EmailService;
import com.sendgrid.*;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Attachments;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Base64;

@Service
public class EmailServiceImpl implements EmailService {

    @Value("${SENDGRID_API_KEY}")
    private String SENDGRID_API_KEY;

    @Value("${SENDGRID_FROM}")
    private String SENDGRID_FROM;

    @Override
    public void sendEmail(String to, String subject, String content) {
        Email from = new Email(SENDGRID_FROM, "Petcare");
        Email toEmail = new Email(to);

        Content htmlContent = new Content("text/html", content);
        Mail mail = new Mail(from, subject, toEmail, htmlContent);

        SendGrid sg = new SendGrid(SENDGRID_API_KEY);
        Request request = new Request();

        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            sg.api(request);
            Response response = sg.api(request);
            System.out.println("STATUS = " + response.getStatusCode());
            System.out.println("BODY = " + response.getBody());
            System.out.println("HEADERS = " + response.getHeaders());

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void sendEmailWithAttachment(String to, String subject, String content, byte[] attachment, String filename) {

        Email from = new Email(SENDGRID_FROM, "Petcare");
        Email toEmail = new Email(to);

        Content htmlContent = new Content("text/html", content);
        Mail mail = new Mail(from, subject, toEmail, htmlContent);

        if (attachment != null && filename != null) {
            Attachments attachments = new Attachments();
            attachments.setFilename(filename);
            attachments.setType("application/octet-stream");
            attachments.setDisposition("attachment");

            String base64Attachment = Base64.getEncoder().encodeToString(attachment);
            attachments.setContent(base64Attachment);

            mail.addAttachments(attachments);
        }

        SendGrid sg = new SendGrid(SENDGRID_API_KEY);
        Request request = new Request();

        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            sg.api(request);
            Response response = sg.api(request);
            System.out.println("STATUS = " + response.getStatusCode());
            System.out.println("BODY = " + response.getBody());
            System.out.println("HEADERS = " + response.getHeaders());

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
