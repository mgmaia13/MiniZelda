package zeldaminiclone;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class World {
	
	public static List<Block> bloco = new ArrayList<Block>();
	
	public World() {
											
		for(int xx = 0; xx < 15*2; xx++) {	//loop pra adicionar blocos ao redor da tela
			bloco.add(new Block(xx*32,0));
		}
		for(int xx = 0; xx < 15*2; xx++) {
			bloco.add(new Block(xx*32,480-32));
		}
		for(int yy = 0; yy < 15*2; yy++) {
			bloco.add(new Block(0,yy*32));
		}
		for(int yy = 0; yy < 15*2; yy++) {
			bloco.add(new Block(640-32,yy*32));
		}
	}
	
	public static boolean isFree(int x, int y) {
		for(int i = 0; i< bloco.size(); i++) {
			Block blocoAtual = bloco.get(i);
			if(blocoAtual.intersects(new Rectangle(x,y,32,32))) {
				return false;
			}
		}
		return true;
	}
	
	public void render(Graphics g) {
		for(int i = 0; i< bloco.size(); i++) {
			bloco.get(i).render(g);
		}
	}
	
}
