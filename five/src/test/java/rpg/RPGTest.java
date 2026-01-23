package rpg;

import static java.lang.System.in;
import static java.lang.System.out;
import static java.lang.System.setIn;
import static java.lang.System.setOut;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Paths;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RPGTest {
  private final InputStream originalIn = in;
  private final PrintStream originalOut = out;
  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

  @BeforeEach
  public void setUpStreams() {
    setOut(new PrintStream(outContent, true, StandardCharsets.UTF_8));
  }

  @AfterEach
  public void restoreStreams() {
    setIn(originalIn);
    setOut(originalOut);
  }

  @Test
  void testOnlyBasicAttack() throws URISyntaxException, IOException {
    testRPG("only-basic-attack");
  }

  private void testRPG(String scenario) throws URISyntaxException, IOException {
    // Arrange
    setInputStream(scenario + ".in");
    String expected = getExpectedString(scenario + ".out");

    // Act
    Main.main(new String[0]);
    String actual = outContent.toString(StandardCharsets.UTF_8).replaceAll("\\r\\n", "\\n");

    // Assert
    try {
      Files.write(Paths.get("target/expected.txt"), expected.getBytes(StandardCharsets.UTF_8));
      Files.write(Paths.get("target/actual.txt"), actual.getBytes(StandardCharsets.UTF_8));
    } catch (IOException e) {
      e.printStackTrace();
    }
    assertEquals(expected, actual);
  }

  private void setInputStream(String resourceName) throws URISyntaxException, IOException {
    setIn(
        new ByteArrayInputStream(
            Files.readAllBytes(
                Paths.get(getClass().getClassLoader().getResource(resourceName).toURI()))));
  }

  private String getExpectedString(String resourceName) throws URISyntaxException, IOException {
    return new String(
            Files.readAllBytes(
                Paths.get(getClass().getClassLoader().getResource(resourceName).toURI())),
            StandardCharsets.UTF_8)
        .replaceAll("\\r\\n", "\\n");
  }
}
