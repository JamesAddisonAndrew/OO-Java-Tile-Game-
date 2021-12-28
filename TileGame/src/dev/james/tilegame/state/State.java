package dev.james.tilegame.state;

import java.awt.Graphics;

import dev.james.tilegame.Game;
import dev.james.tilegame.Handler;

public abstract class State //abstract is used to make other instances of regular classes, dog example: abstract class Dog,  Dog d = new dog, dog.bark(); -> fail. Class Golden extends Dog, Golden g = new golden(); g.bark; -> works
{
	//this doesn't have to be in this class, it isn't abstract
	private static State currentState = null; 
	
	public static void setState(State state)
	{
		currentState = state; 
	}
	
	public static State getState()
	{
		return currentState; 
	}
	
	//Class
	protected Handler handler; 
	public State(Handler handler)
	{
		this.handler = handler; 
	}
	
	public abstract void tick(); 
	public abstract void render(Graphics g);

}
