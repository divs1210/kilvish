package cars;

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
	
	Cars c;
	int curr = 0;
	
	public Map(GamePane gp){
		this.c = (Cars)gp;
	}
	
	public void loadNext(){
		loadNext(false);
	}
	
	public MapElement randomNaturalElement(){
		return c.r.nextBoolean()?new Grass():
				c.r.nextBoolean()?new Grass():
				c.r.nextBoolean()?new  Tree():
				c.r.nextBoolean()?new  Tree():
								  new  Rock();
	}
	
	public void loadNext(boolean visible){
		Sprite s;
		for(int col=0; col<8; col++){
			s = null;
			
			switch(repr[curr][col]){
				case 0: s = new Road();  break;
				case 1: s = randomNaturalElement(); break;
				case 2: s = new Stone(); break;
			}
			
			if(s!=null){
				s.setLocation(col*100, -100);
				s.setVisible(visible);
				c.add(s);
			}
		}
		curr=(curr+1)%repr.length;
	}
}
