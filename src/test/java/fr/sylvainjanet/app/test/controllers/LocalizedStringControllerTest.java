package fr.sylvainjanet.app.test.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.sylvainjanet.app.App;
import fr.sylvainjanet.app.WebSecurityConfig;
import fr.sylvainjanet.app.config.ConfigurationParams;
import fr.sylvainjanet.app.controllers.LocalizedStringController;
import fr.sylvainjanet.app.dtos.StringDto;
import fr.sylvainjanet.app.entities.TextLanguage;
import fr.sylvainjanet.app.services.LocalizedStringServiceImpl;

/**
 * Test the LocalizedString controller.
 * 
 * @author Sylvain
 *
 */
@WebMvcTest(controllers = LocalizedStringController.class)
@ContextConfiguration(classes = { App.class, WebSecurityConfig.class })
public class LocalizedStringControllerTest {

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
   * Mocked service.
   */
  @MockBean
  private LocalizedStringServiceImpl service;

  /**
   * GET /hello should return Hello world and the environment name.
   *
   * @throws Exception if something goes wrong during the testing.
   */
  @Test
  @DisplayName("getText should return the text when it is found")
  void getText() throws Exception {

    String inputSelecteur = "test-selecteur";
    TextLanguage inputTextLanguage = TextLanguage.ENGLISH;
    String expectedResult = "this is a test";

    // mock setup

    when(service.getText(inputSelecteur, inputTextLanguage))
        .thenReturn(expectedResult);

    // query setup

    LinkedMultiValueMap<String, String> requestParams =
        new LinkedMultiValueMap<>();
    requestParams.add("selector", inputSelecteur);
    requestParams.add("language", inputTextLanguage.toString());

    this.mockMvc.perform(get("/text").params(requestParams))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(content().json(
            mapper.writeValueAsString(new StringDto(expectedResult))));

  }

  @Test
  @DisplayName("getText should return an error message when it is not found")
  void getTextNotFound() throws Exception {

    String inputSelecteur = "test-selecteur";
    TextLanguage inputTextLanguage = TextLanguage.ENGLISH;
    String expectedResult =
        ConfigurationParams.DEFAULT_TEXT_NO_SELECTOR_FOUND;

    // mock setup

    when(service.getText(inputSelecteur, inputTextLanguage))
        .thenReturn(expectedResult);

    // query setup

    LinkedMultiValueMap<String, String> requestParams =
        new LinkedMultiValueMap<>();
    requestParams.add("selector", inputSelecteur);
    requestParams.add("language", inputTextLanguage.toString());

    this.mockMvc.perform(get("/text").params(requestParams))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(content().json(
            mapper.writeValueAsString(new StringDto(expectedResult))));
  }

  @Test
  @DisplayName("getText should return an error message when it is found but "
      + "not for the language specified")
  void getTextFoundNotLanguage() throws Exception {

    String inputSelecteur = "test-selecteur";
    TextLanguage inputTextLanguage = TextLanguage.ENGLISH;
    String expectedResult =
        ConfigurationParams.DEFAULT_TEXT_NO_TRANSLATION_FOUND;

    // mock setup

    when(service.getText(inputSelecteur, inputTextLanguage))
        .thenReturn(expectedResult);

    // query setup

    LinkedMultiValueMap<String, String> requestParams =
        new LinkedMultiValueMap<>();
    requestParams.add("selector", inputSelecteur);
    requestParams.add("language", inputTextLanguage.toString());

    this.mockMvc.perform(get("/text").params(requestParams))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(content().json(
            mapper.writeValueAsString(new StringDto(expectedResult))));
  }
}
