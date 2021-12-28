package dev.james.tilegame;
import dev.james.tilegame.display.Display;

public class Launcher 
{
	public static void main (String[] args) 
	{
		Game game= new Game("Portfolio Game", 1000, 1000); //new game called game 
		game.start(); // calls start method of game which does run method whichc does the initialize method
	}
}
