package infra.adapters;

import modules.fsm.contracts.IFsmEvent;
import modules.fsm.contracts.IFsmObserver;
import modules.fsm.contracts.IFsmState;
import shared.event.contracts.EventBus;


public class FsmEventBusAdapter implements IFsmObserver {
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
