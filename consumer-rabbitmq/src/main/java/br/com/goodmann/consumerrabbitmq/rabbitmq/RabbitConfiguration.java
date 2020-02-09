package br.com.goodmann.consumerrabbitmq.rabbitmq;

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

	@Value("${RESPONSE_EXCHANGE}")
	private String exchange;

	@Value("${RESPONSE_QUEUE}")
	private String responseQueue;

	@Value("${RESPONSE_ROUTING_KEY}")
	private String routingKey;

	@Bean
	DirectExchange exchange() {
		return new DirectExchange(exchange);
	}

	@Bean
	Queue responseQueue() {
		return new Queue(this.responseQueue, true);
	}

	@Bean
	Binding responseBinding(Queue responseQueue, DirectExchange exchange) {
		return BindingBuilder.bind(responseQueue).to(exchange).with(routingKey);
	}

	@Bean
	public MessageConverter jsonMessageConverter() {
		return new Jackson2JsonMessageConverter();
	}

}
