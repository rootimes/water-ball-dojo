package modules.bot.domain.event;

import java.util.Map;

public abstract class BotEvent {
    protected String type;
    protected Map<String, Object> payload;

    public BotEvent(String type, Map<String, Object> payload) {
        this.type = type;
        this.payload = payload;
    }

    public String getType() {
        return type;
    }

    public Map<String, Object> getPayload() {
        return payload;
    }
}
