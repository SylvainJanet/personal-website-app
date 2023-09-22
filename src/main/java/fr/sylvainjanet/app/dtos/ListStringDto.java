package fr.sylvainjanet.app.dtos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * DTO used to send a list of strings.
 * 
 * @author Sylvain
 * 
 */
public class ListStringDto {

  /**
   * The messages.
   */
  private List<String> messages;

  /**
   * Get messages.
   *
   * @return the messages
   */
  public List<String> getMessages() {
    return messages;
  }

  /**
   * Set messages.
   *
   * @param messages the messages to set
   */
  public void setMessages(final List<String> messages) {
    this.messages = messages;
  }

  /**
   * ListStringDto constructor with no parameters.
   */
  public ListStringDto() {
    super();
    this.messages = new ArrayList<>();
  }

  /**
   * ListStringDto constructor.
   * 
   * @param messages the messages
   */
  public ListStringDto(final List<String> messages) {
    super();
    this.messages = messages;
  }

  /**
   * Two ListStringDto are equals iff the message is equal.
   */
  @Override
  public int hashCode() {
    return Objects.hash(messages);
  }

  /**
   * Two ListStringDto are equals iff the message is equal.
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
    ListStringDto other = (ListStringDto) obj;
    return Objects.equals(messages, other.messages);
  }

  /**
   * To String method.
   */
  @Override
  public String toString() {
    return "ListStringDto\r\n[\r\n\tmessages = " + messages + "\r\n]";
  }

}
