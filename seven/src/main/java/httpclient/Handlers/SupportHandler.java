package httpclient.Handlers;

import httpclient.HttpHandler;
import httpclient.HttpRequest;

public abstract class SupportHandler implements HttpHandler {
    @Override
    public abstract HttpRequest handle(HttpRequest request);
}
