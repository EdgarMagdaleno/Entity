package Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Framework.Mouse;

public class Lobby {
	boolean first = true;
	Loader load = new Loader();
	BufferedImage bg= load.loadImage("/bgT.png");
	BufferedImage red = load.loadImage("/red.png");
	BufferedImage green = load.loadImage("/green.png");
	BufferedImage wallV = load.loadImage("/wallV.gif");
	BufferedImage br = load.loadImage("/shipR.png");
	BufferedImage bl = load.loadImage("/shipL.png");
	BufferedImage lock = load.loadImage("/lock.png");
	BufferedImage lockS = load.loadImage("/lockS.png");
	BufferedImage playb = load.loadImage("/playb.png");
	BufferedImage playl = load.loadImage("/playl.png");
	public static BufferedImage[] nave = new BufferedImage[10];
	
	public void render(Graphics g){
		if(first) {
			init();
			first = false;
		}
		
		g.drawImage(bg, 0, 0, 1200, 720, null);
		g.drawImage(red, 181, 50, 238, 70,null);
		g.drawImage(green, 697, 50, 405, 70,null);
		g.drawImage(wallV, 593, 0, 10, 720, null);
		
		g.drawImage(br, 360, 320 + Mouse.p1r, 100, 60, null);
		g.drawImage(bl, 140, 320 + Mouse.p1l, 100, 60, null);
		
		g.drawImage(br, 960, 320 + Mouse.p2r, 100, 60, null);
		g.drawImage(bl, 740, 320 + Mouse.p2l, 100, 60, null);
		
		if(Mouse.p1choose && Mouse.p2choose) g.drawImage(playb, 530, 470 + Mouse.gameb, 140, 84, null);
		else g.drawImage(playl, 530, 470, 140, 84, null); 
		
		if(!Mouse.p1choose) g.drawImage(lock, 250, 320, 100, 60, null);
		else g.drawImage(lockS, 250, 320 + Mouse.p1lock, 100, 60,null);
		
		if(!Mouse.p2choose) g.drawImage(lock, 850, 320, 100, 60, null);
		else g.drawImage(lockS, 850, 320 + Mouse.p2lock, 100, 60,null);
		
		for(int i = 0; i < nave.length; i++) {
			if(Mouse.ship1 == i) {
				g.drawImage(nave[i], 250, 200, 100, 100, null);
				
				if(i >= 2 && i < nave.length - 2) {
					g.drawImage(nave[i - 2], 110, 234, 33, 33, null);	
					g.drawImage(nave[i - 1], 163, 217, 67, 67, null);
					g.drawImage(nave[i + 1], 370, 217, 67, 67, null);
					g.drawImage(nave[i + 2], 454, 234, 33, 33, null);
				} else if(i == 1) {
					g.drawImage(nave[nave.length - 1], 110, 234, 33, 33, null);	
					g.drawImage(nave[0], 163, 217, 67, 67, null);
					g.drawImage(nave[i + 1], 370, 217, 67, 67, null);
					g.drawImage(nave[i + 2], 454, 234, 33, 33, null);	
				}else if(i == 0){
					g.drawImage(nave[nave.length - 2], 110, 234, 33, 33, null);	
					g.drawImage(nave[nave.length - 1], 163, 217, 67, 67, null);
					g.drawImage(nave[i + 1], 370, 217, 67, 67, null);
					g.drawImage(nave[i + 2], 454, 234, 33, 33, null);						
				} else if(i == nave.length - 2) {
					g.drawImage(nave[i - 2], 110, 234, 33, 33, null);	
					g.drawImage(nave[i - 1], 163, 217, 67, 67, null);
					g.drawImage(nave[nave.length - 1], 370, 217, 67, 67, null);
					g.drawImage(nave[0], 454, 234, 33, 33, null);				
				} else if(i == nave.length - 1) {
					g.drawImage(nave[i - 2], 110, 234, 33, 33, null);	
					g.drawImage(nave[i - 1], 163, 217, 67, 67, null);
					g.drawImage(nave[0], 370, 217, 67, 67, null);
					g.drawImage(nave[1], 454, 234, 33, 33, null);					
				}
			}
			
		}
		
		for(int i = 0; i < nave.length; i++) {
			if(Mouse.ship2 == i){
				g.drawImage(nave[i], 850, 200, 100, 100, null);
				
				if(i >= 2 && i < nave.length - 2) {
					g.drawImage(nave[i - 2], 710, 234, 33, 33, null);	
					g.drawImage(nave[i - 1], 763, 217, 67, 67, null);
					g.drawImage(nave[i + 1], 970, 217, 67, 67, null);
					g.drawImage(nave[i + 2], 1054, 234, 33, 33, null);
				} else if(i == 1) {
					g.drawImage(nave[nave.length - 1], 710, 234, 33, 33, null);	
					g.drawImage(nave[0], 763, 217, 67, 67, null);
					g.drawImage(nave[i + 1], 970, 217, 67, 67, null);
					g.drawImage(nave[i + 2], 1054, 234, 33, 33, null);	
				}else if(i == 0){
					g.drawImage(nave[nave.length - 2], 710, 234, 33, 33, null);	
					g.drawImage(nave[nave.length - 1], 763, 217, 67, 67, null);
					g.drawImage(nave[i + 1], 970, 217, 67, 67, null);
					g.drawImage(nave[i + 2], 1054, 234, 33, 33, null);						
				} else if(i == nave.length - 2) {
					g.drawImage(nave[i - 2], 710, 234, 33, 33, null);	
					g.drawImage(nave[i - 1], 763, 217, 67, 67, null);
					g.drawImage(nave[nave.length - 1], 970, 217, 67, 67, null);
					g.drawImage(nave[0], 1054, 234, 33, 33, null);				
				} else if(i == nave.length - 1) {
					g.drawImage(nave[i - 2], 710, 234, 33, 33, null);	
					g.drawImage(nave[i - 1], 763, 217, 67, 67, null);
					g.drawImage(nave[0], 970, 217, 67, 67, null);
					g.drawImage(nave[1], 1054, 234, 33, 33, null);					
				}
			}
		}
		
	}
	
	public void init() {
		for(int i = 0; i < nave.length; i++) 
			nave[i] = load.loadImage("/nave"+(i+1)+"/icon.png");		
	}
}
