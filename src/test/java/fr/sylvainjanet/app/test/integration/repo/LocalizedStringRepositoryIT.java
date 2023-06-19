package fr.sylvainjanet.app.test.integration.repo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

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

  @Test
  void getBySelectorNotFound() {
    String input = "test-unused-selector";
    LocalizedString ls = repo.getBySelector(input);

    assertNull(ls);

  }

  @Test
  void getBySelectorFound() {
    String input = "test-main";
    LocalizedString expected = InitialTestData.LS_MAIN;
    LocalizedString actual = repo.getBySelector(input);

    assertNotNull(actual);
    assertEquals(expected, actual);

    input = "test-multiple-selectors";
    expected = InitialTestData.LS_MULTIPLE_SELECTORS;
    actual = repo.getBySelector(input);

    assertNotNull(actual);
    assertEquals(expected, actual);

    input = "test-other-selector";
    expected = InitialTestData.LS_MULTIPLE_SELECTORS;
    actual = repo.getBySelector(input);

    assertNotNull(actual);
    assertEquals(expected, actual);

  }

}
