package fr.sylvainjanet.app.test.integration;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import fr.sylvainjanet.app.entities.LocalizedString;
import fr.sylvainjanet.app.repo.LocalizedStringRepository;
import fr.sylvainjanet.app.test.integration.config.InitialTestData;

/**
 * Before each test, truncate all table and put the initial data. That way,
 * the database state is controller before each integration test.
 * DataJpaTest should not use the embedded in-memory, since our app may use
 * SGBD specific queries.
 * 
 * @author Sylvain
 *
 */
@Tag("Integration-test")
//CHECKSTYLE.OFF: AbbreviationAsWordInNameCheck 
//IT should be part of the class name
public class InitDbForTestsIT {
  // CHECKSTYLE.ON: AbbreviationAsWordInNameCheck

  /**
   * Repository used to insert elements.
   */
  @Autowired
  private LocalizedStringRepository localizedStringRepo;

  /**
   * Before each tests, truncate all tables and put back the initial data.
   * That way, the database state is controlled before each test.
   */
  @BeforeEach
  void initDb() {
    resetDb();
    addInitData();
  }

  /**
   * Truncate all tables.
   */
  @Sql(scripts = "/sql/truncate_all.sql")
  void resetDb() {
  }

  /**
   * Add initial data.
   */
  void addInitData() {
    final List<LocalizedString> lsList =
        InitialTestData.TEST_LOCALIZED_STRING;
    for (LocalizedString ls : lsList) {
      ls = localizedStringRepo.save(ls);
    }
  }
}
