package dev.james.tilegame.tile;

import java.awt.image.BufferedImage;

import dev.james.tilegame.gfx.Assets;

public class GrassTile extends Tile
{

	public GrassTile(int id) 
	{
		super(Assets.grass, id);
	}

	public boolean isSolid()
	{
		return false;
	}

}
