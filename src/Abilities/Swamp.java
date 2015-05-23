package Abilities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import Framework.GameObject;
import Framework.Input;
import Framework.ObjectId;
import Main.Handler;
import Objects.Player;
import Objects.Player2;

public class Swamp extends GameObject{
	
	public static int createdBy = 0;
	public static long timeCreation = 0;
	public static long timeCreation2 = 0;
	int direction = Player.pointing;
	int direction2 = Player2.pointing2;
	public static long slowDuration = 2000;
	public static final int Cooldown = 1500;
	private Handler handler;
	
	public Swamp(float x, float y, Handler handler,ObjectId id) {
		super(x, y, id);
		this.handler = handler;
	}

	
	public void tick(LinkedList<GameObject> object) {
		if(createdBy == 1)
		switch(direction){
			case 1:
				x+=7;
				break;
		
			case 2:
				x-=7;
				break;
			
			case 3:
				y-=7;
				break;
			
			case 4:
				y+=7;
				break;
		} else
			switch(direction2){
			case 1:
				x+=7;
				break;
		
			case 2:
				x-=7;
				break;
			
			case 3:
				y-=7;
				break;
			
			case 4:
				y+=7;
				break;
			}
			
		
		collision(object);
	}


	private void collision(LinkedList<GameObject> object) {
		
		for (int i = 0; i < handler.object.size(); i++)
		{
			GameObject temp = handler.object.get(i);
			if(temp.getId() == ObjectId.WallR) if(getBounds().intersects(temp.getBounds())) handler.removeObject(this);
			if(temp.getId() == ObjectId.WallD) if(getBounds().intersects(temp.getBounds())) handler.removeObject(this);
			if(temp.getId() == ObjectId.WallU) if(getBounds().intersects(temp.getBounds())) handler.removeObject(this);
			if(temp.getId() == ObjectId.WallL) if(getBounds().intersects(temp.getBounds())) handler.removeObject(this);
			if(temp.getId() == ObjectId.Block) if(getBounds().intersects(temp.getBounds())) handler.removeObject(this);
			
			if(createdBy == 1){
				if(temp.getId() == ObjectId.Player2) {
					if(getBounds().intersects(temp.getBounds())) {
						handler.removeObject(this); 
						Player2.slowDur = Player2.slowDur + 3000;
						Input.p2vel = 2; 
						Player2.slowedBy = 1;
						Player2.slowed = true;
						Player2.timeSlowed = System.currentTimeMillis();				
						}
					if(getBounds().intersects(((Player2) temp).getBoundsTop())){
						Player2.slowDur = Player2.slowDur + 3000;
					handler.removeObject(this); 
					Input.p2vel = 2; 
					Player2.slowed = true;
					Player2.slowedBy = 1;
					Player2.timeSlowed = System.currentTimeMillis();				
					}
					if(getBounds().intersects(((Player2) temp).getBoundsLeft())) {
					Player2.slowDur = Player2.slowDur + 3000;
					handler.removeObject(this); 
					Input.p2vel = 2; 
					Player2.slowed = true;
					Player2.slowedBy = 1;
					Player2.timeSlowed = System.currentTimeMillis();				
					}
					if(getBounds().intersects(((Player2) temp).getBoundsRight()))
					{handler.removeObject(this); 
					Player2.slowDur = Player2.slowDur + 3000;
					Input.p2vel = 2; 
					Player2.slowedBy = 1;
					Player2.slowed = true;
					Player2.timeSlowed = System.currentTimeMillis();				
					}
				}
			}else if(createdBy == 2){
				if(temp.getId() == ObjectId.Player) {
					if(getBounds().intersects(temp.getBounds())) {
						Input.p1vel = 2; 
						Player.slowDuration = Player.slowDuration + 3000;
						handler.removeObject(this); 
						Player.slowedBy = 1;
						Player.slowed = true;
						Player.timeSlowed = System.currentTimeMillis();				
						}
					if(getBounds().intersects(((Player) temp).getBoundsTop())){
						Input.p1vel = 2; 
						Player.slowDuration = Player.slowDuration + 3000;
						handler.removeObject(this); 
						Player.slowedBy = 1;
						Player.slowed = true;
						Player.timeSlowed = System.currentTimeMillis();				
						}
					if(getBounds().intersects(((Player) temp).getBoundsLeft())) {
						Input.p1vel = 2; 
						Player.slowDuration = Player.slowDuration + 3000;
						handler.removeObject(this); 
						Player.slowedBy = 1;
						Player.slowed = true;
						Player.timeSlowed = System.currentTimeMillis();				
						}
					if(getBounds().intersects(((Player) temp).getBoundsRight())) {
						Input.p1vel = 2; 
						Player.slowDuration = Player.slowDuration + 3000;
						handler.removeObject(this); 
						Player.slowedBy = 1; 
						Player.slowed = true;
						Player.timeSlowed = System.currentTimeMillis();				
						}
				}
			}
		}
	}


	public void render(Graphics g) {
		g.setColor(Color.blue);
			g.fillRect((int)x, (int)y, 50, 50);

	}


	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 50, 50);
	}

}
