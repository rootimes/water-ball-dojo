package modules.bot.domain.event;

import java.util.List;
import java.util.Map;

import modules.bot.contracts.IBotEvent;

public abstract class BotEvent implements IBotEvent {
    protected String name;
    protected Map<String, Object> payload;

    public BotEvent(String name, Map<String, Object> payload) {
        this.name = name;
        this.payload = payload;
    }

    @Override
    public boolean matchName(List<String> names) {
        return names.contains(this.name);
    }

    @Override
    public Object getPayload(String key) {
        return payload.get(key);
    }
}
