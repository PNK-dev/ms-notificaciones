package com.upeu.notificaciones.listeners;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.upeu.notificaciones.services.IEmailService;
import com.upeu.notificaciones.services.models.EmailDTO;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaNotificationListener {

    private final IEmailService emailService;
    private final ObjectMapper objectMapper;

    public KafkaNotificationListener(IEmailService emailService) {
        this.emailService = emailService;
        this.objectMapper = new ObjectMapper();
    }

    @KafkaListener(topics = "user.created", groupId = "notificaciones-group")
    public void onUserCreated(String message) {
        try {
            EmailDTO dto = objectMapper.readValue(message, EmailDTO.class);
            emailService.sendEmail(dto); // Reutiliza tu lógica actual
        } catch (Exception e) {
            System.err.println("Error al procesar mensaje Kafka: " + e.getMessage());
        }
    }
}
