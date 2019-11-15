package paul.codes.GameSetup;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import paul.codes.Display;
import paul.codes.GameManager.GameManager;
import paul.codes.LoadImages.LoadImages;

public class GameSetup implements Runnable {
	
	private String title;
	private int width, height;
	private Thread thread;
	private boolean running;
	private Display display;
	private BufferStrategy bs;
	private Graphics g;
	private GameManager manager;
	
	public static int gameWidth;
	public static int gameHeight;
	
	
	public GameSetup(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
	}
	public void init() {
		display = new Display(title, width, height);
		manager = new GameManager();
		manager.init();
		
		gameWidth = 460;
		gameHeight = 550;
		
		LoadImages.init();
		
	}
	
	public synchronized void start() {
		if(running) 
			return;
		running = true;
		if(thread == null) {
		thread = new Thread(this);
		thread.start();
		}
	}
	
	public synchronized void stop() {
		if(!(running))
			return;
		running = false;
		
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void tick() {
		manager.tick();
	}
	
	public void render() {
		bs = display.getCanvas().getBufferStrategy();
		if(bs ==null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		g.clearRect(0, 0, width, height);
		//drawn Graphics
		
		g.drawImage(LoadImages.image, 20, 20, gameWidth, gameHeight, null, null);
		manager.render(g);
		
		//end of Graphics
		bs.show();
		g.dispose();
	}
	
	public void run() {
		int fps = 50;
		double timeperTick = 1000000000/fps;
		double delta = 0;
		long current = System.nanoTime();
		
		init();
		while(running) {
			delta = delta + (System.nanoTime() - current)/timeperTick;
			current = System.nanoTime();
			if(delta >= 1) {
				tick();
				render();
				delta--;
			}
		}
		
	}
}
