package zeldaminiclone;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable, KeyListener {
	
	public static int WIDTH = 640, HEIGHT = 480;
	public static int SCALE = 3;
	public Player player; //instanciando
	public World world;
	
	public Game() {
		this.addKeyListener(this);//quero adicionar eventos de teclado e os metodos ja foram criados qdo implementei o keylistener
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		new Spritesheet();
		
		player = new Player(32,32); //posicao inicial
		world = new World();
	}
	
	public void tick() { //metodo em TODO jogo que é responsavel pela movimentação/colisao/etc
		player.tick();
	}
	
	public void render() { //toda renderização dos graficos vai ficar aqui
		BufferStrategy bs = this.getBufferStrategy();
										//toda vez que vai renderizar precisa limpar o buffer
		
		if(bs == null) {
			this.createBufferStrategy(3);//3 ou 2, otimizacao grafica
			return;                      // codigo usado pra otimizar parte grafica
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(new Color(0,135,13));
		g.fillRect(0, 0, WIDTH*SCALE, HEIGHT*SCALE);
		
//		g.setColor(Color.red);
//		g.fillRect(0, 0, 50, 50);
		
		player.render(g);
		world.render(g);
		
		bs.show(); //pra mostrar o que tem(?)
		
	}
	
	public static void main(String[]args) {
		Game game = new Game();
		JFrame frame = new JFrame();
		
		frame.add(game);
		frame.setTitle("Mini Zelda");
		frame.setLocationRelativeTo(null); //deixar janela centralizada, sempre depois do .pack
		frame.pack();//empacotar tudo isso que foi feito e calcular tamanho da janela
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		frame.setVisible(true); //pra ver a janela
		
		new Thread(game).start(); //do proprio java, vai procurar o metodo run  na classe Game
		
	}

	@Override
	public void run() {
		
		while(true) {
			tick();
			render(); //tanto o tick quanto o render, qdo vc pega um engine pronta, nao existe isso aqui
					  //eh diferente
			try {
				Thread.sleep(1000/60); //pra rodar a 60fps
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	//OS METODOS KEYS ABAIXO, sao gerados automaticamente qdo implementados no KeyListener(tem que importar os metodos na classe se nao fica com erro e nao aparece)
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.right = true;
		} else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			player.left = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			player.up = true;
		} else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			player.down = true;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.right = false;
		} else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			player.left = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			player.up = false;
		} else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			player.down = false;
		}
	}
	
	

}
