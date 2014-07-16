package deadgod;

import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.ImageIcon;

import org.imgscalr.Scalr;

import com.kilvish.core.Sprite;
import com.kilvish.util.MediaLoader;

public class Diver extends Sprite {

	final static BufferedImage sheet = MediaLoader.getBufferedImage("media/deadgod/DiverWithMissle.png");
	
	Random r;
	
	Diver(){
		super("diver");
		
		r = new Random();
		
		this.addImage(new ImageIcon(Scalr.crop(sheet, 303, 130, 50, 20)), 5);
		this.addImage(new ImageIcon(Scalr.crop(sheet, 360, 130, 50, 20)), 10);
		this.addImage(new ImageIcon(Scalr.crop(sheet, 418, 130, 50, 20)), 5);
	}
	
	public void update(){
		this.moveBy(1, 0);
		
		if(r.nextInt(100)>97){
			Bubble b= new Bubble();
			b.placeRightOf(this, 0);
			b.placeAbove(this, 0);
			b.setVisible(true);
			this.getParent().add(b);
		}
	}
	
}
