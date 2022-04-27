package br.com.goodmann.publisherrabbitmq;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfiguration {

	public static final String GOODMANN_EXCHANGE = "goodmann_exchange";
	
	@Autowired
	private ConnectionFactory connectionFactory;

	@Bean
	DirectExchange goodmannExchange() {
		return new DirectExchange(GOODMANN_EXCHANGE);
	}
	
	@Bean
	public AmqpAdmin amqpAdmin() {
	    return new RabbitAdmin(connectionFactory);
	}

	@Bean
	Queue adminQueue() {
		return new Queue("admin_queue", true);
	}

	@Bean
	Binding directBinding(Queue adminQueue, DirectExchange goodmannExchange) {
		return BindingBuilder.bind(adminQueue).to(goodmannExchange).with("admin_RoutingKey");
	}

	@Bean
	public MessageConverter jsonMessageConverter() {
		return new Jackson2JsonMessageConverter();
	}

}
