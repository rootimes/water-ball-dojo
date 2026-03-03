package infra;

import infra.event.contracts.EventBus;
import modules.fsm.contracts.IFsmEvent;
import modules.fsm.contracts.IFsmEventHandler;
import modules.fsm.contracts.IFsmState;

public class FsmEventBusAdapter implements IFsmEventHandler {
    private final EventBus bus;

    public FsmEventBusAdapter(EventBus bus) {
        this.bus = bus;
    }

    @Override
    public void onTransition(IFsmState fromState, IFsmState toState, IFsmEvent event) {
    }

    @Override
    public void onAction(IFsmState state) {
        // 如果需要，也可以在這裡發佈 Action 相關的事件
    }
}
