package rpg;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;

class PoisonTest extends BaseRPGTest {
	@Test
	void testPoison() throws URISyntaxException, IOException {
		testRPG("poison");
	}
}
