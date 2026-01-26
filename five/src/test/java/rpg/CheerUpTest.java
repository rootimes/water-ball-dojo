package rpg;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;

class CheerUpTest extends BaseRPGTest {
  @Test
  void testCheerUp() throws URISyntaxException, IOException {
    testRPG("cheerup");
  }
}
