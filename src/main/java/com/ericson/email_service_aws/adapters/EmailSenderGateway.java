package com.ericson.email_service_aws.adapters;

public interface EmailSenderGateway {

    void sendEmail(String to, String subject, String body);
}
