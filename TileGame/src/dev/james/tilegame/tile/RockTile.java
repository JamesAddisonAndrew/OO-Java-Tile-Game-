package dev.james.tilegame.tile;

import java.awt.image.BufferedImage;

import dev.james.tilegame.gfx.Assets;

public class RockTile extends Tile{

	public RockTile(int id) {
		super(Assets.stone, id);
	}
	
	@Override
	public boolean isSolid()
	{
		return true;
	}

}
