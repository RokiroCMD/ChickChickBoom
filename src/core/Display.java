package core;

import game.Game;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;

public class Display extends JFrame {

    public int WIDTH;
    public int HEIGHT;

    Game game;
    Canvas canvas;

    public Display(int WIDTH, int HEIGHT, Game game) {
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        this.game = game;

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);
        setExtendedState(MAXIMIZED_BOTH);
        setResizable(false);
        setTitle("ChickChickBoom");

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        canvas.setFocusable(false);
        add(canvas);
        pack();

        canvas.createBufferStrategy(3);

        setVisible(true);
        requestFocus();

        canvas.addMouseListener(game.mouse);
        canvas.addMouseMotionListener(game.mouse);
        canvas.addMouseWheelListener(game.mouse);
    }

    public void render() {
        BufferStrategy bufferStrategy = canvas.getBufferStrategy();
        Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
        
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g.setColor(Color.cyan);
        g.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        
        game.strokeManager.render(g);
        
        g.dispose();
        bufferStrategy.show();
    }

}
