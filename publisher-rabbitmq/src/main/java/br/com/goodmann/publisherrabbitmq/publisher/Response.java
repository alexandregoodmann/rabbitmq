package br.com.goodmann.publisherrabbitmq.publisher;

public class Response {

	private Boolean match;

	private String regex;

	private Integer corralationId;

	public Boolean getMatch() {
		return match;
	}

	public void setMatch(Boolean match) {
		this.match = match;
	}

	public String getRegex() {
		return regex;
	}

	public void setRegex(String regex) {
		this.regex = regex;
	}

	public Integer getCorralationId() {
		return corralationId;
	}

	public void setCorralationId(Integer corralationId) {
		this.corralationId = corralationId;
	}

}
