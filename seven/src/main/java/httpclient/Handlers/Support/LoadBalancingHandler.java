package httpclient.Handlers.Support;

import java.util.Map;

import httpclient.Handlers.SupportHandler;
import httpclient.HttpHandler;
import httpclient.HttpRequest;
import httpclient.Pool;

public class LoadBalancingHandler extends SupportHandler<Map<String, Pool>> {
    public LoadBalancingHandler(Map<String, Pool> hosts, HttpHandler next) {
        super(hosts, next);
    }

    @Override
    public void handle(HttpRequest request) {

        if (hosts.containsKey(request.getHost())) {
            String host = request.getHost();
            Pool pool = hosts.get(host);
            String ip = pool.getBalanceIp();
            if (ip != null) {
                request.setTarget(ip);
            } else {
                request.setTarget(host);
            }
        }

        next.handle(request);
    }
}
