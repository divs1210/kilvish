package com.kilvish.core;

import javax.swing.ImageIcon;

public class SpriteImage{
	public ImageIcon img;
	public int frames;
	
	public SpriteImage(ImageIcon img){
		this(img, 1);
	}
	
	public SpriteImage(ImageIcon img, int frames){
		this.img = img;
		this.frames = frames;
	}
}