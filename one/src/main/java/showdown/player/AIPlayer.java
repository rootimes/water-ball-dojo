package showdown.player;

public class AIPlayer extends Player {

    public int thinkCardIndex() {
        // 簡單的 AI 策略：隨機選擇一張卡牌
        return (int) (Math.random() * hand.size());
    }
}