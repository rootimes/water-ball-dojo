package httpclient.Handlers;

import httpclient.HttpHandler;
import httpclient.HttpRequest;

public class FakeHttpClient implements HttpHandler {
    @Override
    public HttpRequest handle(HttpRequest request) {
        System.out.println("FakeHttpClient handling request: " + request.getTargetUrl());

        request.setStatus("200");
        return request;
    }
}
