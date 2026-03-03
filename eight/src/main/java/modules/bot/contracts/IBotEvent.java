package modules.bot.contracts;

import java.util.List;

public interface IBotEvent {
    public boolean matchName(List<String> names);

    public Object getPayload(String key);
}
