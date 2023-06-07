package fr.sylvainjanet.app.entities;

import java.util.Locale;

/**
 * Every language supported by this app.
 * https://www.baeldung.com/jpa-persisting-enums-in-jpa
 */
public enum TextLanguage {

  /**
   * French language.
   */
  FRENCH("fr", "FR", "", "Latn"),
  /**
   * English language.
   */
  ENGLISH("en", "US", "", "Latn");

  /**
   * Language. https://www.iso.org/iso-639-language-codes.html
   */
  private final String language;
  /**
   * Region. https://www.iso.org/iso-3166-country-codes.html
   * https://unstats.un.org/unsd/methodology/m49/
   */
  private final String region;
  /**
   * Variants. https://www.iana.org/assignments/language-subtag-registry/
   * language-subtag-registry
   */
  private final String variant;
  /**
   * Scripts. https://en.wikipedia.org/wiki/ISO_15924
   */
  private final String script;
  /**
   * Locale object constructed with the language, region, variant and script
   * provided. https://www.baeldung.com/java-8-localization
   */
  private final Locale locale;

  /**
   * Enum constructor. Sets the properties and builds the locale object.
   * 
   * @param language the language
   * @param region   the region
   * @param variant  the variant
   * @param script   the script
   */
  TextLanguage(final String language, final String region, final String variant,
      final String script) {
    this.language = language;
    this.region = region;
    this.variant = variant;
    this.script = script;
    this.locale = new Locale.Builder().setLanguage(language).setRegion(region)
        .setVariant(variant).setScript(script).build();
  }

  /**
   * Get language.
   *
   * @return the language
   */
  public String getLanguage() {
    return language;
  }

  /**
   * Get region.
   *
   * @return the region
   */
  public String getRegion() {
    return region;
  }

  /**
   * Get variant.
   *
   * @return the variant
   */
  public String getVariant() {
    return variant;
  }

  /**
   * Get script.
   *
   * @return the script
   */
  public String getScript() {
    return script;
  }

  /**
   * Get locale.
   *
   * @return the locale
   */
  public Locale getLocale() {
    return locale;
  }

}
