package bricksnball;

import static com.kilvish.util.MediaLoader.getImageIcon;

import javax.swing.ImageIcon;

import com.kilvish.core.Sprite;

public class Brick extends Sprite {
	
	static final ImageIcon img_Y=getImageIcon("media/bricksnball/bricks/brick2.png"),
                           img_R=getImageIcon("media/bricksnball/bricks/brick1.png");
	
	static final int YELLOW = 0,
		 	            RED = 1;
	
	int type;
	
	public Brick(int type){
		super("brick");
		
		this.type = type;
		if(type==YELLOW)
			this.addImage(img_Y, 9999);
		else
			this.addImage(img_R, 9999);
	}

}