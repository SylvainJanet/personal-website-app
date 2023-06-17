package fr.sylvainjanet.app.test.integration;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.operation.preprocess.OperationRequestPreprocessor;
import org.springframework.restdocs.operation.preprocess.OperationResponsePreprocessor;
import org.springframework.restdocs.operation.preprocess.Preprocessors;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Base class for every controller integration test that also makes
 * restDocs.
 * 
 * @author Sylvain
 *
 */
@SpringBootTest
@AutoConfigureMockMvc
//CHECKSTYLE.OFF: AbbreviationAsWordInNameCheck 
//IT should be part of the class name
public class ControllerAndRestDocIT extends InitDbForTestsIT {
  // CHECKSTYLE.ON: AbbreviationAsWordInNameCheck

  /**
   * Autowired mockMvc used to mock http requests.
   */
  @Autowired
  private MockMvc mockMvc;

  /**
   * Regiter the rest doc extension with a custom output directory.
   */
  @RegisterExtension
  private final RestDocumentationExtension restDocumentation =
      new RestDocumentationExtension("target-restdoc/generated-snippets");

  protected static OperationRequestPreprocessor preprocessRequest() {
    return Preprocessors.preprocessRequest(
        Preprocessors.removeHeaders("Content-Length", "X-CSRF-TOKEN"),
        Preprocessors.prettyPrint());
  }

  protected static OperationResponsePreprocessor preprocessResponse() {
    return Preprocessors.preprocessResponse(
        Preprocessors.removeHeaders("Content-Length", "Pragma",
            "X-XSS-Protection", "Expires", "X-Frame-Options",
            "X-Content-Type-Options", "Cache-Control"),
        Preprocessors.prettyPrint());
  }

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
    this.setMockMvc(
        MockMvcBuilders.webAppContextSetup(webApplicationContext)
            .apply(documentationConfiguration(restDocumentation)
                .operationPreprocessors()
                .withRequestDefaults(Preprocessors
                    .removeHeaders("Content-Length", "X-CSRF-TOKEN"),
                    Preprocessors.prettyPrint())
                .withResponseDefaults(
                    Preprocessors.removeHeaders("Content-Length", "Pragma",
                        "X-XSS-Protection", "Expires", "X-Frame-Options",
                        "X-Content-Type-Options", "Cache-Control"),
                    Preprocessors.prettyPrint()))
            .build());
  }

  /**
   * Get mockMvc.
   *
   * @return the mockMvc
   */
  protected MockMvc getMockMvc() {
    return mockMvc;
  }

  /**
   * Set mockMvc.
   *
   * @param mockMvc the mockMvc to set
   */
  private void setMockMvc(final MockMvc mockMvc) {
    this.mockMvc = mockMvc;
  }

}
