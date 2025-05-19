package com.upeu.notificaciones.controllers;

import com.upeu.notificaciones.services.IEmailService;
import com.upeu.notificaciones.services.models.EmailDTO;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class EmailController {
    @Autowired
    IEmailService emailService;
    @PostMapping("/send-email")
    private ResponseEntity<String> sendEmail(@RequestBody EmailDTO email) throws MessagingException {
        emailService.sendEmail(email);
        return new ResponseEntity<>("Email enviado con exito", HttpStatus.OK);
    }
}
