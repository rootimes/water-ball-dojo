package httpclient.Handlers.Support;

import httpclient.HttpRequest;
import httpclient.Handlers.SupportHandler;

public class ServiceDiscoveryHandler extends SupportHandler {
    @Override
    public HttpRequest handle(HttpRequest request) {
        return request;
    }
}
