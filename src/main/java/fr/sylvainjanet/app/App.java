package fr.sylvainjanet.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Main App.
 *
 * @author Sylvain Janet
 *
 */
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
   * Version from app.version. Uses the ConfigurationProperties annotation
   * to bind the property and avoid warnings in .properties file
   */
  private String version;

  /**
   * Get the current environment. Corresponds to the current maven profile.
   * 
   * <p>Can be : dev, staging, prod for different stages of development.
   * Can be coverage-dev, coverage-staging, or coverage-prod during test
   * coverage computation. Can be depGraph during dependency graph
   * computation.
   * 
   * @return the environment
   */
  public String getEnvironment() {
    return environment;
  }

  /**
   * Set the current environment. Used for property binding by the
   * ConfigurationProperties annotation. Corresponds to the current maven
   * profile.
   * 
   * <p>Can be : dev, staging, prod for different stages of development.
   * Can be coverage-dev, coverage-staging, or coverage-prod during test
   * coverage computation. Can be depGraph during dependency graph
   * computation.
   * 
   * @param environment the profile
   */
  public void setEnvironment(final String environment) {
    this.environment = environment;
  }

  /**
   * Get version.
   *
   * @return the version
   */
  public String getVersion() {
    return version;
  }

  /**
   * Set version. Used for property binding by the ConfigurationProperties
   * annotation.
   *
   * @param version the version to set
   */
  public void setVersion(final String version) {
    this.version = version;
  }

  /**
   * Launch the spring application.
   *
   * @param args args
   */
  public static void main(final String[] args) {
    SpringApplication.run(App.class, args);
  }
}
