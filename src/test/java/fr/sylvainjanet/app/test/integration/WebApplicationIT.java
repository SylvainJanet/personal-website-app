package fr.sylvainjanet.app.test.integration;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Test the webapp global behaviour.
 *
 * @author Sylvain
 *
 */
@Tag("Integration-test")
@SpringBootTest
//CHECKSTYLE.OFF: AbbreviationAsWordInNameCheck 
//IT should be part of the class name
public class WebApplicationIT {
  // CHECKSTYLE.ON: AbbreviationAsWordInNameCheck

  /**
   * The application context should load.
   */
  @Test
  void contextLoads() {
    // nothing to do
    assertTrue(true);
  }

}
