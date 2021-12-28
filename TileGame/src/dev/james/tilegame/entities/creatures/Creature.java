package dev.james.tilegame.entities.creatures;

import dev.james.tilegame.Game;
import dev.james.tilegame.Handler;
import dev.james.tilegame.entities.Entity;
import dev.james.tilegame.tile.Tile;

public abstract class Creature extends Entity 
{
	public static final int DEFAULT_HEALTH = 10; // cannot change default health due to final
	public static final float DEFAULT_SPEED = 5.0f; // cannot change default health due to final
	public static final int DEFAULT_CREATURE_WIDTH = 113;
	public static final int DEFAULT_CREATURE_HEIGHT = 113;
	
	

	protected int health; 
	protected float speed; 
	protected float xMove, yMove; 
	
	
	public Creature(Handler handler, float x, float y, int width, int height) 
	{
		super(handler, x, y, width, height);
		health = DEFAULT_HEALTH;
		speed = DEFAULT_SPEED; 
		xMove = 0; 
		yMove = 0; 
	}
	public void move()
	{
		moveX();
		moveY(); 
	}
	public void moveX()
	{
		if (xMove > 0) //moving right
		{
			int tx = (int)(x+xMove + bounds.x + bounds.width)/Tile.TILEWIDTH;
			if(!collisonWithTile(tx, (int)(y+bounds.y)/Tile.TILEHEIGHT) && !collisonWithTile(tx, (int)(y+bounds.y+bounds.height)/Tile.TILEHEIGHT) )
			{
				x+=xMove;
			}
			else
			{
				x = tx*Tile.TILEWIDTH - bounds.x - bounds.width -1;
				
			}
		}
		else if (xMove < 0) //moving left
		{
			int tx = (int)(x+xMove + bounds.x)/Tile.TILEWIDTH;
			if(!collisonWithTile(tx, (int)(y+bounds.y)/Tile.TILEHEIGHT) && !collisonWithTile(tx, (int)(y+bounds.y+bounds.height)/Tile.TILEHEIGHT) )
			{
				x+=xMove;
			}
			else
			{
				x = tx*Tile.TILEWIDTH +Tile.TILEWIDTH-bounds.x;
				
			}
		}
			
	}
	
	public void moveY()
	{
		if(yMove < 0) //up
		{
			int ty = (int)(y+yMove +bounds.y)/Tile.TILEHEIGHT;
			if(!collisonWithTile((int)(x+bounds.x)/Tile.TILEWIDTH, ty) && !collisonWithTile((int)(x+bounds.x +bounds.width)/Tile.TILEWIDTH, ty))
			{
				y+=yMove; 
			}
			else
			{
				y = ty*Tile.TILEHEIGHT + Tile.TILEHEIGHT - bounds.y ;
				
			}
			
		}
		else if(yMove>0) //down
		{
			int ty = (int)(y+yMove +bounds.y +bounds.height)/Tile.TILEHEIGHT;
			if(!collisonWithTile((int)(x+bounds.x)/Tile.TILEWIDTH, ty) && !collisonWithTile((int)(x+bounds.x +bounds.width)/Tile.TILEWIDTH, ty))
			{
				y+=yMove; 
			}
			else
			{
				y = ty*Tile.TILEHEIGHT - bounds.height - bounds.y -1 ;
				
			}
		}
	}
	
	protected boolean collisonWithTile(int x, int y)
	{
		return handler.getWorld().getTile(x, y).isSolid();
	}
	
	//Getters and setters
	
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public float getSpeed() {
		return speed;
	}
	public void setSpeed(float speed) {
		this.speed = speed;
	}
	public float getxMove() {
		return xMove;
	}
	public void setxMove(float xMove) {
		this.xMove = xMove;
	}
	public float getyMove() {
		return yMove;
	}
	public void setyMove(float yMove) {
		this.yMove = yMove;
	}
	
}
