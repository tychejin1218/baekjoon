package doit;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

class Problem1546Test {

  @Test
  public void testProblem01() throws Exception {

    // Given
    String input = "4\n40 80 60\n";
    ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream out = new ByteArrayOutputStream();
    System.setOut(new PrintStream(out));

    // When
    Problem1546.main(new String[]{});

    // Then
    String expectedOutput = "75.0";
    assertEquals(expectedOutput, out.toString().trim());
  }

  @Test
  public void testProblem02() throws Exception {

    // Given
    String input = "3\n10 20 30\n";
    ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream out = new ByteArrayOutputStream();
    System.setOut(new PrintStream(out));

    // When
    Problem1546.main(new String[]{});

    // Then
    String expectedOutput = "66.666667";
    assertEquals(expectedOutput, out.toString().trim());
  }

  @Test
  public void testProblem03() throws Exception {

    // Given
    String input = "4\n1 100 100 100\n";
    ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream out = new ByteArrayOutputStream();
    System.setOut(new PrintStream(out));

    // When
    Problem1546.main(new String[]{});

    // Then
    String expectedOutput = "75.25";
    assertEquals(expectedOutput, out.toString().trim());
  }

  @Test
  public void testProblem04() throws Exception {

    // Given
    String input = "5\n1 2 4 8 16\n";
    ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream out = new ByteArrayOutputStream();
    System.setOut(new PrintStream(out));

    // When
    Problem1546.main(new String[]{});

    // Then
    String expectedOutput = "38.75";
    assertEquals(expectedOutput, out.toString().trim());
  }

  @Test
  public void testProblem05() throws Exception {

    // Given
    String input = "2\n3 10\n";
    ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream out = new ByteArrayOutputStream();
    System.setOut(new PrintStream(out));

    // When
    Problem1546.main(new String[]{});

    // Then
    String expectedOutput = "65.0";
    assertEquals(expectedOutput, out.toString().trim());
  }

  @Test
  public void testProblem06() throws Exception {

    // Given
    String input = "4\n10 20 0 100\n";
    ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream out = new ByteArrayOutputStream();
    System.setOut(new PrintStream(out));

    // When
    Problem1546.main(new String[]{});

    // Then
    String expectedOutput = "32.5";
    assertEquals(expectedOutput, out.toString().trim());
  }

  @Test
  public void testProblem07() throws Exception {

    // Given
    String input = "1\n50\n";
    ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream out = new ByteArrayOutputStream();
    System.setOut(new PrintStream(out));

    // When
    Problem1546.main(new String[]{});

    // Then
    String expectedOutput = "100.0";
    assertEquals(expectedOutput, out.toString().trim());
  }

  @Test
  public void testProblem08() throws Exception {

    // Given
    String input = "9\n10 20 30 40 50 60 70 80 90\n";
    ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream out = new ByteArrayOutputStream();
    System.setOut(new PrintStream(out));

    // When
    Problem1546.main(new String[]{});

    // Then
    String expectedOutput = "55.55555555555556";
    assertEquals(expectedOutput, out.toString().trim());
  }
}
