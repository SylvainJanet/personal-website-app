package fr.sylvainjanet.app.test.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.operation.preprocess.OperationRequestPreprocessor;
import org.springframework.restdocs.operation.preprocess.OperationResponsePreprocessor;
import org.springframework.restdocs.operation.preprocess.Preprocessors;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

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
public class LocalizedStringControllerTest {

  /**
   * Regiter the rest doc extension with a custom output directory.
   */
  @RegisterExtension
  private final RestDocumentationExtension restDocumentation =
      new RestDocumentationExtension("target-restdoc/generated-snippets");

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

  static OperationRequestPreprocessor preprocessRequest() {
    return Preprocessors.preprocessRequest(
        Preprocessors.removeHeaders("Content-Length", "X-CSRF-TOKEN"),
        Preprocessors.prettyPrint());
  }

  static OperationResponsePreprocessor preprocessResponse() {
    return Preprocessors.preprocessResponse(
        Preprocessors.removeHeaders("Content-Length", "Pragma",
            "X-XSS-Protection", "Expires", "X-Frame-Options",
            "X-Content-Type-Options", "Cache-Control"),
        Preprocessors.prettyPrint());
  }

  /**
   * Mocked service.
   */
  @MockBean
  private LocalizedStringServiceImpl service;

  /**
   * Set up the mockMvc instance to use RestDocumentation.
   * 
   * @param webApplicationContext the {@link WebApplicationContext}
   * @param restDocumentation     the
   *                              {@link RestDocumentationContextProvider}
   */
  @BeforeEach
  public void setUp(final WebApplicationContext webApplicationContext,
      final RestDocumentationContextProvider restDocumentation) {
    this.mockMvc = MockMvcBuilders
        .webAppContextSetup(webApplicationContext)
        .apply(documentationConfiguration(restDocumentation)
            .operationPreprocessors()
            .withResponseDefaults(Preprocessors.prettyPrint()))
        .build();
  }

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
    // for integration test
    // .andDo(
    // document("Get a text associated with a selector in a language",
    // resourceDetails()
    // .requestSchema(new Schema("selector-language"))
    // .summary("/text request")
    // .description("blablabla still coding the tests")
    // .tag("Test tag")
    // .responseSchema(new Schema("stringResponseEntity")),
    // preprocessRequest(), preprocessResponse(),
    // requestParameters(
    // parameterWithName("selector")
    // .description("the selector blablabla"),
    // parameterWithName("language")
    // .description("the language blablablabla"))));

    // String formattedEnumValues = Arrays.stream(Season.values())
    // .map(type -> String.format("`%s`", type))
    // .collect(Collectors.joining(", "));
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
