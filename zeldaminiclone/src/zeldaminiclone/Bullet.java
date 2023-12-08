package zeldaminiclone;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullet extends Rectangle {
	
	public int dir = 1; 
	public int speed = 8; //boa velocidade prum jogo em boa velocidade, a diferença eh que no jogo 3D tem o eixo Z
	
	public int frames = 0;
	
	public Bullet(int x, int y, int dir) {
		super(x+16,y+16,10,10); //pra invocar o metodo construtor da classe rectangle // o 20,20 é o tamanho da bullet //+16+16 pra sair do centro do personagem
		this.dir = dir; //quando a gente instancia uma bullet a gente vai saber pra qual lado ela vai
						//e a gente ja define isso qdo a gente cria ela
	}
	
	public void tick() { //pra dar o update na bullet
		x+= speed*dir; // *dir pra conseguir trocar de forma dinamica
		frames++;
		if(frames == 60) { //pra bullet sumir depois de 1 seg (ja que 60fps(que foi definido) = 1seg)
			Player.bullets.remove(this);
			return;
		}
	}
	
	public void render(Graphics g) { //renderizar a bullet
		g.setColor(Color.yellow);
		//g.fillRect(x, y, width, height); //width e height ta sendo importada da classe teclado
		g.fillOval(x, y, width, height);
		 
	}

}
