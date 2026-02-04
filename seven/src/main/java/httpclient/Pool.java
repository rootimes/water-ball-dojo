package httpclient;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Pool {
    private List<EndPoint> endPoints = new ArrayList<>();
    private List<EndPoint> enabledEndPoints = new ArrayList<>();
    private int cursor = 0;

    public void SearchEnabledEndPoints() {
        enabledEndPoints.clear();
        for (EndPoint endPoint : endPoints) {
            if (isAvailable(endPoint)) {
                enabledEndPoints.add(endPoint);
            }
        }
    }

    public String getEnabledIp(int index) {
        if (index < 0 || index >= enabledEndPoints.size()) {
            return null;
        }
        return enabledEndPoints.get(index).getIp();
    }

    public String getBalanceIp() {
        int n = enabledEndPoints.size();

        if (n == 0) {
            return null;
        }

        for (int i = 0; i < n; i++) {
            EndPoint endPoint = enabledEndPoints.get(cursor);
            cursor = (cursor + 1) % n;

            if (isAvailable(endPoint)) {
                endPoint.setEnabled(1);
                endPoint.setTime(LocalDateTime.now());
                return endPoint.getIp();
            }
        }

        return null;
    }

    public void addEndPoint(EndPoint endPoint) {
        endPoints.add(endPoint);
    }

    public void removeEndPoint(EndPoint endPoint) {
        endPoints.remove(endPoint);
    }

    private boolean isAvailable(EndPoint endPoint) {
        if (endPoint.getEnabled() == 1) {
            return true;
        }

        if (endPoint.getEnabled() == 0 &&
                endPoint.getTime().plusSeconds(10).isBefore(LocalDateTime.now())) {
            endPoint.setEnabled(1);
            return true;
        }
        return false;
    }
}
