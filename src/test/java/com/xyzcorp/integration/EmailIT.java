package com.xyzcorp.integration;

import com.consol.citrus.annotations.CitrusTest;
import com.consol.citrus.dsl.junit.JUnit4CitrusTestDesigner;
import com.consol.citrus.mail.message.MailMessage;
import com.consol.citrus.mail.server.MailServer;
import com.consol.citrus.model.testcase.core.SendModel;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Test a connection of your service with an email
 *
 * @author Daniel Hinojosa
 * @since 2019-03-13
 */
public class EmailIT extends JUnit4CitrusTestDesigner {

    @Autowired
    private MailServer mailServer;

    @CitrusTest
    @Test
    public void sendAnEmailTest() throws MessagingException,
            InterruptedException {

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "localhost");
        prop.put("mail.smtp.port", "2222");

        Session session = Session.getInstance(prop);

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("dhinojosa@evolutionnext.com"));
        message.setRecipients(
                Message.RecipientType.TO, InternetAddress.parse("bob@aol.com"));
        message.setSubject("Hello");
        message.setText("Hope all is well");

        Transport.send(message);

        Thread.sleep(3000);

        //Authenticate that the message was sent
        receive(mailServer)
                .message(MailMessage.request()
                                    .from("dhinojosa@evolutionnext.com")
                                    .to("bob@aol.com")
                                    .cc("")
                                    .bcc("")
                                    .subject("Hello")
                                    .body("Hope all is well",
                                            "text/plain; charset=us-ascii"));


        send(mailServer)
                .message(MailMessage.response(250, "OK"));
    }
}
