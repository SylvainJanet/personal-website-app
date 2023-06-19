package fr.sylvainjanet.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.sylvainjanet.app.config.InitialData;
import fr.sylvainjanet.app.dtos.StringDto;
import fr.sylvainjanet.app.entities.LocalizedString;
import fr.sylvainjanet.app.repo.LocalizedStringRepository;

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
   * Get mapping used for basic testing of the app functionality : the API
   * Hello world.
   *
   * @return hello
   */
  @GetMapping("/hello")
  @ResponseBody
  ResponseEntity<StringDto> home() {
    for (LocalizedString ls : InitialData.INIT_LOCALIZED_STRING) {
      repo.save(ls);
    }
    return new ResponseEntity<>(
        new StringDto("Hello World ! - " + environment), HttpStatus.OK);
  }

  /**
   * Temp.
   */
  @Autowired
  // CHECKSTYLE.OFF: VisibilityModifierCheck
  LocalizedStringRepository repo;
  // CHECKSTYLE.ON: VisibilityModifierCheck

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
        new StringDto("Method PUT not allowed - " + environment),
        HttpStatus.METHOD_NOT_ALLOWED);
  }
}
