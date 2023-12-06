package zeldaminiclone;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends Rectangle{ //Player vai herdar tudo da classe Rectangle
	
	public int spd = 4;
	public boolean right, up, down, left;
	
	public int curAnimation = 0;
	
	public int curFrames = 0, targetFrames = 15; //a cada 60 frames passa 1 segundo (60FPS), entao 15 a gente sabe que eh menos de meio seg
												 //logo, animação vai ser feita em menos de meio segundo
	public Player(int x, int y) {
		super(x, y, 32, 32);
	}
	
	public void tick() { //essa logica de movimento esta aqui e nao na KeyPressed/Released pq nao vai ta dentro do frame looping e dentro do FPS que a gente colocou(1000/60 (60))  
		
		boolean moved = false; //variavel criada pra animação nao ficar em loop, para parar qdo nao houver movimento
		if(right && World.isFree(x+spd, y)) {
			x+=spd;
			moved = true;
		} else if(left && World.isFree(x-spd, y)) {
			x-=spd;
			moved = true;
		}
		
		if(up && World.isFree(x, y-spd)) {
			y-=spd;
			moved = true;
		} else if(down && World.isFree(x, y+spd)) {
			y+=spd;
			moved = true;
		}
		
		if(moved) {
			curFrames++;
			if(curFrames == targetFrames) {
				curFrames = 0;
				curAnimation++;
				if(curAnimation == Spritesheet.player_front.length) {
					curAnimation = 0;
				}
			}
		}
		
		
	}
	
	public void render(Graphics g) {
		//g.setColor(Color.blue);
		//g.fillRect(x, y, width, height); //propriedades que a gente ja em da classe Rectangle
		g.drawImage(Spritesheet.player_front[curAnimation],x,y,32,32,null);
	}

}
