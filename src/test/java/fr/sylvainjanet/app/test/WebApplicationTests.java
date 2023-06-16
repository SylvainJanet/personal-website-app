package fr.sylvainjanet.app.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Test the webapp global behaviour.
 *
 * @author Sylvain
 *
 */
@SpringBootTest
public class WebApplicationTests {

  /**
   * The application context should load.
   */
  @Test
  void contextLoads() {
    // nothing to do
    assertTrue(true);
  }

}
