package cars;

import com.kilvish.core.Sprite;

public abstract class MapElement extends Sprite {
	
	public MapElement(String type) {
		super(type);
	}
	
	public final void update(){
		if(this.getX()<-100)
			this.kill();
	}
	
}