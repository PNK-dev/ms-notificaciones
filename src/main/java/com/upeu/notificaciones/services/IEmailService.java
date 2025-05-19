package com.upeu.notificaciones.services;

import com.upeu.notificaciones.services.models.EmailDTO;
import jakarta.mail.MessagingException;

public interface IEmailService {
    public void sendEmail(EmailDTO email) throws MessagingException;
}
