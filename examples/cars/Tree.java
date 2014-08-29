package cars;

import javax.swing.ImageIcon;

import com.kilvish.util.MediaLoader;

public class Tree extends MapElement {

	final static ImageIcon img = MediaLoader.getImageIcon("media/cars/tree.jpg");
	
	public Tree() {
		super("tree");
		this.addImage(img);
	}
	
}