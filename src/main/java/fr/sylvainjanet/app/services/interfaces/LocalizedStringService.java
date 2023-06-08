package fr.sylvainjanet.app.services.interfaces;

import fr.sylvainjanet.app.entities.TextLanguage;

/**
 * Interface for the LocalizedString Service.
 * 
 * @author Sylvain
 *
 */
public interface LocalizedStringService {

  /**
   * Get the text string for a selector in a given language.
   * 
   * @param selector the selector
   * @param language the language
   * @return the text string
   */
  String getText(String selector, TextLanguage language);

}
