package modules.bot.domain.event;

import java.util.List;
import java.util.Map;

import modules.bot.contracts.IBotEvent;

public abstract class BotEvent implements IBotEvent {
    protected String type;
    protected Map<String, Object> payload;

    public BotEvent(String type, Map<String, Object> payload) {
        this.type = type;
        this.payload = payload;
    }

    @Override
    public boolean matchType(List<String> types) {
        return types.contains(this.type);
    }

    @Override
    public Object getPayload(String key) {
        return payload.get(key);
    }
}
