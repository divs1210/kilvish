package com.kilvish.view;

import java.awt.Dimension;

import javax.swing.JFrame;

public class GameWindow extends JFrame {
	
	public GameWindow(int w, int h){
		this(new GamePane(w, h));
	}
	
	public GameWindow(GamePane gp){
		this.setContentPane(gp);
		this.setSize(gp.getSize());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
	}
	
	@Override
	public Dimension getPreferredSize(){
		return this.getContentPane().getSize();
	}

}