package httpclient.Handlers.Support;

import httpclient.HttpRequest;
import httpclient.Handlers.SupportHandler;
import httpclient.HttpHandler;

public class ServiceDiscoveryHandler extends SupportHandler {
    public ServiceDiscoveryHandler(HttpHandler next) {
        super(next);
    }

    @Override
    public HttpRequest handle(HttpRequest request) {
        return request;
    }
}
