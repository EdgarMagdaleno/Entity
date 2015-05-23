package Main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Menu {

	static Loader load = new Loader();
	static BufferedImage title= load.loadImage("/eRe.png");
	static BufferedImage bg = load.loadImage("/bgT.png");
	static BufferedImage playButton = load.loadImage("/playButton.png");
	static BufferedImage playButtonS = load.loadImage("/playButtonS.png");
	static BufferedImage exit = load.loadImage("/exit.png");
	static BufferedImage help = load.loadImage("/help.png");
	public static boolean playButtonSB = false;
	
	public void render(Graphics g){
		g.drawImage(bg, 0, 0,1200,720, null);
		g.drawImage(title, 200, 115, null);
		if(playButtonSB == true) {g.drawImage(playButtonS,433,325,333,50,null);}
		if(playButtonSB == false) {g.drawImage(playButton,433,325,333,50,null);}
		g.drawImage(exit, 433,525,333,50,null);
		g.drawImage(help, 433,425,333,50,null);
	}
	
}
