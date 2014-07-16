package deadgod;

import java.awt.Color;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import com.kilvish.core.Sprite;
import com.kilvish.util.DragAdapter;
import com.kilvish.util.MediaLoader;
import com.kilvish.view.GamePane;
import com.kilvish.view.GameWindow;

public class DeadGod extends GamePane {

	Diver d;
	Map map;
	
	public DeadGod() {
		super(600, 400);
		this.setFPS(60);
		this.setBackground(new Color(55, 150, 115));
		
		map = new Map(this);
		map.loadNext();
		
		d = new Diver();
		d.setLocation(0, 180);
		this.add(d);
	}
	
	public void update(){
		if(isKeyDown(KeyEvent.VK_UP))
			d.moveBy(0, -1);
		else if(isKeyDown(KeyEvent.VK_DOWN))
			d.moveBy(0,  1);		
		
		if(d.getX()>550){
			this.shiftScreenBy(-600, 0);
			map.loadNext(true);
		}
	}

	public static void main(String[] args) {
		DeadGod dg = new DeadGod();
		
		GameWindow game = new GameWindow(dg);
		game.setTitle("DeadGod - Alhazred's Dream");
		
		dg.play();
	}

}