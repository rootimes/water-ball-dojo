package httpclient.Handlers;

import httpclient.HttpHandler;
import httpclient.HttpRequest;

public class FakeHttpClient implements HttpHandler {
    @Override
    public HttpRequest handle(HttpRequest request) {
        return request;
    }
}
