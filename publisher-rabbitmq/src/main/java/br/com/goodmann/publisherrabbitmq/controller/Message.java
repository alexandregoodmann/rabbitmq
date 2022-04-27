package br.com.goodmann.publisherrabbitmq.controller;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Message {

	private String from;

	private String to;

	private String message;

}
