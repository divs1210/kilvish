package dragon_egg;

import static com.kilvish.util.MediaLoader.getImageIcon;

import javax.swing.ImageIcon;

import com.kilvish.core.Actor;
import com.kilvish.core.Animation;

public class Wagon extends Actor {
	
	static final ImageIcon img_1=getImageIcon("media/dragon_egg/wagon/1.png"),
                           img_2=getImageIcon("media/dragon_egg/wagon/2.PNG"),
                           img_3=getImageIcon("media/dragon_egg/wagon/3.PNG");
	
	Animation[] anims = new Animation[3];
	
	int dir = 0;
	
	public Wagon(){
		super("wagon");
		
		anims[0] = new Animation("idle");
		anims[0].add(img_1, 1); 
		this.addAnimation(anims[0]);
		
		anims[1] = new Animation("move_left");
		anims[1].add(img_2, 6);
		anims[1].add(img_3, 6);
		anims[1].add(img_1, 6);
		this.addAnimation(anims[1]);
		
		anims[2] = new Animation("move_right");
		anims[2].add(img_3, 6);
		anims[2].add(img_2, 6);
		anims[2].add(img_1, 6);
		this.addAnimation(anims[2]);

		this.setCurrentAnimation("idle");
	}
	
	@Override
	public void update(){
		this.moveBy(3*dir, 0);
	}
}
