package clouddemo;

import javax.swing.ImageIcon;

import com.kilvish.core.Sprite;
import com.kilvish.util.DragAdapter;
import com.kilvish.util.MediaLoader;
import com.kilvish.view.GamePane;
import com.kilvish.view.GameWindow;

public class CloudDemo extends GamePane {
	
	static final ImageIcon cloudImg1 = MediaLoader.getImageIcon("media/etc/cloud.png"),
			               cloudImg2 = MediaLoader.getImageIcon("media/etc/cloud2.png");
	
	Sprite cloud;
	
	CloudDemo(){
		super(600, 400);
		this.setFPS(60);
		
		cloud = new Sprite("cloud");
		cloud.addImage(cloudImg1);
		
		this.add(cloud);
	}
	
	public static void main(String[] args) {
		CloudDemo cd = new CloudDemo();
		new GameWindow(cd);
		cd.play();
	}

}