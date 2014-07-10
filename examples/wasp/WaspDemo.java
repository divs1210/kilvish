package wasp;

import static com.kilvish.util.MediaLoader.getBufferedImage;

import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

import org.imgscalr.Scalr;

import com.kilvish.core.Sprite;
import com.kilvish.view.GamePane;
import com.kilvish.view.GameWindow;

public class WaspDemo extends GamePane{

	WaspDemo(){
		super(600, 400);
		
		BufferedImage waspImg = getBufferedImage("media/wasp/wasp.png");
		
		Sprite wasp = new Sprite("wasp");
		for(int i=0; i<8; i++){
			ImageIcon img = new ImageIcon( Scalr.crop(waspImg, 100*i, 0, 100, 100) );
			wasp.addImage(img, 1);
		}
		wasp.setLocation(250, 150);
		this.add(wasp);
	}
	
	public static void main(String[] args){
		WaspDemo wd = new WaspDemo();
		new GameWindow(wd);
		wd.play();
	}
	
}