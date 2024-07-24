package com.ericson.email_service_aws.infra.SesAWS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.*;
import com.ericson.email_service_aws.adapters.EmailSenderGateway;
import com.ericson.email_service_aws.core.exceptions.EmailServiceException;

@Service
public class SesEmailSender implements EmailSenderGateway {

    @Value("${aws.email}")
    private String email;

    private final AmazonSimpleEmailService amazonSimpleEmailService;

    @Autowired
    public SesEmailSender(AmazonSimpleEmailService amazonSimpleEmailService) {
        this.amazonSimpleEmailService = amazonSimpleEmailService;
    }

    @Override
    public void sendEmail(String to, String subject, String body) {
        SendEmailRequest request = new SendEmailRequest()
                .withSource(email)
                .withDestination(new Destination().withToAddresses(to))
                .withMessage(new Message()
                        .withSubject(new Content(subject))
                        .withBody(new Body().withText(new Content(body))));

        try {
            this.amazonSimpleEmailService.sendEmail(request);
        } catch (Exception e) {
            e.printStackTrace();
            throw new EmailServiceException("Failure while sending email to " + to, e);
        }
    }

}
