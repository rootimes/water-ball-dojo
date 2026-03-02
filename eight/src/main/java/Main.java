import modules.bot.domain.BOT;
import modules.fsm.contracts.FsmListener;
import modules.fsm.domain.FSM;
import shared.event.ChatObserver;
import shared.event.SimpleEventBus;
import shared.event.contracts.EventBus;
import shared.event.contracts.IEventObserver;

public class Main {

    public static void main(String[] args) {
             EventBus bus = new SimpleEventBus();
            FsmListener bridge = new FsmEventBusBridge(bus);
            FSM fsm = new FSM(bridge, ...);

            BOT myBot = new BOT(fsm);
           myBot.start();
       }
}
