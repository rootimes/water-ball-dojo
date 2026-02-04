package feature;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import httpclient.Handlers.FakeHttpClient;
import httpclient.Handlers.Support.BlackListHandler;
import httpclient.HttpClient;
import httpclient.HttpHandler;
import httpclient.HttpRequest;
import httpclient.Main;

public class BlackListTest {

    private BlackListHandler blackListHandler;
    private Set<String> blacklist;
    private HttpClient client;

    @BeforeEach
    void setUp() throws IOException, URISyntaxException {
        final String blacklistPath = "src/test/resource/blacklist.in";

        blacklist = Main.loadBlacklist(blacklistPath);

        HttpHandler nextHandler = new FakeHttpClient();
        blackListHandler = new BlackListHandler(blacklist, nextHandler);
        client = new HttpClient();
    }

    @Test
    @DisplayName("Should throw RuntimeException when host is blacklisted from file")
    void shouldThrowExceptionWhenHostIsBlacklistedFromFile() {
        HttpRequest request = new HttpRequest("https://badhost1.com/test");

        assertThrows(RuntimeException.class, () -> {
            client.get(request, blackListHandler);
        });
    }

    @Test
    @DisplayName("Should pass to next handler when host and target are not blacklisted")
    void shouldPassToNextHandlerWhenNotBlacklisted() {
        HttpRequest request = new HttpRequest("https://waterballsa.tw/test");

        assertDoesNotThrow(() -> {
            client.get(request, blackListHandler);
        });
    }
}
