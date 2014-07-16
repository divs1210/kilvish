package deadgod;

import com.kilvish.view.GamePane;

public class Map {

	int[][][] repr = {//screen1
					  {{0,0,0,0,1,1},
					   {0,0,0,0,0,0},
					   {0,0,0,0,0,0},
					   {0,0,0,0,1,1}}
					 };
	int curr = 0;
	GamePane gp;
	
	public Map(GamePane gp){
		this.gp = gp;
	}
	
	public void loadNext(){
		Stone s;
		for(int r=0; r<4; r++){
			for(int c=0; c<6; c++){
				if(repr[curr][r][c]==1){
					s = new Stone();
					s.setLocation(c*100, r*100);
					gp.add(s);
				}
			}
		}
		curr++;
	}
}
