package com.linkomanija.backend.mail;

import com.linkomanija.backend.domain.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.util.Properties;

@Service
public class Mail {

  @Autowired
  private MailProperties mailProperties;

  public void sendDocuments(Reservation reservation) throws MessagingException {
    String to = reservation.getUserClient().getEmail();
    String from = mailProperties.getUsername();

    Session session = createSession();
    Message message = createMessage(session, to, from);

    Transport.send(message);
  }

  private Message createMessage(Session session, String to, String from) throws MessagingException {
    Message message = new MimeMessage(session);
    message.setFrom(new InternetAddress(from));
    message.setRecipients(Message.RecipientType.TO,
      InternetAddress.parse(to));
    message.setSubject("Linkomanija. Bilietas");

    BodyPart messageBodyPart = new MimeBodyPart();
    messageBodyPart.setText("Gero žiūrėjimo!");

    BodyPart attachmentInvoice = new MimeBodyPart();
    String invoicePath = new File("src/main/resources/templates/invoice/invoice.pdf").getAbsolutePath();

    BodyPart attachmentTicket = new MimeBodyPart();
    String ticketPath = new File("src/main/resources/templates/ticket/ticket.pdf").getAbsolutePath();

    DataSource invoiceSource = new FileDataSource(invoicePath);
    DataSource ticketSource = new FileDataSource(ticketPath);

    attachmentInvoice.setDataHandler(new DataHandler(invoiceSource));
    attachmentInvoice.setFileName("invoice.pdf");

    attachmentTicket.setDataHandler(new DataHandler(ticketSource));
    attachmentTicket.setFileName("ticket.pdf");

    Multipart multipart = new MimeMultipart();
    multipart.addBodyPart(messageBodyPart);
    multipart.addBodyPart(attachmentInvoice);
    multipart.addBodyPart(attachmentTicket);

    message.setContent(multipart);
    return message;
  }

  private Session createSession() {
    Properties props = new Properties();
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.host", mailProperties.getHost());
    props.put("mail.smtp.port", mailProperties.getPort());

    return Session.getInstance(props,
      new javax.mail.Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication() {
          return new PasswordAuthentication(mailProperties.getUsername(), mailProperties.getPassword());
        }
      });
  }
}
