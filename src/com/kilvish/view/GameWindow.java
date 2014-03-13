package com.kilvish.view;

import java.awt.Dimension;

import javax.swing.JFrame;

import com.kilvish.util.MediaLoader;

public class GameWindow extends JFrame {
	
	public GameWindow(int w, int h){
		this(new GamePane(w, h));
	}
	
	public GameWindow(GamePane gp){
		this.setContentPane(gp);
		this.setTitle("Kilvish Game Engine");
		this.setSize(gp.getSize());
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setIconImage(MediaLoader.getBufferedImage("media/engine/ic.lp"));
		this.pack();
		this.setVisible(true);
	}
	
	@Override
	public Dimension getPreferredSize(){
		return this.getContentPane().getSize();
	}

}