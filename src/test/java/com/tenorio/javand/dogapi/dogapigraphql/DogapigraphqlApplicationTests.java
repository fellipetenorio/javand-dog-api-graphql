package com.tenorio.javand.dogapi.dogapigraphql;

import com.tenorio.javand.dogapi.dogapigraphql.service.DogService;
import com.tenorio.javand.dogapi.dogapigraphql.webservice.DogController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(DogController.class)
public class DogapigraphqlApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	DogService dogService;

	@Test
	public void getAllDogsWithoutAuth() throws Exception {
		mockMvc.perform(get("/dogs2"))
				.andExpect(status().isUnauthorized());
//				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
//				.andExpect(content().json("[]"));

		verify(dogService, times(0)).findAllDogs();
	}

}
