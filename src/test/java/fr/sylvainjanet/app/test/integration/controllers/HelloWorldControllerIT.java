package fr.sylvainjanet.app.test.integration.controllers;

import static com.epages.restdocs.apispec.MockMvcRestDocumentationWrapper.document;
import static com.epages.restdocs.apispec.MockMvcRestDocumentationWrapper.resourceDetails;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;

import com.epages.restdocs.apispec.Schema;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.sylvainjanet.app.dtos.StringDto;
import fr.sylvainjanet.app.test.integration.ControllerAndRestDocIT;

/**
 * Integration tests of the HelloWorld controller.
 * 
 * @author Sylvain
 *
 */
//CHECKSTYLE.OFF: AbbreviationAsWordInNameCheck 
//IT should be part of the class name
public class HelloWorldControllerIT extends ControllerAndRestDocIT {
  // CHECKSTYLE.ON: AbbreviationAsWordInNameCheck

  /**
   * Current environment.
   */
  @Value("${app.environment}")
  private String environment;

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
    this.getMockMvc()
        .perform(RestDocumentationRequestBuilders.get("/hello")
            .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(content().json(mapper.writeValueAsString(
            new StringDto("Hello World ! - " + environment))))
        .andDo(document("Hello world !", resourceDetails()
            .summary("Get Hello world message")
            .description("Request to test the API, the doc generation and "
                + "everything while setting up anything really.")
            .tag("Hello world").responseSchema(new Schema("StringDTO")),
            responseFields(
                fieldWithPath("message").description("the message"))));
  }

  /**
   * PUT /hello should ERROR 405.
   *
   * @throws Exception if something goes wrong during the testing.
   */
  @Test
  @DisplayName("PUT /hello should 405")
  void testPutHello() throws Exception {
    this.getMockMvc()
        .perform(RestDocumentationRequestBuilders.put("/hello")
            .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().is(HttpStatus.METHOD_NOT_ALLOWED.value()))
        .andExpect(content().json(mapper.writeValueAsString(
            new StringDto("Method PUT not allowed - " + environment))))
        .andDo(document("PUT Hello world error",
            resourceDetails().summary("PUT Hello world error").description(
                "This request should return a METHOD NOT ALLOWED error")
                .tag("Hello world")
                .responseSchema(new Schema("StringDTO"))));
  }
}
