/*
 * This work is licensed under the Creative Commons Attribution-ShareAlike 3.0 Unported License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send 
 * a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041, USA.
 */


package com.kilvish.core;

import java.util.ArrayList;

import javax.swing.ImageIcon;

/**
 * A class to represent an animation created
 * using a series of images
 *  
 * @author Divyansh Prakash
 */
public class Animation extends ArrayList<SpriteImage> {
	
	String name;
	
	public Animation(String name){
		this.name = name;
	}
	
	/**
	 * Returns the name of this animation.
	 */
	public String getName(){
		return name;
	}
	
	public void add(ImageIcon img, int frames){
		this.add(new SpriteImage(img, frames));
	}
	
}