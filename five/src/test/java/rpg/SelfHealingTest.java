package rpg;

import java.io.IOException;
import java.net.URISyntaxException;
import org.junit.jupiter.api.Test;

class SelfHealingTest extends BaseRPGTest {
    @Test
    void testSelfHealing() throws URISyntaxException, IOException {
        testRPG("self-healing");
    }
}
