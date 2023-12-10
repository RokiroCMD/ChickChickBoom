package utils;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.IndexColorModel;

public class Stroke {

    Position position;
    Rectangle box;
    BufferedImage sprite;
    private int strokeSize = 20;
    public static BufferedImage SpriteLoaded;

    public Stroke(Position position) {
        this.position = position;
        this.box = new Rectangle(position.x, position.y, strokeSize, strokeSize);
        if (SpriteLoaded == null) {
            createSprite();
        }
        sprite = SpriteLoaded;

    }

    public Stroke(Position position, boolean centered) {
        if (centered) {
            this.position = new Position(position.getX() - (strokeSize / 2), position.getY() - (strokeSize / 2));
        } else {
            this.position = position;
        }
        this.box = new Rectangle(position.x, position.y, strokeSize, strokeSize);
        if (SpriteLoaded == null) {
            createSprite();
        }
        sprite = SpriteLoaded;
    }

    public void createSprite() {
        BufferedImage img = new BufferedImage((int) box.getWidth(), (int) box.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = img.createGraphics();
        g.setColor(Color.red);
        g.fill(new Ellipse2D.Float(0, 0, strokeSize, strokeSize));

        //g.setColor(Color.RED);
        //g.fillRect(box.x, box.y, (int) box.getWidth(), (int) box.getHeight());
        SpriteLoaded = img;
        //sprite = img;
        g.dispose();
    }

    public void setPosition(Position position) {
        this.position = position;
        box.setLocation(position.x, position.y);
    }

    public Position getPosition() {
        return position;
    }

    public Rectangle getBox() {
        return box;
    }

    public BufferedImage getSprite() {
        return sprite;
    }

}
