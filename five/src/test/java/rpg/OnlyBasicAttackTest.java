package rpg;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;

class OnlyBasicAttackTest extends BaseRPGTest {
  @Test
  void testOnlyBasicAttack() throws URISyntaxException, IOException {
    testRPG("only-basic-attack");
  }
}
