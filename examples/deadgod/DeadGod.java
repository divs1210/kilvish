package deadgod;

import java.awt.Color;
import java.awt.event.KeyEvent;

import com.kilvish.view.GamePane;
import com.kilvish.view.GameWindow;

public class DeadGod extends GamePane {

	Diver d;
	Map map;
	Sonar sonar;
	
	public DeadGod() {
		super(600, 400);
		this.setFPS(80);
		this.setBackground(new Color(55, 150, 115));
		
		sonar = new Sonar();
		sonar.setLocation(600-64, 400-64);
		this.add(sonar);
		
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
		
		Stone s;
		while((s=(Stone) d.collidingWithSome("stone")) != null){
			if(d.isLeftTo(s, 5))
				d.placeLeftOf(s, 1);
			else if(d.isAbove(s))
				d.placeAbove(s, 1);
			else if(d.isBelow(s))
				d.placeBelow(s, 1);
		}
		
		if(d.r.nextInt(500)<5){
			int choice=d.r.nextInt(100);
			if(choice<10){
				Jellyfish j = new Jellyfish();
				j.setLocation(d.r.nextInt(580), 400);
				j.setVisible(true);
				this.add(j);
			}else if(choice<15){
				FloatingEye j = new FloatingEye();
				j.setLocation(d.getLocation());
				j.setVisible(true);
				this.add(j);
			}
		}
		
		if(d.getX()>550){
			this.shiftScreenBy(-600, 0);
			map.loadNext(true);
			sonar.setLocation(600-64, 400-64);
		}
	}

	public static void main(String[] args) {
		DeadGod dg = new DeadGod();
		
		GameWindow game = new GameWindow(dg);
		game.setTitle("DeadGod - Alhazred's Dream");
		
		dg.play();
	}

}