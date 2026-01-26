package rpg;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;

class OnePunchTest extends BaseRPGTest {
  @Test
  void testOnePunch() throws URISyntaxException, IOException {
    testRPG("one-punch");
  }
}
