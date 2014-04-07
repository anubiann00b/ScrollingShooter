package game;

import game.state.StatePlaying;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Game extends StateBasedGame {
    
    public static final int STATE_MENU = 0;
    public static final int STATE_PLAYING = 1;
    public static final int STATE_PAUSED = 2;
    
    public static int VIEW_SIZE_X;
    public static int VIEW_SIZE_Y;
    
    public Game() {
        super("Scrolling Shooter");
    }
        
    public static void main(String[] args) {
        try {
            AppGameContainer app = new AppGameContainer(new Game());
            setupAGC(app);
        } catch (SlickException e) {
            System.out.println("Error initializing game: " + e);
        }
    }

    @Override
    public void initStatesList(GameContainer container) throws SlickException {
        this.addState(new StatePlaying(STATE_PLAYING));
    }
    
    /** Sets up the window. */
    private static void setupAGC(AppGameContainer app) throws SlickException {
        VIEW_SIZE_X = app.getScreenWidth();
        VIEW_SIZE_Y = app.getScreenHeight();
        app.setDisplayMode(VIEW_SIZE_X,VIEW_SIZE_Y,false);
        app.setShowFPS(true);
        app.setVSync(true);
        app.setForceExit(true);
        app.start();
    }
}