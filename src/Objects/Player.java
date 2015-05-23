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
import Main.Handler;
import Main.Loader;

public class Player extends GameObject{
	public static float vel = 6;
	private float width = 50, height = 50;
	public static float life = 100;
	Loader load = new Loader();
	public static String nave;
	BufferedImage right = load.loadImage("/"+nave+"/right.png");
	BufferedImage left = load.loadImage("/"+nave+"/left.png");
	BufferedImage top = load.loadImage("/"+nave+"/top.png");
	BufferedImage down = load.loadImage("/"+nave+"/down.png");
	private Handler handler;
	int mix = 0;
	public static boolean hit = false;
	public static int pointing = 1;
	public static boolean paralyzed = false;
	public static long timePar = 0;
	public static int ability1 = 0;
	public static int ability2 = 0;
	public static int ability3 = 0;
	public static int a1inCD = 0;
	public static int a2inCD = 0;
	public static int a3inCD = 0;
	public static long a1CD = 0;
	public static long a2CD = 0;
	public static long a3CD = 0;
	public static long a1Creation = 0;
	public static long a2Creation = 0;
	public static long a3Creation = 0;
	public static long slowedBy = 0;
	public static boolean slowed = false;
	public static long timeSlowed = 0;
	public static long slowDuration = 0;
	public static long parDur = 0;
	
	
	public Player(float x, float y, Handler handler, ObjectId id) {
		super(x, y, id);
		this.handler = handler;
	}
	
	public void tick(LinkedList<GameObject> object) {
		if(x < 63) x = 63;
		if(x > 1077) x = 1077;
		if(y < 63) y = 63;
		if(y > 582) y = 582;
		
		if(Input.keyDown[0]) x += vel;
		if(Input.keyDown[1]) x -= vel;
		if(Input.keyDown[2]) y -= vel;
		if(Input.keyDown[3]) y += vel;
		
		if(slowed == true) {
			long timeNow = System.currentTimeMillis();
			if(timeNow - timeSlowed > slowDuration) {
				slowed = false;
				slowedBy = 0;
				timeSlowed = 0;
				Input.p1vel = 6;
			} else {
				
			}
	}
		
		colission(object);
	}
	
	private void colission(LinkedList<GameObject> object) {
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject temp = handler.object.get(i);
			
			if(temp.getId() == ObjectId.Block){
				if(getBoundsTop().intersects(temp.getBounds())) y = temp.getY()+70;
				if(getBounds().intersects(temp.getBounds())) y = temp.getY()-50;			
				if(getBoundsRight().intersects(temp.getBounds())) x = temp.getX()-50;					
				if(getBoundsLeft().intersects(temp.getBounds())) x = temp.getX()+70;}
			
		
			if(temp.getId() == ObjectId.Paralyzer2){
				if(hit == false)
					if(getBoundsTop().intersects(temp.getBounds()) || 
						getBounds().intersects(temp.getBounds()) || 
						getBoundsRight().intersects(temp.getBounds()) || 
						getBoundsLeft().intersects(temp.getBounds())){
						if(slowed == true){
							timePar = System.currentTimeMillis();
							life = life-7;
							parDur = 1500;
							velX = 0;
							velY = 0;
							paralyzed = true;
							hit = true;
						}else {
							Input.p1vel = 2;
							life = life-5;
							slowed = true;
							timeSlowed = System.currentTimeMillis();
							slowDuration = 1000;
							hit = true;
						} 
				}
			}	
		}
	}
	
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		if(life < 0) life = 0;
		g.setColor(new Color(155,155,155));
		g.fillRoundRect(53, 12, 540, 28, 10, 38);
		
		if(life > 75) g.setColor(new Color(0, 255, 0));
		else if(life > 50) g.setColor(new Color(255, 255, 51));
		else if(life > 25) g.setColor(new Color(255, 150, 0));
		else g.setColor(new Color(255, 0, 0));
		
		g.fillRoundRect(53, 12, (int) (life*5.4), 28, 10, 38);
			
		if(pointing == 1) g.drawImage(right,(int)x,(int)y,50,50,null);
		else if(pointing == 2) g.drawImage(left,(int)x,(int)y,50,50,null);
		else if(pointing == 3) g.drawImage(top,(int)x,(int)y,50,50,null);
		else if(pointing == 4) g.drawImage(down,(int)x,(int)y,50,50,null);
		
		if(Input.developerMode == true) {
			g.setColor(Color.green);
			g2d.draw(getBounds());
			g2d.draw(getBoundsRight());
			g2d.draw(getBoundsLeft());
			g2d.draw(getBoundsTop());
		}
	
		g.setColor(Color.white);	
		if(a1inCD == 0){
			g.fillRect(7, 53, 40, 40);
		}else {
			long timeNow = System.currentTimeMillis();
			if(timeNow - a1Creation > a1CD)
				a1inCD = 0;
			g.setColor(Color.gray);
			g.fillRect(7, 53, 40, 40);
		}
		
		g.setColor(Color.white);
		if(a2inCD == 0){
			g.fillRect(7, 103, 40, 40);
		} else{
			long timeNow = System.currentTimeMillis();
			if(timeNow - a2Creation > a2CD)
				a2inCD = 0;
			g.setColor(Color.gray);
			g.fillRect(7, 103, 40, 40);	
		}

		g.setColor(Color.white);
		if(a3inCD == 0){
			g.fillRect(7, 153, 40, 40);
		}else {
			long timeNow = System.currentTimeMillis();
			if(timeNow - a3Creation > a3CD)
				a3inCD = 0;
			g.setColor(Color.gray);
			g.fillRect(7, 153, 40, 40);
		}
	}

	public Rectangle getBounds() { return new Rectangle((int) ((int)x+(width/4)), (int) ((int)y+(height/2)),(int)(width/2),(int)(height/2)); }
	public Rectangle getBoundsTop() { return new Rectangle((int) ((int)x+(width/4)), (int)y,(int)width/2,(int)height/2); }
	public Rectangle getBoundsRight() { return new Rectangle((int)x+45, (int)y+1,(int)5,(int)height-2); }	
	public Rectangle getBoundsLeft() { return new Rectangle((int)x, (int)y+1,(int)5,(int)height-2); }
}
