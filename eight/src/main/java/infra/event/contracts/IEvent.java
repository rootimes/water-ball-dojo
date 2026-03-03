package infra.event.contracts;

import java.util.List;

public interface IEvent {
    public boolean matchName(List<String> names);

    public Object getPayload(String key);
}
