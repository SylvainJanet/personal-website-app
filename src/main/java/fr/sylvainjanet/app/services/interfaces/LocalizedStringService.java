package fr.sylvainjanet.app.services.interfaces;

import java.util.List;

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

  /**
   * Get multiple text strings for multiple selectors in a given language.
   * 
   * @param selectors the selectors
   * @param language  the language
   * @return the text string
   */
  List<String> getMultiText(List<String> selectors, TextLanguage language);

}
