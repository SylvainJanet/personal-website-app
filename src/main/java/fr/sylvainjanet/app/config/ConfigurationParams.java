package fr.sylvainjanet.app.config;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Configuration class. Contains parameters used in the app configuration,
 * such as web security (cors config, csrf config, ...), database
 * restrictions (max property size, ...).
 * 
 * @author Sylvain
 *
 */
public final class ConfigurationParams {

  /**
   * Max string size for DB entities.
   */
  public static final int MAX_STR_SIZE = 50;

  /**
   * Max string very long size for DB entities.
   */
  public static final int MAX_LONG_STR_SIZE = 10000;

  /**
   * Origins allowed in prod environment.
   */
  public static final List<String> ORIGINS_ALLOWED_PROD =
      Collections.unmodifiableList(Arrays.asList("https://sylvainjanet.fr",
          "https://dev.sylvainjanet.fr"));

  /**
   * Origins allowed in dev environment.
   */
  public static final List<String> ORIGINS_ALLOWED_DEV =
      Collections.unmodifiableList(Arrays.asList("http://localhost:4200/",
          "https://dev.sylvainjanet.fr"));

  /**
   * Methods allowed in prod environment.
   */
  public static final List<String> METHODS_ALLOWED_PROD =
      Collections.unmodifiableList(Arrays.asList("GET", "POST", "PUT",
          "DELETE", "OPTIONS", "PATCH", "DELETE"));

  /**
   * Methods allowed in dev environment.
   */
  public static final List<String> METHODS_ALLOWED_DEV =
      METHODS_ALLOWED_PROD;

  /**
   * Headers allowed in prod environment.
   */
  public static final List<String> HEADERS_ALLOWED_PROD =
      Collections.unmodifiableList(Arrays.asList("authorization",
          "content-type", "x-auth-token", "X-XSRF-TOKEN"));

  /**
   * Headers allowed in dev environment.
   */
  public static final List<String> HEADERS_ALLOWED_DEV =
      HEADERS_ALLOWED_PROD;

  /**
   * Exposed headers in prod environment.
   */
  public static final List<String> EXPOSED_HEADERS_PROD = Collections
      .unmodifiableList(Arrays.asList("x-auth-token", "X-XSRF-TOKEN"));

  /**
   * Exposed headers in dev environment.
   */
  public static final List<String> EXPOSED_HEADERS_DEV =
      EXPOSED_HEADERS_PROD;

  /**
   * Max age of preflight cache. https://netbasal.com/
   * reduce-response-latency-by-caching-preflight-requests-2c450b6f9cb6
   */
  public static final Long MAX_AGE_PREFLIGHT_CACHE = 7200L;

  private ConfigurationParams() {

  }
}
