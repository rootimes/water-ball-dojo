package httpclient;

public class HttpClient {
    public void get(HttpRequest request, HttpHandler handler) {
        handler.handle(request);
    }
}
