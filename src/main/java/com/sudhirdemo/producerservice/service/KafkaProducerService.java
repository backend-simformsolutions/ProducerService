package com.sudhirdemo.producerservice.service;

import java.util.UUID;

import com.sudhirdemo.producerservice.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class KafkaProducerService {

	private static final String TOPIC = "user";

	@Autowired
	private KafkaTemplate<String, Order> kafkaTemplate;

	public void send(Order order) {
		log.info("Order object is {}", order);
		kafkaTemplate.send(TOPIC, UUID.randomUUID().toString(), order);
	}

}
