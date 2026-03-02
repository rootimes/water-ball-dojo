package modules.bot.shared;

import java.util.Map;

import modules.bot.contracts.BotEvent;

public class CommunityInfo {
    private int ccu;

    private int ccb;

    private Map<String, Boolean> users;

    public int getOnline() {
        return ccu + ccb;
    }

    public void login(BotEvent event) {
    }
}
