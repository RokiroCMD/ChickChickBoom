package game;


public class GameLoop implements Runnable {

    Game game;
    boolean running;
    double updateRate = 1000d / 60d;
    long nextStatTime;
    int fps, ups = 0;
    
    public GameLoop(Game game) {
        this.game = game;
    }

    @Override
    public void run() {

        this.running = true;
        double acumulator = 0;
        long currentTime, lastUpdate = System.currentTimeMillis();
        nextStatTime = System.currentTimeMillis() + 1000;
        
        while (running) {

            currentTime = System.currentTimeMillis();

            double lastRenderTime = (currentTime - lastUpdate);
            acumulator += lastRenderTime;
            lastUpdate = currentTime;

            if (acumulator >= updateRate) {

                while (acumulator >= updateRate) {
                    update();
                    acumulator -= updateRate;

                }
                
                render();

            }
            
            printStats();

        }
    }
    
    public void printStats(){
        if (nextStatTime < System.currentTimeMillis()) {
            System.out.println(String.format("FPS: %d , UPS: %d",fps, ups));
            fps = 0;
            ups = 0;
            nextStatTime = System.currentTimeMillis() + 1000;
        }
    }
    
    public void render(){
        fps++;
        game.render();
    }
    
    public void update(){
        ups++;
        game.update();
    }

}
