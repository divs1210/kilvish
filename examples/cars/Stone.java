package cars;

import javax.swing.ImageIcon;

import com.kilvish.util.MediaLoader;

public class Stone extends MapElement {

	final static ImageIcon img = MediaLoader.getImageIcon("media/cars/stone.jpg");
	
	public Stone() {
		super("stone");
		this.addImage(img);
	}
	
}