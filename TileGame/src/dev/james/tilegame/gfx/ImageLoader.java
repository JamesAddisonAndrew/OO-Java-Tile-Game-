package dev.james.tilegame.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageLoader 
{
	public static BufferedImage loadImage(String path) //java stores images in a buffered image object going to desination of the path 
	
	{
		try 
		{

			return ImageIO.read(ImageLoader.class.getResource(path)); // loads in image at path
		
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
			System.exit(1); // if image fails to load, dont run game
		}
		return null;
	}
	
}
