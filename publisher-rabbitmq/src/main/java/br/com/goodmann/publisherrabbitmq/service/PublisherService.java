package br.com.goodmann.publisherrabbitmq.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.goodmann.publisherrabbitmq.controller.Message;

@Service
public class PublisherService {

	public static final Logger logger = LoggerFactory.getLogger(PublisherService.class);

	@Autowired
	private ObjectMapper mapper;

	@Autowired
	private AmqpTemplate amqpTemplate;

	public void sendToAdmin(Message message) throws JsonProcessingException {
		amqpTemplate.convertAndSend("admin_RoutingKey", message);
		logger.info("[PUBLISHER] - ADD: " + mapper.writeValueAsString(message));
	}

}
