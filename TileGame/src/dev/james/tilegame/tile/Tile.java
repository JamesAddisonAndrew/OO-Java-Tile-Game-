package dev.james.tilegame.tile;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile 
{
	//static variables
	
	public static Tile[] tiles = new Tile[256];
	public static Tile grassTile = new GrassTile(0); 
	public static Tile rockTile = new RockTile(1); 
	public static Tile dirtTile = new DirtTile(2); 
	public static Tile rockVertTile = new RockVertTile(3); 
	
	protected BufferedImage texture; //protected b/c we will have classes that extends tileclass
	protected final int id; //tiles id will never change so final 
	public static final int TILEWIDTH = 113; 
	public static final int	TILEHEIGHT = 113;

	public Tile(BufferedImage texture, int id)
	{
		this.texture = texture;
		this.id = id; 
		
		tiles[id] = this; 
	}
	
	public int getId()
	{
		return id; 
	}
	
	public void tick()
	{
		
	}
	
	public void render(Graphics g, int x, int y)
	{
		g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
	}
	
	public boolean isSolid()
	{
		return false;
	}
	
}
