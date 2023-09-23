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

  /**
   * getMessage should return the message.
   */
  @Test
  @DisplayName("getMessage should return the message")
  void getMessage() {

    final StringDto input = new StringDto();

    // input setup

    final String expectedMessage = "test message";

    input.setMessage(expectedMessage);

    final String actualMessage = input.getMessage();

    assertEquals(expectedMessage, actualMessage,
        "getMessage should return the message");
  }

  /**
   * setMessage should set the message.
   */
  @Test
  @DisplayName("setMessage should set the message")
  void setMessage() {

    final StringDto input = new StringDto();

    // input setup

    final String expectedMessage = "test message";

    input.setMessage(expectedMessage);

    final String actualMessage = input.getMessage();

    assertEquals(expectedMessage, actualMessage,
        "setMessage should set the message");
  }

  /**
   * Default constructor should instanciate properly.
   */
  @Test
  @DisplayName("Default constructor should instanciate properly")
  void defaultConstructor() {

    final StringDto input = new StringDto();

    final String messageExpected = null;

    final String messageActual = input.getMessage();

    assertEquals(messageExpected, messageActual, "message should be set");

  }

  /**
   * Full constructor should instanciate properly.
   */
  @Test
  @DisplayName("Full constructor should instanciate properly")
  void fullConstructor() {

    final String messageExpected = "test message";

    final StringDto input = new StringDto(messageExpected);

    final String messageActual = input.getMessage();

    assertEquals(messageExpected, messageActual, "message should be set");

  }

  /**
   * Equals and Hashcode should be true if messages are equal.
   */
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

    assertEquals(input1, input2,
        "Equals should be true if messages are equal");
    assertEquals(input1.hashCode(), input2.hashCode(),
        "Hashcode should be true if messages are equal");

  }

  /**
   * Equals and Hashcode should be false if messages are different or
   * objects are different.
   */
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

    assertNotEquals(input1, input2,
        "Equals should be false if messages are different");
    assertNotEquals(input1.hashCode(), input2.hashCode(),
        "Hashcode should be false if messages are different");

    @SuppressWarnings("unlikely-arg-type")
    final boolean actualNotSameType = input1.equals(new String());
    assertFalse(actualNotSameType,
        "Equals should be false if other object is of another type");

    final boolean actualNull = input1.equals(null);
    assertFalse(actualNull,
        "Equals should be false if other object is null");
  }

  /**
   * Equals and Hashcode should be reflexive.
   */
  @Test
  @DisplayName("Equals and Hashcode should be reflexive")
  void equalsHashcodeReflexive() {

    final StringDto input = new StringDto();

    // input setup

    final String message = "test message";

    input.setMessage(message);

    assertEquals(input, input, "Equals should be reflexive");
    assertEquals(input.hashCode(), input.hashCode(),
        "Hashcode should be reflexive");
  }

  /**
   * Equals and Hashcode should be symmetric.
   */
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

    assertNotEquals(input1, input2,
        "Equals should be symmetric (1 - different)");
    assertNotEquals(input2, input1,
        "Equals should be symmetric (2 - different)");
    assertNotEquals(input1.hashCode(), input2.hashCode(),
        "Hashcode should be symmetric (1 - different)");
    assertNotEquals(input2.hashCode(), input1.hashCode(),
        "Hashcode should be symmetric (2 - different)");

    input1.setMessage(message1);
    input2.setMessage(message1);

    assertEquals(input1, input2, "Equals should be symmetric (1 - same)");
    assertEquals(input2, input1, "Equals should be symmetric (2 - same)");
    assertEquals(input1.hashCode(), input2.hashCode(),
        "Hashcode should be symmetric (1 - different)");
    assertEquals(input2.hashCode(), input1.hashCode(),
        "Hashcode should be symmetric (2 - different)");
  }

  /**
   * Equals and Hashcode should be transitive.
   */
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

    assertEquals(input1, input2, "Equals should be transitive - 1");
    assertEquals(input2, input3, "Equals should be transitive - 2");
    assertEquals(input1, input3, "Equals should be transitive - 3");
    assertEquals(input1.hashCode(), input2.hashCode(),
        "Hashcode should be transitive - 1");
    assertEquals(input2.hashCode(), input3.hashCode(),
        "Hashcode should be transitive - 2");
    assertEquals(input1.hashCode(), input3.hashCode(),
        "Hashcode should be transitive - 3");
  }

  /**
   * toString should return a proper representation of the dto.
   */
  @Test
  @DisplayName("toString should return a proper representation of the dto")
  void toStringTest() {

    final StringDto input = new StringDto();

    // input setup

    final String message = "test message";

    input.setMessage(message);

    final String expected =
        "StringDto\r\n" + "[\r\n\tmessage = test message\r\n" + "]";
    final String actual = input.toString();

    assertEquals(expected, actual,
        "toString should return a proper representation of the dto");
  }
}
