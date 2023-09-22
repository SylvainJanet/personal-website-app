package fr.sylvainjanet.app.test.integration.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

  /**
   * getText should return the text when it is found.
   */
  @Test
  @DisplayName("getText should return the text when it is found")
  void getTextFound() {

    final String inputSelector =
        InitialTestData.LS_MAIN.getSelectors().get(0);
    final TextLanguage inputTextLanguage = TextLanguage.FRENCH;
    final String expected =
        InitialTestData.LS_MAIN.from(inputTextLanguage);

    final String actual =
        service.getText(inputSelector, inputTextLanguage);

    assertEquals(expected, actual);
  }

  /**
   * getText should return an error message when it is not found.
   */
  @Test
  @DisplayName("getText should return an error message when it is not found")
  void getTextNotFound() {

    final String inputSelector = "test-not-exist";
    final TextLanguage inputTextLanguage = TextLanguage.FRENCH;
    final String expected =
        ConfigurationParams.DEFAULT_TEXT_NO_SELECTOR_FOUND;

    final String actual =
        service.getText(inputSelector, inputTextLanguage);

    assertEquals(expected, actual);
  }

  /**
   * getText should return an error message when it is found but not for
   * the language specified.
   */
  @Test
  @DisplayName("getText should return an error message when it is found but "
      + "not for the language specified")
  void getTextFoundNotLanguage() {

    final String inputSelector =
        InitialTestData.LS_ENGLISH_ONLY.getSelectors().get(0);
    final TextLanguage inputTextLanguage = TextLanguage.FRENCH;
    final String expected =
        ConfigurationParams.DEFAULT_TEXT_NO_TRANSLATION_FOUND;

    final String actual =
        service.getText(inputSelector, inputTextLanguage);

    assertEquals(expected, actual);
  }

  /**
   * getMultiText should return the texts when they are found.
   */
  @Test
  @DisplayName("getMultiText should return the texts when they are found")
  void getMultiTextFound() {

    final List<String> inputSelectors = new ArrayList<String>(
        Arrays.asList(InitialTestData.LS_MAIN.getSelectors().get(0),
            InitialTestData.LS_SKILLS.getSelectors().get(0)));

    final TextLanguage inputTextLanguage = TextLanguage.FRENCH;
    final List<String> expected = new ArrayList<String>(
        Arrays.asList(InitialTestData.LS_MAIN.from(inputTextLanguage),
            InitialTestData.LS_SKILLS.from(inputTextLanguage)));

    final List<String> actual =
        service.getMultiText(inputSelectors, inputTextLanguage);

    assertEquals(expected, actual);
  }

  /**
   * getMultiText should return an error message when it is not found.
   */
  @Test
  @DisplayName("getMultiText should return an error message "
      + "when it is not found")
  void getMultiTextNotFound() {

    final List<String> inputSelectors =
        new ArrayList<String>(Arrays.asList("test-1-not-exist",
            InitialTestData.LS_MAIN.getSelectors().get(0),
            "test-2-not-exist"));
    final TextLanguage inputTextLanguage = TextLanguage.FRENCH;
    final List<String> expected = new ArrayList<String>(
        Arrays.asList(ConfigurationParams.DEFAULT_TEXT_NO_SELECTOR_FOUND,
            InitialTestData.LS_MAIN.from(inputTextLanguage),
            ConfigurationParams.DEFAULT_TEXT_NO_SELECTOR_FOUND));

    final List<String> actual =
        service.getMultiText(inputSelectors, inputTextLanguage);

    assertEquals(expected, actual);
  }

  /**
   * getMultiText should return an error message when it is found but not
   * for the language specified.
   */
  @Test
  @DisplayName("getMultiText should return an error message "
      + "when it is found but not for the language specified")
  void getMultiTextFoundNotLanguage() {

    final List<String> inputSelectors = new ArrayList<String>(Arrays
        .asList(InitialTestData.LS_ENGLISH_ONLY.getSelectors().get(0),
            InitialTestData.LS_MAIN.getSelectors().get(0),
            InitialTestData.LS_ENGLISH_ONLY.getSelectors().get(0)));
    final TextLanguage inputTextLanguage = TextLanguage.FRENCH;
    final List<String> expected = new ArrayList<String>(Arrays.asList(
        ConfigurationParams.DEFAULT_TEXT_NO_TRANSLATION_FOUND,
        InitialTestData.LS_MAIN.from(inputTextLanguage),
        ConfigurationParams.DEFAULT_TEXT_NO_TRANSLATION_FOUND));

    final List<String> actual =
        service.getMultiText(inputSelectors, inputTextLanguage);

    assertEquals(expected, actual);
  }
}
