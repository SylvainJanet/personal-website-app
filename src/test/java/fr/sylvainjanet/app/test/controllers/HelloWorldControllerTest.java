package fr.sylvainjanet.app.test.controllers;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.sylvainjanet.app.App;
import fr.sylvainjanet.app.WebSecurityConfig;
import fr.sylvainjanet.app.controllers.HelloWorldController;
import fr.sylvainjanet.app.dtos.StringDto;

/**
 * Test the HelloWorld controller.
 * 
 * @author Sylvain
 *
 */
@WebMvcTest(controllers = HelloWorldController.class)
@ContextConfiguration(classes = { App.class, WebSecurityConfig.class })
public class HelloWorldControllerTest {

  /**
   * Current environment.
   */
  @Value("${app.environment}")
  private String environment;

  /**
   * Current version.
   */
  @Value("${app.version}")
  private String version;

  /**
   * Autowired mockMvc used to mock http requests.
   */
  @Autowired
  private MockMvc mockMvc;

  /**
   * Object mapper.
   */
  @Autowired
  private ObjectMapper mapper;

  /**
   * GET /hello should return Hello world and the environment name.
   *
   * @throws Exception if something goes wrong during the testing.
   */
  @Test
  @DisplayName("GET /hello should return Hello World and the environment")
  void testHello() throws Exception {
    this.mockMvc
        .perform(RestDocumentationRequestBuilders.get("/hello")
            .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(content().json(mapper.writeValueAsString(new StringDto(
            "Hello World ! - " + environment + " - v" + version))));
  }

  /**
   * PUT /hello should ERROR 405.
   *
   * @throws Exception if something goes wrong during the testing.
   */
  @Test
  @DisplayName("PUT /hello should 405")
  void testPutHello() throws Exception {
    this.mockMvc
        .perform(RestDocumentationRequestBuilders.put("/hello")
            .with(csrf()).accept(MediaType.APPLICATION_JSON))
        .andExpect(status().is(HttpStatus.METHOD_NOT_ALLOWED.value()));
  }
}
