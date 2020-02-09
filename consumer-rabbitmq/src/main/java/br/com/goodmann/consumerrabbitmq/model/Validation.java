package br.com.goodmann.consumerrabbitmq.model;

import javax.validation.constraints.NotNull;

public class Validation {

	private String client;

	@NotNull
	private String url;

	@NotNull
	private Integer corralationId;

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getCorralationId() {
		return corralationId;
	}

	public void setCorralationId(Integer corralationId) {
		this.corralationId = corralationId;
	}

}
