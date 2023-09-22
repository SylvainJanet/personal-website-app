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

  @Test
  @DisplayName("getLanguage should return the language")
  void getLanguageTest() {

    String expected = "fr";
    String actual = TextLanguage.FRENCH.getLanguage();

    assertEquals(expected, actual);
  }

  @Test
  @DisplayName("getRegion should return the region")
  void getRegionTest() {

    String expected = "FR";
    String actual = TextLanguage.FRENCH.getRegion();

    assertEquals(expected, actual);
  }

  @Test
  @DisplayName("getVariant should return the variant")
  void getVariantTest() {

    String expected = "";
    String actual = TextLanguage.FRENCH.getVariant();

    assertEquals(expected, actual);
  }

  @Test
  @DisplayName("getScript should return the script")
  void getScriptTest() {

    String expected = "Latn";
    String actual = TextLanguage.FRENCH.getScript();

    assertEquals(expected, actual);
  }

  @Test
  @DisplayName("getLocale should return the locale")
  void getLocaleTest() {

    Locale expected = new Locale.Builder().setLanguage("fr")
        .setRegion("FR").setVariant("").setScript("Latn").build();
    Locale actual = TextLanguage.FRENCH.getLocale();

    assertEquals(expected, actual);
  }
}
