package httpclient;

public class HttpRequest {
    private String scheme;
    private String host;
    private String path;

    public HttpRequest(String url) {
        String[] parts = url.split("://");
        this.scheme = parts[0];
        String[] hostAndPath = parts[1].split("/", 2);
        this.host = hostAndPath[0];
        this.path = hostAndPath.length > 1 ? "/" + hostAndPath[1] : "/";
    }

    public String getScheme() {
        return scheme;
    }

    public String getHost() {
        return host;
    }

    public String getPath() {
        return path;
    }

    public String getUrl() {
        return scheme + "://" + host + path;
    }
}
