package br.com.goodmann.publisherrabbitmq;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.goodmann.publisherrabbitmq.controller.Message;
import br.com.goodmann.publisherrabbitmq.controller.PublisherController;
import br.com.goodmann.publisherrabbitmq.service.PublisherService;

@WebMvcTest(controllers = PublisherController.class)
public class SendMessageTest {

	@Autowired
	MockMvc mockMvc;

	@Autowired
	ObjectMapper mapper;

	@MockBean
	PublisherService publisherService;

	@Test
	public void SendDirectTest() throws Exception {
		
		Message msg = new Message();
		msg.setMessage("First Message");
		
		this.publisherService.sendToAdmin(msg);
		/*
		 * 
		 * MockHttpServletRequestBuilder mockRequest =
		 * MockMvcRequestBuilders.post("/admin")
		 * .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
		 * .content(this.mapper.writeValueAsString(msg));
		 * 
		 * mockMvc.perform(mockRequest).andExpect(MockMvcResultMatchers.status().isOk())
		 * ;
		 */	}

}
