package com.kilvish.view;

import javax.swing.JApplet;

public class GameApplet extends JApplet {
	
	GamePane gp;
	
	public void setGamePane(GamePane gp){
		this.gp = gp;
		this.setContentPane(gp);
		this.setSize(gp.getSize());
	}
	
	public GamePane getGamePane(){
		return gp;
	}
	
}
