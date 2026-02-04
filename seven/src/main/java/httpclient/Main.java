package httpclient;

import java.util.Map;
import java.util.Set;

import httpclient.Handlers.FakeHttpClient;
import httpclient.Handlers.Support.BlackListHandler;
import httpclient.Handlers.Support.LoadBalancingHandler;
import httpclient.Handlers.Support.ServiceDiscoveryHandler;

public class Main {
    public static void main(String[] args) {
        HttpClient client = new HttpClient();

        HttpRequest request = new HttpRequest("http://example.com/api/test");

        Set<String> blacklistedHosts = Set.of("badhost1.com", "badhost2.com");

        Pool pool = new Pool();

        Map<String, Pool> serviceDiscoveryHosts = Map.of("waterballsa.tw", pool);

        Map<String, Pool> loadBalancingHosts = Map.of("waterballsa.tw", pool);

        HttpHandler handlers = new BlackListHandler(blacklistedHosts,
                new ServiceDiscoveryHandler(serviceDiscoveryHosts,
                        new LoadBalancingHandler(loadBalancingHosts,
                                new FakeHttpClient())));

        client.get(request, handlers);
    }
}
