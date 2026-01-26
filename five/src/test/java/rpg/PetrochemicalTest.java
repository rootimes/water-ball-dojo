package rpg;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;

class PetrochemicalTest extends BaseRPGTest {
  @Test
  void testPetrochemical() throws URISyntaxException, IOException {
    testRPG("petrochemical");
  }
}
