package com.kilvish.core;

import javax.swing.ImageIcon;

public class SpriteImage{
	public final ImageIcon img;
	public final int frames;
	
	public SpriteImage(ImageIcon img){
		this(img, 1);
	}
	
	public SpriteImage(ImageIcon img, int frames){
		this.img = img;
		this.frames = frames;
	}
}