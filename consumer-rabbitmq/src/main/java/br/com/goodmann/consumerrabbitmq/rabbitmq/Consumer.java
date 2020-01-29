package br.com.goodmann.consumerrabbitmq.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import br.com.goodmann.consumerrabbitmq.whitelist.WhiteList;

@Component
public class Consumer {

	public static final Logger logger = LoggerFactory.getLogger(Consumer.class);

	@RabbitListener(queues = "${INSERTION_QUEUE}")
	public void receivedInsertionMessage(WhiteList obj) {
		logger.info("[SUBSCRIBER - Mensagem do INSERTION_QUEUE] - " + obj);
	}

	@RabbitListener(queues = "${VALIDATION_QUEUE}")
	public void receivedValidationMessage(String msg) {
		logger.info("[SUBSCRIBER - Mensagem do VALIDATION_QUEUE] - " + msg);
	}

}
