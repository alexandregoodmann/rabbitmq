package br.com.goodmann.publisherrabbitmq;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.goodmann.publisherrabbitmq.rabbitmq.Publisher;

@SpringBootTest
class PublisherRabbitmqApplicationTests {

	@Autowired
	private Publisher publisher;

	@Test
	void add() {
		this.publisher.add("Adicionando Regex do cliente");
	}

	@Test
	void validate() {
		this.publisher.validate("Validando mensagem");
	}

}
