package Abilities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import Framework.GameObject;
import Framework.ObjectId;
import Main.Handler;
import Objects.Player2;

public class Paralyzer extends GameObject{
	
	
	public static final long Cooldown = 4000;
	public static int created = 0;
	public static long timeCreation = 0;
	int duration = 40;
	
	Handler handler;
	
	public Paralyzer(float x, float y,Handler handler, ObjectId id) {
		super(x, y, id);
		this.handler = handler;
	}

	
	public void tick(LinkedList<GameObject> object) {
		long timeNow = System.currentTimeMillis();
		if(timeNow - timeCreation > duration){
		handler.removeObject(this);
		Player2.hit = false;
		}
	}  

	public void render(Graphics g) {
		g.setColor(Color.yellow);
		g.fillRect((int)x,(int)y,100,100);
	}

	public Rectangle getBounds() {
		return new Rectangle ((int)x,(int)y,100,100);
	}

}
