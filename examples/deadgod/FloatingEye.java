package deadgod;

import java.util.Random;

import javax.swing.ImageIcon;

import com.kilvish.core.Sprite;
import com.kilvish.util.MediaLoader;

public class FloatingEye extends Sprite {

	final static ImageIcon img1 = MediaLoader.getImageIcon("media/deadgod/floating_eye/maj-lasereye2.gif"),
			               img2 = MediaLoader.getImageIcon("media/deadgod/floating_eye/maj-lasereye3.gif"),
					       img3 = MediaLoader.getImageIcon("media/deadgod/floating_eye/maj-lasereye4.gif");
	
	final static Random r = new Random();
	
	public FloatingEye() {
		super("bubble");
		
		this.addImage(img1, 15);
		this.addImage(img2, 15);
		this.addImage(img3, 15);
	}
	
	public void update(){
		//int d = (r.nextInt(2)+1)*(r.nextBoolean()?1:-1);
		this.moveBy((r.nextInt(5)+1)*(r.nextBoolean()?1:-1), (r.nextInt(5)+1)*(r.nextBoolean()?1:-1));
		
		if(this.getX()<-this.getWidth() || this.collidingWithSome("stone")!=null)
			this.kill();
	}
	
}