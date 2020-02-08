package br.com.goodmann.publisherrabbitmq.publisher;

public class Validation {

	private String client;

	private String url;

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
