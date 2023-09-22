package fr.sylvainjanet.app.test.integration.controllers;

import static com.epages.restdocs.apispec.MockMvcRestDocumentationWrapper.document;
import static com.epages.restdocs.apispec.MockMvcRestDocumentationWrapper.resourceDetails;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.requestParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;

import com.epages.restdocs.apispec.Schema;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.sylvainjanet.app.config.ConfigurationParams;
import fr.sylvainjanet.app.dtos.ListStringDto;
import fr.sylvainjanet.app.dtos.StringDto;
import fr.sylvainjanet.app.entities.TextLanguage;
import fr.sylvainjanet.app.test.integration.ControllerAndRestDocIT;
import fr.sylvainjanet.app.test.integration.config.InitialTestData;

/**
 * Integration tests of the LocalizedString controller.
 * 
 * @author Sylvain
 *
 */
//CHECKSTYLE.OFF: AbbreviationAsWordInNameCheck 
//IT should be part of the class name
public class LocalizedStringControllerIT extends ControllerAndRestDocIT {
  // CHECKSTYLE.ON: AbbreviationAsWordInNameCheck

  /**
   * Object mapper.
   */
  @Autowired
  private ObjectMapper mapper;

  @Test
  @DisplayName("getText should return the text when it is found")
  void getText() throws Exception {

    final String inputSelecteur =
        InitialTestData.LS_MAIN.getSelectors().get(0);
    final TextLanguage inputTextLanguage = TextLanguage.ENGLISH;
    final String expectedResult =
        InitialTestData.LS_MAIN.from(inputTextLanguage);

    // query setup

    final LinkedMultiValueMap<String, String> requestParams =
        new LinkedMultiValueMap<>();
    requestParams.add("selector", inputSelecteur);
    requestParams.add("language", inputTextLanguage.toString());

    // restDoc setup
    final String formattedEnumValues = Arrays.stream(TextLanguage.values())
        .map(type -> String.format("`%s`", type))
        .collect(Collectors.joining(", "));

    this.getMockMvc().perform(get("/text").params(requestParams))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(content().json(
            mapper.writeValueAsString(new StringDto(expectedResult))))
        .andDo(document("Get Text", resourceDetails()
            .summary("Get text in a language for a selector")
            .description(
                "Get a text in a given language, for a given selector.")
            .tag("Text").responseSchema(new Schema("StringDTO")),
            requestParameters(
                parameterWithName("selector").description("the selector"),
                parameterWithName("language")
                    .description("the language. Can be any of "
                        + formattedEnumValues))));

  }

  @Test
  @DisplayName("getText should return an error message when it is not found")
  void getTextNotFound() throws Exception {

    final String inputSelecteur = "test-i-dont-exist";
    final TextLanguage inputTextLanguage = TextLanguage.ENGLISH;
    final String expectedResult =
        ConfigurationParams.DEFAULT_TEXT_NO_SELECTOR_FOUND;

    // query setup

    final LinkedMultiValueMap<String, String> requestParams =
        new LinkedMultiValueMap<>();
    requestParams.add("selector", inputSelecteur);
    requestParams.add("language", inputTextLanguage.toString());

    this.getMockMvc().perform(get("/text").params(requestParams))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(content().json(
            mapper.writeValueAsString(new StringDto(expectedResult))))
        .andDo(document("Get Text - selector not found", resourceDetails()
            .tag("Text").responseSchema(new Schema("StringDTO"))));
  }

  @Test
  @DisplayName("getText should return an error message when it is found but "
      + "not for the language specified")
  void getTextFoundNotLanguage() throws Exception {

    final String inputSelecteur =
        InitialTestData.LS_ENGLISH_ONLY.getSelectors().get(0);
    final TextLanguage inputTextLanguage = TextLanguage.FRENCH;
    final String expectedResult =
        ConfigurationParams.DEFAULT_TEXT_NO_TRANSLATION_FOUND;

    // query setup

    final LinkedMultiValueMap<String, String> requestParams =
        new LinkedMultiValueMap<>();
    requestParams.add("selector", inputSelecteur);
    requestParams.add("language", inputTextLanguage.toString());

    this.getMockMvc().perform(get("/text").params(requestParams))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(content().json(
            mapper.writeValueAsString(new StringDto(expectedResult))))
        .andDo(document("Get Text - no translation", resourceDetails()
            .tag("Text").responseSchema(new Schema("StringDTO"))));
  }

  @Test
  @DisplayName("getMultiText should return the text when it is found")
  void getMultiText() throws Exception {

    final List<String> inputSelectors = new ArrayList<String>(
        Arrays.asList(InitialTestData.LS_MAIN.getSelectors().get(0),
            InitialTestData.LS_SKILLS.getSelectors().get(0)));
    final TextLanguage inputTextLanguage = TextLanguage.FRENCH;
    final List<String> expected = new ArrayList<String>(
        Arrays.asList(InitialTestData.LS_MAIN.from(inputTextLanguage),
            InitialTestData.LS_SKILLS.from(inputTextLanguage)));

    // query setup

    final LinkedMultiValueMap<String, String> requestParams =
        new LinkedMultiValueMap<>();
    requestParams.add("selectors", inputSelectors.get(0));
    requestParams.add("selectors", inputSelectors.get(1));
    requestParams.add("language", inputTextLanguage.toString());

    // restDoc setup
    final String formattedEnumValues = Arrays.stream(TextLanguage.values())
        .map(type -> String.format("`%s`", type))
        .collect(Collectors.joining(", "));

    this.getMockMvc().perform(get("/multi-text").params(requestParams))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(content()
            .json(mapper.writeValueAsString(new ListStringDto(expected))))
        .andDo(document("Get Multiple Texts", resourceDetails()
            .summary("Get texts in a language for multiple selectors")
            .description(
                "Get texts in a given language, for multiple given selectors.")
            .tag("Text").responseSchema(new Schema("ListStringDTO")),
            requestParameters(
                parameterWithName("selectors")
                    .description("the selectors"),
                parameterWithName("language")
                    .description("the language. Can be any of "
                        + formattedEnumValues))));

  }

  @Test
  @DisplayName("getMultiText should return an error message "
      + "when it is not found")
  void getMultiTextNotFound() throws Exception {

    final List<String> inputSelectors =
        new ArrayList<String>(Arrays.asList("test-1-not-exist",
            InitialTestData.LS_MAIN.getSelectors().get(0),
            "test-2-not-exist"));
    final TextLanguage inputTextLanguage = TextLanguage.FRENCH;
    final List<String> expected = new ArrayList<String>(
        Arrays.asList(ConfigurationParams.DEFAULT_TEXT_NO_SELECTOR_FOUND,
            InitialTestData.LS_MAIN.from(inputTextLanguage),
            ConfigurationParams.DEFAULT_TEXT_NO_SELECTOR_FOUND));

    // query setup

    final LinkedMultiValueMap<String, String> requestParams =
        new LinkedMultiValueMap<>();
    requestParams.add("selectors", inputSelectors.get(0));
    requestParams.add("selectors", inputSelectors.get(1));
    requestParams.add("selectors", inputSelectors.get(2));
    requestParams.add("language", inputTextLanguage.toString());

    this.getMockMvc().perform(get("/multi-text").params(requestParams))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(content()
            .json(mapper.writeValueAsString(new ListStringDto(expected))))
        .andDo(document("Get Multi Text - selector not found",
            resourceDetails().tag("Text")
                .responseSchema(new Schema("ListStringDTO"))));
  }

  @Test
  @DisplayName("getMultiText should return an error message "
      + "when it is found but not for the language specified")
  void getMultiTextFoundNotLanguage() throws Exception {

    final List<String> inputSelectors = new ArrayList<String>(Arrays
        .asList(InitialTestData.LS_ENGLISH_ONLY.getSelectors().get(0),
            InitialTestData.LS_MAIN.getSelectors().get(0),
            InitialTestData.LS_ENGLISH_ONLY.getSelectors().get(0)));
    final TextLanguage inputTextLanguage = TextLanguage.FRENCH;
    final List<String> expected = new ArrayList<String>(Arrays.asList(
        ConfigurationParams.DEFAULT_TEXT_NO_TRANSLATION_FOUND,
        InitialTestData.LS_MAIN.from(inputTextLanguage),
        ConfigurationParams.DEFAULT_TEXT_NO_TRANSLATION_FOUND));

    // query setup

    final LinkedMultiValueMap<String, String> requestParams =
        new LinkedMultiValueMap<>();
    requestParams.add("selectors", inputSelectors.get(0));
    requestParams.add("selectors", inputSelectors.get(1));
    requestParams.add("selectors", inputSelectors.get(2));
    requestParams.add("language", inputTextLanguage.toString());

    this.getMockMvc().perform(get("/multi-text").params(requestParams))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(content()
            .json(mapper.writeValueAsString(new ListStringDto(expected))))
        .andDo(
            document("Get Multi Text - no translation", resourceDetails()
                .tag("Text").responseSchema(new Schema("ListStringDTO"))));
  }
}
