package fr.sylvainjanet.app.test.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import fr.sylvainjanet.app.entities.LocalizedString;
import fr.sylvainjanet.app.entities.TextLanguage;

/**
 * Tests the LocalizedString class.
 * 
 * @author Sylvain
 *
 */
public class LocalizedStringTest {

  /**
   * isDefinedForAllLanguages should return true when a LocalizedString is
   * defined for all languages.
   */
  @Test
  @DisplayName("isDefinedForAllLanguages should return "
      + "true when a LocalizedString is defined for all languages")
  void testDefinedForAllLanguagesTrue() {

    final LocalizedString input = new LocalizedString();

    // input setup

    final Long id = 1L;
    final List<String> selectors =
        Arrays.asList("test-selector", "other-test-selector");
    final Map<TextLanguage, String> textMap =
        new HashMap<TextLanguage, String>();
    textMap.put(TextLanguage.ENGLISH, "test in english");
    textMap.put(TextLanguage.FRENCH, "test en français");

    input.setId(id);
    input.setSelectors(selectors);
    input.setTextMap(textMap);

    final Boolean expected = true;
    final Boolean actual = input.isDefinedForAllLanguages();

    assertEquals(expected, actual,
        "isDefinedForAllLanguages should return true");

  }

  /**
   * isDefinedForAllLanguages should return false when a LocalizedString is
   * not defined for all languages.
   */
  @Test
  @DisplayName("isDefinedForAllLanguages should return "
      + "false when a LocalizedString is not defined for all languages")
  void testDefinedForAllLanguagesFalse() {

    final LocalizedString input = new LocalizedString();

    // input setup

    final Long id = 1L;
    final List<String> selectors =
        Arrays.asList("test-selector", "other-test-selector");
    final Map<TextLanguage, String> textMap =
        new HashMap<TextLanguage, String>();
    textMap.put(TextLanguage.ENGLISH, "test in english");
    // not defined for TextLanguage.FRENCH

    input.setId(id);
    input.setSelectors(selectors);
    input.setTextMap(textMap);

    final Boolean expected = false;
    final Boolean actual = input.isDefinedForAllLanguages();

    assertEquals(expected, actual,
        "isDefinedForAllLanguages should return false");

  }

  /**
   * isDefinedFor should return true when a LocalizedString is defined the
   * language given.
   */
  @Test
  @DisplayName("isDefinedFor should return "
      + "true when a LocalizedString is defined the language given")
  void testDefinedForTrue() {

    final LocalizedString input = new LocalizedString();

    // input setup

    final Long id = 1L;
    final List<String> selectors =
        Arrays.asList("test-selector", "other-test-selector");
    final Map<TextLanguage, String> textMap =
        new HashMap<TextLanguage, String>();
    textMap.put(TextLanguage.ENGLISH, "test in english");
    textMap.put(TextLanguage.FRENCH, "test en français");

    input.setId(id);
    input.setSelectors(selectors);
    input.setTextMap(textMap);

    final Boolean expected = true;
    final Boolean actual = input.isDefinedFor(TextLanguage.ENGLISH);

    assertEquals(expected, actual, "isDefinedFor should return true");

  }

  /**
   * isDefinedFor should return false when a LocalizedString is not defined
   * for the language given.
   */
  @Test
  @DisplayName("isDefinedFor should return "
      + "false when a LocalizedString is not defined for the language given")
  void testDefinedForFalse() {

    final LocalizedString input = new LocalizedString();

    // input setup

    final Long id = 1L;
    final List<String> selectors =
        Arrays.asList("test-selector", "other-test-selector");
    final Map<TextLanguage, String> textMap =
        new HashMap<TextLanguage, String>();
    textMap.put(TextLanguage.ENGLISH, "test in english");
    // not defined for TextLanguage.FRENCH

    input.setId(id);
    input.setSelectors(selectors);
    input.setTextMap(textMap);

    final Boolean expected = false;
    final Boolean actual = input.isDefinedFor(TextLanguage.FRENCH);

    assertEquals(expected, actual, "isDefinedFor should return false");

  }

  /**
   * isNonEmptyForAllLanguages should return true when a LocalizedString
   * has non empty text for every language.
   */
  @Test
  @DisplayName("isNonEmptyForAllLanguages should return "
      + "true when a LocalizedString has non empty text for every language")
  void isNonEmptyForAllLanguagesTrue() {

    final LocalizedString input = new LocalizedString();

    // input setup

    final Long id = 1L;
    final List<String> selectors =
        Arrays.asList("test-selector", "other-test-selector");
    final Map<TextLanguage, String> textMap =
        new HashMap<TextLanguage, String>();
    textMap.put(TextLanguage.ENGLISH, "test in english");
    textMap.put(TextLanguage.FRENCH, "test en français");

    input.setId(id);
    input.setSelectors(selectors);
    input.setTextMap(textMap);

    final Boolean expected = true;
    final Boolean actual = input.isNonEmptyForAllLanguages();

    assertEquals(expected, actual,
        "isNonEmptyForAllLanguages should return true");

  }

  /**
   * isNonEmptyForAllLanguages should return false when a LocalizedString
   * has no text or is null for a TextLanguage.
   * 
   * @param hasNullTranslation whether or not the text is null.
   */
  @ParameterizedTest
  @DisplayName("isNonEmptyForAllLanguages should return "
      + "false when a LocalizedString has no text or is null "
      + "for a TextLanguage")
  @ValueSource(booleans = { true, false })
  final void isNonEmptyForAllLanguagesFalseSomeDontExist(
      final boolean hasNullTranslation) {

    final LocalizedString input = new LocalizedString();

    // input setup

    final Long id = 1L;
    final List<String> selectors =
        Arrays.asList("test-selector", "other-test-selector");
    final Map<TextLanguage, String> textMap =
        new HashMap<TextLanguage, String>();
    textMap.put(TextLanguage.ENGLISH, "test in english");
    if (hasNullTranslation) {
      textMap.put(TextLanguage.ENGLISH, null);
    }

    input.setId(id);
    input.setSelectors(selectors);
    input.setTextMap(textMap);

    final Boolean expected = false;
    final Boolean actual = input.isNonEmptyForAllLanguages();

    assertEquals(expected, actual,
        "isNonEmptyForAllLanguages should return false");

  }

  /**
   * isNonEmptyForAllLanguages should return false when a LocalizedString
   * has an empty text for a TextLanguage.
   */
  @Test
  @DisplayName("isNonEmptyForAllLanguages should return "
      + "false when a LocalizedString has an empty text for a TextLanguage")
  void isNonEmptyForAllLanguagesFalseSomeEmpty() {

    final LocalizedString input = new LocalizedString();

    // input setup

    final Long id = 1L;
    final List<String> selectors =
        Arrays.asList("test-selector", "other-test-selector");
    final Map<TextLanguage, String> textMap =
        new HashMap<TextLanguage, String>();
    textMap.put(TextLanguage.ENGLISH, "test in english");
    textMap.put(TextLanguage.FRENCH, "");

    input.setId(id);
    input.setSelectors(selectors);
    input.setTextMap(textMap);

    final Boolean expected = false;
    final Boolean actual = input.isNonEmptyForAllLanguages();

    assertEquals(expected, actual,
        "isNonEmptyForAllLanguages should return false");

  }

  /**
   * isNonEmptyFor should return true when a LocalizedString has non empty
   * text for the language given.
   */
  @Test
  @DisplayName("isNonEmptyFor should return "
      + "true when a LocalizedString has non empty text for the language given")
  void isNonEmptyForTrue() {

    final LocalizedString input = new LocalizedString();

    // input setup

    final Long id = 1L;
    final List<String> selectors =
        Arrays.asList("test-selector", "other-test-selector");
    final Map<TextLanguage, String> textMap =
        new HashMap<TextLanguage, String>();
    textMap.put(TextLanguage.ENGLISH, "test in english");
    textMap.put(TextLanguage.FRENCH, "test en français");

    input.setId(id);
    input.setSelectors(selectors);
    input.setTextMap(textMap);

    final Boolean expected = true;
    final Boolean actual = input.isNonEmptyFor(TextLanguage.FRENCH);

    assertEquals(expected, actual, "isNonEmptyFor should return true");

  }

  /**
   * isNonEmptyFor should return false when a LocalizedString has no text
   * for the language given.
   */
  @Test
  @DisplayName("isNonEmptyFor should return "
      + "false when a LocalizedString has no text for the language given")
  void isNonEmptyForFalseSomeDontExist() {

    final LocalizedString input = new LocalizedString();

    // input setup

    final Long id = 1L;
    final List<String> selectors =
        Arrays.asList("test-selector", "other-test-selector");
    final Map<TextLanguage, String> textMap =
        new HashMap<TextLanguage, String>();
    textMap.put(TextLanguage.ENGLISH, "test in english");

    input.setId(id);
    input.setSelectors(selectors);
    input.setTextMap(textMap);

    final Boolean expected = false;
    final Boolean actual = input.isNonEmptyFor(TextLanguage.FRENCH);

    assertEquals(expected, actual, "isNonEmptyFor should return false");

  }

  /**
   * isNonEmptyFor should return false when a LocalizedString has some null
   * text or an empty text for the language given.
   * 
   * @param hasNullTranslation whether or not the text is null.
   */
  @ParameterizedTest
  @DisplayName("isNonEmptyFor should return "
      + "false when a LocalizedString has some null text "
      + "or an empty text for the language given")
  @ValueSource(booleans = { true, false })
  final void isNonEmptyForFalseSomeNull(final boolean hasNullTranslation) {

    final LocalizedString input = new LocalizedString();

    // input setup

    final Long id = 1L;
    final List<String> selectors =
        Arrays.asList("test-selector", "other-test-selector");
    final Map<TextLanguage, String> textMap =
        new HashMap<TextLanguage, String>();
    textMap.put(TextLanguage.ENGLISH, "test in english");
    textMap.put(TextLanguage.FRENCH, hasNullTranslation ? null : "");

    input.setId(id);
    input.setSelectors(selectors);
    input.setTextMap(textMap);

    final Boolean expected = false;
    final Boolean actual = input.isNonEmptyFor(TextLanguage.FRENCH);

    assertEquals(expected, actual, "isNonEmptyFor should return false");

  }

  /**
   * isForSelector should return true when a LocalizedString is associated
   * with the selector given.
   */
  @Test
  @DisplayName("isForSelector should return "
      + "true when a LocalizedString is associated with the selector given")
  void isForSelectorTrue() {

    final LocalizedString input = new LocalizedString();

    // input setup

    final Long id = 1L;
    final List<String> selectors =
        Arrays.asList("test-selector", "other-test-selector");
    final Map<TextLanguage, String> textMap =
        new HashMap<TextLanguage, String>();
    textMap.put(TextLanguage.ENGLISH, "test in english");
    textMap.put(TextLanguage.FRENCH, "test en français");

    input.setId(id);
    input.setSelectors(selectors);
    input.setTextMap(textMap);

    final Boolean expected = true;
    final Boolean actual = input.isForSelector("test-selector");

    assertEquals(expected, actual, "isForSelector should return true");

  }

  /**
   * isForSelector should return false when a LocalizedString is not
   * associated with the selector given.
   */
  @Test
  @DisplayName("isForSelector should return "
      + "false when a LocalizedString is not associated with "
      + "the selector given")
  void isForSelectorFalse() {

    final LocalizedString input = new LocalizedString();

    // input setup

    final Long id = 1L;
    final List<String> selectors =
        Arrays.asList("test-selector", "other-test-selector");
    final Map<TextLanguage, String> textMap =
        new HashMap<TextLanguage, String>();
    textMap.put(TextLanguage.ENGLISH, "test in english");
    textMap.put(TextLanguage.FRENCH, "test en français");

    input.setId(id);
    input.setSelectors(selectors);
    input.setTextMap(textMap);

    final Boolean expected = false;
    final Boolean actual = input.isForSelector("not-present-selector");

    assertEquals(expected, actual, "isForSelector should return false");

  }

  /**
   * addSelector should add a given selector to the selector list of a
   * LocalizedString.
   */
  @Test
  @DisplayName("addSelector should add a given selector "
      + "to the selector list of a LocalizedString")
  void addSelector() {

    final LocalizedString input = new LocalizedString();

    // input setup

    final Long id = 1L;
    final List<String> selectors = new ArrayList<>(
        Arrays.asList("test-selector", "other-test-selector"));

    final Map<TextLanguage, String> textMap =
        new HashMap<TextLanguage, String>();
    textMap.put(TextLanguage.ENGLISH, "test in english");
    textMap.put(TextLanguage.FRENCH, "test en français");

    input.setId(id);
    input.setSelectors(selectors);
    input.setTextMap(textMap);

    input.addSelector("added-selector");

    final List<String> expected = new ArrayList<>(Arrays
        .asList("test-selector", "other-test-selector", "added-selector"));
    final List<String> actual = input.getSelectors();

    assertEquals(expected, actual, "addSelector should add selector");

  }

  /**
   * removeSelector should remove a given selector to the selector list of
   * a LocalizedString if it is present and return true.
   */
  @Test
  @DisplayName("removeSelector should remove a given selector "
      + "to the selector list of a LocalizedString if it is present "
      + "and return true")
  void removeSelectorTrue() {

    final LocalizedString input = new LocalizedString();

    // input setup

    final Long id = 1L;
    final List<String> selectors = new ArrayList<>(
        Arrays.asList("test-selector", "other-test-selector"));

    final Map<TextLanguage, String> textMap =
        new HashMap<TextLanguage, String>();
    textMap.put(TextLanguage.ENGLISH, "test in english");
    textMap.put(TextLanguage.FRENCH, "test en français");

    input.setId(id);
    input.setSelectors(selectors);
    input.setTextMap(textMap);

    final Boolean expectedResult = true;
    final Boolean actualResult = input.removeSelector("test-selector");
    assertEquals(expectedResult, actualResult,
        "removeSelector should return true");

    final List<String> expectedSelectors =
        new ArrayList<>(Arrays.asList("other-test-selector"));
    final List<String> actualSelectors = input.getSelectors();

    assertEquals(expectedSelectors, actualSelectors,
        "removeSelector should remove selector");

  }

  /**
   * removeSelector should not do anything to the selector list of a
   * LocalizedString if it is not present and return false.
   */
  @Test
  @DisplayName("removeSelector should not do anything "
      + "to the selector list of a LocalizedString if it is not present "
      + "and return false")
  void removeSelectorFalse() {

    final LocalizedString input = new LocalizedString();

    // input setup

    final Long id = 1L;
    final List<String> selectors = new ArrayList<>(
        Arrays.asList("test-selector", "other-test-selector"));

    final Map<TextLanguage, String> textMap =
        new HashMap<TextLanguage, String>();
    textMap.put(TextLanguage.ENGLISH, "test in english");
    textMap.put(TextLanguage.FRENCH, "test en français");

    input.setId(id);
    input.setSelectors(selectors);
    input.setTextMap(textMap);

    final Boolean expectedResult = false;
    final Boolean actualResult =
        input.removeSelector("not-present-selector");
    assertEquals(expectedResult, actualResult,
        "removeSelector should return false");

    final List<String> expectedSelectors = new ArrayList<>(
        Arrays.asList("test-selector", "other-test-selector"));
    final List<String> actualSelectors = input.getSelectors();

    assertEquals(expectedSelectors, actualSelectors,
        "removeSelector should not do anything");

  }

  /**
   * from should return the text in the language given when it is listed.
   */
  @Test
  @DisplayName("from should return "
      + "the text in the language given when it is listed")
  void fromExists() {

    final LocalizedString input = new LocalizedString();

    // input setup

    final Long id = 1L;
    final List<String> selectors = new ArrayList<>(
        Arrays.asList("test-selector", "other-test-selector"));

    final Map<TextLanguage, String> textMap =
        new HashMap<TextLanguage, String>();
    textMap.put(TextLanguage.ENGLISH, "test in english");
    textMap.put(TextLanguage.FRENCH, "test en français");

    input.setId(id);
    input.setSelectors(selectors);
    input.setTextMap(textMap);

    final String expected = "test in english";
    final String actual = input.from(TextLanguage.ENGLISH);

    assertEquals(expected, actual, "from should return the text");

  }

  /**
   * from should return null when the language given is not listed.
   */
  @Test
  @DisplayName("from should return "
      + "null when the language given is not listed")
  void fromDontExist() {

    final LocalizedString input = new LocalizedString();

    // input setup

    final Long id = 1L;
    final List<String> selectors = new ArrayList<>(
        Arrays.asList("test-selector", "other-test-selector"));

    final Map<TextLanguage, String> textMap =
        new HashMap<TextLanguage, String>();
    textMap.put(TextLanguage.ENGLISH, "test in english");

    input.setId(id);
    input.setSelectors(selectors);
    input.setTextMap(textMap);

    final String expected = null;
    final String actual = input.from(TextLanguage.FRENCH);

    assertEquals(expected, actual, "from should return null");

  }

  /**
   * translateIn should add a given translation associated to a given
   * language and return the previous translation..
   */
  @Test
  @DisplayName("translateIn should add a given translation "
      + "associated to a given language and return the previous "
      + "translation.")
  void translateInExisted() {

    final LocalizedString input = new LocalizedString();

    // input setup

    final Long id = 1L;
    final List<String> selectors = new ArrayList<>(
        Arrays.asList("test-selector", "other-test-selector"));

    final Map<TextLanguage, String> textMap =
        new HashMap<TextLanguage, String>();
    textMap.put(TextLanguage.ENGLISH, "test in english");
    textMap.put(TextLanguage.FRENCH, "test en français");

    input.setId(id);
    input.setSelectors(selectors);
    input.setTextMap(textMap);

    final String expectedPrevious = "test en français";
    final String actualPrevious =
        input.translateIn(TextLanguage.FRENCH, "nouveau texte");

    assertEquals(expectedPrevious, actualPrevious,
        "translateIn should return the previous translation");

    final String expectedTranslation = "nouveau texte";
    final String actualTranslation = input.from(TextLanguage.FRENCH);

    assertEquals(expectedTranslation, actualTranslation,
        "translateIn should change the text");

  }

  /**
   * translateIn should add a given translation associated to a given
   * language and return the previous translation..
   */
  @Test
  @DisplayName("translateIn should add a given translation "
      + "associated to a given language and return the previous "
      + "translation.")
  void translateInNew() {

    final LocalizedString input = new LocalizedString();

    // input setup

    final Long id = 1L;
    final List<String> selectors = new ArrayList<>(
        Arrays.asList("test-selector", "other-test-selector"));

    final Map<TextLanguage, String> textMap =
        new HashMap<TextLanguage, String>();
    textMap.put(TextLanguage.ENGLISH, "test in english");

    input.setId(id);
    input.setSelectors(selectors);
    input.setTextMap(textMap);

    final String expectedPrevious = null;
    final String actualPrevious =
        input.translateIn(TextLanguage.FRENCH, "nouveau texte");

    assertEquals(expectedPrevious, actualPrevious,
        "translateIn should return null");

    final String expectedTranslation = "nouveau texte";
    final String actualTranslation = input.from(TextLanguage.FRENCH);

    assertEquals(expectedTranslation, actualTranslation,
        "translateIn should change the text");

  }

  /**
   * Default constructor should instanciate properly.
   */
  @Test
  @DisplayName("Default constructor should instanciate properly")
  void defaultConstructor() {

    final LocalizedString input = new LocalizedString();

    final Long idExpected = null;
    final List<String> selectorsExpected = new ArrayList<>();
    final Map<TextLanguage, String> textMapExpected =
        new EnumMap<>(TextLanguage.class);

    final Long idActual = input.getId();
    final List<String> selectorsActual = input.getSelectors();
    final Map<TextLanguage, String> textMapActual = input.getTextMap();

    assertEquals(idExpected, idActual, "id should be set");
    assertEquals(selectorsExpected, selectorsActual,
        "selectors should be set");
    assertEquals(textMapExpected, textMapActual, "textMap should be set");

  }

  /**
   * Full constructor should instanciate properly.
   */
  @Test
  @DisplayName("Full constructor should instanciate properly")
  void fullConstructor() {

    // input setup

    final Long idExpected = 1L;
    final List<String> selectorsExpected =
        Arrays.asList("test-selector", "other-test-selector");
    final Map<TextLanguage, String> textMapExpected =
        new HashMap<TextLanguage, String>();
    textMapExpected.put(TextLanguage.ENGLISH, "test in english");
    textMapExpected.put(TextLanguage.FRENCH, "test en français");

    final LocalizedString input = new LocalizedString(idExpected,
        selectorsExpected, textMapExpected);

    final Long idActual = input.getId();
    final List<String> selectorsActual = input.getSelectors();
    final Map<TextLanguage, String> textMapActual = input.getTextMap();

    assertEquals(idExpected, idActual, "id should be set");
    assertEquals(selectorsExpected, selectorsActual,
        "selectors should be set");
    assertEquals(textMapExpected, textMapActual, "textMap should be set");

  }

  /**
   * Constructor without the id should instanciate properly.
   */
  @Test
  @DisplayName("Constructor without the id should instanciate properly")
  void withoutIdConstructor() {

    // input setup

    final Long idExpected = null;
    final List<String> selectorsExpected =
        Arrays.asList("test-selector", "other-test-selector");
    final Map<TextLanguage, String> textMapExpected =
        new HashMap<TextLanguage, String>();
    textMapExpected.put(TextLanguage.ENGLISH, "test in english");
    textMapExpected.put(TextLanguage.FRENCH, "test en français");

    final LocalizedString input =
        new LocalizedString(selectorsExpected, textMapExpected);

    final Long idActual = input.getId();
    final List<String> selectorsActual = input.getSelectors();
    final Map<TextLanguage, String> textMapActual = input.getTextMap();

    assertEquals(idExpected, idActual, "id should be set");
    assertEquals(selectorsExpected, selectorsActual,
        "selectors should be set");
    assertEquals(textMapExpected, textMapActual, "textMap should be set");

  }

  /**
   * getId should return the id.
   */
  @Test
  @DisplayName("getId should return the id")
  void getId() {

    final LocalizedString input = new LocalizedString();

    // input setup

    final Long expectedId = 1L;
    final List<String> selectors =
        Arrays.asList("test-selector", "other-test-selector");
    final Map<TextLanguage, String> textMap =
        new HashMap<TextLanguage, String>();
    textMap.put(TextLanguage.ENGLISH, "test in english");
    textMap.put(TextLanguage.FRENCH, "test en français");

    input.setId(expectedId);
    input.setSelectors(selectors);
    input.setTextMap(textMap);

    final Long actualId = input.getId();

    assertEquals(expectedId, actualId, "getId should return the id");
  }

  /**
   * setId should set the id.
   */
  @Test
  @DisplayName("setId should set the id")
  void setId() {

    final LocalizedString input = new LocalizedString();

    // input setup

    final Long expectedId = 1L;

    input.setId(expectedId);

    final Long actualId = input.getId();

    assertEquals(expectedId, actualId, "setId should set the id");
  }

  /**
   * getSelectors should return the selectors.
   */
  @Test
  @DisplayName("getSelectors should return the selectors")
  void getSelectors() {

    final LocalizedString input = new LocalizedString();

    // input setup

    final Long id = 1L;
    final List<String> expectedSelectors =
        Arrays.asList("test-selector", "other-test-selector");
    final Map<TextLanguage, String> textMap =
        new HashMap<TextLanguage, String>();
    textMap.put(TextLanguage.ENGLISH, "test in english");
    textMap.put(TextLanguage.FRENCH, "test en français");

    input.setId(id);
    input.setSelectors(expectedSelectors);
    input.setTextMap(textMap);

    final List<String> actualSelectors = input.getSelectors();

    assertEquals(expectedSelectors, actualSelectors,
        "getSelectors should return the selectors");
  }

  /**
   * setSelectors should set the selectors.
   */
  @Test
  @DisplayName("setSelectors should set the selectors")
  void setSelectors() {

    final LocalizedString input = new LocalizedString();

    // input setup

    final List<String> expectedSelectors =
        Arrays.asList("test-selector", "other-test-selector");

    input.setSelectors(expectedSelectors);

    final List<String> actualSelectors = input.getSelectors();

    assertEquals(expectedSelectors, actualSelectors,
        "setSelectors should set the selectors");
  }

  /**
   * getTextMap should return the textMap.
   */
  @Test
  @DisplayName("getTextMap should return the textMap")
  void getTextMap() {

    final LocalizedString input = new LocalizedString();

    // input setup

    final Long id = 1L;
    final List<String> selectors =
        Arrays.asList("test-selector", "other-test-selector");
    final Map<TextLanguage, String> expectedTextMap =
        new HashMap<TextLanguage, String>();
    expectedTextMap.put(TextLanguage.ENGLISH, "test in english");
    expectedTextMap.put(TextLanguage.FRENCH, "test en français");

    input.setId(id);
    input.setSelectors(selectors);
    input.setTextMap(expectedTextMap);

    final Map<TextLanguage, String> actualTextMap = input.getTextMap();

    assertEquals(expectedTextMap, actualTextMap,
        "getTextMap should return the textMap");
  }

  /**
   * setTextMap should set the textMap.
   */
  @Test
  @DisplayName("setTextMap should set the textMap")
  void setTextMap() {

    final LocalizedString input = new LocalizedString();

    // input setup

    final Map<TextLanguage, String> expectedTextMap =
        new HashMap<TextLanguage, String>();
    expectedTextMap.put(TextLanguage.ENGLISH, "test in english");
    expectedTextMap.put(TextLanguage.FRENCH, "test en français");

    input.setTextMap(expectedTextMap);

    final Map<TextLanguage, String> actualTextMap = input.getTextMap();

    assertEquals(expectedTextMap, actualTextMap,
        "setTextMap should set the textMap");
  }

  /**
   * Equals and Hashcode should be true if id are equal.
   */
  @Test
  @DisplayName("Equals and Hashcode should be true if id are equal")
  void equalsHashcodeTrue() {

    final LocalizedString input1 = new LocalizedString();
    final LocalizedString input2 = new LocalizedString();

    // input setup

    final Long id1 = 1L;
    final Long id2 = 1L;
    final List<String> selectors1 =
        Arrays.asList("test-selector-1", "other-test-selector-1");
    final List<String> selectors2 =
        Arrays.asList("test-selector-2", "other-test-selector-2");
    final Map<TextLanguage, String> expectedTextMap1 =
        new HashMap<TextLanguage, String>();
    expectedTextMap1.put(TextLanguage.ENGLISH, "test in english-1");
    expectedTextMap1.put(TextLanguage.FRENCH, "test en français-1");
    final Map<TextLanguage, String> expectedTextMap2 =
        new HashMap<TextLanguage, String>();
    expectedTextMap1.put(TextLanguage.ENGLISH, "test in english-2");
    expectedTextMap1.put(TextLanguage.FRENCH, "test en français-2");

    input1.setId(id1);
    input1.setSelectors(selectors1);
    input1.setTextMap(expectedTextMap1);
    input2.setId(id2);
    input2.setSelectors(selectors2);
    input2.setTextMap(expectedTextMap2);

    assertEquals(input1, input2, "Equals should be true if id are equal");
    assertEquals(input1.hashCode(), input2.hashCode(),
        "Hashcode should be the same if id are equal");

  }

  /**
   * Equals and Hashcode should be false if id are different or objects are
   * different.
   */
  @Test
  @DisplayName("Equals and Hashcode should be false if id are different or "
      + "objects are different")
  void equalsHashcodeFalse() {

    final LocalizedString input1 = new LocalizedString();
    final LocalizedString input2 = new LocalizedString();

    // input setup

    final Long id1 = 1L;
    final Long id2 = 2L;
    final List<String> selectors1 =
        Arrays.asList("test-selector-1", "other-test-selector-1");
    final List<String> selectors2 =
        Arrays.asList("test-selector-2", "other-test-selector-2");
    final Map<TextLanguage, String> expectedTextMap1 =
        new HashMap<TextLanguage, String>();
    expectedTextMap1.put(TextLanguage.ENGLISH, "test in english-1");
    expectedTextMap1.put(TextLanguage.FRENCH, "test en français-1");
    final Map<TextLanguage, String> expectedTextMap2 =
        new HashMap<TextLanguage, String>();
    expectedTextMap1.put(TextLanguage.ENGLISH, "test in english-2");
    expectedTextMap1.put(TextLanguage.FRENCH, "test en français-2");

    input1.setId(id1);
    input1.setSelectors(selectors1);
    input1.setTextMap(expectedTextMap1);
    input2.setId(id2);
    input2.setSelectors(selectors2);
    input2.setTextMap(expectedTextMap2);

    assertNotEquals(input1, input2,
        "Equals should be false if id (and other fields) are different");
    assertNotEquals(input1.hashCode(), input2.hashCode(),
        "Hashcode should be different if id (and other fields) are different");

    input1.setId(id1);
    input1.setSelectors(selectors1);
    input1.setTextMap(expectedTextMap1);
    input2.setId(id2);
    input2.setSelectors(selectors1);
    input2.setTextMap(expectedTextMap1);

    assertNotEquals(input1, input2,
        "Equals should be false if id (only) are different");
    assertNotEquals(input1.hashCode(), input2.hashCode(),
        "Hashcode should be different if id (only) are different");

    @SuppressWarnings("unlikely-arg-type")
    final boolean actualNotSameType = input1.equals(new String());
    assertFalse(actualNotSameType,
        "Equals should be false if other object is of another type");

    final boolean actualNull = input1.equals(null);
    assertFalse(actualNull,
        "Equals should be false if other object is null");
  }

  /**
   * Equals and Hashcode should be reflexive.
   */
  @Test
  @DisplayName("Equals and Hashcode should be reflexive")
  void equalsHashcodeReflexive() {

    final LocalizedString input = new LocalizedString();

    // input setup

    final Long id = 1L;
    final List<String> selectors =
        Arrays.asList("test-selector", "other-test-selector");
    final Map<TextLanguage, String> expectedTextMap =
        new HashMap<TextLanguage, String>();
    expectedTextMap.put(TextLanguage.ENGLISH, "test in english");
    expectedTextMap.put(TextLanguage.FRENCH, "test en français");

    input.setId(id);
    input.setSelectors(selectors);
    input.setTextMap(expectedTextMap);

    assertEquals(input, input, "Equals should be reflexive");
    assertEquals(input.hashCode(), input.hashCode(),
        "Hashcode should be reflexive");
  }

  /**
   * Equals and Hashcode should be symmetric.
   */
  @Test
  @DisplayName("Equals and Hashcode should be symmetric")
  void equalsHashcodeSymmetric() {

    final LocalizedString input1 = new LocalizedString();
    final LocalizedString input2 = new LocalizedString();

    // input setup

    final Long id1 = 1L;
    final Long id2 = 2L;
    final List<String> selectors =
        Arrays.asList("test-selector-1", "other-test-selector-1");
    final Map<TextLanguage, String> expectedTextMap =
        new HashMap<TextLanguage, String>();
    expectedTextMap.put(TextLanguage.ENGLISH, "test in english-1");
    expectedTextMap.put(TextLanguage.FRENCH, "test en français-1");

    input1.setId(id1);
    input1.setSelectors(selectors);
    input1.setTextMap(expectedTextMap);
    input2.setId(id2);
    input2.setSelectors(selectors);
    input2.setTextMap(expectedTextMap);

    assertNotEquals(input1, input2,
        "Equals should be symmetric (1 - different)");
    assertNotEquals(input2, input1,
        "Equals should be symmetric (2 - different)");
    assertNotEquals(input1.hashCode(), input2.hashCode(),
        "Hashcode should be symmetric (1 - different)");
    assertNotEquals(input2.hashCode(), input1.hashCode(),
        "Hashcode should be symmetric (2 - different)");

    input1.setId(id1);
    input1.setSelectors(selectors);
    input1.setTextMap(expectedTextMap);
    input2.setId(id1);
    input2.setSelectors(selectors);
    input2.setTextMap(expectedTextMap);

    assertEquals(input1, input2, "Equals should be symmetric (1 - same)");
    assertEquals(input2, input1, "Equals should be symmetric (2 - same)");
    assertEquals(input1.hashCode(), input2.hashCode(),
        "Hashcode should be symmetric (1 - different)");
    assertEquals(input2.hashCode(), input1.hashCode(),
        "Hashcode should be symmetric (2 - different)");
  }

  /**
   * Equals and Hashcode should be transitive.
   */
  @Test
  @DisplayName("Equals and Hashcode should be transitive")
  void equalsHashcodeTransitive() {

    final LocalizedString input1 = new LocalizedString();
    final LocalizedString input2 = new LocalizedString();
    final LocalizedString input3 = new LocalizedString();

    // input setup

    final Long id1 = 1L;
    final Long id2 = 1L;
    final Long id3 = 1L;
    final List<String> selectors1 =
        Arrays.asList("test-selector-1", "other-test-selector-1");
    final List<String> selectors2 =
        Arrays.asList("test-selector-2", "other-test-selector-2");
    final List<String> selectors3 =
        Arrays.asList("test-selector-3", "other-test-selector-3");
    final Map<TextLanguage, String> expectedTextMap1 =
        new HashMap<TextLanguage, String>();
    expectedTextMap1.put(TextLanguage.ENGLISH, "test in english-1");
    expectedTextMap1.put(TextLanguage.FRENCH, "test en français-1");
    final Map<TextLanguage, String> expectedTextMap2 =
        new HashMap<TextLanguage, String>();
    expectedTextMap1.put(TextLanguage.ENGLISH, "test in english-2");
    expectedTextMap1.put(TextLanguage.FRENCH, "test en français-2");
    final Map<TextLanguage, String> expectedTextMap3 =
        new HashMap<TextLanguage, String>();
    expectedTextMap1.put(TextLanguage.ENGLISH, "test in english-3");
    expectedTextMap1.put(TextLanguage.FRENCH, "test en français-3");

    input1.setId(id1);
    input1.setSelectors(selectors1);
    input1.setTextMap(expectedTextMap1);
    input2.setId(id2);
    input2.setSelectors(selectors2);
    input2.setTextMap(expectedTextMap2);
    input3.setId(id3);
    input3.setSelectors(selectors3);
    input3.setTextMap(expectedTextMap3);

    assertEquals(input1, input2, "Equals should be transitive - 1");
    assertEquals(input2, input3, "Equals should be transitive - 2");
    assertEquals(input1, input3, "Equals should be transitive - 3");
    assertEquals(input1.hashCode(), input2.hashCode(),
        "Hashcode should be transitive - 1");
    assertEquals(input2.hashCode(), input3.hashCode(),
        "Hashcode should be transitive - 2");
    assertEquals(input1.hashCode(), input3.hashCode(),
        "Hashcode should be transitive - 3");
  }

  /**
   * toString should return a proper representation of the entity.
   */
  @Test
  @DisplayName("toString should return a proper representation of the entity")
  void toStringTest() {

    final LocalizedString input = new LocalizedString();

    // input setup

    final Long id = 1L;
    final List<String> selectors =
        Arrays.asList("test-selector", "other-test-selector");
    final Map<TextLanguage, String> textMap =
        new HashMap<TextLanguage, String>();
    textMap.put(TextLanguage.ENGLISH, "test in english");
    textMap.put(TextLanguage.FRENCH, "test en français");

    input.setId(id);
    input.setSelectors(selectors);
    input.setTextMap(textMap);

    final String expected = "LocalizedString\r\n" + "[\r\n\tid = 1\r\n"
        + "\tselectors = [test-selector, other-test-selector]\r\n"
        + "\ttextMap = " + textMap + "\r\n" + "]";
    final String actual = input.toString();

    assertEquals(expected, actual,
        "toString should return a proper representation of the entity");
  }
}
