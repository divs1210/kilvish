package deadgod;

import javax.swing.ImageIcon;

import com.kilvish.core.Sprite;
import com.kilvish.util.MediaLoader;

public class Sonar extends Sprite {

	final static ImageIcon img0 = MediaLoader.getImageIcon("media/deadgod/sonar/0.png"),
							img1 = MediaLoader.getImageIcon("media/deadgod/sonar/1.png"),
							img2 = MediaLoader.getImageIcon("media/deadgod/sonar/2.png"),
							img3 = MediaLoader.getImageIcon("media/deadgod/sonar/3.png"),
							img4 = MediaLoader.getImageIcon("media/deadgod/sonar/4.png"),
							img5 = MediaLoader.getImageIcon("media/deadgod/sonar/5.png"),
							img6 = MediaLoader.getImageIcon("media/deadgod/sonar/6.png"),
							img7 = MediaLoader.getImageIcon("media/deadgod/sonar/7.png");
	
	public Sonar() {
		super("sonar");
		
		this.addImage(img0, 15);
		this.addImage(img1, 15);
		this.addImage(img2, 15);
		this.addImage(img3, 15);
		this.addImage(img4, 15);
		this.addImage(img5, 15);
		this.addImage(img6, 15);
		this.addImage(img7, 15);
	}
}