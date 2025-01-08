package doit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

class Problem11720Test {

  @Test
  public void testProblem01() throws Exception {

    // Given
    String input = "1\n1\n";
    ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream out = new ByteArrayOutputStream();
    System.setOut(new PrintStream(out));

    // When
    Problem11720.main(new String[]{});

    // Then
    String expectedOutput = "1";
    assertEquals(expectedOutput, out.toString().trim());
  }

  @Test
  public void testProblem02() throws Exception {

    // Given
    String input = "5\n54321\n";
    ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream out = new ByteArrayOutputStream();
    System.setOut(new PrintStream(out));

    // When
    Problem11720.main(new String[]{});

    // Then
    String expectedOutput = "15";
    assertEquals(expectedOutput, out.toString().trim());
  }

  @Test
  public void testProblem03() throws Exception {

    // Given
    String input = "25\n7000000000000000000000000\n";
    ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream out = new ByteArrayOutputStream();
    System.setOut(new PrintStream(out));

    // When
    Problem11720.main(new String[]{});

    // Then
    String expectedOutput = "7";
    assertEquals(expectedOutput, out.toString().trim());
  }

  @Test
  public void testProblem04() throws Exception {

    // Given
    String input = "11\n10987654321\n";
    ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream out = new ByteArrayOutputStream();
    System.setOut(new PrintStream(out));

    // When
    Problem11720.main(new String[]{});

    // Then
    String expectedOutput = "46";
    assertEquals(expectedOutput, out.toString().trim());
  }
}
