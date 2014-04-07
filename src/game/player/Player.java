package game.player;

import game.state.StatePlaying;
import game.util.Plane;
import game.util.resource.ImageLibrary;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;

public class Player extends Plane {
    
    private int x;
    private int y;
    
    private int dir;
    private int speed;
    
    private Image sprite;
    
    public int getX() { return x; }
    public int getY() { return y; }
    
    public Player() {
        x = 256;
        y = 256;
        dir = 0;
        speed = 0;
    }
    
    public void init(GameContainer container, StateBasedGame game) {
        sprite = ImageLibrary.PLAYER_PLANE.getImage();
    }
    
    public void update(GameContainer container, int delta) {
        resolveMove(container.getInput(),delta);
    }
    
    public void render(GameContainer container, Graphics g, int cx, int cy) {
        g.drawImage(sprite,x,y);
        g.rotate(cx+StatePlaying.VIEW_SIZE_X/2,cy+StatePlaying.VIEW_SIZE_Y/2,dir);
    }
    
    private void resolveMove(Input input, int delta) {
        int accel = 0;
        int dDir = 0;
        if (input.isKeyDown(Input.KEY_W))
            accel++;
        if (input.isKeyDown(Input.KEY_S))
            accel--;
        if (input.isKeyDown(Input.KEY_D))
            dDir++;
        if (input.isKeyDown(Input.KEY_A))
            dDir--;
        speed -= accel;
        dir -= dDir;
        y += delta*speed*Math.cos(dir*Math.PI/180)/16;
        x += delta*speed*Math.sin(dir*Math.PI/180)/16;
    }
}