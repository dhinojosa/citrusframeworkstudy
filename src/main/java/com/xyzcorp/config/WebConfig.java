package com.xyzcorp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Properties;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.xyzcorp")
public class WebConfig {

    /**
     * Either create a properties file
     */
    @Bean
    public JavaMailSender getJavaMailSender() {
        String smtpServer = System.getProperty("smtp.server");
        String smtpPort = System.getProperty("smtp.port");
        String smtpUserName = System.getProperty("smtp.username");
        String smtpPassword = System.getProperty("smtp.password");

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(smtpServer);
        mailSender.setPort(Integer.parseInt(smtpPort));
        mailSender.setUsername(smtpUserName);
        mailSender.setPassword(smtpPassword);

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }
}

