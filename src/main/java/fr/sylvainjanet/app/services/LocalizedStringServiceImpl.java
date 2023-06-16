package fr.sylvainjanet.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.sylvainjanet.app.config.ConfigurationParams;
import fr.sylvainjanet.app.entities.LocalizedString;
import fr.sylvainjanet.app.entities.TextLanguage;
import fr.sylvainjanet.app.repo.LocalizedStringRepository;
import fr.sylvainjanet.app.services.interfaces.LocalizedStringService;

/**
 * Service for the LocalizedString entity.
 * 
 * @author Sylvain
 *
 */
@Service
public class LocalizedStringServiceImpl implements LocalizedStringService {

  /**
   * The LocalizedString repository.
   */
  @Autowired
  private LocalizedStringRepository repo;

  /**
   * Get the text string for a selector in a given language.
   * 
   * @param selector the selector
   * @param language the language
   * @return the text string
   */
  @Override
  public String getText(final String selector,
      final TextLanguage language) {
    LocalizedString ls = repo.getBySelector(selector);
    String result;
    if (ls == null) {
      result = ConfigurationParams.DEFAULT_TEXT_NO_SELECTOR_FOUND;
    } else {
      result = ls.isDefinedFor(language) ? ls.from(language)
          : ConfigurationParams.DEFAULT_TEXT_NO_TRANSLATION_FOUND;
    }
    return result;
  }

}
