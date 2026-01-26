package rpg;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;

class SelfExplosionTest extends BaseRPGTest {
  @Test
  void testSelfExplosion() throws URISyntaxException, IOException {
    testRPG("self-explosion");
  }
}
