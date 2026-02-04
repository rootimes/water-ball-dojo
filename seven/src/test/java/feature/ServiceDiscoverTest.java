package feature;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import httpclient.Handlers.FakeHttpClient;
import httpclient.Handlers.Support.ServiceDiscoveryHandler;
import httpclient.HttpClient;
import httpclient.HttpHandler;
import httpclient.HttpRequest;
import httpclient.Main;
import httpclient.Pool;

public class ServiceDiscoverTest {
    private ServiceDiscoveryHandler serviceDiscoveryHandler;
    private HttpClient client;
    private Map<String, Pool> hosts;

    @BeforeEach
    void setUp() {
        final String configPath = "src/test/resource/config.in";

        hosts = Main.loadHostsConfig(configPath);

        HttpHandler nextHandler = new FakeHttpClient();

        serviceDiscoveryHandler = new ServiceDiscoveryHandler(hosts, nextHandler);

        client = new HttpClient();
    }

    @Test
    @DisplayName("Should discover service IPs based on host configuration")
    void shouldDiscoverServiceIPsBasedOnHostConfiguration() {
        HttpRequest request = new HttpRequest("https://waterballsa.tw/test");

        client.get(request, serviceDiscoveryHandler);

        assertEquals("35.21.35.18", request.getTarget());
    }
}