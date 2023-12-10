package inputs;

import game.Game;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import utils.Position;

public class MouseInput extends MouseAdapter{

    Game game;

    public MouseInput(Game game) {
        this.game = game;
    }
    
    @Override
    public void mouseMoved(MouseEvent e) {
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        
        game.strokeManager.createStroke(new Position(e.getX(), e.getY()));
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }
    
}
