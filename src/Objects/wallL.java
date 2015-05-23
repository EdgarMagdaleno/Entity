package Objects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import Framework.GameObject;
import Framework.ObjectId;
import Main.Loader;

public class wallL extends GameObject{
	Loader load = new Loader();
	BufferedImage wallV = load.loadImage("/wallV.gif");
	
	public wallL(float x, float y, ObjectId id) {
		super(x, y, id);
	}

	public void tick(LinkedList<GameObject> object) {
		
	}

	public void render(Graphics g) {
		g.drawImage(wallV, 53,62,9,568, null);
	}
	
	public Rectangle getBounds() {
		return new Rectangle(53,62,9,568);
	}
}
