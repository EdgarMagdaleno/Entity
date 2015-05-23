package Objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import Framework.GameObject;
import Framework.Input;
import Framework.ObjectId;
import Main.Loader;

public class Block extends GameObject {
	Loader load = new Loader();
	BufferedImage bh = load.loadImage("/bh.png");
	public Block(float x, float y, ObjectId id) {
		super(x, y, id);
	}
	
	public void tick(LinkedList<GameObject> object) {
		
	}

	public void render(Graphics g) {
		g.drawImage(bh,(int)x,(int)y, 80, 80, null);
		
		if(Input.developerMode == true){		
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.green);
		g2d.draw(getBounds());
		}
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x + 5, (int)y + 5, 70, 70);
	}
}