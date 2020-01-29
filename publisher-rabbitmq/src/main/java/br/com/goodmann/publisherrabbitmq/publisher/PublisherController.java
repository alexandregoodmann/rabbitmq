package br.com.goodmann.publisherrabbitmq.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import br.com.goodmann.publisherrabbitmq.rabbitmq.Publisher;

@RestController
public class PublisherController {

	@Autowired
	private Publisher publisher;

	@PostMapping
	public void add(@RequestBody WhiteList obj) throws JsonProcessingException {
		this.publisher.add(obj);
	}
}
