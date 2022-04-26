package br.com.goodmann.consumerrabbitmq.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Consumer;

@Service
public class ConsumerService {

	public static final Logger logger = LoggerFactory.getLogger(Consumer.class);

	@Autowired
	private ObjectMapper mapper;

	@RabbitListener(queues = "admin_queue")
	public void adminListenerQueue(String message) throws JsonProcessingException {
		logger.info("[CONSUMER] - Admin Mesage: " + mapper.writeValueAsString(message));
	}

}
