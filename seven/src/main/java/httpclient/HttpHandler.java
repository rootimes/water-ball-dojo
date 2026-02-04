package httpclient;

public interface HttpHandler {
    public HttpRequest handle(HttpRequest request);
}
