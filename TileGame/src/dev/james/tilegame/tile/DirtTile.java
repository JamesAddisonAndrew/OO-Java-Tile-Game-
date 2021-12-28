package dev.james.tilegame.tile;

import java.awt.image.BufferedImage;

import dev.james.tilegame.gfx.Assets;

public class DirtTile extends Tile{

	public DirtTile(int id) {
		super(Assets.dirt, id);
	}
	
	@Override
	public boolean isSolid()
	{
		return false;
	}

}
