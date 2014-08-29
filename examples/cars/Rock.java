package cars;

import javax.swing.ImageIcon;

import com.kilvish.util.MediaLoader;

public class Rock extends MapElement {

	final static ImageIcon img = MediaLoader.getImageIcon("media/cars/rock.jpg");
	
	public Rock() {
		super("rock");
		this.addImage(img);
	}
	
}