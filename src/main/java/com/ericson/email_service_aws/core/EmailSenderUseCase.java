package com.ericson.email_service_aws.core;

public interface EmailSenderUseCase {

    void sendEmail(String to, String subject, String body);
}
