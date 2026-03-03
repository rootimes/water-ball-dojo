package modules.bot.domain;

import modules.bot.contracts.IBotEventHandler;
import modules.bot.contracts.IBotMessage;

public class BOT {

    private IBotEventHandler handler;

    public BOT(IBotEventHandler handler) {
        this.handler = handler;
    }

    public void OnEvent(String event) {
    }

    public void SendMessage(IBotMessage message) {
    }
}
