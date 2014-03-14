package bricksnball;

import static com.kilvish.util.MediaLoader.getImageIcon;

import javax.swing.ImageIcon;

import com.kilvish.core.Sprite;

public class Ball extends Sprite {

	static final ImageIcon img=getImageIcon("media/bricksnball/ball.png");

	int xdir,
	    ydir;
	
	int xvel,
		yvel;
	
	public Ball(){
		super("ball");
		
		this.addImage(img, 9999);
	}
	
	@Override
	public void update(){
		this.moveBy(xvel*xdir, yvel*ydir);
	}
	
}
