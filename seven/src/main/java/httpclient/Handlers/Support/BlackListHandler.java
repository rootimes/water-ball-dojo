package httpclient.Handlers.Support;

import httpclient.HttpRequest;
import httpclient.Handlers.SupportHandler;
import httpclient.HttpHandler;
import java.util.Set;

public class BlackListHandler extends SupportHandler<Set<String>> {
    public BlackListHandler(Set<String> hosts, HttpHandler next) {
        super(hosts, next);
    }

    @Override
    public HttpRequest handle(HttpRequest request) {
        return request;
    }
}
