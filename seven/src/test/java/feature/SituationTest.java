package feature;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import httpclient.Handlers.FakeHttpClient;
import httpclient.Handlers.Support.*;
import httpclient.HttpClient;
import httpclient.HttpHandler;
import httpclient.HttpRequest;
import httpclient.Main;
import httpclient.Pool;

public class SituationTest {
    private Set<String> blacklist;
    private HttpClient client;
    private Map<String, Pool> hosts;

    @BeforeEach
    void setUp() {
        final String blacklistPath = "src/test/resource/blacklist.in";

        blacklist = Main.loadBlacklist(blacklistPath);
        hosts = Main.loadHostsConfig("src/test/resource/config.in");

        client = new HttpClient();
    }

    @Test
    @DisplayName("Should handle requests with blacklist,load balancing and service discovery")
    void shouldHandleRequestsWithBlacklistLoadBalancingAndServiceDiscovery() {

        HttpHandler Handlers = new BlackListHandler(blacklist,
                new LoadBalancingHandler(hosts,
                        new ServiceDiscoveryHandler(hosts,
                                new FakeHttpClient())));

        HttpRequest request = new HttpRequest("https://waterballsa.tw/test");

        client.get(request, Handlers);

        assertEquals("35.21.35.18", request.getTarget());
    }

    @Test
    @DisplayName("Should handle requests service discovery , load balancing and blacklist")
    void shouldHandleRequestsServiceDiscoveryLoadBalancingAndBlacklist() {

        HttpHandler Handlers = new ServiceDiscoveryHandler(hosts,
                new LoadBalancingHandler(hosts,
                        new BlackListHandler(blacklist,
                                new FakeHttpClient())));

        HttpRequest request = new HttpRequest("https://waterballsa.tw/test");

        client.get(request, Handlers);

        assertEquals("35.21.35.18", request.getTarget());
    }
}
