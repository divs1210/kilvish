package cars;

import com.kilvish.core.Sprite;
import com.kilvish.util.MediaLoader;
import com.kilvish.view.GamePane;

public class Map {

	int[][][] repr = {//screen1
					  {{1,1,0,0,1,1},
					   {1,1,0,0,1,1},
					   {1,1,0,0,1,1},
					   {1,1,0,0,1,1}},
					  //screen2
					  {{1,1,0,0,1,1},
					   {1,1,0,0,1,1},
					   {1,1,0,0,1,1},
					   {1,1,0,0,1,1}},
					  //screen2
					  {{1,1,0,0,1,1},
					   {1,1,0,0,1,1},
					   {1,1,0,0,1,1},
					   {1,1,0,0,1,1}},  
					 };
	int curr = 0;
	GamePane gp;
	
	public Map(GamePane gp){
		this.gp = gp;
	}
	
	public void loadNext(){
		loadNext(false);
	}
	
	public void loadNext(boolean visible){
		Sprite s=null;
		for(int r=0; r<4; r++){
			for(int c=0; c<6; c++){
				if(repr[curr][r][c]==0)
					s = new Road();
				else if(repr[curr][r][c]==1)
					s = new Grass();
				
				if(s!=null){
					s.setLocation(c*100, r*100);
					s.setVisible(visible);
					gp.add(s);
					
					s = null;
				}
			}
		}
		curr=(curr+1)%repr.length;
	}
}
