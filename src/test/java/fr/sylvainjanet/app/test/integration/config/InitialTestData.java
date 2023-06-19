package fr.sylvainjanet.app.test.integration.config;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import fr.sylvainjanet.app.entities.LocalizedString;
import fr.sylvainjanet.app.entities.TextLanguage;

/**
 * Initial data for integration tests.
 * 
 * @author Sylvain
 *
 */
public final class InitialTestData {

  /**
   * Texts for sylvain janet.
   */
  private static final Map<TextLanguage, String> TEST_TEXTMAP_MAIN =
      new EnumMap<>(TextLanguage.class);

  /**
   * Texts for sylvain janet.
   */
  private static final Map<TextLanguage, String> TEST_TEXTMAP_SKILLS =
      new EnumMap<>(TextLanguage.class);

  /**
   * Texts for sylvain janet.
   */
  private static final Map<TextLanguage, String> TEST_TEXTMAP_ENGLISH_ONLY =
      new EnumMap<>(TextLanguage.class);

  /**
   * Texts for sylvain janet.
   */
  // CHECKSTYLE.OFF: LineLengthCheck - Line can't be made smaller
  private static final Map<TextLanguage, String> TEST_TEXTMAP_MULTIPLE_SELECTORS =
      new EnumMap<>(TextLanguage.class);
  // CHECKSTYLE.ON: LineLengthCheck

  static {

    TEST_TEXTMAP_MAIN.put(TextLanguage.FRENCH,
        "Test - Je suis Sylvain Janet");
    TEST_TEXTMAP_MAIN.put(TextLanguage.ENGLISH,
        "Test - I am Sylvain Janet");

    TEST_TEXTMAP_SKILLS.put(TextLanguage.FRENCH, "Test - Compétences");
    TEST_TEXTMAP_SKILLS.put(TextLanguage.ENGLISH, "Test - Skills");

    TEST_TEXTMAP_ENGLISH_ONLY.put(TextLanguage.ENGLISH,
        "Test - This is only available in english");

    TEST_TEXTMAP_MULTIPLE_SELECTORS.put(TextLanguage.FRENCH,
        "Test - Plusieurs selecteurs");
    TEST_TEXTMAP_MULTIPLE_SELECTORS.put(TextLanguage.ENGLISH,
        "Test - Multiple selectors");

  }

  /**
   * Localized string for tests.
   */
  public static final LocalizedString LS_MAIN =
      new LocalizedString(Arrays.asList("test-main"), TEST_TEXTMAP_MAIN);

  /**
   * Localized string for tests.
   */
  public static final LocalizedString LS_SKILLS = new LocalizedString(
      Arrays.asList("test-skills"), TEST_TEXTMAP_SKILLS);

  /**
   * Localized string for tests.
   */
  public static final LocalizedString LS_ENGLISH_ONLY =
      new LocalizedString(Arrays.asList("test-english-only"),
          TEST_TEXTMAP_ENGLISH_ONLY);

  /**
   * Localized string for tests.
   */
  public static final LocalizedString LS_MULTIPLE_SELECTORS =
      new LocalizedString(
          Arrays.asList("test-multiple-selectors", "test-other-selector"),
          TEST_TEXTMAP_MULTIPLE_SELECTORS);

  /**
   * Initial text in db.
   */
  public static final List<LocalizedString> TEST_LOCALIZED_STRING =
      Collections.unmodifiableList(Arrays.asList(LS_MAIN, LS_SKILLS,
          LS_ENGLISH_ONLY, LS_MULTIPLE_SELECTORS));

  private InitialTestData() {

  }

}
