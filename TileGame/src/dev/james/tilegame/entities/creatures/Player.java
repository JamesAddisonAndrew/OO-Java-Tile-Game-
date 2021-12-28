package dev.james.tilegame.entities.creatures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.james.tilegame.Game;
import dev.james.tilegame.Handler;
import dev.james.tilegame.gfx.Animation;
import dev.james.tilegame.gfx.Assets;

public class Player extends Creature 
{
	//animations
	private Animation animDown, animRight, animLeft, animUp, animStat; 
	
	
	public Player(Handler handler, float x, float y) 
	{
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		bounds.x = 32;
		bounds.y = 20;
		bounds.width = 50; 
		bounds.height = 90;
		
		//animations
		animDown = new Animation(200, Assets.player_down);
		animUp = new Animation(200, Assets.player_up);
		animRight = new Animation (200, Assets.player_right);
		animLeft = new Animation (200, Assets.player_left);
		animStat = new Animation (200, Assets.player_stat);
	}

	public void tick() 
	{
		//animations
		animDown.tick();
		animUp.tick();
		animLeft.tick();
		animRight.tick();

		//move
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
	}
	
	private void getInput()
	{
		xMove = 0; 
		yMove = 0;
		
		if(handler.getKeyManager().up)
		{
			yMove = -speed;
		}
		
		if(handler.getKeyManager().down)
		{
			yMove = speed;
		}
		
		if(handler.getKeyManager().left)
		{
			xMove = -speed;
		}
		
		if(handler.getKeyManager().right)
		{
			xMove = speed;
		}
		
	}

	public void render(Graphics g) 
	{
		g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null); // originally float, casting the floats into ints required by drawImage 
		
	}
	private BufferedImage getCurrentAnimationFrame()
	{
		if(xMove < 0)
		{
			return animLeft.getCurrentFrame();
		}
		else if (xMove > 0)
		{
			return animRight.getCurrentFrame();
		}
		else if(yMove<0)
		{
			return animUp.getCurrentFrame();
			
		}
		else if  (yMove>0)
		{
			return animDown.getCurrentFrame();
		}
		else
		{
			return animStat.getCurrentFrame();
		}
			
	}
}








