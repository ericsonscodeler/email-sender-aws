# Email Sending Service with AWS SES

This project is a Java service for sending emails using Amazon Simple Email Service (AWS SES). It provides a simple and effective way to integrate email sending into your Java applications.

## Requirements

- Java 17 or higher
- Maven (for dependency management)
- AWS account with permissions to access SES

## Setup

1. **AWS Configuration**

   Ensure you have AWS credentials configured in your environment. You can configure this using the AWS CLI or by creating a credentials file (`~/.aws/credentials`).

2. **Dependencies**

   Add the AWS SDK dependency to your `pom.xml`:

   ```xml
   <dependency>
      <groupId>com.amazonaws</groupId>
      <artifactId>aws-java-sdk-ses</artifactId>
      <version>1.12.763</version> <!-- Check in Maven repositories the last version -->
   </dependency>