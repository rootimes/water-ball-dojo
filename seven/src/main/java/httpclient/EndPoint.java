package httpclient;

import java.time.LocalDateTime;

public class EndPoint {
    private String ip;
    private LocalDateTime time;
    private int enabled;

    public EndPoint(String ip) {
        this.ip = ip;
        this.time = LocalDateTime.now();
        this.enabled = 1;
    }

    public String getIp() {
        return ip;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }
}
