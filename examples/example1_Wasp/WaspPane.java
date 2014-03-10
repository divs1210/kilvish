package example1_Wasp;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import org.imgscalr.Scalr;

import com.kilvish.core.Sprite;
import com.kilvish.view.GamePane;
import com.kilvish.view.GameWindow;

public class WaspPane extends GamePane{

	WaspPane(){
		super(150, 150);
		
		BufferedImage wasp=null;
		try {
			wasp = ImageIO.read(new File("media/wasp/wasp.png"));
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		Sprite buzz = new Sprite("wasp");
		for(int i=0; i<8; i++){
			ImageIcon img = new ImageIcon( Scalr.crop(wasp, 100*i, 0, 100, 100) );
			buzz.addImage(img, 1);
		}
		this.add(buzz);
	}
	
	public static void main(String[] args){
		WaspPane wp = new WaspPane();
		GameWindow gw = new GameWindow(wp);
		wp.play();
	}
	
}