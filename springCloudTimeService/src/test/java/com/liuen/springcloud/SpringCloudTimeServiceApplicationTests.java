package com.liuen.springcloud;

import com.liuen.springcloud.controller.TimeController;
import com.liuen.springcloud.service.TimeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringCloudTimeServiceApplicationTests {


	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(TimeController.class).build();
	}

	@Autowired
	private TestRestTemplate restTemplate;
	@Autowired
	private TimeService timeService;

	@Test
	public void exampleTest() {
		String body = this.restTemplate.getForObject("/", String.class);
		assertThat(body).isEqualTo("Hello World");
	}

	@Test
	public void timeService() {
		// RemoteService has been injected into the reverser bean
		given(this.timeService.selectTest("mock")).willReturn("mock");
		String reverse = timeService.selectTest("mock");
		assertThat(reverse).isEqualTo("mock");
	}
}
