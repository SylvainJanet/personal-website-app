package fr.sylvainjanet.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.sylvainjanet.app.dtos.StringDto;
import fr.sylvainjanet.app.entities.TextLanguage;
import fr.sylvainjanet.app.services.LocalizedStringServiceImpl;

/**
 * Controller for the LocalizedString entity.
 * 
 * @author Sylvain
 *
 */
@Controller
public class LocalizedStringController {

  /**
   * Entity service.
   */
  @Autowired
  private LocalizedStringServiceImpl service;

  /**
   * Get text for a selector in a language.
   * 
   * @param selector the selector
   * @param language the language
   * @return the text
   */
  @GetMapping(value = "/text", produces = "application/json")
  ResponseEntity<StringDto> getText(
      @RequestParam(required = true) final String selector,
      @RequestParam(required = true) final TextLanguage language) {
    String message = service.getText(selector, language);
    return new ResponseEntity<>(new StringDto(message), HttpStatus.OK);
  }

}
