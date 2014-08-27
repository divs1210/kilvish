package cars;

import javax.swing.ImageIcon;

import com.kilvish.core.Sprite;
import com.kilvish.util.MediaLoader;

public class Road extends Sprite {

	final static ImageIcon img = MediaLoader.getImageIcon("media/deadgod/stone.jpg");
	
	public Road() {
		super("stone");
		this.addImage(img);
	}
	
	public void update(){
		if(this.getX()<-100)
			this.kill();
	}
	
}