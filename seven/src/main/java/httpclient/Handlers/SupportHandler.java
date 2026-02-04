package httpclient.Handlers;

import httpclient.HttpHandler;
import httpclient.HttpRequest;

public abstract class SupportHandler<T> implements HttpHandler {
    protected HttpHandler next;

    protected T hosts;

    public SupportHandler(T hosts, HttpHandler next) {
        this.next = next;
        this.hosts = hosts;
    }

    @Override
    public abstract void handle(HttpRequest request);
}
