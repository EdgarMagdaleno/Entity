package Objects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import Framework.GameObject;
import Framework.ObjectId;
import Main.Loader;

public class wallU extends GameObject{
	Loader load = new Loader();
	BufferedImage wallH = load.loadImage("/wallH.gif");

	public wallU(float x, float y, ObjectId id) {
		super(x, y, id);
	}

	public void tick(LinkedList<GameObject> object) {
		
	}

	public void render(Graphics g) {
		g.drawImage(wallH, 63, 53, 1063, 9, null);
	}

	public Rectangle getBounds() {
		return new Rectangle(62,53,1200-129,9);
	}
}
