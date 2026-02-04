package httpclient.Handlers.Support;

import httpclient.HttpRequest;
import httpclient.Pool;
import httpclient.Handlers.SupportHandler;

import java.util.Map;

import httpclient.HttpHandler;

public class LoadBalancingHandler extends SupportHandler<Map<String, Pool>> {
    public LoadBalancingHandler(Map<String, Pool> hosts, HttpHandler next) {
        super(hosts, next);
    }

    @Override
    public HttpRequest handle(HttpRequest request) {
        return request;
    }
}
