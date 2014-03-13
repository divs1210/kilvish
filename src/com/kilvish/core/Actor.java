/*
 * This work is licensed under the Creative Commons Attribution-ShareAlike 3.0 Unported License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send 
 * a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041, USA.
 */


package com.kilvish.core;


import java.util.ArrayList;

/**
 * Class to represent complex characters with multiple animations.
 * 
 * @author Divyansh Prakash
 */
public class Actor extends Sprite {

	ArrayList<Animation> anims;
	int curr;
	
	/**
	 * Instantiates a new Actor
	 */
	public Actor(String name){
		super(name);
		anims = new ArrayList<Animation>();
	}
	
	/**
	 * Adds an animation to this actor
	 */
	public void addAnimation(Animation a){
		anims.add(a);
	}
	
	/**
	 * Returns a set of all the Animations of this Actor
	 */
	public ArrayList<Animation> getAnimations(){
		return anims;
	}
	
	/**
	 * Sets the current animation being played by this Actor
	 */
	public void setCurrentAnimationIndex(int i){
		if(i<anims.size()){
			this.getSpriteImages().removeAll(this.getSpriteImages());
			for(SpriteImage simg:getCurrentAnimation())
				this.addSpriteImage(simg);
			curr = i;
		}
	}
	
	public int getCurrentAnimationIndex(){
		if(curr>=anims.size())
			curr=0;
		return curr;
	}
	
	/**
	 * Returns the animation being played by this Actor
	 */
	public Animation getCurrentAnimation(){
		return anims.get(this.getCurrentAnimationIndex());
	}
	
	public boolean equals(String name){
		return name.equals(this.getName());
	}
}