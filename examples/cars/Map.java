package cars;

import java.util.Random;

import com.kilvish.core.Sprite;
import com.kilvish.view.GamePane;

public class Map {

	int[][] repr =   {{2,2,2,0,0,2,2,2},
					  {1,1,1,0,0,1,1,1},
					  {1,1,1,0,0,1,1,1},
				      {1,1,1,0,0,1,1,1},
				      {1,1,1,0,0,1,1,1},
					  {1,1,1,0,0,1,1,1},
					  {1,1,1,0,0,1,1,1},
					  {1,1,1,0,0,1,1,1},
					  {1,1,1,0,0,1,1,1},
					  {1,1,1,0,0,1,1,1},
					  {1,1,1,0,0,1,1,1},
					  {1,1,1,0,0,1,1,1},
					  {1,1,1,0,0,1,1,1},
					  {1,1,1,0,0,1,1,1},
				      {1,1,1,0,0,1,1,1},
					  {1,1,1,0,0,1,1,1},
					  {1,1,1,0,0,1,1,1},
					  {1,1,1,0,0,1,1,1},
					  {1,1,1,0,0,1,1,1},
					  {1,1,1,0,0,1,1,1},
					  {1,1,1,0,0,1,1,1},
					  {1,1,1,0,0,1,1,1},
					  {1,1,1,0,0,1,1,1},
					  {1,1,1,0,0,1,1,1},
					  {1,1,1,0,0,1,1,1},
					  {1,1,1,0,0,1,1,1},
					  {1,1,1,0,0,1,1,1}};
	
	int curr = 0;
	GamePane gp;
	
	public Map(GamePane gp){
		this.gp = gp;
	}
	
	public void loadNext(){
		loadNext(false);
	}
	
	public MapElement randomNaturalElement(){
		Random r = ((Cars)gp).r;
		return r.nextBoolean()?new Grass():
				r.nextBoolean()?new Grass():
				r.nextBoolean()?new  Tree():
				r.nextBoolean()?new  Tree():
								new  Rock();
	}
	
	public void loadNext(boolean visible){
		Sprite s=null;
		for(int c=0; c<8; c++){
			switch(repr[curr][c]){
				case 0: s = new Road();  break;
				case 1: s = randomNaturalElement(); break;
				case 2: s = new Stone(); break;
			}
			
			if(s!=null){
				s.setLocation(c*100, -100);
				s.setVisible(visible);
				gp.add(s);
				
				s = null;
			}
		}
		curr=(curr+1)%repr.length;
	}
}
