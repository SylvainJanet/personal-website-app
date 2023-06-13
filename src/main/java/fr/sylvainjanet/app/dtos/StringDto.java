package fr.sylvainjanet.app.dtos;

import java.util.Objects;

/**
 * DTO used to send a string.
 * 
 * @author Sylvain
 *
 */
public class StringDto {

  /**
   * The message.
   */
  private String message;

  /**
   * Get message.
   *
   * @return the message
   */
  public String getMessage() {
    return message;
  }

  /**
   * Set message.
   *
   * @param message the message to set
   */
  public void setMessage(final String message) {
    this.message = message;
  }

  /**
   * StringDto constructor with no parameters.
   */
  public StringDto() {
    super();
  }

  /**
   * StringDto constructor.
   * 
   * @param message the message
   */
  public StringDto(final String message) {
    super();
    this.message = message;
  }

  /**
   * Two StringDto are equals iff the message is equal.
   */
  @Override
  public int hashCode() {
    return Objects.hash(message);
  }

  /**
   * Two StringDto are equals iff the message is equal.
   */
  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    StringDto other = (StringDto) obj;
    return Objects.equals(message, other.message);
  }
}
