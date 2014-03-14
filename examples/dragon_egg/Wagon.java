package dragon_egg;

import static com.kilvish.util.MediaLoader.getImageIcon;

import javax.swing.ImageIcon;

import com.kilvish.core.Actor;
import com.kilvish.core.Animation;

public class Wagon extends Actor {
	
	static final ImageIcon img_1=getImageIcon("media/dragon_egg/wagon/1.png"),
                           img_2=getImageIcon("media/dragon_egg/wagon/2.PNG"),
                           img_3=getImageIcon("media/dragon_egg/wagon/3.PNG");
	
	int dir = 0;
	
	public Wagon(){
		super("wagon");
		
		Animation temp;
		temp = new Animation("idle");
		temp.add(img_1, 1); 
		this.addAnimation(temp);
		
		temp = new Animation("move_left");
		temp.add(img_2, 6);
		temp.add(img_3, 6);
		temp.add(img_1, 6);
		this.addAnimation(temp);
		
		temp = new Animation("move_right");
		temp.add(img_3, 6);
		temp.add(img_2, 6);
		temp.add(img_1, 6);
		this.addAnimation(temp);

		this.setCurrentAnimation("idle");
	}
	
	@Override
	public void update(){
		this.moveBy(3*dir, 0);
	}
}
