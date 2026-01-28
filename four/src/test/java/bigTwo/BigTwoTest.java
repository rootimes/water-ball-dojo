package bigTwo;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

import bigTwo.game.BigTwo;

class BigTwoTest {

	@Test
	void testAlwaysPlayFirstCard() throws Exception {
		runTestCase("always-play-first-card.in", "always-play-first-card.out");
	}

	@Test
	void testFullhouse() throws Exception {
		runTestCase("fullhouse.in", "fullhouse.out");
	}

	@Test
	void testIllegalActions() throws Exception {
		runTestCase("illegal-actions.in", "illegal-actions.out");
	}

	@Test
	void testNormalNoErrorPlay1() throws Exception {
		runTestCase("normal-no-error-play1.in", "normal-no-error-play1.out");
	}

	@Test
	void testNormalNoErrorPlay2() throws Exception {
		runTestCase("normal-no-error-play2.in", "normal-no-error-play2.out");
	}

	@Test
	void testStraight() throws Exception {
		runTestCase("straight.in", "straight.out");
	}

	private void runTestCase(String inputFile, String expectedFile) throws Exception {
		// 讀取測試資料
		String input = readResource(inputFile);
		String expected = readResource(expectedFile);

		// 重導向 System.in 和 System.out
		InputStream originalIn = System.in;
		PrintStream originalOut = System.out;
		PrintStream originalErr = System.err;

		ByteArrayInputStream testIn = new ByteArrayInputStream(input.getBytes("UTF-8"));
		ByteArrayOutputStream testOut = new ByteArrayOutputStream();

		System.setIn(testIn);
		System.setOut(new PrintStream(testOut, true, "UTF-8"));

		try {
			// 執行遊戲（測試模式）
			BigTwo game = new BigTwo(false);
			game.start();
			game.end();

			// 比對輸出（統一行尾符號為 \n）
			String actual = testOut.toString("UTF-8").replace("\r\n", "\n");
			expected = expected.replace("\r\n", "\n");

			assertEquals(expected, actual);
		} finally {
			System.setIn(originalIn);
			System.setOut(originalOut);
			System.setErr(originalErr);
		}
	}

	private String readResource(String filename) throws Exception {
		java.net.URL url = getClass().getClassLoader().getResource(filename);
		if (url == null) {
			throw new RuntimeException("找不到測試檔案: " + filename);
		}
		return Files.readString(Paths.get(url.toURI()));
	}
}
