package dragon_egg;

import javax.swing.ImageIcon;

import com.kilvish.core.Sprite;

import static com.kilvish.util.MediaLoader.*;

class Dragon extends Sprite {
	static final ImageIcon img_1=getImageIcon("media/dragon_egg/dragon/1.png"),
                           img_2=getImageIcon("media/dragon_egg/dragon/2.png"),
                           img_3=getImageIcon("media/dragon_egg/dragon/3.png"),
                           img_4=getImageIcon("media/dragon_egg/dragon/4.png");
	
	public Dragon(){
		super("dragon");
		
		this.addImage(img_1, 1);
		this.addImage(img_2, 1);
		this.addImage(img_3, 1);
		this.addImage(img_4, 1);
	}
	
	@Override
	public void update(){
		if(this.getX()>this.getParent().getWidth())
			this.setLocation(-this.getWidth(), this.getY());
		this.moveBy(5, 0);
	}
}