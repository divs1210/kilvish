package deadgod;

import javax.swing.ImageIcon;

import com.kilvish.core.Sprite;
import com.kilvish.util.MediaLoader;

public class Bubble extends Sprite {

	final static ImageIcon img = MediaLoader.getImageIcon("media/deadgod/bubble.png");
	
	public Bubble() {
		super("bubble");
		this.addImage(img);
	}
	
	public void update(){
		this.moveBy(0, -1);
		
		if(this.getY()<0 || this.collidingWithSome("stone")!=null)
			this.kill();
	}
	
}