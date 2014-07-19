package deadgod;

import java.util.Random;

import javax.swing.ImageIcon;

import com.kilvish.core.Sprite;
import com.kilvish.util.MediaLoader;

public class Jellyfish extends Sprite {

	final static ImageIcon img1 = MediaLoader.getImageIcon("media/deadgod/jellyfish/pd-bossjelly5.gif"),
			               img2 = MediaLoader.getImageIcon("media/deadgod/jellyfish/pd-bossjelly.gif"),
					       img3 = MediaLoader.getImageIcon("media/deadgod/jellyfish/pd-bossjelly2.gif"),
						   img4 = MediaLoader.getImageIcon("media/deadgod/jellyfish/pd-bossjelly3.gif");
	
	final static Random r = new Random();
	
	public Jellyfish() {
		super("bubble");
		
		//this.addImage(img1, 30);
		this.addImage(img2, 15);
		this.addImage(img3, 15);
		this.addImage(img4, 15);
	}
	
	public void update(){
		this.moveBy(0, -r.nextInt(1)-1);
		
		if(this.getY()<-this.getHeight())// || this.collidingWithSome("stone")!=null)
			this.kill();
	}
	
}