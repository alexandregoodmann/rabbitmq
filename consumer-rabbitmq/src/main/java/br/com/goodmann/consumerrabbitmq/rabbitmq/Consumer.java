package br.com.goodmann.consumerrabbitmq.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

	public static final Logger logger = LoggerFactory.getLogger(Consumer.class);

	@RabbitListener(queues = "${INSERTION_QUEUE}")
	public void receivedInsertionMessage(String msg) {
		logger.info("[SUBSCRIBER - Mensagem do INSERTION_QUEUE] - " + msg);
	}

	@RabbitListener(queues = "${VALIDATION_QUEUE}")
	public void receivedValidationMessage(String msg) {
		logger.info("[SUBSCRIBER - Mensagem do VALIDATION_QUEUE] - " + msg);
	}

}
