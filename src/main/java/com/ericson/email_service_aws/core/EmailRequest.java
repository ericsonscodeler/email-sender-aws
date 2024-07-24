package com.ericson.email_service_aws.core;

public record EmailRequest(String to, String subject, String body) {

}
