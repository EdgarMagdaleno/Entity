package Framework;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import Abilities.Buster;
import Abilities.Charging;
import Abilities.MeteorDash;
import Abilities.Paralyzer;
import Abilities.Paralyzer2;
import Abilities.Swamp;
import Abilities.p1bala;
import Abilities.p2bala;
import Main.Game;
import Main.Game.STATE;
import Main.Handler;
import Objects.Block;
import Objects.Player;
import Objects.Player2;

public class Input extends KeyAdapter {
	
	public static boolean developerMode = false;
	long lastTime = 0;
	long lastTime2 = 0;
	long attackDelay = 120;
	public static boolean[] keyDown = new boolean[4];
	private boolean[] keyDown2 = new boolean[4];
	Handler handler;
	Block block;
	Game game;
	public static double p2vel = 6;
	public static double p1vel = 6;
	
	public Input(Handler handler) {
		this.handler = handler;
		keyDown[0]=false;
		keyDown[1]=false;
		keyDown[2]=false;
		keyDown[3]=false;
		
		keyDown2[0]=false;
		keyDown2[1]=false; 
		keyDown2[2]=false;
		keyDown2[3]=false;	
	}
	
	static long cooldownAssigner(long a){
		long CD = 0;
		switch((int)a){
			case 1: break;
			case 2: CD = Paralyzer.Cooldown; break;
			case 3: CD = Swamp.Cooldown; break;
			case 4: CD = MeteorDash.Cooldown; break;
			case 5: CD = Buster.Cooldown; break;
		}
		return CD;
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		GameObject p1 = null;
		GameObject p2 = null;
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject temp = handler.object.get(i);
			
			if(temp.getId() == ObjectId.Player) p1 = handler.object.get(i);
			if(temp.getId() == ObjectId.Player2) p2 = handler.object.get(i);
		}
		
		if(Game.State == STATE.Battle){
			if(key == KeyEvent.VK_X){
				if(developerMode == true) developerMode = false;
				else developerMode = true;
			}
			
			if(Player.paralyzed == false) {			
				if(key == KeyEvent.VK_D) {Player.vel = 6; keyDown[0]=true; Player.pointing = 1;}
				if(key == KeyEvent.VK_A) {Player.vel = 6; keyDown[1]=true; Player.pointing = 2;}
				if(key == KeyEvent.VK_W) {Player.vel = 6; keyDown[2]=true; Player.pointing = 3;}
				if(key == KeyEvent.VK_S) {Player.vel = 6; keyDown[3]=true; Player.pointing = 4;}
				
				if(key == KeyEvent.VK_Y) p1AbilityM(Player.ability1,1,1);
				if(key == KeyEvent.VK_U) p1AbilityM(Player.ability2,2,1);
				if(key == KeyEvent.VK_I) p1AbilityM(Player.ability3,3,1);
						
			} else {
				long timeNow = System.currentTimeMillis();
				if (timeNow - Player.timePar > Player.parDur) Player.paralyzed = false;
			}
				
			if(Player2.paralized == false) {		
				if(key == KeyEvent.VK_RIGHT) {p2.setVelX((float) p2vel); keyDown2[0]=true; Player2.pointing2 = 1;}
				if(key == KeyEvent.VK_LEFT) {p2.setVelX((float) -p2vel); keyDown2[1]=true; Player2.pointing2 = 2;}
				if(key == KeyEvent.VK_UP) {p2.setVelY((float) -p2vel); keyDown2[2]=true; Player2.pointing2 = 3;}
				if(key == KeyEvent.VK_DOWN) {p2.setVelY((float) p2vel); keyDown2[3]=true; Player2.pointing2 = 4;}
					
				if(key == KeyEvent.VK_NUMPAD1) p1AbilityM(Player2.ability1,1,2);						
				if(key == KeyEvent.VK_NUMPAD2) p1AbilityM(Player2.ability2,2,2);									
				if(key == KeyEvent.VK_NUMPAD3) p1AbilityM(Player2.ability3,3,2);
					
			} else {
				long timeNow2 = System.currentTimeMillis();
				if (timeNow2 - Player2.timePar > Player2.parDur) Player2.paralized = false;
			}		
		}
		
		if(key == KeyEvent.VK_ESCAPE){
			System.exit(1);
		}
	}
	
	private void p1AbilityM(int a, int f, int p){
		GameObject p1 = null;
		GameObject p2 = null;
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject temp = handler.object.get(i);
			
			if(temp.getId() == ObjectId.Player) p1 = handler.object.get(i);
			if(temp.getId() == ObjectId.Player2) p2 = handler.object.get(i);
		}
		
		if(p == 1){
			if(a == 1){
				long timeNow = System.currentTimeMillis();
				if (timeNow - lastTime < attackDelay) 
					return;
				lastTime = timeNow;
				handler.addObject(new p1bala(p1.getX() + 20,p1.getY() + 20, handler,ObjectId.p1bala));
			}
			if(a == 2){
				long timeNow = System.currentTimeMillis();
				if(timeNow - Paralyzer.timeCreation < Paralyzer.Cooldown)
					return;
				Paralyzer.timeCreation = System.currentTimeMillis();
				handler.addObject(new Paralyzer(p1.getX()-25,p1.getY()-25,handler,ObjectId.Paralyzer));
			}
			if(a == 3){
				long timeNow = System.currentTimeMillis();
				if(timeNow - Swamp.timeCreation < Swamp.Cooldown)
					return;
				Swamp.createdBy = 1;
				Swamp.timeCreation = System.currentTimeMillis();
				handler.addObject(new Swamp(p1.getX(),p1.getY(),handler,ObjectId.Swamp));
			}
			if(a == 4){
				long timeNow = System.currentTimeMillis();
				if (timeNow - MeteorDash.timeCreation < MeteorDash.Cooldown) 
					return;
				MeteorDash.createdBy = 1;
				MeteorDash.timeCreation = System.currentTimeMillis();
				if(Player.pointing == 1) handler.addObject(new MeteorDash(p1.getX()-53,p1.getY()-15,handler,ObjectId.MeteorDash));
				if(Player.pointing == 2) handler.addObject(new MeteorDash(p1.getX(),p1.getY()-15,handler,ObjectId.MeteorDash));
				if(Player.pointing == 3) handler.addObject(new MeteorDash(p1.getX()-15,p1.getY(),handler,ObjectId.MeteorDash));
				if(Player.pointing == 4) handler.addObject(new MeteorDash(p1.getX()-15,p1.getY()-53,handler,ObjectId.MeteorDash));		
			}
			
			if(a == 5) {
				long timeNow = System.currentTimeMillis();
				if(timeNow - Buster.timeCreation < Buster.Cooldown) return;
				Buster.createdBy = 1;
				Buster.timeCreation = System.currentTimeMillis();
				Player.paralyzed = true;
				p1.setVelX(0);
				p1.setVelY(0);
				Player.timePar = System.currentTimeMillis();
				Player.parDur = 690;
				if(Player.pointing == 1) handler.addObject(new Charging(p1.getX(),p1.getY()-25,handler,ObjectId.Charging));
				if(Player.pointing == 2) handler.addObject(new Charging(p1.getX()-45,p1.getY()-25,handler,ObjectId.Charging));
				if(Player.pointing == 3) handler.addObject(new Charging(p1.getX()-25,p1.getY()-45,handler,ObjectId.Charging));
				if(Player.pointing == 4) handler.addObject(new Charging(p1.getX()-25,p1.getY(),handler,ObjectId.Charging));		
			}
			
			//aqui llacen los sueños y esperanzas de magdaleno
			if(a == 6){}
			if(a == 7){}
			if(a == 8){}
			if(a == 9){}
			if(a == 10){}
			if(a == 11){}
			if(a == 12){}
			if(a == 13){}
			if(a == 14){}
			if(a == 15){}
			if(a == 16){}
			if(a == 17){}
			if(a == 18){}
			if(a == 19){}
			if(a == 20){}
			
			if(f == 1){
				Player.a1inCD = 1;
				Player.a1Creation = System.currentTimeMillis();
				if(a == 5)Player.a1Creation = System.currentTimeMillis() + 1950;}
			if(f == 2){
				Player.a2inCD = 1;
				Player.a2Creation = System.currentTimeMillis();
				if(a == 5)Player.a2Creation = System.currentTimeMillis() + 1950;}
			if(f == 3 ){
				Player.a3inCD = 1;
				Player.a3Creation = System.currentTimeMillis();
				if(a == 5)Player.a3Creation = System.currentTimeMillis() + 1950;}
			
		} else {
			if(a == 1){
				long timeNow = System.currentTimeMillis();
				if (timeNow - lastTime2 < attackDelay) 
					return;
				lastTime2 = timeNow;
				handler.addObject(new p2bala(p2.getX() + 20,p2.getY() + 20, handler,ObjectId.p2bala));
			}
			if(a == 2){
				long timeNow = System.currentTimeMillis();
				if(timeNow - Paralyzer2.timeCreation < Paralyzer2.Cooldown)
					return;
				Paralyzer2.timeCreation = System.currentTimeMillis();
				handler.addObject(new Paralyzer2(p2.getX()-25,p2.getY()-25,handler,ObjectId.Paralyzer2));
			}
			if(a == 3){
				long timeNow = System.currentTimeMillis();
				if(timeNow - Swamp.timeCreation2 < Swamp.Cooldown)
					return;
				Swamp.createdBy = 2;
				Swamp.timeCreation2 = System.currentTimeMillis();
				handler.addObject(new Swamp(p2.getX(),p2.getY(),handler,ObjectId.Swamp));
			}
			if(a == 4){
				long timeNow = System.currentTimeMillis();
				if (timeNow - MeteorDash.timeCreation2 < MeteorDash.Cooldown) 
					return;
				MeteorDash.createdBy = 2;
				MeteorDash.timeCreation2 = System.currentTimeMillis();
				if(Player2.pointing2 == 1) handler.addObject(new MeteorDash(p2.getX()-53,p2.getY()-15,handler,ObjectId.MeteorDash));
				if(Player2.pointing2 == 2) handler.addObject(new MeteorDash(p2.getX(),p2.getY()-15,handler,ObjectId.MeteorDash));
				if(Player2.pointing2 == 3) handler.addObject(new MeteorDash(p2.getX()-15,p2.getY(),handler,ObjectId.MeteorDash));
				if(Player2.pointing2 == 4) handler.addObject(new MeteorDash(p2.getX()-15,p2.getY()-53,handler,ObjectId.MeteorDash));		
			}
			if(a == 5){
				long timeNow = System.currentTimeMillis();
				if(timeNow - Buster.timeCreation2 < Buster.Cooldown) return;
				Buster.createdBy = 2;
				Buster.timeCreation2 = System.currentTimeMillis();
				Player2.paralized = true;
				p2.setVelX(0);
				p2.setVelY(0);
				Player2.timePar = System.currentTimeMillis();
				Player2.parDur = 690;
				if(Player2.pointing2 == 1) handler.addObject(new Charging(p2.getX(),p2.getY()-25,handler,ObjectId.Charging));
				if(Player2.pointing2 == 2) handler.addObject(new Charging(p2.getX()-45,p2.getY()-25,handler,ObjectId.Charging));
				if(Player2.pointing2 == 3) handler.addObject(new Charging(p2.getX()-25,p2.getY()-45,handler,ObjectId.Charging));
				if(Player2.pointing2 == 4) handler.addObject(new Charging(p2.getX()-25,p2.getY(),handler,ObjectId.Charging));			
			}
			if(a == 6){}
			if(a == 7){}
			if(a == 8){}
			if(a == 9){}
			if(a == 10){}
			if(a == 11){}
			if(a == 12){}
			if(a == 13){}
			if(a == 14){}
			if(a == 15){}
			if(a == 16){}
			if(a == 17){}
			if(a == 18){}
			if(a == 19){}
			if(a == 20){}
			
			if(f == 1){
				Player2.a1inCD = 1;
				Player2.a1Creation = System.currentTimeMillis();}
			if(f == 2){
				Player2.a2inCD = 1;
				Player2.a2Creation = System.currentTimeMillis();}
			if(f == 3 ){
				Player2.a3inCD = 1;
				Player2.a3Creation = System.currentTimeMillis();}
		}	
	}
	
	
	public void keyReleased(KeyEvent e) {
		GameObject p1 = null;
		GameObject p2 = null;
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject temp = handler.object.get(i);
			
			if(temp.getId() == ObjectId.Player2) p2 = handler.object.get(i);
			if(temp.getId() == ObjectId.Player) p1 = handler.object.get(i);
		
		}
		
		int key = e.getKeyCode();
		
		if(Game.State == STATE.Battle){
			if(key == KeyEvent.VK_D)  {
				keyDown[0]=false;
					if(keyDown[2] == true)
						Player.pointing = 3;
					if(keyDown[3] == true)
						Player.pointing = 4;
					if(keyDown[1] == true) {
						Player.pointing = 2;
						p1.setVelX((float) -p1vel);
					}
			}
				
			if(key == KeyEvent.VK_A) {
				keyDown[1]=false;
				if(keyDown[2] == true)
					Player.pointing = 3;
				if(keyDown[3] == true)
					Player.pointing = 4;
				if(keyDown[0] == true) {
					Player.pointing = 1;
					p1.setVelX((float) p1vel);
				}
			}
				
			if(key == KeyEvent.VK_W) {
				keyDown[2]=false;
				if(keyDown[0] == true)
					Player.pointing = 1;
				if(keyDown[1] == true)
					Player.pointing = 2;
				if(keyDown[3] == true) {
					Player.pointing = 4;
					p1.setVelY((float) p1vel);
				}
			}
				
			if(key == KeyEvent.VK_S) {
				keyDown[3]=false;
				if(keyDown[0] == true)
					Player.pointing = 1;
				if(keyDown[1] == true)
					Player.pointing = 2;
				if(keyDown[2] == true) {
					Player.pointing = 3;
					p1.setVelY((float) -p1vel);
				}
			}
					
			if(!keyDown[2] && !keyDown[3]) p1.setVelY(0);
			if(!keyDown[0] && !keyDown[1]) p1.setVelX(0);		
		
			
			
			if(key == KeyEvent.VK_RIGHT)  {
				keyDown2[0]=false;
					if(keyDown2[2] == true)
						Player2.pointing2 = 3;
					if(keyDown2[3] == true)
						Player2.pointing2 = 4;
					if(keyDown2[1] == true) {
						Player2.pointing2 = 2;
						p2.setVelX((float) -p2vel);
					}
			}
			
			if(key == KeyEvent.VK_LEFT) {
				keyDown2[1]=false;
				if(keyDown2[2] == true)
					Player2.pointing2 = 3;
				if(keyDown2[3] == true)
					Player2.pointing2 = 4;
				if(keyDown2[0] == true) {
					Player2.pointing2 = 1;
					p2.setVelX((float) p2vel);
				}
			}
			
			if(key == KeyEvent.VK_UP) {
				keyDown2[2]=false;
				if(keyDown2[0] == true)
					Player2.pointing2 = 1;
				if(keyDown2[1] == true)
					Player2.pointing2 = 2;
				if(keyDown2[3] == true) {
					Player2.pointing2 = 4;
					p2.setVelY((float) p2vel);
				}
			}
			
			if(key == KeyEvent.VK_DOWN) {
				keyDown2[3]=false;
				if(keyDown2[0] == true)
					Player2.pointing2 = 1;
				if(keyDown2[1] == true)
					Player2.pointing2 = 2;
				if(keyDown2[2] == true) {
					Player2.pointing2 = 3;
					p2.setVelY((float) -p2vel);
				}
			}
			
			if(!keyDown2[2] && !keyDown2[3]) p2.setVelY(0);
			if(!keyDown2[0] && !keyDown2[1]) p2.setVelX(0);
		}	
	}
		
}
			


