package fr.sylvainjanet.app.test;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Test the webapp global behaviour.
 *
 * @author Sylvain
 *
 */
@SpringBootTest
class WebApplicationTests {

  /**
   * The application context should load.
   */
  @Test
  void contextLoads() {
    // nothing to do
    assertTrue(true);
  }

}
