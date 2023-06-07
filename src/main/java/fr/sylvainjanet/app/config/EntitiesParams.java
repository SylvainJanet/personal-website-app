package fr.sylvainjanet.app.config;

/**
 * Parameters for this app's entities.
 * 
 * @author Sylvain
 *
 */
public final class EntitiesParams {

  /**
   * Name of the localized string table in db.
   */
  public static final String LOCALIZED_STRING_NAME =
      "messages_localized_string";
  /**
   * Name of the selectors table name in db.
   */
  public static final String LOCALIZED_STRING_SELECTORS_NAME =
      "messages_selectors";
  /**
   * Name of the selector column (of selectors table) in db.
   */
  public static final String LOCALIZED_STRING_SELECTOR_NAME = "selector";
  /**
   * Name of the textMap table in db.
   */
  public static final String LOCALIZED_STRING_TEXTMAP_NAME =
      "messages_text_map";
  /**
   * Name of the selector column (of textmap table) in db.
   */
  public static final String LOCALIZED_LANGUAGE_NAME = "language";
  /**
   * Name of the selector column (of textmap table) in db.
   */
  public static final String LOCALIZED_STRING_TEXT_NAME = "text";

  private EntitiesParams() {

  }
}
