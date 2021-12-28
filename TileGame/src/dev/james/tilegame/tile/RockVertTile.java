package dev.james.tilegame.tile;

import java.awt.image.BufferedImage;

import dev.james.tilegame.gfx.Assets;

public class RockVertTile extends Tile{

	public RockVertTile(int id) {
		super(Assets.stonevert, id);
	}
	
	@Override
	public boolean isSolid()
	{
		return true;
	}

}
