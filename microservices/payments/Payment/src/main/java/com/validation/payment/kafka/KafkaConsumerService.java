package com.validation.payment.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "reservations", groupId = "hotel-service-group")
    public void consumeMessage(Object payload) {
        System.out.println("Received JSON message: " + payload);
    }
}
