package dev.james.tilegame.gfx;

import java.awt.image.BufferedImage;

public class Assets 
{
	private static final int width = 113, height = 113;
	public static BufferedImage dirt, stone, tree, grass, stonevert, playerL1, playerL2, playerR1, playerR2, playerU1, playerU2, playerD1,playerD2, playerLA, playerRA, playerUA, playerDA, playerLAG, playerRAG,
	playerUAG, playerDAG, slimeD, slimeU,slimeL,slimeR,wood, gold, mnt, playerR, playerU, playerD, glue;
	public static BufferedImage[] player_down, player_up, player_right, player_left, player_stat;
	
	public static  void init()
	{
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));
		//player = sheet.crop(2, 3, width-3 , height-1);
		tree = sheet.crop(width+2, 0, width, height);
		dirt  = sheet.crop(2*width+5, 5, width-3, height-3);
		stone = sheet.crop(3*width+5, 0, width-2, height);
		grass = sheet.crop(4*width+6, 0+2, width-4, height-2);
		stonevert = sheet.crop(4*width+8, 3*height+3 + 3, width-2, height-4);

		player_down = new BufferedImage[4];
		player_left = new BufferedImage[4];
		player_right = new BufferedImage[4];
		player_up = new BufferedImage[4];
		player_stat = new BufferedImage[1];

		player_stat[0] = sheet.crop(2*width+4, height+4, width -1, height-1);
		
		player_left[0] = sheet.crop(2, 3, width-3 , height-1); //standard
		player_left[1] = sheet.crop(2, height+4, width-2 , height-1);//L
		player_left[2] = sheet.crop(2, 3, width-3 , height-1); //standard
		player_left[3] = sheet.crop(2, 2*height+5, width-2 , height-1);//R
		

		
		player_right[0] = sheet.crop(2, 3*height+7, width-2 , height-3);
		player_right[1]= sheet.crop(2, 4*height+7, width-2 , height-1);
		player_right[3] = sheet.crop(2, 5*height+8, width-2 , height-1);
		player_right[2] = sheet.crop(2, 3*height+7, width-2 , height-3);

		player_up[0] = sheet.crop(width+3, height+5, width-1 , height-2);
		player_up[1] = sheet.crop(width+3, 2* height+5, width-1 , height-1);
		player_up[2] = sheet.crop(width+3, height+5, width-1 , height-2);
		player_up[3] = sheet.crop(width+3, 3* height+6, width-1 , height-1);

		player_down[1] = sheet.crop(2*width+4, 2*height+5, width -1, height-1); //left leg up
		player_down[0]  = sheet.crop(2*width+4, height+4, width -1, height-1);//stationary 
		player_down[3]  = sheet.crop(2*width+4, 3*height+6, width -1, height-1);//right leg up
		player_down[2]  = sheet.crop(2*width+4, height+4, width -1, height-1);//stationary

		
		playerLA = sheet.crop(3*width, height, width-1 , height);
		playerRA = sheet.crop(4*width, height, width-1 , height);
		playerUA = sheet.crop(4*width, 2*height, width-1 , height);
		playerDA = sheet.crop(3*width, 2*height, width-1 , height);
		playerLAG = sheet.crop(3*width, 4*height, width-1 , height);
		playerRAG = sheet.crop(4*width, 4*height, width-1 , height);
		playerUAG = sheet.crop(4*width, 4*height, width-1 , height);
		playerDAG = sheet.crop(3*width, 4*height, width-1 , height);
		
		slimeD  = sheet.crop(5*width, 2, width-1 , height);
		slimeU = sheet.crop(5*width, height, width-1 , height);
		slimeL = sheet.crop(5*width, 3*height, width-1 , height);
		slimeR = sheet.crop(5*width, 4*height, width-1 , height);
		
		wood = sheet.crop(3*width, 4*height, width-1 , height);
		
		gold = sheet.crop(width, 4*height, width-1 , height);
		
		mnt  = sheet.crop(3*width, 3*height, width-1 , height);
		
		glue  = sheet.crop(5*width, 5*height, width-1 , height);
	}
}
