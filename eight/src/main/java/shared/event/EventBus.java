package shared.event;

import java.util.function.Consumer;

/**
 * 定義事件發布與訂閱的契約。
 * 解耦事件的產生者 (Producer) 與處理者 (Consumer)。
 */
public interface EventBus {
    
    /**
     * 發布一個領域事件。
     */
    void publish(Event event);

    /**
     * 訂閱特定類型的領域事件。
     */
    <T extends Event> void subscribe(Class<T> eventType, Consumer<T> handler);
}
