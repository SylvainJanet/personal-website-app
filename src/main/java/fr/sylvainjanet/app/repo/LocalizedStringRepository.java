package fr.sylvainjanet.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.sylvainjanet.app.config.EntitiesParams;
import fr.sylvainjanet.app.entities.LocalizedString;

/**
 * Repository.
 * 
 * @author Sylvain
 *
 */
public interface LocalizedStringRepository
    extends JpaRepository<LocalizedString, Long> {

  /**
   * Get a localized string by selector.
   * 
   * @param selector the selector.
   * @return the localized string having that selector.
   */
  @Query("SELECT ls FROM " + EntitiesParams.LOCALIZED_STRING_NAME
      + " ls WHERE ?1 MEMBER OF ls.selectors")
  LocalizedString getBySelector(String selector);

}
