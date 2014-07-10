package bricksnball;

import static com.kilvish.util.MediaLoader.getImageIcon;

import java.applet.AudioClip;

import javax.swing.ImageIcon;

import com.kilvish.core.Sprite;
import com.kilvish.util.MediaLoader;

public class Brick extends Sprite {
	
	static final ImageIcon img_Y0=getImageIcon("media/bricksnball/bricks/brick2_0.png"),
			               img_Y1=getImageIcon("media/bricksnball/bricks/brick2_1.png"),
			               img_Y2=getImageIcon("media/bricksnball/bricks/brick2_2.png"),
					       img_Y3=getImageIcon("media/bricksnball/bricks/brick2_3.png"),
                           img_R0=getImageIcon("media/bricksnball/bricks/brick1_0.png"),
                           img_R1=getImageIcon("media/bricksnball/bricks/brick1_1.png"),
                           img_R2=getImageIcon("media/bricksnball/bricks/brick1_2.png"),
                           img_R3=getImageIcon("media/bricksnball/bricks/brick1_3.png");
	
	static final int YELLOW = 0,
		 	            RED = 1;
	
	int type;
	
	public Brick(int type){
		super("brick");
		
		this.type = type;
		if(type==YELLOW){
			this.addImage(img_Y0, 60);
			this.addImage(img_Y1, 20);
			this.addImage(img_Y2, 20);
			this.addImage(img_Y3, 10);
		}else{
			this.addImage(img_R0, 200);
			this.addImage(img_R1, 25);
			this.addImage(img_R2, 20);
			this.addImage(img_R3, 10);
		}
	}

}