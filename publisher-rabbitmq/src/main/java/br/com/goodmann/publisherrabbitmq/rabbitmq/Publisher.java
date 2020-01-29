package br.com.goodmann.publisherrabbitmq.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import br.com.goodmann.publisherrabbitmq.publisher.WhiteList;

@Component
public class Publisher {

	public static final Logger logger = LoggerFactory.getLogger(Publisher.class);

	@Autowired
	private AmqpTemplate amqpTemplate;

	@Value("${INSERTION_QUEUE}")
	private String insertionQueue;

	@Value("${VALIDATION_QUEUE}")
	private String validationQueue;

	public void add(WhiteList obj) {
		amqpTemplate.convertAndSend(this.insertionQueue, obj);
		logger.info("[Mensagem ADD para RebbitMQ] - " + obj);
	}

	public void validate(String msg) {
		amqpTemplate.convertAndSend(this.validationQueue, msg);
		logger.info("[Mensagem VALIDATION para RebbitMQ] - " + msg);
	}

}
