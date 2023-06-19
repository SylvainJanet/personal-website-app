package fr.sylvainjanet.app.test.dtos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import fr.sylvainjanet.app.dtos.StringDto;

/**
 * Tests the StringDto class.
 * 
 * @author Sylvain
 *
 */
public class StringDtoTest {

  @Test
  @DisplayName("getMessage should return the message")
  void getMessage() {

    final StringDto input = new StringDto();

    // input setup

    final String expectedMessage = "test message";

    input.setMessage(expectedMessage);

    String actualMessage = input.getMessage();

    assertEquals(expectedMessage, actualMessage);
  }

  @Test
  @DisplayName("setMessage should set the message")
  void setMessage() {

    final StringDto input = new StringDto();

    // input setup

    final String expectedMessage = "test message";

    input.setMessage(expectedMessage);

    String actualMessage = input.getMessage();

    assertEquals(expectedMessage, actualMessage);
  }

  @Test
  @DisplayName("Default constructor should instanciate properly")
  void defaultConstructor() {

    final StringDto input = new StringDto();

    String messageExpected = null;

    String messageActual = input.getMessage();

    assertEquals(messageExpected, messageActual);

  }

  @Test
  @DisplayName("Full constructor should instanciate properly")
  void fullConstructor() {

    String messageExpected = "test message";

    final StringDto input = new StringDto(messageExpected);

    String messageActual = input.getMessage();

    assertEquals(messageExpected, messageActual);

  }

  @Test
  @DisplayName("Equals and Hashcode should be true if messages are equal")
  void equalsHashcodeTrue() {

    final StringDto input1 = new StringDto();
    final StringDto input2 = new StringDto();

    // input setup

    final String message1 = "test message";
    final String message2 = "test message";

    input1.setMessage(message1);
    input2.setMessage(message2);

    assertEquals(input1, input2);
    assertEquals(input1.hashCode(), input2.hashCode());

  }

  @Test
  @DisplayName("Equals and Hashcode should be false if messages "
      + "are different or objects are different")
  void equalsHashcodeFalse() {

    final StringDto input1 = new StringDto();
    final StringDto input2 = new StringDto();

    // input setup

    final String message1 = "test message 1";
    final String message2 = "test message 2";

    input1.setMessage(message1);
    input2.setMessage(message2);

    assertNotEquals(input1, input2);
    assertNotEquals(input1.hashCode(), input2.hashCode());

    @SuppressWarnings("unlikely-arg-type")
    boolean actual = input1.equals(new String());
    assertFalse(actual);

    actual = input1.equals(null);
    assertFalse(actual);
  }

  @Test
  @DisplayName("Equals and Hashcode should be reflexive")
  void equalsHashcodeReflexive() {

    final StringDto input = new StringDto();

    // input setup

    final String message = "test message";

    input.setMessage(message);

    assertEquals(input, input);
    assertEquals(input.hashCode(), input.hashCode());
  }

  @Test
  @DisplayName("Equals and Hashcode should be symmetric")
  void equalsHashcodeSymmetric() {

    final StringDto input1 = new StringDto();
    final StringDto input2 = new StringDto();

    // input setup

    final String message1 = "test message 1";
    final String message2 = "test message 2";

    input1.setMessage(message1);
    input2.setMessage(message2);

    assertNotEquals(input1, input2);
    assertNotEquals(input2, input1);
    assertNotEquals(input1.hashCode(), input2.hashCode());
    assertNotEquals(input2.hashCode(), input1.hashCode());

    input1.setMessage(message1);
    input2.setMessage(message1);

    assertEquals(input1, input2);
    assertEquals(input2, input1);
    assertEquals(input1.hashCode(), input2.hashCode());
    assertEquals(input2.hashCode(), input1.hashCode());
  }

  @Test
  @DisplayName("Equals and Hashcode should be transitive")
  void equalsHashcodeTransitive() {

    final StringDto input1 = new StringDto();
    final StringDto input2 = new StringDto();
    final StringDto input3 = new StringDto();

    // input setup

    final String message1 = "test message";
    final String message2 = "test message";
    final String message3 = "test message";

    input1.setMessage(message1);
    input2.setMessage(message2);
    input3.setMessage(message3);

    assertEquals(input1, input2);
    assertEquals(input2, input3);
    assertEquals(input1, input3);
    assertEquals(input1.hashCode(), input2.hashCode());
    assertEquals(input2.hashCode(), input3.hashCode());
    assertEquals(input1.hashCode(), input3.hashCode());
  }

  @Test
  @DisplayName("toString should return a proper representation of the dto")
  void toStringTest() {

    final StringDto input = new StringDto();

    // input setup

    final String message = "test message";

    input.setMessage(message);

    String expected =
        "StringDto\r\n" + "[\r\n\tmessage = test message\r\n" + "]";
    String actual = input.toString();

    assertEquals(expected, actual);
  }
}
