package fr.sylvainjanet.app.test.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Locale;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import fr.sylvainjanet.app.entities.TextLanguage;

/**
 * Tests the TextLanguage enum.
 * 
 * @author Sylvain
 *
 */
public class TextLanguageTest {

  /**
   * getLanguage should return the language.
   */
  @Test
  @DisplayName("getLanguage should return the language")
  void getLanguageTest() {

    final String expected = "fr";
    final String actual = TextLanguage.FRENCH.getLanguage();

    assertEquals(expected, actual,
        "getLanguage should return the language");
  }

  /**
   * getRegion should return the region.
   */
  @Test
  @DisplayName("getRegion should return the region")
  void getRegionTest() {

    final String expected = "FR";
    final String actual = TextLanguage.FRENCH.getRegion();

    assertEquals(expected, actual, "getRegion should return the region");
  }

  /**
   * getVariant should return the variant.
   */
  @Test
  @DisplayName("getVariant should return the variant")
  void getVariantTest() {

    final String expected = "";
    final String actual = TextLanguage.FRENCH.getVariant();

    assertEquals(expected, actual, "getVariant should return the variant");
  }

  /**
   * getScript should return the script.
   */
  @Test
  @DisplayName("getScript should return the script")
  void getScriptTest() {

    final String expected = "Latn";
    final String actual = TextLanguage.FRENCH.getScript();

    assertEquals(expected, actual, "getScript should return the script");
  }

  /**
   * getLocale should return the locale.
   */
  @Test
  @DisplayName("getLocale should return the locale")
  void getLocaleTest() {

    final Locale expected = new Locale.Builder().setLanguage("fr")
        .setRegion("FR").setVariant("").setScript("Latn").build();
    final Locale actual = TextLanguage.FRENCH.getLocale();

    assertEquals(expected, actual, "getLocale should return the locale");
  }
}
