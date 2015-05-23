package Abilities;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import Framework.GameObject;
import Framework.ObjectId;
import Main.Handler;
import Main.Loader;
import Objects.Player;

public class Charging extends GameObject{

	Handler handler;
	public static int createdBy;
	public static long timeCreation;
	int frameDelay = 70;
	int frame = 0;
	Loader load = new Loader();
	BufferedImage f0 = load.loadImage("/charging/0.png");
	BufferedImage f1 = load.loadImage("/charging/1.png");
	BufferedImage f2 = load.loadImage("/charging/2.png");
	BufferedImage f3 = load.loadImage("/charging/3.png");
	BufferedImage f4 = load.loadImage("/charging/4.png");
	BufferedImage f5 = load.loadImage("/charging/5.png");
	BufferedImage f6 = load.loadImage("/charging/6.png");
	BufferedImage f7 = load.loadImage("/charging/7.png");
	BufferedImage f8 = load.loadImage("/charging/8.png");
	
	
	public Charging(float x, float y, Handler handler,ObjectId id) {
		super(x, y, id);
		this.handler = handler;
	}

	public void tick(LinkedList<GameObject> object) {
		long timeNow = System.currentTimeMillis();
		if(timeNow - timeCreation > frameDelay){
			frame++;
			timeCreation = System.currentTimeMillis();
		}
		
		if(frame == 10) {
			handler.removeObject(this);
			handler.addObject(new Buster((int)x-9,(int)y-25,handler, ObjectId.Buster));
			if(createdBy == 1) {Buster.createdBy = 1; Buster.timeCreation = System.currentTimeMillis();}
			if(createdBy == 2) {Buster.createdBy = 2; Buster.timeCreation2 = System.currentTimeMillis();}
			frame = 0;		
		}
	
		
	}

	
	public void render(Graphics g) {
		if(frame == 1) g.drawImage(f0,(int)x,(int)y,100,100,null);	
		if(frame == 2) g.drawImage(f1,(int)x,(int)y,100,100,null);	
		if(frame == 3) g.drawImage(f2,(int)x,(int)y,100,100,null);	
		if(frame == 4) g.drawImage(f3,(int)x,(int)y,100,100,null);	
		if(frame == 5) g.drawImage(f4,(int)x,(int)y,100,100,null);	
		if(frame == 6) g.drawImage(f5,(int)x,(int)y,100,100,null);	
		if(frame == 7) g.drawImage(f6,(int)x,(int)y,100,100,null);	
		if(frame == 8) g.drawImage(f7,(int)x,(int)y,100,100,null);	
		if(frame == 9) g.drawImage(f8,(int)x,(int)y,100,100,null);	
	}


	public Rectangle getBounds() {
		return null;
	}
	
	
	
}
