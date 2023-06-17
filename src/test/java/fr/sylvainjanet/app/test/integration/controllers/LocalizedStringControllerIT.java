package fr.sylvainjanet.app.test.integration.controllers;

import static com.epages.restdocs.apispec.MockMvcRestDocumentationWrapper.document;
import static com.epages.restdocs.apispec.MockMvcRestDocumentationWrapper.resourceDetails;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.requestParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;

import com.epages.restdocs.apispec.Schema;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.sylvainjanet.app.config.ConfigurationParams;
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

  /**
   * GET /hello should return Hello world and the environment name.
   *
   * @throws Exception if something goes wrong during the testing.
   */
  @Test
  @DisplayName("getText should return the text when it is found")
  void getText() throws Exception {

    String inputSelecteur = InitialTestData.LS_MAIN.getSelectors().get(0);
    TextLanguage inputTextLanguage = TextLanguage.ENGLISH;
    String expectedResult =
        InitialTestData.LS_MAIN.from(inputTextLanguage);

    // query setup

    LinkedMultiValueMap<String, String> requestParams =
        new LinkedMultiValueMap<>();
    requestParams.add("selector", inputSelecteur);
    requestParams.add("language", inputTextLanguage.toString());

    // restDoc setup
    String formattedEnumValues = Arrays.stream(TextLanguage.values())
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

    String inputSelecteur = "test-i-dont-exist";
    TextLanguage inputTextLanguage = TextLanguage.ENGLISH;
    String expectedResult =
        ConfigurationParams.DEFAULT_TEXT_NO_SELECTOR_FOUND;

    // query setup

    LinkedMultiValueMap<String, String> requestParams =
        new LinkedMultiValueMap<>();
    requestParams.add("selector", inputSelecteur);
    requestParams.add("language", inputTextLanguage.toString());

    this.getMockMvc().perform(get("/text").params(requestParams))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(content().json(
            mapper.writeValueAsString(new StringDto(expectedResult))))
        .andDo(document("Get Text - selector not found",
            resourceDetails().tag("Text")));
  }

  @Test
  @DisplayName("getText should return an error message when it is found but "
      + "not for the language specified")
  void getTextFoundNotLanguage() throws Exception {

    String inputSelecteur =
        InitialTestData.LS_ENGLISH_ONLY.getSelectors().get(0);
    TextLanguage inputTextLanguage = TextLanguage.FRENCH;
    String expectedResult =
        ConfigurationParams.DEFAULT_TEXT_NO_TRANSLATION_FOUND;

    // query setup

    LinkedMultiValueMap<String, String> requestParams =
        new LinkedMultiValueMap<>();
    requestParams.add("selector", inputSelecteur);
    requestParams.add("language", inputTextLanguage.toString());

    this.getMockMvc().perform(get("/text").params(requestParams))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(content().json(
            mapper.writeValueAsString(new StringDto(expectedResult))))
        .andDo(document("Get Text - no translation",
            resourceDetails().tag("Text")));
  }
}
