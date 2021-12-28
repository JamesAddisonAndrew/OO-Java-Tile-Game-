package dev.james.tilegame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import dev.james.tilegame.display.Display;
import dev.james.tilegame.gfx.Assets;
import dev.james.tilegame.gfx.GameCamera;
import dev.james.tilegame.gfx.ImageLoader;
import dev.james.tilegame.gfx.SpriteSheet;
import dev.james.tilegame.input.KeyManager;
import dev.james.tilegame.state.GameState;
import dev.james.tilegame.state.MenuState;
import dev.james.tilegame.state.PauseState;
import dev.james.tilegame.state.SettingState;
import dev.james.tilegame.state.State;

public class Game implements Runnable // imp runnable puts this code on a thread for itself. Must have public void run() method inside
{
	private Display display;
	private int width, height; 
	private Thread thread; 
	private boolean running = false;
	public String title; 
	private BufferStrategy bs;
	private Graphics g;
	
	//states
	private State gameState; 
	private State menuState; 
	private State pauseState;
	private State settingState; 
	
	//Inputs 
	private KeyManager keyManager; 
	
	public Game(String title, int width, int height) 
	{
		this.width = width;
		this.height = height; 
		this.title = title; 
		keyManager = new KeyManager(); 
	}
	
	//Camera
	private GameCamera gameCamera;
	
	//Handler
	private Handler handler; 
	
	private void init() 
	{
		display = new Display(title, width, height); 
		display.getFrame().addKeyListener(keyManager); // getting display window and adds a keylistener and passed in keymanager, which implements key listener
		Assets.init();
		handler = new Handler(this);
		gameCamera = new GameCamera(handler, 0,0); 
		
		gameState = new GameState(handler); //initalize states
		menuState = new MenuState(handler); 
		pauseState = new PauseState(handler); 
		settingState = new SettingState(handler); 
		State.setState(gameState);
		
	}
	private void tick()
	{
		keyManager.tick();
		if(State.getState() != null)
		{
			State.setState(gameState);
			State.getState().tick();
		}

		
	}
	
	private void render()
	{
		bs = display.getCanvas().getBufferStrategy(); //sets bs to the current bufferstrat of the canvas, bufferstrat is a hidden screen in comp hidden pulls it to the front 
		if(bs == null)
		{
			display.getCanvas().createBufferStrategy(3); // if no buffer strat add buffer, add 3 buffers
			return;
		}
		g = bs.getDrawGraphics(); // the paintbrush is set from the buffer strat of getting draw graphics
		
		//Clear Screen
		g.clearRect(0, 0, width, height); //clearing each time this is called 
		
		//Draw here
		//g.drawImage(Assets.player, 5, 5, null); // drawing onto x y cords in java starts in top left corner 
		if(State.getState() != null)
		{
			State.getState().render(g);
		}
		//End drawing
		bs.show();
		g.dispose();
	}
	
	public void run() 
	{
		init(); 
		
		int fps = 60; 
		double timePerTick = 1000000000/fps; // max time to execute tick and render to make 60 fps target 
		double delta = 0; //amount of time to call tick and render methods again
		long now; //current time of computer 
		long lastTime = System.nanoTime(); //return current time of computer in nano seconds. 
		long timer = 0; 
		int ticks = 0;
		
		
		while(running)
		{
			now = System.nanoTime(); //sets the var now to the current time of system in nano seconds.
			delta += (now - lastTime)/timePerTick; // adds onto the delta how much time left to the limit we set.
			timer += now - lastTime; // adding amount of time that has past since this was called
			lastTime = now; 
			
			if (delta >= 1) 
			{
				tick();
				render();
				delta--; 
				ticks++; 
			}
			if (timer >= 1000000000)
			{
				ticks = 0; 
				timer = 0; 
			}
			
		}
		stop(); //stops method if not already stopped
	}
	public KeyManager getKeyManager() //reurn key manager obj to other classes can access it 
	{
		return keyManager; 
	}
	
	public GameCamera getGameCamera()
	{
		return gameCamera;
	}
	
	public int getWidth()
	{
		return width;
	}
	public int getHeight()
	{
		return height; 
	}
	
	public synchronized void start() // sychronized is used when dealing with a thread
	{
		if (running)  // if already running skip out
		{
			return;
		}	
		running = true; 
		thread = new Thread(this); //passing in game class to run on a thread
		thread.start(); //calls run method
	}
	public synchronized void stop() 
	{
		if(!running)
		{
			return;
		}
		running = false;
		
		try 
		{
			thread.join(); //stops thread
		} 
		catch (InterruptedException e)
		{
			e.printStackTrace();
		} 
	}
}
