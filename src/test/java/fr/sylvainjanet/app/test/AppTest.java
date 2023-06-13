package fr.sylvainjanet.app.test;

import static com.epages.restdocs.apispec.MockMvcRestDocumentationWrapper.document;
import static com.epages.restdocs.apispec.MockMvcRestDocumentationWrapper.resourceDetails;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.restdocs.operation.preprocess.OperationRequestPreprocessor;
import org.springframework.restdocs.operation.preprocess.OperationResponsePreprocessor;
import org.springframework.restdocs.operation.preprocess.Preprocessors;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.epages.restdocs.apispec.Schema;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.sylvainjanet.app.dtos.StringDto;

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
   * Set up the mockMvc instance to use RestDocumentation. For more, see
   * https://docs.spring.io/spring-restdocs/docs/2.0.7.RELEASE/
   * reference/html5/#documenting-your-api Exemple :
   * https://github.com/BerkleyTechnologyServices/restdocs-spec-example/
   * tree/master
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
  void testHello() throws Exception {
    this.mockMvc
        .perform(RestDocumentationRequestBuilders.get("/hello")
            .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(content().json(mapper.writeValueAsString(
            new StringDto("Hello World ! - " + environment))))
        .andDo(document("Hello world and basic requests", resourceDetails()
            .summary("Hello world request")
            .description("Request to test the API, the doc generation and "
                + "everything while setting up anything really.")
            .tag("Test tag").responseSchema(new Schema("StringDTO")),
            preprocessRequest(), preprocessResponse(), responseFields(
                fieldWithPath("message").description("the message"))));
  }

  /**
   * PUT /hello should ERROR 405.
   *
   * @throws Exception if something goes wrong during the testing.
   */
  @Test
  void testPutHello() throws Exception {
    this.mockMvc
        .perform(RestDocumentationRequestBuilders.put("/hello")
            .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().is(HttpStatus.METHOD_NOT_ALLOWED.value()))
        .andDo(document("Hello world can't PUT",
            resourceDetails().summary("Hello world PUT request")
                .description("Request to test the API PUT ISNT ALLOWED")
                .tag("Test tag"),
            preprocessRequest(), preprocessResponse()));
  }

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

}
