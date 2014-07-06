package com.kilvish.view;

import java.awt.Container;

import javax.swing.JApplet;

import com.kilvish.util.Logger;

/**
 * Extend to wrap your GamePane in an Applet.
 */
public class GameApplet extends JApplet {
	
	GamePane gp;
	
	/**
	 * Sets the given GamePane as the ContentPane of this applet.
	 */
	public void setGamePane(GamePane gp){
		this.gp = gp;
		this.setContentPane(gp);
		this.setSize(gp.getSize());
	}
	
	/**
	 * Returns the GamePane that this Applet is displaying.
	 */
	public GamePane getGamePane(){
		return gp;
	}
	
	@Override
	public Container getContentPane(){
		return gp;
	}
	
}