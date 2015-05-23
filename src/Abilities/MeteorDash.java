package Abilities;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import Framework.GameObject;
import Framework.Input;
import Framework.ObjectId;
import Main.Handler;
import Main.Loader;
import Objects.Player;
import Objects.Player2;

public class MeteorDash extends GameObject{
	
	public static final long Cooldown = 4500;
	Loader load = new Loader();
	Handler handler;
	int direction = Player.pointing;
	int direction2 = Player2.pointing2;
	public static int createdBy = 0;
	public static long timeCreation = 0;
	public static long timeCreation2 = 0;
	BufferedImage fb = load.loadImage("/fireBall.png");
	BufferedImage fb2 = load.loadImage("/fireBall2.png");
	BufferedImage fb3 = load.loadImage("/fireBall3.png");
	BufferedImage fb4 = load.loadImage("/fireBall4.png");
	Rectangle r;
	
	public MeteorDash(float x, float y, Handler handler, ObjectId id) {
		super(x, y, id);
		this.handler = handler;
	}

	public void tick(LinkedList<GameObject> object) {
		GameObject p1 = null;
		GameObject p2 = null;
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject temp = handler.object.get(i);
			
			if(temp.getId() == ObjectId.Player) p1 = handler.object.get(i);
			if(temp.getId() == ObjectId.Player2) p2 = handler.object.get(i);
		}
		if(createdBy == 1)
			switch(direction){
			case 1: 
				p1.setX(x+40); 
				p1.setY(y+15); 
				x+=20; 
				Player.paralyzed = true; 
				break;
			case 2:
				p1.setX(x+10); 
				p1.setY(y+15); 
				x-=20;  
				Player.paralyzed = true; 
				break;
			case 3: 
				p1.setY(y+10); 
				p1.setX(x+15); 
				y-=20; 
				Player.paralyzed = true; 
				break;
			case 4: 
				p1.setY(y+40); 
				y+=20; 
				p1.setX(x+15); 
				Player.paralyzed = true; 
				break;
			}
		
		if(createdBy == 2){
			switch(direction2){
			case 1: 
				p2.setX(x+40); 
				p2.setY(y+15); 
				x+=20; 
				Player2.paralized = true; 
				break;
			case 2:
				p2.setX(x+10); 
				p2.setY(y+15); 
				x-=20;  
				Player2.paralized = true; 
				break;
			case 3: 
				p2.setY(y+10); 
				p2.setX(x+15); 
				y-=20; 
				Player2.paralized = true; 
				break;
			case 4: 
				p2.setY(y+40); 
				y+=20; 
				p2.setX(x+15); 
				Player2.paralized = true; 
				break;
			}
		}
		col(object);
	}

	public void render(Graphics g) {
		if(createdBy == 1){
			switch(direction){
			case 1: g.drawImage(fb,(int)x,(int)y,null); break;
			case 2: g.drawImage(fb2,(int)x,(int)y,null); break;
			case 3: g.drawImage(fb3,(int)x,(int)y,null); break;
			case 4: g.drawImage(fb4,(int)x,(int)y,null); break;
			}
		
		
		}
		
		if(createdBy == 2){
			switch(direction2){
			case 1: g.drawImage(fb,(int)x,(int)y,null); break;
			case 2: g.drawImage(fb2,(int)x,(int)y,null); break;
			case 3: g.drawImage(fb3,(int)x,(int)y,null); break;
			case 4: g.drawImage(fb4,(int)x,(int)y,null); break;
			}
		
		
		}
		
		if(Input.developerMode == true){
			Graphics2D g2d = (Graphics2D) g;
			g2d.draw(getBounds());
		}

	}

	public Rectangle getBounds() {	
		if(createdBy == 1){
			if(direction == 1) r = new Rectangle((int)x+40,(int)y+15,50,50);
			if(direction == 2) r = new Rectangle((int)x+10,(int)y+15,50,50);
			if(direction == 3) r = new Rectangle((int)x+15,(int)y+10,50,50);
			if(direction == 4) r = new Rectangle((int)x+15,(int)y+40,50,50);}
		else{
			if(direction2 == 1) r = new Rectangle((int)x+40,(int)y+15,50,50);
			if(direction2 == 2) r = new Rectangle((int)x+10,(int)y+15,50,50);
			if(direction2 == 3) r = new Rectangle((int)x+15,(int)y+10,50,50);
			if(direction2 == 4) r = new Rectangle((int)x+15,(int)y+40,50,50);
		}
			return r;
	}
	
	private void col(LinkedList<GameObject> object){
		for(int i = 0; i < handler.object.size(); i++){
			GameObject temp = handler.object.get(i);
			
			if(temp.getId() == ObjectId.WallR) if(getBounds().intersects(temp.getBounds())) {handler.removeObject(this); Player.paralyzed = false;}
			if(temp.getId() == ObjectId.WallD) if(getBounds().intersects(temp.getBounds())) {handler.removeObject(this); Player.paralyzed = false;}
			if(temp.getId() == ObjectId.WallU) if(getBounds().intersects(temp.getBounds())) {handler.removeObject(this); Player.paralyzed = false;}
			if(temp.getId() == ObjectId.WallL) if(getBounds().intersects(temp.getBounds())) {handler.removeObject(this); Player.paralyzed = false;}
			if(temp.getId() == ObjectId.Block) if(getBounds().intersects(temp.getBounds())) {handler.removeObject(this); Player.paralyzed = false;}
			
			
			if(temp.getId() == ObjectId.Player2){
				if(createdBy == 1){
				if(getBounds().intersects(temp.getBounds()) || 
				getBounds().intersects(((Player2) temp).getBoundsTop()) || 
				getBounds().intersects(((Player2) temp).getBoundsRight()) ||
				getBounds().intersects(((Player2) temp).getBoundsLeft())){
					handler.removeObject(this);
					temp.setVelX(0);
					temp.setVelY(0);
					Player.paralyzed = false;
					Player2.slowed = true;
					Player2.slowDur = 1000;
					Input.p2vel = 2;
					Player2.timeSlowed = System.currentTimeMillis();
					Player2.life2 = Player2.life2 - 15;
				}
							
				}
			}
			
			if(temp.getId() == ObjectId.Player){
				if(createdBy == 2){
				if(getBounds().intersects(temp.getBounds()) || 
				getBounds().intersects(((Player) temp).getBoundsTop()) || 
				getBounds().intersects(((Player) temp).getBoundsRight()) ||
				getBounds().intersects(((Player) temp).getBoundsLeft())){
					handler.removeObject(this);
					Player2.paralized = false;
					Player.paralyzed = true;
					temp.setVelX(0);
					temp.setVelY(0);
					Input.p1vel = 2;
					Player.timeSlowed = System.currentTimeMillis();
					Player.slowDuration = 1000;
					Player.life = Player.life - 15;
				}
							
				}
			}
		}
		
		
		
	}

}
