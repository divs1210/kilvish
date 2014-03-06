package dragon_egg;
import javax.swing.ImageIcon;

import com.threecoffee.anim.Sprite;

public class Egg extends Sprite {

	static final ImageIcon egg = new ImageIcon("media/dragon-egg/egg.jpg"),
	                broken_egg = new ImageIcon("media/dragon-egg/broken_egg.jpg");
	
	boolean broken = false;
	
	public Egg(){
	}
		
	@Override
	public void collided(Sprite s) {
	}
	
}