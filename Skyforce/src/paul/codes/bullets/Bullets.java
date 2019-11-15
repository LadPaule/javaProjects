package paul.codes.bullets;


import java.awt.Graphics;
import paul.codes.LoadImages.LoadImages;

public class Bullets {
	
	private int x;
	private int y;
	int speed;
	
	public Bullets(int x, int y) {
		this.x = x;
		this.y = y;
		speed = 10;
	}
	public void tick() {
		y -= speed;
	}
	public int getY() {
		return y;
	}
	public int getX() {
		return x;
	}
	
	public void init() {
		
	}
	public void render(Graphics g){
		
		g.drawImage(LoadImages.bulletim, x, y, 3, 6, null);
	}

}
