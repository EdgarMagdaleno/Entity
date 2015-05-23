package Framework;

import Abilities.Paralyzer;
import Main.Handler;
import Objects.Player;

public class AbilityManager {
	
	Handler handler;
	public static int p1a1;
	public static int p1a2;
	public static int p1a3;
	
	public static int p2a1;
	public static int p2a2;
	public static int p2a3;
	
	public AbilityManager(Handler handler){
		this.handler = handler;
	}
	
	
	//Player 1 abilities
	public void p1Ability1(){
		
		GameObject p1 = handler.object.get(2);
		
		if(p1a1 == 1){
			
		}
		
		if(p1a1 == 2){
			long timeNow = System.currentTimeMillis();
			if(timeNow - Paralyzer.timeCreation < Paralyzer.Cooldown){ 
				return;}
			Paralyzer.timeCreation = System.currentTimeMillis();
			Player.a2Creation = System.currentTimeMillis();
			handler.addObject(new Paralyzer(p1.getX()-25,p1.getY()-25,handler,ObjectId.Paralyzer));
			Player.a2inCD = 1;
		}
		
		if(p1a1 == 3){
			
		}
	}
	
	public void p1Ability2(){
		
	}
	
	public void p1Ability3(){
		
	}
	
	
	
	//Player 2 abilities
	public void p2Ability1(){
		
	}
	
	public void p2Ability2(){
		
	}
	
	public void p2Ability3(){
		
	}
}
