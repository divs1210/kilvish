package dragon_egg;

import static com.kilvish.util.MediaLoader.getImageIcon;

import javax.swing.ImageIcon;

import com.kilvish.core.Actor;
import com.kilvish.core.Animation;

public class Wagon extends Actor {
	
	static final ImageIcon img_1=getImageIcon("media/dragon_egg/wagon/1.png"),
                           img_2=getImageIcon("media/dragon_egg/wagon/2.PNG"),
                           img_3=getImageIcon("media/dragon_egg/wagon/3.PNG"),
                           img_4=getImageIcon("media/dragon_egg/wagon/4.PNG");
	
	Animation[] anims;
	
	int dir = 0;
	
	public Wagon(){
		super("wagon");
		
		anims = new Animation[2];
		
		anims[0] = new Animation("still");
		anims[0].add(img_1, 1); 
		this.addAnimation(anims[0]);
		
		anims[1] = new Animation("moving");
		anims[1].add(img_2, 2);
		anims[1].add(img_4, 2);
		anims[1].add(img_1, 2);
		this.addAnimation(anims[1]);

		this.setCurrentAnimationIndex(0);
	}
	
	@Override
	public void update(){
		this.moveBy(5*dir, 0);
	}
}
