package com.liuen.springcloud;

import com.liuen.springcloud.controller.TimeController;
import com.liuen.springcloud.service.TimeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringCloudTimeServiceApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;
	@Autowired
	private TimeService timeService;

	private MockMvc mockMvc;	//use to mock controller request

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(TimeController.class).build();
	}

	//controller test
	@Test
	public void exampleTest() {
		//test1
		String body = this.restTemplate.getForObject("/hello", String.class);
		assertThat(body).isEqualTo("Hello World");
		System.out.println("test2");
		//test2
		try {
			mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/hello").accept(MediaType.TEXT_PLAIN))
					.andExpect(status().isOk())
					.andExpect(content().string(equalTo("Hello World")));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void timeService() {
		// RemoteService has been injected into the reverser bean
		given(this.timeService.selectTest("mock")).willReturn("mock");
		String reverse = timeService.selectTest("mock");
		assertThat(reverse).isEqualTo("mock");
	}
}
