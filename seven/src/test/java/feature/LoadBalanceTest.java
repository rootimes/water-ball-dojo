package feature;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import httpclient.Handlers.FakeHttpClient;
import httpclient.Handlers.Support.LoadBalancingHandler;
import httpclient.Handlers.Support.ServiceDiscoveryHandler;
import httpclient.HttpClient;
import httpclient.HttpHandler;
import httpclient.HttpRequest;
import httpclient.Main;
import httpclient.Pool;

public class LoadBalanceTest {

    private LoadBalancingHandler loadBalancingHandler;
    private HttpClient client;
    private Map<String, Pool> hosts;

    @BeforeEach
    void setUp() {
        final String configPath = "src/test/resource/config.in";

        hosts = Main.loadHostsConfig(configPath);

        HttpHandler nextHandler = new FakeHttpClient();

        loadBalancingHandler = new LoadBalancingHandler(hosts, nextHandler);

        client = new HttpClient();
    }

    @Test
    @DisplayName("Should load balance requests across available IPs")
    void shouldLoadBalanceRequestsAcrossAvailableIPs() {

        HttpHandler Handlers = new ServiceDiscoveryHandler(hosts,
                loadBalancingHandler);

        HttpRequest request1 = new HttpRequest("https://waterballsa.tw/test");
        HttpRequest request2 = new HttpRequest("https://waterballsa.tw/test");
        HttpRequest request3 = new HttpRequest("https://waterballsa.tw/test");
        HttpRequest request4 = new HttpRequest("https://waterballsa.tw/test");

        client.get(request1, Handlers);
        client.get(request2, Handlers);
        client.get(request3, Handlers);
        client.get(request4, Handlers);

        assertEquals("35.21.35.18", request1.getTarget());
        assertEquals("35.21.35.19", request2.getTarget());
        assertEquals("35.21.35.20", request3.getTarget());
        assertEquals("35.21.35.18", request4.getTarget());
    }

    @Test
    @DisplayName("Should pass request to next handler if host not configured")
    void shouldReturnOriginalHostIfNotEnabledIp() {
        HttpRequest request = new HttpRequest("https://waterballsa.tw/test");
        client.get(request, loadBalancingHandler);
        assertEquals("waterballsa.tw", request.getTarget());
    }
}