package httpclient;

public class HttpRequest {
    private String scheme;
    private String host;
    private String path;
    private String target;
    private String status;

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

    public String getTarget() {
        return target;
    }

    public String getTargetUrl() {
        return scheme + "://" + target + path;
    }

    public String getStatus() {
        return status;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}