package rpg;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;

class SummonTest extends BaseRPGTest {
  @Test
  void testSummon() throws URISyntaxException, IOException {
    testRPG("summon");
  }
}
