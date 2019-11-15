package paul.codes.entity;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import paul.codes.Display;
import paul.codes.GameManager.GameManager;
import paul.codes.LoadImages.LoadImages;
import paul.codes.bullets.Bullets;

public class player implements KeyListener {
	private int x;
	private int y;
	private boolean left;
	private boolean right;
	private boolean fire;
	private long current;
	private long delay;
	private int health;
	
	public player(int x, int y) {
		this.x = x;
		this.y = y;
		
	}
	
	public void init() {
		Display.frame.addKeyListener(this);
		current = System.nanoTime();
		delay = 100;
		health = 3;
	}
	
	public void tick() {
		if(!(health <=0)) {
			if(left) {
				if(x<=445){
					x += 5;
				}
			}
			if(right) {
				if(x>=25) {
					x -= 5;
				}
			}
			if(fire) {
			long breaks = (System.nanoTime() - current)/1000000;
			GameManager.bullets.add(new Bullets(x+10,y));
			}
			current = System.nanoTime();
		}
	}

	public void  render(Graphics g) {
		if(!(health <= 0)) {
			g.drawImage(LoadImages.playerplane,x, y-10, 30, 45, null);
		}
	}
	public void keyPressed(KeyEvent e) {
		int source = e.getKeyCode();
		if(source == KeyEvent.VK_LEFT) {
			right = true;
		}
		if(source == KeyEvent.VK_RIGHT) {
			left = true;
		}
		if(source == KeyEvent.VK_UP) {
			fire = true;
		}
	}
	public void keyReleased(KeyEvent e) {
		int source = e.getKeyCode();
		if(source == KeyEvent.VK_LEFT) {
			right = false;
		}
		if(source == KeyEvent.VK_RIGHT) {
			left = false;
		}
		if(source == KeyEvent.VK_UP) {
			fire = false;
		}
		
		
	}
	public void keyTyped(KeyEvent e) {
		
	}
	
	public int getX() {
		return x;
	}
	
	public  int getY() {
		return y;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}

}
