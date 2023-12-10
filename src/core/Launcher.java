package core;

import game.Game;
import game.GameLoop;
import java.awt.Dimension;
import java.awt.Toolkit;

public class Launcher {

    public static void main(String[] args) {

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        Thread thread = new Thread(
                new GameLoop(
                        new Game(screenSize.width, screenSize.height)));
        thread.start();
    }
}
