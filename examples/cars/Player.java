package cars;

import javax.swing.ImageIcon;

import com.kilvish.core.Sprite;
import com.kilvish.util.MediaLoader;

public class Player extends Sprite {

	final static ImageIcon red_car = MediaLoader.getImageIcon("media/cars/red_car.png"),
			                blue_car = MediaLoader.getImageIcon("media/cars/blue_car.png");
	
	int velX=0,
		velY=0;
	
	Player(int type){
		super("player");
		
		if(type==0)
			this.addImage(red_car);
		else
			this.addImage(blue_car);
	}
	
	@Override
	public void update(){
		this.moveBy(velX, -velY/4);
	}
	
}