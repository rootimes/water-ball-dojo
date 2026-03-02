package modules.bot.shared;

import java.util.Map;

import modules.bot.contracts.IBotEvent;

public class ComContext {
    private int ccu;

    private int ccb;

    private Map<String, Boolean> admins;

    public int getOnline() {
        return ccu + ccb;
    }

    public void login(IBotEvent event) {
    }
}
