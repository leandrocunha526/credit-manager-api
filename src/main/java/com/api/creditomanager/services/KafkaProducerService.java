package com.api.creditomanager.services;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class KafkaProducerService {

    private static final Logger logger = LoggerFactory.getLogger(KafkaProducerService.class);
    private static final String TOPIC = "consulta-log";

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendLog(String message) {
        CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send(TOPIC, message);

        future.whenComplete((result, ex) -> {
            if (ex != null) {
                logger.error("❌ Erro ao enviar mensagem: {}", ex.getMessage(), ex);
            } else {
                RecordMetadata metadata = result.getRecordMetadata();
                logger.info("✅ Mensagem enviada com sucesso - Tópico: {}, Partição: {}, Offset: {}",
                        metadata.topic(), metadata.partition(), metadata.offset());
            }
        });
    }
}
