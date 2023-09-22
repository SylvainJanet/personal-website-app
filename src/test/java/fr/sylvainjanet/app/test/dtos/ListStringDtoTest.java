package fr.sylvainjanet.app.test.dtos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import fr.sylvainjanet.app.dtos.ListStringDto;

/**
 * Tests the ListStringDto class.
 * 
 * @author Sylvain
 *
 */
public class ListStringDtoTest {

  /**
   * getMessages should return the messages.
   */
  @Test
  @DisplayName("getMessages should return the messages")
  void getMessages() {

    final ListStringDto input = new ListStringDto();

    // input setup

    final List<String> expectedMessages = new ArrayList<String>(
        Arrays.asList("test message", "other test message"));

    input.setMessages(expectedMessages);

    final List<String> actualMessages = input.getMessages();

    assertEquals(expectedMessages, actualMessages);
  }

  /**
   * setMessages should set the messages.
   */
  @Test
  @DisplayName("setMessages should set the messages")
  void setMessage() {

    final ListStringDto input = new ListStringDto();

    // input setup

    final List<String> expectedMessages = new ArrayList<String>(
        Arrays.asList("test message", "other test message"));

    input.setMessages(expectedMessages);

    final List<String> actualMessages = input.getMessages();

    assertEquals(expectedMessages, actualMessages);
  }

  /**
   * Default constructor should instanciate properly.
   */
  @Test
  @DisplayName("Default constructor should instanciate properly")
  void defaultConstructor() {

    final ListStringDto input = new ListStringDto();

    final List<String> actualMessages = input.getMessages();

    assertNotNull(actualMessages);
    assertEquals(0, actualMessages.size());

  }

  /**
   * Full constructor should instanciate properly.
   */
  @Test
  @DisplayName("Full constructor should instanciate properly")
  void fullConstructor() {

    final List<String> expectedMessages = new ArrayList<String>(
        Arrays.asList("test message", "other test message"));

    final ListStringDto input = new ListStringDto(expectedMessages);

    final List<String> actualMessages = input.getMessages();

    assertEquals(expectedMessages, actualMessages);

  }

  /**
   * Equals and Hashcode should be true if messages are equal.
   */
  @Test
  @DisplayName("Equals and Hashcode should be true if messages are equal")
  void equalsHashcodeTrue() {

    final ListStringDto input1 = new ListStringDto();
    final ListStringDto input2 = new ListStringDto();

    // input setup

    final List<String> messages1 = new ArrayList<String>(
        Arrays.asList("test message", "other test message"));
    final List<String> messages2 = new ArrayList<String>(
        Arrays.asList("test message", "other test message"));

    input1.setMessages(messages1);
    input2.setMessages(messages2);

    assertEquals(input1, input2);
    assertEquals(input1.hashCode(), input2.hashCode());

  }

  /**
   * Equals and Hashcode should be false if messages are different or
   * objects are different.
   */
  @Test
  @DisplayName("Equals and Hashcode should be false if messages "
      + "are different or objects are different")
  void equalsHashcodeFalse() {

    final ListStringDto input1 = new ListStringDto();
    final ListStringDto input2 = new ListStringDto();

    // input setup

    final List<String> messages1 = new ArrayList<String>(
        Arrays.asList("test message 1", "other test message"));
    final List<String> messages2 = new ArrayList<String>(
        Arrays.asList("test message 2", "other test message"));

    input1.setMessages(messages1);
    input2.setMessages(messages2);

    assertNotEquals(input1, input2);
    assertNotEquals(input1.hashCode(), input2.hashCode());

    @SuppressWarnings("unlikely-arg-type")
    final boolean actualNotSameType = input1.equals(new String());
    assertFalse(actualNotSameType);

    final boolean actualNull = input1.equals(null);
    assertFalse(actualNull);
  }

  /**
   * Equals and Hashcode should be reflexive.
   */
  @Test
  @DisplayName("Equals and Hashcode should be reflexive")
  void equalsHashcodeReflexive() {

    final ListStringDto input = new ListStringDto();

    // input setup

    final List<String> messages = new ArrayList<String>(
        Arrays.asList("test message 1", "other test message"));

    input.setMessages(messages);

    assertEquals(input, input);
    assertEquals(input.hashCode(), input.hashCode());
  }

  /**
   * Equals and Hashcode should be symmetric.
   */
  @Test
  @DisplayName("Equals and Hashcode should be symmetric")
  void equalsHashcodeSymmetric() {

    final ListStringDto input1 = new ListStringDto();
    final ListStringDto input2 = new ListStringDto();

    // input setup

    final List<String> messages1 = new ArrayList<String>(
        Arrays.asList("test message 1", "other test message"));
    final List<String> messages2 = new ArrayList<String>(
        Arrays.asList("test message 2", "other test message"));

    input1.setMessages(messages1);
    input2.setMessages(messages2);

    assertNotEquals(input1, input2);
    assertNotEquals(input2, input1);
    assertNotEquals(input1.hashCode(), input2.hashCode());
    assertNotEquals(input2.hashCode(), input1.hashCode());

    input1.setMessages(messages1);
    input2.setMessages(messages1);

    assertEquals(input1, input2);
    assertEquals(input2, input1);
    assertEquals(input1.hashCode(), input2.hashCode());
    assertEquals(input2.hashCode(), input1.hashCode());
  }

  /**
   * Equals and Hashcode should be transitive.
   */
  @Test
  @DisplayName("Equals and Hashcode should be transitive")
  void equalsHashcodeTransitive() {

    final ListStringDto input1 = new ListStringDto();
    final ListStringDto input2 = new ListStringDto();
    final ListStringDto input3 = new ListStringDto();

    // input setup

    final List<String> messages1 = new ArrayList<String>(
        Arrays.asList("test message", "other test message"));
    final List<String> messages2 = new ArrayList<String>(
        Arrays.asList("test message", "other test message"));
    final List<String> messages3 = new ArrayList<String>(
        Arrays.asList("test message", "other test message"));

    input1.setMessages(messages1);
    input2.setMessages(messages2);
    input3.setMessages(messages3);

    assertEquals(input1, input2);
    assertEquals(input2, input3);
    assertEquals(input1, input3);
    assertEquals(input1.hashCode(), input2.hashCode());
    assertEquals(input2.hashCode(), input3.hashCode());
    assertEquals(input1.hashCode(), input3.hashCode());
  }

  /**
   * toString should return a proper representation of the dto.
   */
  @Test
  @DisplayName("toString should return a proper representation of the dto")
  void toStringTest() {

    final ListStringDto input = new ListStringDto();

    // input setup

    final List<String> messages = new ArrayList<String>(
        Arrays.asList("test message", "other test message"));

    input.setMessages(messages);

    final String expected = "ListStringDto\r\n"
        + "[\r\n\tmessages = [test message, other test message]\r\n" + "]";
    final String actual = input.toString();

    assertEquals(expected, actual);
  }
}
