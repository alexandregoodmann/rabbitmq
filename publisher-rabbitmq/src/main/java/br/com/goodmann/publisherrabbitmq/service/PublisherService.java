package br.com.goodmann.publisherrabbitmq.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Binding.DestinationType;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.goodmann.publisherrabbitmq.controller.Message;

@Component
public class PublisherService {

	public static final Logger logger = LoggerFactory.getLogger(PublisherService.class);

	@Autowired
	private ObjectMapper mapper;

	@Autowired
	private AmqpTemplate amqpTemplate;

	@Autowired
	private AmqpAdmin amqpAdmin;

	@Autowired
	private DirectExchange goodmannExchange;

	public void sendToAdmin(Message message) throws JsonProcessingException {
		amqpTemplate.convertAndSend(this.goodmannExchange.getName(), "admin_RoutingKey", message);
		logger.info("[PUBLISHER] - ADD: " + mapper.writeValueAsString(message));
	}

	public void sendTo(Message message) throws JsonProcessingException {

		Queue queue = new Queue(message.getTo(), true);
		Binding binding = new Binding(message.getTo(), DestinationType.QUEUE, this.goodmannExchange.getName(), message.getTo(), null);
		this.amqpAdmin.declareQueue(queue);
		this.amqpAdmin.declareBinding(binding);
		
		amqpTemplate.convertAndSend(this.goodmannExchange.getName(), message.getTo(), message);
		
		logger.info("[PUBLISHER] - Send To: " + mapper.writeValueAsString(message));
	}

}
