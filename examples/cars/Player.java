package cars;

import javax.swing.ImageIcon;

import com.kilvish.core.Sprite;
import com.kilvish.util.MediaLoader;

public class Player extends Sprite {

	final static ImageIcon red_car = MediaLoader.getImageIcon("media/cars/red_car.jpg");
	
	Player(){
		super("player");
		this.addImage(red_car);
	}
	
	public void update(){
	}
	
}
