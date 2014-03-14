/*
 * This work is licensed under the Creative Commons Attribution-ShareAlike 3.0 Unported License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send 
 * a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041, USA.
 */


package com.kilvish.core;


import java.util.ArrayList;

import com.kilvish.util.Logger;

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
		}else
			i=0;
	}
	
	public int getCurrentAnimationIndex(){
		if(curr>=anims.size())
			curr=0;
		return curr;
	}
	
	public void setCurrentAnimation(String name){
		Animation a;
		for(int i=0;i<anims.size();i++){
			a = anims.get(i);
			if(a.equals(name)){
				this.setCurrentAnimationIndex(i);
				return;
			}
		}
		Logger.log(new Exception("No such animation: "+name+" in "+this.getName()+"!"));
	}
	
	/**
	 * Returns the animation being played by this Actor
	 */
	public Animation getCurrentAnimation(){
		return anims.get(this.getCurrentAnimationIndex());
	}
}