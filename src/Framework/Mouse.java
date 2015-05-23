package Framework;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import Main.Game;
import Main.Lobby;
import Objects.Player;
import Objects.Player2;

public class Mouse extends MouseAdapter implements MouseMotionListener{
	public Game game = new Game();
	Lobby lobby = new Lobby();
	public static int gameb = 0;
	public static int p2l = 0;
	public static int p2r = 0;
	public static int p1r = 0;
	public static int p1l = 0;
	public static int p1lock = 0;
	public static int p2lock = 0;
	public static int back = 0;
	
	public static int ship1 = 0;
	public static int ship2 = 0;
	public static boolean p1choose = false;
	public static boolean p2choose = false;
	
	public void mousePressed(MouseEvent event){
		int mx = event.getX();
		int my = event.getY();
		
		if(Game.State == Game.STATE.Menu){
			if(mx >= 433 && mx <= 766)
				if(my >= 325 && my <= 375) 
					Game.State = Game.STATE.Lobby;	
							
			if(mx >= 433 && mx <= 766)
				if(my >= 525 && my <= 575) System.exit(1);			
		}
		
		if(Game.State == Game.STATE.StageSelect) {
			if(mx >= 340 && mx <= 590)
				if(my >= 200 && my <= 350) {
					Game.room = 1;
					Game.State = Game.STATE.Battle;
				}

			if(mx >= 7 && mx <= 93)
				if(my >= 7 && my <= 57) {
					back = 3;
					wait(70);
					
					back = 0;
					wait(20);
					ship1 = 0;
					ship2 = 0;
					
					p1choose = false;
					p2choose = false;
					Game.State = Game.STATE.Lobby;
				}

			if(mx >= 610 && mx <= 860)
				if(my >= 200 && my <= 350) {
					Game.room = 2;
					Game.State = Game.STATE.Battle;
				}
			
			if(mx >= 340 && mx <= 590)
				if(my >= 370 && my <= 520) {
					Game.room = 3;	
					Game.State = Game.STATE.Battle;
				}
			
			if(mx >= 610 && mx <= 860)
				if(my >= 370 && my <= 520) {
					Game.room = 4;
					Game.State = Game.STATE.Battle;
				}			
		}
		
		if(Game.State == Game.STATE.Lobby) {
			if(!p1choose) {
				if(mx >= 360 && mx <= 460)
					if(my >= 320 && my <= 380) {
						p1r = 3;
						ship1++;
						if(ship1 == Lobby.nave.length) ship1 = 0;
					}
				
				if(mx >= 140 && mx <= 240)
					if(my >= 320 && my <= 380) {
						p1l = 3;
						
						ship1--;
						if(ship1 == -1) ship1 = Lobby.nave.length - 1;
					}	
			}
			
			if(!p2choose) {
				if(mx >= 960 && mx <= 1060)
					if(my >= 320 && my <= 380) {
						p2r = 3;
						ship2++;
						if(ship2 == Lobby.nave.length) ship2 = 0;
					}
				
				if(mx >= 740 && mx <= 840)
					if(my >= 320 && my <= 380) {
						p2l = 3;
						ship2--;
						if(ship2 == -1) ship2 = Lobby.nave.length - 1;
					}
			}
				
			if(mx >= 250 && mx <= 350)
				if(my >= 320 && my <= 380) {
					p1lock = 3;
					Player.nave = "nave" + (ship1 + 1);
					setAbilities();
					p1choose = true;
				}
			
			if(mx >= 850 && mx <= 950)
				if(my >= 320 && my <= 380) {
					p2lock = 3;
					Player2.nave = "nave" + (ship2 + 1);
					setAbilities();
					p2choose = true;
				}
			
				if(mx >= 530 && mx <= 670)
					if(my >= 480 && my <= 564) {
						gameb = 3;
						wait(70);
						
						gameb = 0;
						wait(20);
						if(p1choose && p2choose) Game.State = Game.STATE.StageSelect;
					}
		}
		
	}
	
	public void wait(int n) {
		try{ Thread.sleep(n);
		} catch(Exception e) {}
	}
	
	public void mouseReleased(MouseEvent e) {
		p1r = 0;
		p1l = 0;
		p2r = 0;
		p2l = 0;
		back = 0;
	}
	
	public void setAbilities() {
		Player.ability1 = 1;
		Player.a1CD = Input.cooldownAssigner(Player.ability1);
		Player.ability2 = 2;
		Player.a2CD = Input.cooldownAssigner(Player.ability2);
		Player.ability3 = 4;
		Player.a3CD = Input.cooldownAssigner(Player.ability3);
			
		Player2.ability1 = 1;
		Player2.a1CD = Input.cooldownAssigner(Player2.ability1);
		Player2.ability2 = 2;
		Player2.a2CD = Input.cooldownAssigner(Player2.ability2);	
		Player2.ability3 = 5;
		Player2.a3CD = Input.cooldownAssigner(Player2.ability3);
	}
}
