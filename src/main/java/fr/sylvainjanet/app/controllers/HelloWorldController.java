package fr.sylvainjanet.app.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.sylvainjanet.app.dtos.StringDto;

/**
 * Controller for Hello World.
 * 
 * @author Sylvain
 *
 */
@Controller
public class HelloWorldController {

  /**
   * Current environment.
   */
  @Value("${app.environment}")
  private String environment;

  /**
   * Current version.
   */
  @Value("${app.version}")
  private String version;

  /**
   * Get mapping used for basic testing of the app functionality : the API
   * Hello world.
   *
   * @return hello
   */
  @GetMapping("/hello")
  @ResponseBody
  ResponseEntity<StringDto> home() {
    return new ResponseEntity<>(
        new StringDto("Hello World ! - " + environment + " - v" + version),
        HttpStatus.OK);
  }

  /**
   * Put mapping used for basic testing of the app functionality : the API
   * Hello world.
   *
   * @return hello
   */
  @PutMapping("/hello")
  @ResponseBody
  ResponseEntity<StringDto> putHome() {
    return new ResponseEntity<>(
        new StringDto(
            "Method PUT not allowed - " + environment + " - v" + version),
        HttpStatus.METHOD_NOT_ALLOWED);
  }
}
