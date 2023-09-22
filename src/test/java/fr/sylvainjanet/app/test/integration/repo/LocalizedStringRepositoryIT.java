package fr.sylvainjanet.app.test.integration.repo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import com.ulisesbocchio.jasyptspringboot.configuration.EnableEncryptablePropertiesConfiguration;

import fr.sylvainjanet.app.entities.LocalizedString;
import fr.sylvainjanet.app.repo.LocalizedStringRepository;
import fr.sylvainjanet.app.test.integration.InitDbForTestsIT;
import fr.sylvainjanet.app.test.integration.config.InitialTestData;

/**
 * Integration tests for the LocalizedString repository.
 * 
 * @author Sylvain
 *
 */
//CHECKSTYLE.OFF: AbbreviationAsWordInNameCheck 
//IT should be part of the class name
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Import(EnableEncryptablePropertiesConfiguration.class)
public class LocalizedStringRepositoryIT extends InitDbForTestsIT {
  // CHECKSTYLE.ON: AbbreviationAsWordInNameCheck

  /**
   * LocalizedString repository.
   */
  @Autowired
  private LocalizedStringRepository repo;

  /**
   * getBySelector should return null when localized string is not found.
   */
  @Test
  @DisplayName("getBySelector should return null "
      + "when localized string is not found")
  void getBySelectorNotFound() {
    final String input = "test-unused-selector";
    final LocalizedString ls = repo.getBySelector(input);

    assertNull(ls);

  }

  /**
   * getBySelector should return the localized string with a given
   * selector.
   */
  @Test
  @DisplayName("getBySelector should return the localized string "
      + "with a given selector")
  void getBySelectorFound() {
    final String inputSingle = "test-main";
    final LocalizedString expectedSingle = InitialTestData.LS_MAIN;
    final LocalizedString actualSingle = repo.getBySelector(inputSingle);

    assertNotNull(actualSingle);
    assertEquals(expectedSingle, actualSingle);

    final String inputMultiple1 = "test-multiple-selectors";
    final LocalizedString expectedMultiple1 =
        InitialTestData.LS_MULTIPLE_SELECTORS;
    final LocalizedString actualMultiple1 =
        repo.getBySelector(inputMultiple1);

    assertNotNull(actualMultiple1);
    assertEquals(expectedMultiple1, actualMultiple1);

    final String inputMultiple2 = "test-other-selector";
    final LocalizedString expectedMultiple2 =
        InitialTestData.LS_MULTIPLE_SELECTORS;
    final LocalizedString actualMultiple2 =
        repo.getBySelector(inputMultiple2);

    assertNotNull(actualMultiple2);
    assertEquals(expectedMultiple2, actualMultiple2);

  }

}
