package showdown.player;

import showdown.card.Card;
import java.util.List;

public class AIPlayer extends Player {
    
    public AIPlayer(String name) {
        super(name);
    }
    
    @Override
    public List<Card> exchange() {
        return null;
    }
}