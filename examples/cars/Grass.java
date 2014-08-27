package cars;

import javax.swing.ImageIcon;

import com.kilvish.util.MediaLoader;

public class Grass extends MapElement {

	final static ImageIcon img = MediaLoader.getImageIcon("media/cars/grass.jpg");
	
	public Grass() {
		super("grass");
		this.addImage(img);
	}
	
}