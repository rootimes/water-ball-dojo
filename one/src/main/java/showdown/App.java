package showdown;

import showdown.game.ShowdownGame;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        ShowdownGame game = new ShowdownGame();
        
        game.start();

        game.end();
    }
}
