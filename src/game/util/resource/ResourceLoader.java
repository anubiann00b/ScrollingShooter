package game.util.resource;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class ResourceLoader {
    
    public static Image initializeImage(String filepath) throws SlickException {
        Image image = new Image("resources/" + filepath);
        image.setFilter(Image.FILTER_NEAREST);
        return image;
    }
}
