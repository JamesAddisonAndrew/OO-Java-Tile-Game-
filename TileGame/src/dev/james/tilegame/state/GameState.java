//game state manager
package dev.james.tilegame.state;

import java.awt.Graphics;

import dev.james.tilegame.Game;
import dev.james.tilegame.Handler;
import dev.james.tilegame.entities.creatures.Player;
import dev.james.tilegame.gfx.Assets;
import dev.james.tilegame.tile.Tile;
import dev.james.tilegame.world.World;

public class GameState extends State //must have methods demanded by the state.java
{
	private World world;
	
	private Player player; 
	
	public GameState(Handler handler)
	{
		super(handler); //calls constructer of state class with game as parameter 
		world = new World(handler, "res/Worlds/World1.txt");
		handler.setWorld(world);	
		player = new Player(handler, 100, 100);
	}
	
	public void tick() 
	{
		world.tick();
		player.tick();
	}

	public void render(Graphics g) 
	{
		world.render(g);
		player.render(g);
	}

}
//entity is anything that isn't a tile.
