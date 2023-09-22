package fr.sylvainjanet.app.test.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import fr.sylvainjanet.app.config.ConfigurationParams;
import fr.sylvainjanet.app.entities.LocalizedString;
import fr.sylvainjanet.app.entities.TextLanguage;
import fr.sylvainjanet.app.repo.LocalizedStringRepository;
import fr.sylvainjanet.app.services.LocalizedStringServiceImpl;

/**
 * Tests the LocalizedStringServiceImpl class.
 * 
 * @author Sylvain
 *
 */
public class LocalizedStringServiceImplTest {

  /**
   * Service, on which injection will be performed.
   */
  @InjectMocks
  private LocalizedStringServiceImpl service;

  /**
   * Repository, to be mocked in the service.
   */
  @Mock
  private LocalizedStringRepository repo;

  /**
   * Mocks initialisation.
   */
  @BeforeEach
  public void init() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  @DisplayName("getText should return the text when it is found")
  void getTextFound() {

    final String inputSelector = "test";
    final TextLanguage inputTextLanguage = TextLanguage.FRENCH;
    final String expected = "ceci est un test";

    // mock setup
    final LocalizedString ls = new LocalizedString();
    ls.addSelector(inputSelector);
    ls.translateIn(inputTextLanguage, expected);
    when(repo.getBySelector(inputSelector)).thenReturn(ls);

    final String actual =
        service.getText(inputSelector, inputTextLanguage);

    assertEquals(expected, actual);
  }

  @Test
  @DisplayName("getText should return an error message when it is not found")
  void getTextNotFound() {

    final String inputSelector = "test";
    final TextLanguage inputTextLanguage = TextLanguage.FRENCH;
    final String expected =
        ConfigurationParams.DEFAULT_TEXT_NO_SELECTOR_FOUND;

    // mock setup
    when(repo.getBySelector(inputSelector)).thenReturn(null);

    final String actual =
        service.getText(inputSelector, inputTextLanguage);

    assertEquals(expected, actual);
  }

  @Test
  @DisplayName("getText should return an error message when it is found but "
      + "not for the language specified")
  void getTextFoundNotLanguage() {

    final String inputSelector = "test";
    final TextLanguage inputTextLanguage = TextLanguage.FRENCH;
    final String expected =
        ConfigurationParams.DEFAULT_TEXT_NO_TRANSLATION_FOUND;

    // mock setup
    final LocalizedString ls = new LocalizedString();
    ls.addSelector(inputSelector);
    ls.translateIn(TextLanguage.ENGLISH, "ceci est un test");
    when(repo.getBySelector(inputSelector)).thenReturn(ls);

    final String actual =
        service.getText(inputSelector, inputTextLanguage);

    assertEquals(expected, actual);
  }

  @Test
  @DisplayName("getMultiText should return the texts when they are found")
  void getMultiTextFound() {

    final List<String> inputSelectors =
        new ArrayList<String>(Arrays.asList("test 1", "test 2"));
    final TextLanguage inputTextLanguage = TextLanguage.FRENCH;
    final List<String> expected = new ArrayList<String>(
        Arrays.asList("ceci est un test", "ceci est un autre test"));

    // mock setup
    final LocalizedString ls1 = new LocalizedString();
    ls1.addSelector(inputSelectors.get(0));
    ls1.translateIn(inputTextLanguage, expected.get(0));
    when(repo.getBySelector(inputSelectors.get(0))).thenReturn(ls1);

    final LocalizedString ls2 = new LocalizedString();
    ls2.addSelector(inputSelectors.get(1));
    ls2.translateIn(inputTextLanguage, expected.get(1));
    when(repo.getBySelector(inputSelectors.get(1))).thenReturn(ls2);

    final List<String> actual =
        service.getMultiText(inputSelectors, inputTextLanguage);

    assertEquals(expected, actual);
  }

  @Test
  @DisplayName("getMultiText should return an error message"
      + "when it is not found")
  void getMultiTextNotFound() {

    final List<String> inputSelectors = new ArrayList<String>(Arrays
        .asList("test 1 - not found", "test 2", "test 3 - not found"));
    final TextLanguage inputTextLanguage = TextLanguage.FRENCH;
    final List<String> expected = new ArrayList<String>(
        Arrays.asList(ConfigurationParams.DEFAULT_TEXT_NO_SELECTOR_FOUND,
            "ceci est un autre test",
            ConfigurationParams.DEFAULT_TEXT_NO_SELECTOR_FOUND));

    // mock setup
    when(repo.getBySelector(inputSelectors.get(0))).thenReturn(null);

    final LocalizedString ls = new LocalizedString();
    ls.addSelector(inputSelectors.get(1));
    ls.translateIn(inputTextLanguage, expected.get(1));
    when(repo.getBySelector(inputSelectors.get(1))).thenReturn(ls);

    when(repo.getBySelector(inputSelectors.get(2))).thenReturn(null);

    final List<String> actual =
        service.getMultiText(inputSelectors, inputTextLanguage);

    assertEquals(expected, actual);
  }

  @Test
  @DisplayName("getMultiText should return an error message "
      + "when it is found but not for the language specified")
  void getMultiTextFoundNotLanguage() {

    final List<String> inputSelectors =
        new ArrayList<String>(Arrays.asList("test 1 - not for language",
            "test 2", "test 3 - not for language"));
    final TextLanguage inputTextLanguage = TextLanguage.FRENCH;
    final List<String> expected = new ArrayList<String>(Arrays.asList(
        ConfigurationParams.DEFAULT_TEXT_NO_TRANSLATION_FOUND,
        "ceci est un autre test",
        ConfigurationParams.DEFAULT_TEXT_NO_TRANSLATION_FOUND));

    // mock setup
    final LocalizedString ls1 = new LocalizedString();
    ls1.addSelector(inputSelectors.get(0));
    ls1.translateIn(TextLanguage.ENGLISH, expected.get(0));
    when(repo.getBySelector(inputSelectors.get(0))).thenReturn(ls1);

    final LocalizedString ls2 = new LocalizedString();
    ls2.addSelector(inputSelectors.get(1));
    ls2.translateIn(inputTextLanguage, expected.get(1));
    when(repo.getBySelector(inputSelectors.get(1))).thenReturn(ls2);

    final LocalizedString ls3 = new LocalizedString();
    ls3.addSelector(inputSelectors.get(2));
    ls3.translateIn(TextLanguage.ENGLISH, expected.get(2));
    when(repo.getBySelector(inputSelectors.get(2))).thenReturn(ls3);

    final List<String> actual =
        service.getMultiText(inputSelectors, inputTextLanguage);

    assertEquals(expected, actual);
  }
}
