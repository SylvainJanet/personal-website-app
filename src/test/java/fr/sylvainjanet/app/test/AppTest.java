package fr.sylvainjanet.app.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Tests the App controller.
 * 
 * @author Sylvain
 *
 */
@SpringBootTest
@AutoConfigureMockMvc
class AppTest {

  /**
   * Current environment.
   */
  @Value("${app.environment}")
  private String environment;

  /**
   * Autowired mockMvc used to mock http requests.
   */
  @Autowired
  private MockMvc mockMvc;

  /**
   * GET /hello should return Hello world and the environment name.
   *
   * @throws Exception if something goes wrong during the testing.
   */
  @Test
  void testHello() throws Exception {
    this.mockMvc.perform(get("/hello")).andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(equalTo("Hello World ! - " + environment)));
  }

}
