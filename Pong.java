import javax.swing.JFrame;
import java.awt.*;


class Pong extends Canvas implements Runnable {

    public static final int WIDTH = 1000;
    public static final int HEIGHT = WIDTH * 9 / 16;

    public boolean running = false;
    private Thread gameThread;

    private Ball ball;
    private Paddle paddle1;
    private Paddle paddle2;

    public Pong() {

        canvasSetup();
        new Window("SimplePong", this);
    }

    public void canvasSetup() {
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        this.setMinimumSize(new Dimension(WIDTH, HEIGHT));

    }

    @Override
    public void run() {
        canvasSetup();

    }

    public void start() {
        gameThread = new Thread(this);
        gameThread.start();
        running = true;
    }

    public void stop() {
        try {
            gameThread.join();
            running = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        new Pong();
    }
}
