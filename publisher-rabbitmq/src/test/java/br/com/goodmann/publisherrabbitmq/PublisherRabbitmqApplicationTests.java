package br.com.goodmann.publisherrabbitmq;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonProcessingException;

import br.com.goodmann.publisherrabbitmq.publisher.Validation;
import br.com.goodmann.publisherrabbitmq.publisher.WhiteList;
import br.com.goodmann.publisherrabbitmq.rabbitmq.Publisher;

@SpringBootTest
class PublisherRabbitmqApplicationTests {

	@Autowired
	private Publisher publisher;

	@Test
	void add() throws JsonProcessingException {
		WhiteList w = new WhiteList();
		w.setClient("cliente");
		w.setRegex("qualquer");
		this.publisher.add(w);
	}

	@Test
	void validate() throws JsonProcessingException {
		Validation val = new Validation();
		val.setClient("cliente");
		val.setCorralationId(1);
		val.setUrl("google.com");
		this.publisher.validate(val);
	}

}
