package com.kilvish.view;

import javax.swing.JFrame;

import com.kilvish.util.MediaLoader;

/**
 * A windowed game.
 */
public class GameWindow extends JFrame {
	
	/**
	 * Creates a new GameWindow with the specified 
	 * width and height.
	 * Use GamePane instead, and wrap it into a GameApplet or GameWindow as required.
	 */
	public GameWindow(int w, int h){
		this(new GamePane(w, h));
	}
	
	/**
	 * Wraps the given GamePane into a GameWindow.
	 */
	public GameWindow(GamePane gp){
		this.setContentPane(gp);
		this.setLayout(null);
		this.setTitle("Kilvish Game Engine");
		this.setSize(gp.getSize());
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setIconImage(MediaLoader.getImageIcon("media/engine/ic.lp").getImage());
		this.pack();
		this.setVisible(true);
	}

}