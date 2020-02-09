package br.com.goodmann.consumerrabbitmq.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.goodmann.consumerrabbitmq.model.Response;
import br.com.goodmann.consumerrabbitmq.model.Validation;
import br.com.goodmann.consumerrabbitmq.model.WhiteList;
import br.com.goodmann.consumerrabbitmq.repository.WhiteListRepository;

@Service
public class ValidationService {

	public static final Logger logger = LoggerFactory.getLogger(ValidationService.class);

	private ObjectMapper mapper = new ObjectMapper();

	@Autowired
	private WhiteListRepository repo;

	public Response validateUrl(Validation model) throws JsonProcessingException {

		logger.info("[CONSUMER] Validar Url: " + model.getUrl());

		List<WhiteList> list = null;

		// Define se usa global ou por cliente
		if (StringUtils.isEmpty(model.getClient())) {
			list = this.repo.findAllByClientIsNull();
		} else {
			list = this.repo.findAllByClient(model.getClient());
		}

		// Valida a url com base no regex. Considera que não encontrou. Caso seja válido
		// muda os valores.
		Response response = new Response(false, model.getCorralationId());
		for (WhiteList w : list) {
			if (model.getUrl().matches(w.getRegex())) {
				response.setMatch(true);
				response.setRegex(w.getRegex());
				break;
			}
		}

		logger.info("[CONSUMER] Resultado Validação do Cliente: " + model.getClient() + " -> "
				+ mapper.writeValueAsString(response));

		return response;
	}

}
