package com.example.Helph4iso;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@CrossOrigin(origins = "*")
public class ContactController {

    @Value("${email.username}")
    private String emailUsername;

    @Value("${email.password}")
    private String emailPassword;

    @Value("${email.host}")
    private String emailHost;

    @Value("${email.port}")
    private String emailPort;

    private static final Logger logger = LoggerFactory.getLogger(ContactController.class);

    @PostMapping("/contact")
    public String sendContactEmail(@RequestBody ContactForm contactForm) {
        logger.info("Received contact form submission: {}", contactForm);
        String to = emailUsername;
        String from = "noreply@helph4iso.com";
        String host = emailHost;

        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.smtp.port", emailPort);
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.smtp.connectiontimeout", "5000");
        properties.setProperty("mail.smtp.timeout", "5000");
        properties.setProperty("mail.smtp.writetimeout", "5000");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(emailUsername, emailPassword);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("New Contact Form Submission");
            message.setText("Name: " + contactForm.getName() + "\nEmail: " + contactForm.getEmail() + "\nPhone: " + contactForm.getPhone() + "\nMessage: " + contactForm.getMessage());

            Transport.send(message);
            return "Email sent successfully";
        } catch (AuthenticationFailedException e) {
            logger.error("Email authentication failed", e);
            return "Error: Email authentication failed. Please check your email credentials.";
        } catch (SendFailedException e) {
            logger.error("Email send failed", e);
            return "Error: Email could not be sent. Please check the recipient email address.";
        } catch (MessagingException e) {
            logger.error("Email messaging error", e);
            return "Error: Could not connect to email server. Please try again later.";
        } catch (Exception e) {
            logger.error("Unexpected error", e);
            return "Error: An unexpected error occurred while sending the email. Please contact support.";
        }
    }
}

class ContactForm {
    private String name;
    private String email;
    private String phone;
    private String message;

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
