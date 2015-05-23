package Main;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import Framework.GameObject;
import Framework.Input;
import Framework.Mouse;
import Framework.ObjectId;
import Objects.Block;
import Objects.Player;
import Objects.Player2;
import Objects.wallD;
import Objects.wallL;
import Objects.wallR;
import Objects.wallU;

public class Game extends Canvas implements Runnable{
	
	private static final long serialVersionUID = -1285670934175365101L;
	public static int WIDTH, HEIGHT;
	private boolean running = false;
	private Thread thread;
	Handler handler = new Handler();
	static Loader load = new Loader();
	static BufferedImage background = load.loadImage("/bg.png");
	static BufferedImage bg = load.loadImage("/bgT.png");
	boolean first = true;
	static Loader loader = new Loader();
	BufferedImage room1 = null;
	BufferedImage room2 = null;
	BufferedImage room3 = null;
	BufferedImage room4 = null;
	public static int room = 0;
	
	public static Menu menu;
	public static StageSelect stage;
	public static Lobby lobby;
	
	public synchronized void start() {
		if(running)
			return;
		
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public void createRoom(int r) {	
		if(r == 1) loadLevel(room1);
		if(r == 2) loadLevel(room2);
		if(r == 3) loadLevel(room3);
		if(r == 4) loadLevel(room4);
		handler.addObject(new wallL(0, 0, ObjectId.WallL));
		handler.addObject(new wallR(0, 0, ObjectId.WallR));
		handler.addObject(new wallU(0, 0, ObjectId.WallU));
		handler.addObject(new wallD(0, 0, ObjectId.WallD));
	}
 
	public enum STATE {
		Battle,
		Menu,
		StageSelect,
		Lobby;
	}
	
	public static STATE State = STATE.Menu;
	public static BufferedImage bala1R = loader.loadImage("/bala/bala1R.png");
	public static BufferedImage bala1L = loader.loadImage("/bala/bala1L.png");
	public static BufferedImage bala1U = loader.loadImage("/bala/bala1U.png");
	public static BufferedImage bala1D = loader.loadImage("/bala/bala1D.png");
	
	private void init() {	
		WIDTH = getWidth();
		HEIGHT = getHeight();
		menu = new Menu();
		stage = new StageSelect();
		lobby = new Lobby();
		handler = new Handler();

		room1 = load.loadImage("/room1.png");
		room2 = load.loadImage("/room2.png");
		room3 = load.loadImage("/room3.png");
		room4 = load.loadImage("/room4.png");
		
		this.addKeyListener(new Input(handler));
		this.addMouseListener(new Mouse());
	}
	
	public int p1Object() {
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject temp = handler.object.get(i);		
			if(temp.getId() == ObjectId.Player) return i;
		}
		return 999999;
	}

	public int p2Object() {
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject temp = handler.object.get(i);		
			if(temp.getId() == ObjectId.Player2) return i;
		}
		return 999999;		
	}
	
	private void loadLevel(BufferedImage image) {
		int w = image.getWidth();
		int h = image.getHeight();
		
		for(int xx = 0; xx < h; xx++) {
			for(int yy = 0; yy < w; yy++) {
				
				int pixel = image.getRGB(xx, yy);
				int red = (pixel >> 16) & 0xff;
				int green = (pixel >> 8) & 0xff;
				int blue  = (pixel) & 0xff;
				
				if(red == 255 && green == 255 && blue == 255) handler.addObject(new Block(((xx*71)+63),((yy*71)+63),ObjectId.Block));
				if(red== 255 && green == 0 && blue == 0)  handler.addObject(new Player(((xx*71)+63),((yy*71)+63), handler,ObjectId.Player));
				if(red== 0 && green == 255 && blue == 0) handler.addObject(new Player2(((xx*71)+63),((yy*71)+63), handler,ObjectId.Player2));
			}
		}		
	}
	
	public void run() {
		init();
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int updates = 0;
		int frames = 0;
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1){
				tick();
				updates++;
				delta--;
			}
			render();
			frames++;
					
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println("FPS: " + frames + " TICKS: " + updates);
				frames = 0;
				updates = 0;
			}
		}
	}
	
	public static void main(String args []) {
		new Window(1200, 720, "Entity", new Game());
	}
	
	private void tick() {
		if(State == STATE.Battle)
		handler.tick();
	}
	
	private void render() {
		
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		if(State == STATE.Battle){
			if(first) {
				createRoom(room);
				first = false;
			}
			g.drawImage(bg,0,0,1200,720,null);
			handler.render(g);
		}else if(State == STATE.Menu) {
			menu.render(g);
		}else if(State == STATE.Lobby) {
			lobby.render(g);
		} else if(State == STATE.StageSelect) {
			g.drawImage(bg,0,0,1200,720,null);
			stage.render(g);
		}
		
		g.finalize();
		g.dispose();
		bs.show();
				
		}
}

