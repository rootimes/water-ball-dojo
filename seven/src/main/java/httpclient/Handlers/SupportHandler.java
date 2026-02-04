package httpclient.Handlers;

import httpclient.HttpHandler;
import httpclient.HttpRequest;

public abstract class SupportHandler implements HttpHandler {
    protected HttpHandler next;

    public SupportHandler(HttpHandler next) {
        this.next = next;
    }

    @Override
    public abstract HttpRequest handle(HttpRequest request);
}
