package httpclient.Handlers.Support;

import java.util.Map;

import httpclient.Handlers.SupportHandler;
import httpclient.HttpHandler;
import httpclient.HttpRequest;
import httpclient.Pool;

public class ServiceDiscoveryHandler extends SupportHandler<Map<String, Pool>> {
    public ServiceDiscoveryHandler(Map<String, Pool> hosts, HttpHandler next) {
        super(hosts, next);
    }

    @Override
    public HttpRequest handle(HttpRequest request) {

        if (hosts.containsKey(request.getHost())) {
            String host = request.getHost();
            Pool pool = hosts.get(host);
            pool.SearchEnabledEndPoints();
            String ip = pool.getEnabledIp(0);
            if (ip != null) {
                request.setTarget(ip);
            } else {
                request.setTarget(host);
            }
        }

        return next.handle(request);
    }
}
