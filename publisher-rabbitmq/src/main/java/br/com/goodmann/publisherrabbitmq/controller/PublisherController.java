package br.com.goodmann.publisherrabbitmq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import br.com.goodmann.publisherrabbitmq.service.PublisherService;

@RestController
public class PublisherController {

	@Autowired
	private PublisherService publisherService;

	@PostMapping("/admin")
	public void sendToAdmin(@RequestBody Message message) throws JsonProcessingException {
		this.publisherService.sendToAdmin(message);
	}

	@PostMapping("/direct")
	public void sendTo(@RequestBody Message message) throws JsonProcessingException {
		this.publisherService.sendTo(message);
	}

}
