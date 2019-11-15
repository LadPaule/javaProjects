package paul.codes.GameManager;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import paul.codes.Display;
import paul.codes.GameSetup.GameSetup;
import paul.codes.bullets.Bullets;
import paul.codes.enemies.Enemies;
import paul.codes.entity.*;

public class GameManager implements KeyListener {
	private player Player;
	public static ArrayList<Bullets> bullets;
	public static ArrayList<Enemies> enemies;
	private long current;
	private long delay;
	private int health;
	private int DESTROYED;
	private boolean start;
	
	public GameManager() {
		
	}
	
	public void init() {
		Display.frame.addKeyListener(this);
		Player = new player(230, 540);
		Player.init();
		bullets = new ArrayList<Bullets>();
		enemies = new ArrayList<Enemies>();
		current = System.nanoTime();
		delay = 500;
		health = Player.getHealth(); 
		DESTROYED = 0;
		
	}
	
	public void tick() {
		if(start) {
			Player.tick();
			for(int i =0; i<bullets.size(); i++) {
				bullets.get(i).tick();
			}
			long breaks = (System.nanoTime()-current)/1000000;
		
			if(breaks > delay) {
				for(int i =0; i < 2; i++) {
			
					Random rand = new Random();
					int randX = rand.nextInt(460);
					int randY = rand.nextInt(550);
					if(health > 0) {
						enemies.add(new Enemies(randX, -randY));
					}	
				}
				for(int i = 0; i<enemies.size(); i++) {
					enemies.get(i).tick();
				}
				current = System.nanoTime();
			}
		}
	}
	
	public void render(Graphics g) {
		if(start) {
			for(int i = 0; i<bullets.size(); i++) {
				bullets.get(i).render(g);
			}
			Player.render(g);
		
			for(int i = 0; i<bullets.size(); i++) {
				if(bullets.get(i).getY()<= 20) {
				bullets.remove(i);
				i--;
				}
			}
			for(int i = 0; i<enemies.size(); i++) {
				if(!(enemies.get(i).getX() <= 50 || enemies.get(i).getX()>=435
					||enemies.get(i).getY()>=535)) {
					enemies.get(i).render(g);
				}
			}
		
			for(int i = 0; i<enemies.size(); i++) {
			
				int enemyX = enemies.get(i).getX();
				int enemyY = enemies.get(i).getY();
			
			
				int playerX = Player.getX();
				int playerY = Player.getY();
			
				if(playerX < enemyX + 40 && playerX + 30 >playerX && playerY <enemyY + 45 && playerY + 45 >enemyY) {
					enemies.remove(i);
					i--;
					health --;
					System.out.println(health);
					if(health <= 0 ) {
						enemies.remove(enemies);
						Player.setHealth(0);
						start = false;
					}
				
				}
			
				for(int i1 = 0; i1<bullets.size(); i1++) {
				
					int bulletX = bullets.get(i1).getX();
					int bulletY = bullets.get(i1).getY();
					/*Collision of the enemies and the bullet
					if(r1.x < r2.x + width &&
						r1.x+width > r2.x && 
						r1.y < r2.y + width &&
						r1.y+width > r2.y)
					
						r1 = player;
						r2 = enemies;
					 */
					if(enemyX < bulletX + 3 && enemyX + 45 >bulletX && enemyY < bulletY + 6 && enemyY + 40 > bulletY) {
						enemies.remove(i);
						i--;
						bullets.remove(i1);
						i1--;
						DESTROYED =DESTROYED +1;
					}
				}
				g.setColor(Color.yellow);
				g.setFont(new Font("Cambria", Font.ROMAN_BASELINE,20));
				g.drawString("DESTROYED : "+DESTROYED,100, 630);
			}
		}
		else {
		g.setColor(Color.red);
		g.setFont(new Font("arial", Font.BOLD,20));
		g.drawString("Press Delete key to Start ",100, (GameSetup.gameHeight)/2);
		}
	}


	public void keyPressed(KeyEvent e) {
		int source = e.getKeyCode();
		if(source == KeyEvent.VK_DELETE) {
			start = true;
			init();
		}
		
	}


	public void keyReleased(KeyEvent e) {
		
		
	}


	public void keyTyped(KeyEvent e) {
		
		
	}

}










