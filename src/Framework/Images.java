package Framework;
import java.awt.image.BufferedImage;

public class Images {
	private BufferedImage image;
	
	public Images(BufferedImage image) {
		this.image = image;
	}
	
	public BufferedImage grabImage(int col, int row, int width, int height) {
		BufferedImage img = image.getSubimage((col * width) - width, (row * height) - height, width,height);
		return img;
	}
}