package game;

import core.Display;
import inputs.MouseInput;
import managers.StrokeManager;
import utils.Position;
import utils.Stroke;

public class Game {
    
    public MouseInput mouse;
    public StrokeManager strokeManager;
    Display display;

    public Game(int width, int height) {
        this.mouse = new MouseInput(this);
        this.display = new Display(width, height, this );
        this.strokeManager = new StrokeManager();        
        

    }
    
    
    
    public void update(){
        
    }
    
    public void render(){
        display.render();
    }
    
    
    
}
