package com.kilvish.core;

import javax.swing.ImageIcon;

/**
 * Represents a (image, frames) pair.
 * The image will be displayed for the given consecutive frames.
 */
public class SpriteImage{
	
	public final ImageIcon img;
	public final int frames;
	
	/**
	 * An image that will be displayed continuously.
	 */
	public SpriteImage(ImageIcon img){
		this(img, 9999);
	}
	
	/**
	 * An image that will be displayed for the given consecutive frames.
	 */
	public SpriteImage(ImageIcon img, int frames){
		this.img = img;
		this.frames = frames;
	}
}