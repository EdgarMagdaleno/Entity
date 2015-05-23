package Abilities;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import Framework.GameObject;
import Framework.Images;
import Framework.Input;
import Framework.ObjectId;
import Main.Game;
import Main.Handler;
import Main.Loader;
import Objects.Player;
import Objects.Player2;

public class Buster extends GameObject{

	public static final long Cooldown = 1200;
	public static long timeCreation;
	public static int createdBy;
	int direction = Player.pointing;
	int direction2 = Player2.pointing2;
	int frameDelay = 70;
	Handler handler;
	Loader load = new Loader();
	public static int f = 1;
	public static long timeCreation2;
	BufferedImage fa = load.loadImage("/buster1.png");
	BufferedImage fb = load.loadImage("/buster2.png");
	BufferedImage fc = load.loadImage("/buster3.png");
	BufferedImage fd = load.loadImage("/buster4.png");
	
	BufferedImage f0 = fa.getSubimage(0,0,46,46);
	BufferedImage f1 = fa.getSubimage(0,46,46,46);
	BufferedImage f2 = fa.getSubimage(0,92,46,46);
	BufferedImage f3 = fa.getSubimage(0,138,46,46);
	BufferedImage f4 = fa.getSubimage(0,184,46,46);
	BufferedImage f5 = fa.getSubimage(0,230,46,46);
	BufferedImage f6 = fa.getSubimage(0,276,46,46);
	BufferedImage f7 = fa.getSubimage(0,322,46,46);
	BufferedImage f8 = fa.getSubimage(0,368,46,46);
	BufferedImage f9 = fa.getSubimage(0,414,46,46);
	BufferedImage f10 = fa.getSubimage(0,460,46,46);
	BufferedImage f11 = fa.getSubimage(0,506,46,46);
	BufferedImage f12 = fa.getSubimage(0,552,46,46);
	BufferedImage f13 = fa.getSubimage(0,598,46,46);
	BufferedImage f14 = fa.getSubimage(0,644,46,46);
	BufferedImage f15 = fa.getSubimage(0,690,46,46);
	BufferedImage f16 = fa.getSubimage(0,736,46,46);
	BufferedImage f17 = fa.getSubimage(0,782,46,46);
	BufferedImage f18 = fa.getSubimage(0,828,46,46);
	
	BufferedImage fb0 = fb.getSubimage(0,0,46,46);
	BufferedImage fb1 = fb.getSubimage(0,46,46,46);
	BufferedImage fb2 = fb.getSubimage(0,92,46,46);
	BufferedImage fb3 = fb.getSubimage(0,138,46,46);
	BufferedImage fb4 = fb.getSubimage(0,184,46,46);
	BufferedImage fb5 = fb.getSubimage(0,230,46,46);
	BufferedImage fb6 = fb.getSubimage(0,276,46,46);
	BufferedImage fb7 = fb.getSubimage(0,322,46,46);
	BufferedImage fb8 = fb.getSubimage(0,368,46,46);
	BufferedImage fb9 = fb.getSubimage(0,414,46,46);
	BufferedImage fb10 = fb.getSubimage(0,460,46,46);
	BufferedImage fb11 = fb.getSubimage(0,506,46,46);
	BufferedImage fb12 = fb.getSubimage(0,552,46,46);
	BufferedImage fb13 = fb.getSubimage(0,598,46,46);
	BufferedImage fb14 = fb.getSubimage(0,644,46,46);
	BufferedImage fb15 = fb.getSubimage(0,690,46,46);
	BufferedImage fb16 = fb.getSubimage(0,736,46,46);
	BufferedImage fb17 = fb.getSubimage(0,782,46,46);
	BufferedImage fb18 = fb.getSubimage(0,828,46,46);
	
	BufferedImage fc0 = fc.getSubimage(0,0,46,46);
	BufferedImage fc1 = fc.getSubimage(0,46,46,46);
	BufferedImage fc2 = fc.getSubimage(0,92,46,46);
	BufferedImage fc3 = fc.getSubimage(0,138,46,46);
	BufferedImage fc4 = fc.getSubimage(0,184,46,46);
	BufferedImage fc5 = fc.getSubimage(0,230,46,46);
	BufferedImage fc6 = fc.getSubimage(0,276,46,46);
	BufferedImage fc7 = fc.getSubimage(0,322,46,46);
	BufferedImage fc8 = fc.getSubimage(0,368,46,46);
	BufferedImage fc9 = fc.getSubimage(0,414,46,46);
	BufferedImage fc10 = fc.getSubimage(0,460,46,46);
	BufferedImage fc11 = fc.getSubimage(0,506,46,46);
	BufferedImage fc12 = fc.getSubimage(0,552,46,46);
	BufferedImage fc13 = fc.getSubimage(0,598,46,46);
	BufferedImage fc14 = fc.getSubimage(0,644,46,46);
	BufferedImage fc15 = fc.getSubimage(0,690,46,46);
	BufferedImage fc16 = fc.getSubimage(0,736,46,46);
	BufferedImage fc17 = fc.getSubimage(0,782,46,46);
	BufferedImage fc18 = fc.getSubimage(0,828,46,46);
	
	BufferedImage fd0 = fd.getSubimage(0,0,46,46);
	BufferedImage fd1 = fd.getSubimage(0,46,46,46);
	BufferedImage fd2 = fd.getSubimage(0,92,46,46);
	BufferedImage fd3 = fd.getSubimage(0,138,46,46);
	BufferedImage fd4 = fd.getSubimage(0,184,46,46);
	BufferedImage fd5 = fd.getSubimage(0,230,46,46);
	BufferedImage fd6 = fd.getSubimage(0,276,46,46);
	BufferedImage fd7 = fd.getSubimage(0,322,46,46);
	BufferedImage fd8 = fd.getSubimage(0,368,46,46);
	BufferedImage fd9 = fd.getSubimage(0,414,46,46);
	BufferedImage fd10 = fd.getSubimage(0,460,46,46);
	BufferedImage fd11 = fd.getSubimage(0,506,46,46);
	BufferedImage fd12 = fd.getSubimage(0,552,46,46);
	BufferedImage fd13 = fd.getSubimage(0,598,46,46);
	BufferedImage fd14 = fd.getSubimage(0,644,46,46);
	BufferedImage fd15 = fd.getSubimage(0,690,46,46);
	BufferedImage fd16 = fd.getSubimage(0,736,46,46);
	BufferedImage fd17 = fd.getSubimage(0,782,46,46);
	BufferedImage fd18 = fd.getSubimage(0,828,46,46);
		
	public Buster(float x, float y, Handler handler, ObjectId id) {
		super(x, y, id);
		this.handler = handler;
	}
	

	public void tick(LinkedList<GameObject> object) {
		if(x<63 || x>1077 || y<63 || y>582) {
			handler.removeObject(this);
		}
		if(createdBy == 1){
			switch(direction){
			case 1: if(f > 1) x+=6; break;
			case 2: if(f > 1) x-=6; break;
			case 3: if(f > 1) y-=6; break;
			case 4: if(f > 1) y+=6; break;}
			}
		
			if(createdBy == 2){
				switch(direction2){
				case 1: if(f > 1) x+=6; break;
				case 2: if(f > 1) x-=6; break;
				case 3: if(f > 1) y-=6; break;
				case 4: if(f > 1) y+=6; break;
				}
			
		}
		
		long timeNow = System.currentTimeMillis();
		if(timeNow - timeCreation > frameDelay){
			f++;
			timeCreation = System.currentTimeMillis();
		}
		
		if(f == 20) {
			f = 13;			
		}
		col(object);
	}
	
	
	public void render(Graphics g) {
		//Graphics2D g2d = (Graphics2D) g;
		if(createdBy == 1){
			if(direction == 1){
		if(f == 1) g.drawImage(f0, (int)x, (int)y,150,150,null);
		if(f == 2) g.drawImage(f1, (int)x, (int)y,150,150,null);
		if(f == 3) g.drawImage(f2, (int)x, (int)y,150,150,null);
		if(f == 4) g.drawImage(f3, (int)x, (int)y,150,150,null);
		if(f == 5) g.drawImage(f4, (int)x, (int)y,150,150,null);
		if(f == 6) g.drawImage(f5, (int)x, (int)y,150,150,null);
		if(f == 7) g.drawImage(f6, (int)x, (int)y,150,150,null);
		if(f == 8) g.drawImage(f7, (int)x, (int)y,150,150,null);
		if(f == 9) g.drawImage(f8, (int)x, (int)y,150,150,null);
		if(f == 10)g.drawImage(f9, (int)x, (int)y,150,150,null);
		if(f == 11) g.drawImage(f10, (int)x, (int)y,150,150,null);
		if(f == 12) g.drawImage(f11, (int)x, (int)y,150,150,null);
		if(f == 13) g.drawImage(f12, (int)x, (int)y,150,150,null);
		if(f == 14) g.drawImage(f13, (int)x, (int)y,150,150,null);
		if(f == 15) g.drawImage(f14, (int)x, (int)y,150,150,null);
		if(f == 16) g.drawImage(f15, (int)x, (int)y,150,150,null);
		if(f == 17) g.drawImage(f16, (int)x, (int)y,150,150,null);
		if(f == 18) g.drawImage(f17, (int)x, (int)y,150,150,null);
		if(f == 19) g.drawImage(f18, (int)x, (int)y,150,150,null);
			}
			if(direction == 2){
			if(f == 1) g.drawImage(fb0, (int)x, (int)y,150,150,null);
			if(f == 2) g.drawImage(fb1, (int)x, (int)y,150,150,null);
			if(f == 3) g.drawImage(fb2, (int)x, (int)y,150,150,null);
			if(f == 4) g.drawImage(fb3, (int)x, (int)y,150,150,null);
			if(f == 5) g.drawImage(fb4, (int)x, (int)y,150,150,null);
			if(f == 6) g.drawImage(fb5, (int)x, (int)y,150,150,null);
			if(f == 7) g.drawImage(fb6, (int)x, (int)y,150,150,null);
			if(f == 8) g.drawImage(fb7, (int)x, (int)y,150,150,null);
			if(f == 9) g.drawImage(fb8, (int)x, (int)y,150,150,null);
			if(f == 10)g.drawImage(fb9, (int)x, (int)y,150,150,null);
			if(f == 11) g.drawImage(fb10, (int)x, (int)y,150,150,null);
			if(f == 12) g.drawImage(fb11, (int)x, (int)y,150,150,null);
			if(f == 13) g.drawImage(fb12, (int)x, (int)y,150,150,null);
			if(f == 14) g.drawImage(fb13, (int)x, (int)y,150,150,null);
			if(f == 15) g.drawImage(fb14, (int)x, (int)y,150,150,null);
			if(f == 16) g.drawImage(fb15, (int)x, (int)y,150,150,null);
			if(f == 17) g.drawImage(fb16, (int)x, (int)y,150,150,null);
			if(f == 18) g.drawImage(fb17, (int)x, (int)y,150,150,null);
			if(f == 19) g.drawImage(fb18, (int)x, (int)y,150,150,null);}
		}
		
		if(direction == 3){
			if(f == 1) g.drawImage(fc0, (int)x, (int)y,150,150,null);
			if(f == 2) g.drawImage(fc1, (int)x, (int)y,150,150,null);
			if(f == 3) g.drawImage(fc2, (int)x, (int)y,150,150,null);
			if(f == 4) g.drawImage(fc3, (int)x, (int)y,150,150,null);
			if(f == 5) g.drawImage(fc4, (int)x, (int)y,150,150,null);
			if(f == 6) g.drawImage(fc5, (int)x, (int)y,150,150,null);
			if(f == 7) g.drawImage(fc6, (int)x, (int)y,150,150,null);
			if(f == 8) g.drawImage(fc7, (int)x, (int)y,150,150,null);
			if(f == 9) g.drawImage(fc8, (int)x, (int)y,150,150,null);
			if(f == 10)g.drawImage(fc9, (int)x, (int)y,150,150,null);
			if(f == 11) g.drawImage(fc10, (int)x, (int)y,150,150,null);
			if(f == 12) g.drawImage(fc11, (int)x, (int)y,150,150,null);
			if(f == 13) g.drawImage(fc12, (int)x, (int)y,150,150,null);
			if(f == 14) g.drawImage(fc13, (int)x, (int)y,150,150,null);
			if(f == 15) g.drawImage(fc14, (int)x, (int)y,150,150,null);
			if(f == 16) g.drawImage(fc15, (int)x, (int)y,150,150,null);
			if(f == 17) g.drawImage(fc16, (int)x, (int)y,150,150,null);
			if(f == 18) g.drawImage(fc17, (int)x, (int)y,150,150,null);
			if(f == 19) g.drawImage(fc18, (int)x, (int)y,150,150,null);
		}
		
		if(direction == 4){
			if(f == 1) g.drawImage(fd0, (int)x, (int)y,150,150,null);
			if(f == 2) g.drawImage(fd1, (int)x, (int)y,150,150,null);
			if(f == 3) g.drawImage(fd2, (int)x, (int)y,150,150,null);
			if(f == 4) g.drawImage(fd3, (int)x, (int)y,150,150,null);
			if(f == 5) g.drawImage(fd4, (int)x, (int)y,150,150,null);
			if(f == 6) g.drawImage(fd5, (int)x, (int)y,150,150,null);
			if(f == 7) g.drawImage(fd6, (int)x, (int)y,150,150,null);
			if(f == 8) g.drawImage(fd7, (int)x, (int)y,150,150,null);
			if(f == 9) g.drawImage(fd8, (int)x, (int)y,150,150,null);
			if(f == 10)g.drawImage(fd9, (int)x, (int)y,150,150,null);
			if(f == 11) g.drawImage(fd10, (int)x, (int)y,150,150,null);
			if(f == 12) g.drawImage(fd11, (int)x, (int)y,150,150,null);
			if(f == 13) g.drawImage(fd12, (int)x, (int)y,150,150,null);
			if(f == 14) g.drawImage(fd13, (int)x, (int)y,150,150,null);
			if(f == 15) g.drawImage(fd14, (int)x, (int)y,150,150,null);
			if(f == 16) g.drawImage(fd15, (int)x, (int)y,150,150,null);
			if(f == 17) g.drawImage(fd16, (int)x, (int)y,150,150,null);
			if(f == 18) g.drawImage(fd17, (int)x, (int)y,150,150,null);
			if(f == 19) g.drawImage(fd18, (int)x, (int)y,150,150,null);
		}
		
		if(createdBy == 2){
			if(direction2 == 1){
		if(f == 1) g.drawImage(f0, (int)x, (int)y,150,150,null);
		if(f == 2) g.drawImage(f1, (int)x, (int)y,150,150,null);
		if(f == 3) g.drawImage(f2, (int)x, (int)y,150,150,null);
		if(f == 4) g.drawImage(f3, (int)x, (int)y,150,150,null);
		if(f == 5) g.drawImage(f4, (int)x, (int)y,150,150,null);
		if(f == 6) g.drawImage(f5, (int)x, (int)y,150,150,null);
		if(f == 7) g.drawImage(f6, (int)x, (int)y,150,150,null);
		if(f == 8) g.drawImage(f7, (int)x, (int)y,150,150,null);
		if(f == 9) g.drawImage(f8, (int)x, (int)y,150,150,null);
		if(f == 10)g.drawImage(f9, (int)x, (int)y,150,150,null);
		if(f == 11) g.drawImage(f10, (int)x, (int)y,150,150,null);
		if(f == 12) g.drawImage(f11, (int)x, (int)y,150,150,null);
		if(f == 13) g.drawImage(f12, (int)x, (int)y,150,150,null);
		if(f == 14) g.drawImage(f13, (int)x, (int)y,150,150,null);
		if(f == 15) g.drawImage(f14, (int)x, (int)y,150,150,null);
		if(f == 16) g.drawImage(f15, (int)x, (int)y,150,150,null);
		if(f == 17) g.drawImage(f16, (int)x, (int)y,150,150,null);
		if(f == 18) g.drawImage(f17, (int)x, (int)y,150,150,null);
		if(f == 19) g.drawImage(f18, (int)x, (int)y,150,150,null);
			}
			if(direction2 == 2){
			if(f == 1) g.drawImage(fb0, (int)x, (int)y,150,150,null);
			if(f == 2) g.drawImage(fb1, (int)x, (int)y,150,150,null);
			if(f == 3) g.drawImage(fb2, (int)x, (int)y,150,150,null);
			if(f == 4) g.drawImage(fb3, (int)x, (int)y,150,150,null);
			if(f == 5) g.drawImage(fb4, (int)x, (int)y,150,150,null);
			if(f == 6) g.drawImage(fb5, (int)x, (int)y,150,150,null);
			if(f == 7) g.drawImage(fb6, (int)x, (int)y,150,150,null);
			if(f == 8) g.drawImage(fb7, (int)x, (int)y,150,150,null);
			if(f == 9) g.drawImage(fb8, (int)x, (int)y,150,150,null);
			if(f == 10)g.drawImage(fb9, (int)x, (int)y,150,150,null);
			if(f == 11) g.drawImage(fb10, (int)x, (int)y,150,150,null);
			if(f == 12) g.drawImage(fb11, (int)x, (int)y,150,150,null);
			if(f == 13) g.drawImage(fb12, (int)x, (int)y,150,150,null);
			if(f == 14) g.drawImage(fb13, (int)x, (int)y,150,150,null);
			if(f == 15) g.drawImage(fb14, (int)x, (int)y,150,150,null);
			if(f == 16) g.drawImage(fb15, (int)x, (int)y,150,150,null);
			if(f == 17) g.drawImage(fb16, (int)x, (int)y,150,150,null);
			if(f == 18) g.drawImage(fb17, (int)x, (int)y,150,150,null);
			if(f == 19) g.drawImage(fb18, (int)x, (int)y,150,150,null);}
		}
		
		if(direction2 == 3){
			if(f == 1) g.drawImage(fc0, (int)x, (int)y,150,150,null);
			if(f == 2) g.drawImage(fc1, (int)x, (int)y,150,150,null);
			if(f == 3) g.drawImage(fc2, (int)x, (int)y,150,150,null);
			if(f == 4) g.drawImage(fc3, (int)x, (int)y,150,150,null);
			if(f == 5) g.drawImage(fc4, (int)x, (int)y,150,150,null);
			if(f == 6) g.drawImage(fc5, (int)x, (int)y,150,150,null);
			if(f == 7) g.drawImage(fc6, (int)x, (int)y,150,150,null);
			if(f == 8) g.drawImage(fc7, (int)x, (int)y,150,150,null);
			if(f == 9) g.drawImage(fc8, (int)x, (int)y,150,150,null);
			if(f == 10)g.drawImage(fc9, (int)x, (int)y,150,150,null);
			if(f == 11) g.drawImage(fc10, (int)x, (int)y,150,150,null);
			if(f == 12) g.drawImage(fc11, (int)x, (int)y,150,150,null);
			if(f == 13) g.drawImage(fc12, (int)x, (int)y,150,150,null);
			if(f == 14) g.drawImage(fc13, (int)x, (int)y,150,150,null);
			if(f == 15) g.drawImage(fc14, (int)x, (int)y,150,150,null);
			if(f == 16) g.drawImage(fc15, (int)x, (int)y,150,150,null);
			if(f == 17) g.drawImage(fc16, (int)x, (int)y,150,150,null);
			if(f == 18) g.drawImage(fc17, (int)x, (int)y,150,150,null);
			if(f == 19) g.drawImage(fc18, (int)x, (int)y,150,150,null);
		}
		
		if(direction2 == 4){
			if(f == 1) g.drawImage(fd0, (int)x, (int)y,150,150,null);
			if(f == 2) g.drawImage(fd1, (int)x, (int)y,150,150,null);
			if(f == 3) g.drawImage(fd2, (int)x, (int)y,150,150,null);
			if(f == 4) g.drawImage(fd3, (int)x, (int)y,150,150,null);
			if(f == 5) g.drawImage(fd4, (int)x, (int)y,150,150,null);
			if(f == 6) g.drawImage(fd5, (int)x, (int)y,150,150,null);
			if(f == 7) g.drawImage(fd6, (int)x, (int)y,150,150,null);
			if(f == 8) g.drawImage(fd7, (int)x, (int)y,150,150,null);
			if(f == 9) g.drawImage(fd8, (int)x, (int)y,150,150,null);
			if(f == 10)g.drawImage(fd9, (int)x, (int)y,150,150,null);
			if(f == 11) g.drawImage(fd10, (int)x, (int)y,150,150,null);
			if(f == 12) g.drawImage(fd11, (int)x, (int)y,150,150,null);
			if(f == 13) g.drawImage(fd12, (int)x, (int)y,150,150,null);
			if(f == 14) g.drawImage(fd13, (int)x, (int)y,150,150,null);
			if(f == 15) g.drawImage(fd14, (int)x, (int)y,150,150,null);
			if(f == 16) g.drawImage(fd15, (int)x, (int)y,150,150,null);
			if(f == 17) g.drawImage(fd16, (int)x, (int)y,150,150,null);
			if(f == 18) g.drawImage(fd17, (int)x, (int)y,150,150,null);
			if(f == 19) g.drawImage(fd18, (int)x, (int)y,150,150,null);
		}
		
	}
	
	public void col(LinkedList<GameObject> object){
		GameObject p1 = null;
		GameObject p2 = null;
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject temp = handler.object.get(i);
			
			if(temp.getId() == ObjectId.Player) p1 = handler.object.get(i);
			if(temp.getId() == ObjectId.Player2) p2 = handler.object.get(i);
		}
		
		if(createdBy == 1){
			if(getBounds().intersects(p2.getBounds()) || 
			getBounds().intersects(((Player2) p2).getBoundsTop()) || 
			getBounds().intersects(((Player2) p2).getBoundsRight()) ||
			getBounds().intersects(((Player2) p2).getBoundsLeft())){
				handler.removeObject(this);
				Player2.life2 = Player2.life2 - 20;
			}
			}
		
		else{
		if(getBounds().intersects(p1.getBounds()) || 
		getBounds().intersects(((Player) p1).getBoundsTop()) || 
		getBounds().intersects(((Player) p1).getBoundsRight()) ||
		getBounds().intersects(((Player) p1).getBoundsLeft())){
			handler.removeObject(this);
			Player.life = Player.life - 20;
		}}
	
		}				
			
	

	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,150,150);
	}

}
