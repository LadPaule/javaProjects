package paul.codes.enemies;


import java.awt.Graphics;
import paul.codes.LoadImages.LoadImages;

public class Enemies {
	
	private int x;
	private int y;
	int speed;
	
	public Enemies(int x, int y) {
		this.x = x;
		this.y = y;
		speed = 10;
	}
	public void tick() {
		y += speed;
	}
	public void render(Graphics g) {
		g.drawImage(LoadImages.image1, x, y, 40, 45, null);
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}

}
