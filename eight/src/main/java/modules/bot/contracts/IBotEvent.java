package modules.bot.contracts;

import java.util.Map;

public interface IBotEvent {
    public String getType();
    public Map<String, Object> getPayload();
    public boolean evaluate();
}
