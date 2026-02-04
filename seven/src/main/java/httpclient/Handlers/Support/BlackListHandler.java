package httpclient.Handlers.Support;

import java.util.Set;

import httpclient.Handlers.SupportHandler;
import httpclient.HttpHandler;
import httpclient.HttpRequest;

public class BlackListHandler extends SupportHandler<Set<String>> {
    public BlackListHandler(Set<String> hosts, HttpHandler next) {
        super(hosts, next);
    }

    @Override
    public HttpRequest handle(HttpRequest request) {

        if (hosts.contains(request.getHost())) {
            throw new RuntimeException("Host " + request.getHost() + " is blacklisted.");
        } else if (hosts.contains(request.getTarget())) {
            throw new RuntimeException("Target " + request.getTarget() + " is blacklisted.");
        }

        return next.handle(request);
    }
}
