package cars;

import java.util.Stack;

import com.kilvish.core.Sprite;

public abstract class MapElement extends Sprite {
	
	static final Killer killer = new Killer();
	static final Thread killerThread = new Thread(killer);
	
	boolean pushed = false;
	
	static{
		killerThread.start();
	}
	
	public MapElement(String type) {
		super(type);
	}
	
	public final void update(){
		if(!pushed && this.getY()>1500){
			killer.push(this);
			pushed = true;
		}
	}
	
}

class Killer extends Stack<Sprite> implements Runnable{
	
	public void run(){
		Sprite s;
		while(true){
			if(this.size()>0){
				s = this.pop();
				s.kill();
			}
		}
	}
	
}