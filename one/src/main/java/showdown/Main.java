package showdown;

import showdown.game.ShowdownGame;


public class Main
{
    public static void main( String[] args )
    {
        ShowdownGame game = new ShowdownGame();
        
        game.start();

        game.end();
    }
}
