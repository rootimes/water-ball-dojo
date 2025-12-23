package showdown.player;

public class ExchangeState {

    private int remindingRounds;

    public ExchangeState(int rounds) {
        this.remindingRounds = rounds;
    }

    public boolean decreaseRemindingRounds() {
        this.remindingRounds--;

        return this.remindingRounds > 0;
    }
}