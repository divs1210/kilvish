package dragon_egg;

import javax.swing.ImageIcon;

import com.kilvish.core.Actor;
import com.kilvish.core.Animation;
import com.kilvish.core.Sprite;

import static com.kilvish.util.MediaLoader.*;

class Dragon extends Actor {
	static final ImageIcon img_1=getImageIcon("media/dragon_egg/dragon/1.png"),
                           img_2=getImageIcon("media/dragon_egg/dragon/2.png"),
                           img_3=getImageIcon("media/dragon_egg/dragon/3.png"),
                           img_4=getImageIcon("media/dragon_egg/dragon/4.png");
	
	public Dragon(){
		super("dragon");
		
		Animation fly = new Animation("fly");
		fly.add(img_1, 5);
		fly.add(img_2, 7);
		fly.add(img_3, 7);
		fly.add(img_4, 5);
		this.addAnimation(fly);
		
		this.setCurrentAnimation("fly");
	}
	
	@Override
	public void update(){
		if(this.getX()>this.getParent().getWidth())
			this.setLocation(-this.getWidth(), this.getY());
		this.moveBy(3, 0);
	}
}