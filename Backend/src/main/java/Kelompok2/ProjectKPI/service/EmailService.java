/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Kelompok2.ProjectKPI.service;

import Kelompok2.ProjectKPI.model.dto.request.EmailRequest;
import java.io.File;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
@AllArgsConstructor
public class EmailService {

    private JavaMailSender mailSender;

    public EmailRequest sendSimpleEmail(EmailRequest emailRequest) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(emailRequest.getTo());
        message.setSubject(emailRequest.getSubject());
        message.setText(emailRequest.getBody());

        mailSender.send(message);
        System.out.println("Mail Send . . .");
        return emailRequest;
    }

    public EmailRequest sendEmailWithAttachment(EmailRequest emailRequest) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

            helper.setTo(emailRequest.getTo());
            helper.setSubject(emailRequest.getSubject());
            helper.setText(emailRequest.getBody());

            FileSystemResource fileSystemResource = new FileSystemResource(new File(emailRequest.getAttach()));
            helper.addAttachment(fileSystemResource.getFilename(), fileSystemResource);

            mailSender.send(mimeMessage);
            System.out.println("Send Mail With Attachment broo.....");
        } catch (MessagingException e) {
            System.out.println(e);// SL4j atau LONGGER
            throw new IllegalStateException("Failed to send Email!!");
        }
        return emailRequest;

    }
}
