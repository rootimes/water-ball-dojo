package modules.bot.domain;

import java.util.Map;

import modules.bot.contracts.IBotEvent;

public class ComContext {
    private int ccu;

    private int ccb;

    private Map<String, Boolean> users;

    public int getOnline() {
        return ccu + ccb;
    }

    public void login(IBotEvent event) {
    }

    public boolean isAdmin(String userId) {
        return users.getOrDefault(userId, false);
    }
}
