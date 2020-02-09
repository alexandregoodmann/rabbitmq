package br.com.goodmann.publisherrabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class PublisherRabbitmqApplication {

	@Bean
	ObjectMapper mapper() {
		return new ObjectMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(PublisherRabbitmqApplication.class, args);
	}

}
