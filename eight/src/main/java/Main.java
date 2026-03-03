import infra.event.SimpleEventBus;
import infra.event.contracts.EventBus;

public class Main {
    public static void main(String[] args) {
        EventBus bus = new SimpleEventBus();
    }
}
