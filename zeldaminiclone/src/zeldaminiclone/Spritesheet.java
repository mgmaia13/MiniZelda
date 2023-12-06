package zeldaminiclone;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Spritesheet {
	
	public static BufferedImage spritesheet;
	
	public static BufferedImage[] player_front;
	
	public static BufferedImage tileWall;
	
	public Spritesheet() {
		try {
			spritesheet = ImageIO.read(getClass().getResource("/spritesheet.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//player_front = Spritesheet.getSprite(0, 11, 16, 16); //0,11 sao as coordenadas do sprite na sheet e 16,16 eh a altura e largura do sprite
		
		player_front = new BufferedImage[2]; //3 que é o tamanho que eu quero
		
		player_front[0] = Spritesheet.getSprite(0, 11,16,16);
		player_front[1] = Spritesheet.getSprite(16, 11,16,16);
		tileWall = Spritesheet.getSprite(280, 222, 16, 16);
	}
	
	public static BufferedImage getSprite(int x, int y, int width, int height) {
		return spritesheet.getSubimage(x,y,width,height);
	}
	
	
}
