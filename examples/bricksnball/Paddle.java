package bricksnball;

import static com.kilvish.util.MediaLoader.getImageIcon;

import javax.swing.ImageIcon;

import com.kilvish.core.Sprite;

public class Paddle extends Sprite {

	static final ImageIcon img = getImageIcon("media/bricksnball/paddle.png");
	
	int dir=0;
	
	public Paddle(){
		super("paddle");
		
		this.addImage(img, 9999);
	}
	
	@Override
	public void update(){
		this.moveBy(5*dir, 0);
	}
	
}