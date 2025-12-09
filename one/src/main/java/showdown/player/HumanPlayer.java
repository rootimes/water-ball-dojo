package showdown.player;

import showdown.card.Card;
import java.util.List;

public class HumanPlayer extends Player {
    
    public HumanPlayer(String name) {
        super(name);
    }
    
    @Override
    public List<Card> exchange() {
        return null;
    }
}