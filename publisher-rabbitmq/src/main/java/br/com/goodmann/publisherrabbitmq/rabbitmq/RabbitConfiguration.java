package br.com.goodmann.publisherrabbitmq.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfiguration {

	@Value("${REQUEST_EXCHANGE}")
	private String exchange;

	@Value("${INSERTION_QUEUE}")
	private String insertQueue;

	@Value("${VALIDATION_QUEUE}")
	private String validationQueue;

	@Bean
	DirectExchange exchange() {
		return new DirectExchange(exchange);
	}

	@Bean
	Queue insertQueue() {
		return new Queue(insertQueue, true);
	}

	@Bean
	Queue validationQueue() {
		return new Queue(validationQueue, true);
	}

	@Bean
	Binding insertBinding(Queue insertQueue, DirectExchange exchange) {
		return BindingBuilder.bind(insertQueue).to(exchange).with("client.addRegex");
	}

	@Bean
	Binding validationBinding(Queue validationQueue, DirectExchange exchange) {
		return BindingBuilder.bind(validationQueue).to(exchange).with("client.validateUrl");
	}

	@Bean
	public MessageConverter jsonMessageConverter() {
		return new Jackson2JsonMessageConverter();
	}

}
