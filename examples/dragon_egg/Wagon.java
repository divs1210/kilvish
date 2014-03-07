package dragon_egg;

import javax.swing.ImageIcon;

import com.kilvish.core.Actor;

public class Wagon extends Actor {
	
	static final ImageIcon wagon_1=new ImageIcon("media/dragon-egg/wagon/1.PNG"),
                           wagon_2=new ImageIcon("media/dragon-egg/wagon/2.PNG"),
                           wagon_3=new ImageIcon("media/dragon-egg/wagon/3.PNG"),
                           wagon_4=new ImageIcon("media/dragon-egg/wagon/4.PNG");
	
	public Wagon(){
		super("wagon");
	}
	
	@Override
	public void update(){
	}
}
