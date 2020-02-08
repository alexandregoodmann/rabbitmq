package br.com.goodmann.consumerrabbitmq.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.goodmann.consumerrabbitmq.whitelist.WhiteList;
import br.com.goodmann.consumerrabbitmq.whitelist.WhiteListRepository;

@Component
public class Consumer {

	@Autowired
	private WhiteListRepository repo;

	public static final Logger logger = LoggerFactory.getLogger(Consumer.class);

	private ObjectMapper mapper = new ObjectMapper();

	@RabbitListener(queues = "${INSERTION_QUEUE}")
	public void receivedInsertionMessage(WhiteList obj) throws JsonProcessingException {
		logger.info("[CONSUMER] - ADD: " + mapper.writeValueAsString(obj));
		this.repo.save(obj);
		logger.info("[CONSUMER] - SALVO OBJETO");
	}

	@RabbitListener(queues = "${VALIDATION_QUEUE}")
	public void receivedValidationMessage(String msg) {
		logger.info("[SUBSCRIBER - Mensagem do VALIDATION_QUEUE] - " + msg);
	}

}
