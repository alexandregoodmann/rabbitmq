package br.com.goodmann.publisherrabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfiguration {

	@Bean
	DirectExchange exchange() {
		return new DirectExchange("goodmann_exchange");
	}

	@Bean
	Queue adminQueue() {
		return new Queue("admin_queue", true, false, false);
	}

	@Bean
	Binding directBinding(Queue adminQueue, DirectExchange exchange) {
		return BindingBuilder.bind(adminQueue).to(exchange).with("admin_RoutingKey");
	}

	@Bean
	public MessageConverter jsonMessageConverter() {
		return new Jackson2JsonMessageConverter();
	}

}
