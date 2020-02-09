package br.com.goodmann.consumerrabbitmq.model;

public class Response {

	public Response(Boolean match, Integer corralationId) {
		this.match = match;
		this.corralationId = corralationId;
	}

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
