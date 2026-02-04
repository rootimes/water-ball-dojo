package httpclient.Handlers.Support;

import httpclient.HttpRequest;
import httpclient.Handlers.SupportHandler;

public class BlackListHandler extends SupportHandler {
    @Override
    public HttpRequest handle(HttpRequest request) {
        return request;
    }
}
