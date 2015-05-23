package Main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Framework.Mouse;

public class StageSelect {
	Loader load = new Loader();
	BufferedImage s1 = load.loadImage("/stage1.png");
	BufferedImage s2 = load.loadImage("/stage2.png");
	BufferedImage s3 = load.loadImage("/stage3.png");
	BufferedImage s4 = load.loadImage("/stage4.png");
	BufferedImage title = load.loadImage("/stageSelect.png");
	BufferedImage back = load.loadImage("/back.png");
	
	public void render(Graphics g) {
		g.drawImage(title, 100, 60, 1000, 70, null);
		g.drawImage(s1, 340,200,250,150, null);
		g.drawImage(s2, 610,200,250,150, null);
		g.drawImage(s3, 340,370,250,150, null);
		g.drawImage(s4, 610,370,250,150, null);	
		g.drawImage(back, 7, 7 + Mouse.back, 87, 50, null);
	}
}
