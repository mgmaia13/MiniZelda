package zeldaminiclone;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Block extends Rectangle{
	
	public Block(int x, int y) {
		super(x, y, 32, 32);
	}
	
	public void render(Graphics g) {
//		g.setColor(Color.MAGENTA);
//		g.fillRect(x, y, width, height);
//		g.setColor(Color.black);
//		g.drawRect(x, y, width, height);
		
		g.drawImage(Spritesheet.tileWall, x, y, 32, 32,null);
		
	}

}
