package modules.bot.contracts;

import java.util.List;

public interface IBotEvent {
    public boolean matchType(List<String> types);

    public Object getPayload(String key);
}
