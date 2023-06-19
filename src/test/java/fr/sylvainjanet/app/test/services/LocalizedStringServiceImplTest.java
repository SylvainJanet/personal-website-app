package fr.sylvainjanet.app.test.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

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

    String inputSelector = "test";
    TextLanguage inputTextLanguage = TextLanguage.FRENCH;
    String expected = "ceci est un test";

    // mock setup
    LocalizedString ls = new LocalizedString();
    ls.addSelector(inputSelector);
    ls.translateIn(inputTextLanguage, expected);
    when(repo.getBySelector(inputSelector)).thenReturn(ls);

    String actual = service.getText(inputSelector, inputTextLanguage);

    assertEquals(expected, actual);
  }

  @Test
  @DisplayName("getText should return an error message when it is not found")
  void getTextNotFound() {

    String inputSelector = "test";
    TextLanguage inputTextLanguage = TextLanguage.FRENCH;
    String expected = ConfigurationParams.DEFAULT_TEXT_NO_SELECTOR_FOUND;

    // mock setup
    when(repo.getBySelector(inputSelector)).thenReturn(null);

    String actual = service.getText(inputSelector, inputTextLanguage);

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
    LocalizedString ls = new LocalizedString();
    ls.addSelector(inputSelector);
    ls.translateIn(TextLanguage.ENGLISH, "ceci est un test");
    when(repo.getBySelector(inputSelector)).thenReturn(ls);

    String actual = service.getText(inputSelector, inputTextLanguage);

    assertEquals(expected, actual);
  }
}
