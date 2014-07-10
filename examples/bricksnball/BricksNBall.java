package bricksnball;

import java.applet.AudioClip;
import java.awt.Color;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import com.kilvish.core.Sprite;
import com.kilvish.util.MediaLoader;
import com.kilvish.view.GamePane;
import com.kilvish.view.GameWindow;

public class BricksNBall extends GamePane {
	
	Brick[] bricks=new Brick[50];
	
	Paddle paddle;
	Ball ball;
	
	Sprite wallL,
		   wallR,
	       roof;
	
	static final ImageIcon wallImg_1 = MediaLoader.getImageIcon("media/bricksnball/walls/wall.png"),
						   wallImg_2 = MediaLoader.getImageIcon("media/bricksnball/walls/wall_2.png"),
			               roofImg   = MediaLoader.getImageIcon("media/bricksnball/walls/roof.png");
	
	static final AudioClip hit   = MediaLoader.getSound("media/bricksnball/sounds/hit.wav"),
						   blast = MediaLoader.getSound("media/bricksnball/sounds/blast.wav"),
						   music = MediaLoader.getSound("media/bricksnball/sounds/music.wav");
	
	public BricksNBall(){
		super(600, 400);
		this.setBackground(new Color(215, 212, 210));
		this.setFPS(80);
		
		int[][] map={{1,1,1,1,1,1,1,1,1,1},
				     {1,0,0,0,0,0,0,0,0,1},
				     {1,0,0,0,1,1,0,0,0,1},
				     {1,0,0,0,0,0,0,0,0,1},
				     {1,1,1,1,1,1,1,1,1,1}};
		
		int i=0,
			startX=(this.getWidth()-400)/2,
			startY= this.getHeight()/5;
		for(int r=0; r<5; r++){
			for(int c=0; c<10; c++,i++){
				if(map[r][c]>=0){
					bricks[i] = new Brick(map[r][c]);
					bricks[i].setLocation(startX+40*c, startY+20*r);
					this.add(bricks[i]);
				}
			}
		}
		
		wallL = new Sprite("left_wall");
		wallL.addImage(wallImg_1, 50);
		wallL.addImage(wallImg_2, 50);
		wallL.setLocation(0,0);
		this.add(wallL);
		
		wallR = new Sprite("right_wall");
		wallR.addImage(wallImg_1, 50);
		wallR.addImage(wallImg_2, 50);
		wallR.setLocation(getWidth()-wallR.getWidth(),0);
		this.add(wallR);
		
		roof = new Sprite("roof");
		roof.addImage(roofImg);
		roof.setLocation(0,0);
		this.add(roof);
		
		paddle = new Paddle();
		paddle.setLocation((this.getWidth()-paddle.getWidth())/2, 
				           this.getHeight()-paddle.getHeight());
		this.add(paddle);
		
		ball = new Ball();
		initBall();
		this.add(ball);
	}

	@Override
	public void update(){
		if(isKeyDown(KeyEvent.VK_LEFT))
			paddle.dir = -1;
		else if(isKeyDown(KeyEvent.VK_RIGHT))
			paddle.dir = 1;
		else
			paddle.dir = 0;
		
		/*  Auto-Pilot
		if(ball.ydir==1){
			if(ball.isLeftTo(paddle))
				paddle.dir = -1;
			else if(ball.isRightTo(paddle))
				paddle.dir = 1;
			else
				paddle.dir = 0;
		}else
			paddle.dir = 0;
		//*/
		
		if(paddle.has(ball)){
			ball.placeAbove(paddle, 1);
			ball.ydir = -1;
		}else if(roof.has(ball)){
			ball.placeBelow(roof, 1);
			ball.ydir = 1;
		}else if(ball.getY()>getHeight()){
			initBall();
		}
		
		if(wallL.has(ball)){
			ball.placeRightOf(wallL, 1);
			ball.xdir = 1;
		}else if(wallR.has(ball)){
			ball.placeLeftOf(wallR, 1);
			ball.xdir = -1;
		}
		
		boolean broken;
		int type, remaining=0;
		Brick b;
		for(int i=0; i<bricks.length; i++){
			b = bricks[i];
			if(b==null)
				continue;
			remaining++;
			
			broken = false;
			type = b.type;
			
			if(b.has(ball)){
				broken = true;
				
				if(ball.xdir==-1 && ball.isRightTo(b)){
					ball.placeRightOf(b, 1);
					ball.xdir = 1;
				}else if(ball.xdir==1 && ball.isLeftTo(b)){
					ball.placeLeftOf(b, 1);
					ball.xdir = -1;
				}else if(ball.ydir==-1 && ball.isBelow(b)){
					ball.placeBelow(b, 1);
					ball.ydir = 1;
				}else if(ball.ydir==1 && ball.isAbove(b)){
					ball.placeAbove(b, 1);
					ball.ydir = -1;
				}
			}
			
			if(broken){
				if(type==Brick.RED){
					Brick b1 = new Brick(Brick.YELLOW);
					b1.setLocation(b.getLocation());
					b1.setVisible(true);
					this.add(b1);
					
					bricks[i] = b1;
					hit.play();
				}else{
					bricks[i] = null;
					blast.play();
				}
				b.setVisible(false);
				this.remove(b);
				break;
			}
		}
		
		if(remaining==0){
			this.pause(true);
			JOptionPane.showMessageDialog(this, "This was a demo of Kilvish Game Engine.");
		}
	}
	
	void initBall(){
		ball.xvel = 4;
		ball.yvel = 4;
		ball.xdir = 1;
		ball.ydir = 1;
		ball.setLocation((this.getWidth()-ball.getWidth())/2, 
				         (this.getHeight()*7)/10);
		music.loop();
	}
	
	public static void main(String[] args) {
		BricksNBall bnb = new BricksNBall();
		new GameWindow(bnb);
		bnb.play();
	}

}