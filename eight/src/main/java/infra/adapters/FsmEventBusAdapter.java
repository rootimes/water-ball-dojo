package infra.adapters;

import modules.fsm.contracts.FsmEvent;
import modules.fsm.contracts.FsmObserver;
import modules.fsm.contracts.FsmState;
import shared.event.StateTransitionEvent;
import shared.event.contracts.EventBus;


public class FsmEventBusAdapter implements FsmObserver {
    private final EventBus bus;

    public FsmEventBusAdapter(EventBus bus) {
        this.bus = bus;
    }

    @Override
    public void onTransition(FsmState fromState, FsmState toState, FsmEvent event) {
        bus.publish(new StateTransitionEvent(fromState, toState, event));
    }

    @Override
    public void onAction(FsmState state) {
        // 如果需要，也可以在這裡發佈 Action 相關的事件
    }
}
