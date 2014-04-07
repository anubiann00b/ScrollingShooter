package game.player;

import game.util.MathHelper;
import game.util.Plane;
import game.util.resource.ImageLibrary;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;

public class Player extends Plane {
    
    public int MAX_SPEED = 10;
    public int MIN_SPEED = 2;
    
    private double x;
    private double y;
    
    private int dir;
    private double speed;
    
    private Image sprite;
    
    public double getX() { return x; }
    public double getY() { return y; }
    
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
        g.drawImage(sprite,(int)x,(int)y);
        g.rotate((int)x,(int)y,dir);
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
        speed += accel/10.0;
        dir -= dDir;
        
        speed = MathHelper.median(MIN_SPEED,speed,MAX_SPEED);
                
        x -= delta*speed*Math.sin(dir*Math.PI/180)/16;
        y -= delta*speed*Math.cos(dir*Math.PI/180)/16;
    }
}