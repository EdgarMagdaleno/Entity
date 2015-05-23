package Abilities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import Framework.GameObject;
import Framework.ObjectId;
import Main.Game;
import Main.Handler;
import Main.Loader;
import Objects.Player;
import Objects.Player2;

public class p2bala extends GameObject{
	
	Handler handler;
	int direction = Player2.pointing2;
	Loader loader = new Loader();
	
	public p2bala(float x, float y, Handler handler,ObjectId id) {
		super(x, y, id);
		this.handler = handler;
	}

	
	public void tick(LinkedList<GameObject> object) {
		if(direction == 1){
			velX = 10;
			x += velX;
		}else if(direction == 2){
			velX = -10;
			x += velX;
		}else if(direction == 3){
			velY = -10;
			y += velY;
		}else if(direction == 4){
			velY = 10;
			y += velY;
		}
		
		
		
		col(object);
	}

	
	public void render(Graphics g) {
		
		if(direction == 1) g.drawImage(Game.bala1R, (int) x, (int) y, null);
		if(direction == 2) g.drawImage(Game.bala1L, (int) x, (int) y, null); 
		if(direction == 3) g.drawImage(Game.bala1U, (int) x, (int) y, null);
		if(direction == 4) g.drawImage(Game.bala1D, (int) x, (int) y, null);
	}

	public Rectangle getBounds() {
		return new Rectangle ((int)x,(int)y,10,10);
	}
	
	
	private void col(LinkedList<GameObject> object){
	

		
		for (int i = 0; i < handler.object.size(); i++)
		{
			GameObject temp = handler.object.get(i);
			
			if(temp.getId() == ObjectId.Block)
				if(getBounds().intersects(temp.getBounds()))
					handler.removeObject(this);

			if(temp.getId() == ObjectId.WallU)
				if(getBounds().intersects(temp.getBounds()))
					handler.removeObject(this);
			
			if(temp.getId() == ObjectId.WallD)
				if(getBounds().intersects(temp.getBounds()))
					handler.removeObject(this);
			
			if(temp.getId() == ObjectId.WallR)
				if(getBounds().intersects(temp.getBounds()))
					handler.removeObject(this);
			
			if(temp.getId() == ObjectId.WallL)
				if(getBounds().intersects(temp.getBounds()))
					handler.removeObject(this);
			
			if(temp.getId() == ObjectId.Player){
				if(getBounds().intersects(temp.getBounds())){
					Player.life = Player.life -5; 
					handler.removeObject(this);
					}
				
				if(getBounds().intersects(((Player) temp).getBoundsTop())){
					Player.life = Player.life -5; 
					handler.removeObject(this);
					}
				
				if(getBounds().intersects(((Player) temp).getBoundsRight())){
					Player.life = Player.life -5; 
					handler.removeObject(this);
					}
				
				if(getBounds().intersects(((Player) temp).getBoundsLeft())){
					Player.life = Player.life -5; 
					handler.removeObject(this);
					}
			}
				
				
				
		}
	}
		
}

