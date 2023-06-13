package fr.sylvainjanet.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.sylvainjanet.app.dtos.StringDto;

/**
 * Main App.
 *
 * @author Sylvain Janet
 *
 */
@Controller
@EnableConfigurationProperties
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@ConfigurationProperties(prefix = "app")
public class App extends SpringBootServletInitializer {

  /**
   * Profile name from app.properties. Uses the ConfigurationProperties
   * annotation to bind the property and avoid warnings in .properties file
   */
  private String environment;

  /**
   * Get the current environment (maven profile).
   * 
   * @return the environment
   */
  public String getEnvironment() {
    return environment;
  }

  /**
   * Set the current environment. Used for property binding by the
   * ConfigurationProperties annotation.
   * 
   * @param environment the profile
   */
  public void setEnvironment(final String environment) {
    this.environment = environment;
  }

  /**
   * Mapping used for basic testing of the app functionality : the API
   * Hello world.
   *
   * @return hello
   */
  @GetMapping("/hello")
  @ResponseBody
  ResponseEntity<StringDto> home() {
    return new ResponseEntity<>(
        new StringDto("Hello World ! - " + environment), HttpStatus.OK);
  }

  /**
   * Launch the spring application.
   *
   * @param args args
   */
  public static void main(final String[] args) {
    SpringApplication.run(App.class, args);
  }

  /**
   * Build the spring application.
   */
  @Override
  protected SpringApplicationBuilder configure(
      final SpringApplicationBuilder builder) {
    return builder.sources(App.class);
  }

}
