package fr.sylvainjanet.app.test.integration.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.sylvainjanet.app.config.ConfigurationParams;
import fr.sylvainjanet.app.entities.TextLanguage;
import fr.sylvainjanet.app.services.LocalizedStringServiceImpl;
import fr.sylvainjanet.app.test.integration.InitDbForTestsIT;
import fr.sylvainjanet.app.test.integration.config.InitialTestData;

/**
 * Integration tests for the LocalizedString service.
 * 
 * @author Sylvain
 *
 */
//CHECKSTYLE.OFF: AbbreviationAsWordInNameCheck 
//IT should be part of the class name
@SpringBootTest
public class LocalizedStringServiceImplIT extends InitDbForTestsIT {
  // CHECKSTYLE.ON: AbbreviationAsWordInNameCheck

  /**
   * Service to be tested.
   */
  @Autowired
  private LocalizedStringServiceImpl service;

  @Test
  @DisplayName("getText should return the text when it is found")
  void getTextFound() {

    String inputSelector = InitialTestData.LS_MAIN.getSelectors().get(0);
    TextLanguage inputTextLanguage = TextLanguage.FRENCH;
    String expected = InitialTestData.LS_MAIN.from(inputTextLanguage);

    String actual = service.getText(inputSelector, inputTextLanguage);

    assertEquals(expected, actual);
  }

  @Test
  @DisplayName("getText should return an error message when it is not found")
  void getTextNotFound() {

    String inputSelector = "test-not-exist";
    TextLanguage inputTextLanguage = TextLanguage.FRENCH;
    String expected = ConfigurationParams.DEFAULT_TEXT_NO_SELECTOR_FOUND;

    String actual = service.getText(inputSelector, inputTextLanguage);

    assertEquals(expected, actual);
  }

  @Test
  @DisplayName("getText should return an error message when it is found but "
      + "not for the language specified")
  void getTextFoundNotLanguage() {

    final String inputSelector =
        InitialTestData.LS_ENGLISH_ONLY.getSelectors().get(0);
    final TextLanguage inputTextLanguage = TextLanguage.FRENCH;
    final String expected =
        ConfigurationParams.DEFAULT_TEXT_NO_TRANSLATION_FOUND;

    String actual = service.getText(inputSelector, inputTextLanguage);

    assertEquals(expected, actual);
  }

}
