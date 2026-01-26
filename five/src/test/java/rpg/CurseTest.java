package rpg;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;

class CurseTest extends BaseRPGTest {
  @Test
  void testCurse() throws URISyntaxException, IOException {
    testRPG("curse");
  }
}
