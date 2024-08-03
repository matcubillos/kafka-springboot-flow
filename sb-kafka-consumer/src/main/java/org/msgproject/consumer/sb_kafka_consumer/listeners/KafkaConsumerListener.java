package org.msgproject.consumer.sb_kafka_consumer.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;

@Configuration
public class KafkaConsumerListener {
    private final Logger logger = LoggerFactory.getLogger(KafkaConsumerListener.class);

    @KafkaListener(topics = {"recetas-topic"}, groupId = "my-group.id")
    public void listener(String message, Acknowledgment acknowledgment) {
        try {
            logger.info("Log recibido con el mensaje: {}", message);
            // Procesa el mensaje aquí
            acknowledgment.acknowledge();
        } catch (Exception e) {
            logger.error("Error al procesar el mensaje: {}", e.getMessage());
            // No hacemos acknowledge para que el mensaje sea reintentado
        }
    }
}
