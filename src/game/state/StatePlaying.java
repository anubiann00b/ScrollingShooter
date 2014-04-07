package game.state;

import game.Game;
import game.player.Player;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class StatePlaying extends BasicGameState {
    
    public static final int VIEW_SIZE_X = Game.VIEW_SIZE_X;
    public static final int VIEW_SIZE_Y = Game.VIEW_SIZE_Y;
    public static final int WORLD_SIZE_X = VIEW_SIZE_X*4;
    public static final int WORLD_SIZE_Y = VIEW_SIZE_Y*4;
    
    private final int id;
    private Player player;
    
    private int camX;
    private int camY;
    
    public StatePlaying(int id) {
        this.id = id;
        this.camX = 0;
        this.camY = 0;
    }
    
    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        player = new Player();
        player.init(container,game);
    }
    
    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        player.update(container,delta);
    }
    
    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        updateViewPort();
        g.translate(-(float)camX,-(float)camY);
        player.render(container,g,camX,camY);
        for (int i=0;i<WORLD_SIZE_X;i+=128)
            for (int j=0;j<WORLD_SIZE_Y;j+=128)
                g.drawRect(i,j,128,128);
    }
    
    private void updateViewPort() {
        camX = (int)(player.getX()-VIEW_SIZE_X/2);
        camY = (int)(player.getY()-VIEW_SIZE_Y/2);
    }
    
    @Override
    public int getID() {
        return id;
    }
}