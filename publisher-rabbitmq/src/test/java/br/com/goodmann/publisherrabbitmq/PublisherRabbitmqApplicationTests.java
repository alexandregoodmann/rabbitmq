package br.com.goodmann.publisherrabbitmq;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.goodmann.publisherrabbitmq.publisher.WhiteList;
import br.com.goodmann.publisherrabbitmq.rabbitmq.Publisher;

@SpringBootTest
class PublisherRabbitmqApplicationTests {

	@Autowired
	private Publisher publisher;

	@Test
	void add() {
		WhiteList w = new WhiteList();
		w.setClient("cliente");
		w.setRegex("qualquer");
		this.publisher.add(w);
	}

	@Test
	void validate() {
		this.publisher.validate("Validando mensagem");
	}

}
