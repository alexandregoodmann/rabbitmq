package br.com.goodmann.publisherrabbitmq.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.goodmann.publisherrabbitmq.publisher.Validation;
import br.com.goodmann.publisherrabbitmq.publisher.WhiteList;

@Component
public class Publisher {

	public static final Logger logger = LoggerFactory.getLogger(Publisher.class);

	@Autowired
	private ObjectMapper mapper;

	@Autowired
	private AmqpTemplate amqpTemplate;

	@Value("${INSERTION_QUEUE}")
	private String insertionQueue;

	@Value("${VALIDATION_QUEUE}")
	private String validationQueue;

	public void add(WhiteList obj) throws JsonProcessingException {
		amqpTemplate.convertAndSend(this.insertionQueue, obj);
		logger.info("[PUBLISHER] - ADD: " + mapper.writeValueAsString(obj));
	}

	public void validate(Validation obj) throws JsonProcessingException {
		amqpTemplate.convertAndSend(this.validationQueue, obj);
		logger.info("[PUBLISHER] - VALIDATE: " + mapper.writeValueAsString(obj));
	}

}
