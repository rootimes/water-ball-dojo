package httpclient;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import httpclient.Handlers.FakeHttpClient;
import httpclient.Handlers.Support.BlackListHandler;
import httpclient.Handlers.Support.LoadBalancingHandler;
import httpclient.Handlers.Support.ServiceDiscoveryHandler;

public class Main {
    public static void main(String[] args) {
        final String blacklistPath = "src/test/resource/blacklist.in";
        final String configPath = "src/test/resource/config.in";

        Set<String> blacklistedHosts = loadBlacklist(blacklistPath);
        Map<String, Pool> hosts = loadHostsConfig(configPath);

        HttpClient client = new HttpClient();

        HttpRequest request = new HttpRequest("https://waterballsa.tw/test");

        HttpHandler handler = new BlackListHandler(blacklistedHosts,
                new ServiceDiscoveryHandler(hosts,
                        new LoadBalancingHandler(hosts,
                                new FakeHttpClient())));

        client.get(request, handler);
        client.get(request, handler);
        client.get(request, handler);
        client.get(request, handler);
    }

    public static Set<String> loadBlacklist(String filePath) {
        try {
            return Files.lines(Paths.get(filePath))
                    .filter(line -> !line.trim().isEmpty())
                    .collect(Collectors.toSet());
        } catch (IOException e) {
            System.err.println("Error reading blacklist file: " + filePath);
            e.printStackTrace();
            return new HashSet<>();
        }
    }

    public static Map<String, Pool> loadHostsConfig(String filePath) {
        Map<String, Pool> hosts = new HashMap<>();
        try {
            Files.lines(Paths.get(filePath))
                    .filter(line -> !line.trim().isEmpty())
                    .forEach(line -> {
                        String[] parts = line.split(":");
                        if (parts.length == 2) {
                            String host = parts[0].trim();
                            List<String> ips = Arrays.stream(parts[1].split(","))
                                    .map(String::trim)
                                    .collect(Collectors.toList());

                            Pool pool = new Pool();
                            for (String ip : ips) {
                                pool.addEndPoint(new EndPoint(ip));
                            }
                            hosts.put(host, pool);
                        }
                    });
        } catch (IOException e) {
            System.err.println("Error reading config file: " + filePath);
            e.printStackTrace();
            return new HashMap<>();
        }
        return hosts;
    }
}
