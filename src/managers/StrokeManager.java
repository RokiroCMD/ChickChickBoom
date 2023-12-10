package managers;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import utils.Position;
import utils.Stroke;

public class StrokeManager {

    public List<Stroke> strokes = new ArrayList<>();

    public StrokeManager() {
    }

    public void addStroke(Stroke stroke) {
        strokes.add(stroke);
    }

    public boolean removeStroke(Stroke stroke) {
        return strokes.remove(stroke);
    }

    public boolean hasStroke(Stroke stroke) {
        return strokes.contains(stroke);
    }

    public void render(Graphics2D g) {
        
        List<Stroke> actual = List.copyOf(strokes);
        
        for(Stroke s: actual){
            //g.setColor(Color.red);
            //g.drawOval(s.getPosition().getX(), s.getPosition().getY(), 100, 100);
            g.drawImage(
                    s.getSprite(),
                    s.getPosition().getX(),
                    s.getPosition().getY(),
                    null);
        }
        
    }

    public void createStroke(Position position) {
        if (canCreateStroke(position)) {
            addStroke(new Stroke(position, true));
        }
    }

    public boolean canCreateStroke(Position position) {
        for (Stroke s : strokes) {
            if (s.getBox().contains(position.getX(), position.getY())) {
                return false;
            }
        }
        return true;
    }

}
