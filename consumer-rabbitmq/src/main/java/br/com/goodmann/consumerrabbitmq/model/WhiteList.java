package br.com.goodmann.consumerrabbitmq.model;

import java.math.BigInteger;

public class WhiteList {

	// @Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	private BigInteger id;

	private String client;

	private String regex;

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getRegex() {
		return regex;
	}

	public void setRegex(String regex) {
		this.regex = regex;
	}

}
