package paul.codes.LoadImages;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class LoadImages {
	
	public static BufferedImage image;
	public static BufferedImage image1;
	public static BufferedImage playerplane;
	public static BufferedImage bulletim;
	
	public static void init() {
	image =	loadImage("/Sky.PNG");
	image1 = loadImage("/pointing.PNG");
	playerplane = loadImage("/realMePlane.PNG");
	bulletim = loadImage("/bullet1.PNG");
	}
	public static BufferedImage loadImage(String path) {
		try {
			return ImageIO.read(LoadImages.class.getResource(path));
			} catch (IOException e) {
				e.printStackTrace();
				System.exit(1);
			}
		return null;
	}
	

}
 