/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Kelompok2.ProjectKPI.controller;

import Kelompok2.ProjectKPI.model.dto.request.EmailRequest;
import Kelompok2.ProjectKPI.service.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ASUS
 */
@AllArgsConstructor
@RestController
@RequestMapping("/email")
public class EmailController {
    
    private EmailService emailService;
    
    @PostMapping
    public EmailRequest simpleMail(@RequestBody EmailRequest emailRequest) {
        return emailService.sendSimpleEmail(emailRequest);
    }
    
    @PostMapping("/attach")
    public EmailRequest simpleEmailWithAttachment(@RequestBody EmailRequest emailRequest) {
        return emailService.sendEmailWithAttachment(emailRequest);
    }
}
