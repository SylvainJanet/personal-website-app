package fr.sylvainjanet.app.test.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
import fr.sylvainjanet.app.dtos.ListStringDto;
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

  @Test
  @DisplayName("getText should return the text when it is found")
  void getText() throws Exception {

    final String inputSelecteur = "test-selecteur";
    final TextLanguage inputTextLanguage = TextLanguage.ENGLISH;
    final String expectedResult = "this is a test";

    // mock setup

    when(service.getText(inputSelecteur, inputTextLanguage))
        .thenReturn(expectedResult);

    // query setup

    final LinkedMultiValueMap<String, String> requestParams =
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

    final String inputSelecteur = "test-selecteur";
    final TextLanguage inputTextLanguage = TextLanguage.ENGLISH;
    final String expectedResult =
        ConfigurationParams.DEFAULT_TEXT_NO_SELECTOR_FOUND;

    // mock setup

    when(service.getText(inputSelecteur, inputTextLanguage))
        .thenReturn(expectedResult);

    // query setup

    final LinkedMultiValueMap<String, String> requestParams =
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

    final String inputSelecteur = "test-selecteur";
    final TextLanguage inputTextLanguage = TextLanguage.ENGLISH;
    final String expectedResult =
        ConfigurationParams.DEFAULT_TEXT_NO_TRANSLATION_FOUND;

    // mock setup

    when(service.getText(inputSelecteur, inputTextLanguage))
        .thenReturn(expectedResult);

    // query setup

    final LinkedMultiValueMap<String, String> requestParams =
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
  @DisplayName("getMultiText should return the texts when they are found")
  void getMultiText() throws Exception {

    final List<String> inputSelectors =
        new ArrayList<String>(Arrays.asList("test 1", "test 2"));
    final TextLanguage inputTextLanguage = TextLanguage.FRENCH;
    final List<String> expected = new ArrayList<String>(
        Arrays.asList("ceci est un test", "ceci est un autre test"));

    // mock setup

    when(service.getMultiText(inputSelectors, inputTextLanguage))
        .thenReturn(expected);

    // query setup

    final LinkedMultiValueMap<String, String> requestParams =
        new LinkedMultiValueMap<>();
    requestParams.add("selectors", inputSelectors.get(0));
    requestParams.add("selectors", inputSelectors.get(1));
    requestParams.add("language", inputTextLanguage.toString());

    this.mockMvc.perform(get("/multi-text").params(requestParams))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(content()
            .json(mapper.writeValueAsString(new ListStringDto(expected))));

  }

  @Test
  @DisplayName("getMultiText should return an error message "
      + "when it is not found")
  void getMultiTextNotFound() throws Exception {

    final List<String> inputSelectors = new ArrayList<String>(Arrays
        .asList("test 1 - not found", "test 2", "test 3 - not found"));
    final TextLanguage inputTextLanguage = TextLanguage.FRENCH;
    final List<String> expected = new ArrayList<String>(
        Arrays.asList(ConfigurationParams.DEFAULT_TEXT_NO_SELECTOR_FOUND,
            "ceci est un autre test",
            ConfigurationParams.DEFAULT_TEXT_NO_SELECTOR_FOUND));

    // mock setup

    when(service.getMultiText(inputSelectors, inputTextLanguage))
        .thenReturn(expected);

    // query setup

    final LinkedMultiValueMap<String, String> requestParams =
        new LinkedMultiValueMap<>();
    requestParams.add("selectors", inputSelectors.get(0));
    requestParams.add("selectors", inputSelectors.get(1));
    requestParams.add("selectors", inputSelectors.get(2));
    requestParams.add("language", inputTextLanguage.toString());

    this.mockMvc.perform(get("/multi-text").params(requestParams))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(content()
            .json(mapper.writeValueAsString(new ListStringDto(expected))));
  }

  @Test
  @DisplayName("getMultiText should return an error message "
      + "when it is found but not for the language specified")
  void getMultiTextFoundNotLanguage() throws Exception {

    final List<String> inputSelectors =
        new ArrayList<String>(Arrays.asList("test 1 - not for language",
            "test 2", "test 3 - not for language"));
    final TextLanguage inputTextLanguage = TextLanguage.FRENCH;
    final List<String> expected = new ArrayList<String>(Arrays.asList(
        ConfigurationParams.DEFAULT_TEXT_NO_TRANSLATION_FOUND,
        "ceci est un autre test",
        ConfigurationParams.DEFAULT_TEXT_NO_TRANSLATION_FOUND));

    // mock setup

    when(service.getMultiText(inputSelectors, inputTextLanguage))
        .thenReturn(expected);

    // query setup

    final LinkedMultiValueMap<String, String> requestParams =
        new LinkedMultiValueMap<>();
    requestParams.add("selectors", inputSelectors.get(0));
    requestParams.add("selectors", inputSelectors.get(1));
    requestParams.add("selectors", inputSelectors.get(2));
    requestParams.add("language", inputTextLanguage.toString());

    this.mockMvc.perform(get("/multi-text").params(requestParams))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(content()
            .json(mapper.writeValueAsString(new ListStringDto(expected))));
  }
}
