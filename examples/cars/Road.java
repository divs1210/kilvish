package cars;

import javax.swing.ImageIcon;

import com.kilvish.util.MediaLoader;

public class Road extends MapElement {

	final static ImageIcon img = MediaLoader.getImageIcon("media/cars/road.jpg");
	
	public Road() {
		super("stone");
		this.addImage(img);
	}
	
}