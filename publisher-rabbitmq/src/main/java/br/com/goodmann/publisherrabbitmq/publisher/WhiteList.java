package br.com.goodmann.publisherrabbitmq.publisher;

public class WhiteList {

	private String client;

	private String regex;

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
