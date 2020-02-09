package br.com.goodmann.consumerrabbitmq.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.goodmann.consumerrabbitmq.model.Response;
import br.com.goodmann.consumerrabbitmq.model.Validation;
import br.com.goodmann.consumerrabbitmq.model.WhiteList;
import br.com.goodmann.consumerrabbitmq.repository.WhiteListRepository;
import br.com.goodmann.consumerrabbitmq.service.ValidationService;

@Component
public class Consumer {

	public static final Logger logger = LoggerFactory.getLogger(Consumer.class);

	@Value("${RESPONSE_ROUTING_KEY}")
	private String responseKey;

	@Autowired
	private ObjectMapper mapper;

	@Autowired
	private WhiteListRepository repo;

	@Autowired
	private ValidationService service;

	@Autowired
	private AmqpTemplate amqpTemplate;

	@RabbitListener(queues = "${INSERTION_QUEUE}")
	public void receivedInsertionMessage(WhiteList obj) throws JsonProcessingException {
		logger.info("[CONSUMER] - ADD: " + mapper.writeValueAsString(obj));
		this.repo.save(obj);
	}

	@RabbitListener(queues = "${VALIDATION_QUEUE}")
	public void receivedValidationMessage(Validation obj) throws JsonProcessingException {

		logger.info("[CONSUMER] Validar Url: " + obj.getUrl());
		Response response = this.service.validateUrl(obj);

		logger.info("[CONSUMER] Enviar Response");
		this.amqpTemplate.convertAndSend(responseKey, response);
	}

}
