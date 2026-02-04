package httpclient;

import httpclient.Handlers.Support.BlackListHandler;
import httpclient.Handlers.Support.LoadBalancingHandler;
import httpclient.Handlers.Support.ServiceDiscoveryHandler;
import httpclient.Handlers.FakeHttpClient;

public class Main {
    public static void main(String[] args) {
        HttpClient client = new HttpClient();

        HttpRequest request = new HttpRequest("http://example.com/api/test");

        HttpHandler handlers = new ServiceDiscoveryHandler(
                new LoadBalancingHandler(
                        new BlackListHandler(
                                new FakeHttpClient())));

        client.get(request, handlers);
    }
}
