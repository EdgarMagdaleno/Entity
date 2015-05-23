package Objects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import Framework.GameObject;
import Framework.ObjectId;
import Main.Loader;

public class wallR extends GameObject{
	Loader load = new Loader();
	BufferedImage wallV = load.loadImage("/wallV.gif");
	BufferedImage e1 = load.loadImage("/e1.png");
	BufferedImage e2 = load.loadImage("/e2.png");
	BufferedImage e3 = load.loadImage("/e3.png");
	BufferedImage e4 = load.loadImage("/e4.png");
	
	public wallR(float x, float y, ObjectId id) {
		super(x, y, id);
	}
	
	public void tick(LinkedList<GameObject> object) {
		
	}

	public void render(Graphics g) {
		g.drawImage(wallV, 1127,62,9,568, null);
		g.drawImage(e1, 54, 53, null);
		g.drawImage(e2, 1126, 53, null);
		g.drawImage(e3, 54, 630, null);
		g.drawImage(e4, 1126, 630, null);
	}

	public Rectangle getBounds() {
		return new Rectangle(1127,53,9,720-133);
	}
}
