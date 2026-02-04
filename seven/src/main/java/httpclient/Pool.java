package httpclient;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;

public class Pool {
    private List<EndPoint> endPoints = new ArrayList<>();
    private int cursor = 0;

    public Pool() {
    }

    public EndPoint getEnabledPoint() {
        for (EndPoint endPoint : endPoints) {
            if (isAvailable(endPoint)) {
                endPoint.setEnabled(1);
                endPoint.setTime(LocalDateTime.now());
                return endPoint;
            }
        }
        return null;
    }

    public EndPoint getEnabledBalanceEndPoint() {
        int n = endPoints.size();

        if (n == 0) {
            return null;
        }

        for (int i = 0; i < n; i++) {
            EndPoint endPoint = endPoints.get(cursor);
            cursor = (cursor + 1) % n;

            if (isAvailable(endPoint)) {
                endPoint.setEnabled(1);
                endPoint.setTime(LocalDateTime.now());
                return endPoint;
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
        return endPoint.getEnabled() == 0 &&
                endPoint.getTime().plusSeconds(10).isBefore(LocalDateTime.now());
    }
}
