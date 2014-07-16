/*
 * This work is licensed under the Creative Commons Attribution-ShareAlike 3.0 Unported License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send 
 * a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041, USA.
 */

package com.kilvish.core;

import java.awt.Component;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.kilvish.util.Logger;
import com.kilvish.view.GamePane;

/**
 * Simple class to represent an image or a simple animation consisting of a group of images.
 * 
 * @author Divyansh Prakash
 */
public class Sprite extends JLabel{
	private int currImg,
	            framesPassed;
	
	private String name;
	
	ArrayList<SpriteImage> simgs;
	
	public boolean imgChanged = false;
	
	/**
	 * Creates a named Sprite
	 */
	public Sprite(String name){
		currImg=0;
		framesPassed=0;
		
		this.name = name;
		this.simgs = new ArrayList();
		
		this.setVisible(false);
	}
	
	/**
	 * Gets the GamePane to which this Sprite is attached.
	 */
	public GamePane getGamePane(){
		GamePane gp = null;
		try{
			gp = (GamePane)this.getParent();
		}catch(Exception e){
			Logger.log("This sprite has not been added to a GamePane yet.");
		}
		return gp;
	}
	
	/**
	 * Adds a lone image to the sprite.
	 * Use *only* if the sprite has no other images.
	 */
	public void addImage(ImageIcon img){
		this.addSpriteImage(new SpriteImage(img));
	}
	
	/**
	 * Adds an image to the sprite that is displayed for 
	 * the specified number of consecutive frames.
	 * Routes through addSpriteImage()
	 */
	public void addImage(ImageIcon img, int frames){
		this.addSpriteImage(new SpriteImage(img, frames));
	}
	
	/**
	 * Adds a new SpriteImage to the sprite.
	 * addImage() is more suitable for most purposes.
	 */
	public void addSpriteImage(SpriteImage simg){
		simgs.add(simg);
		if(currImg==0){
			this.setIcon(simg.img);
			this.setSize(simg.img.getIconWidth(), simg.img.getIconHeight());
		}
	}
	
	/**
	 * Gets the name of this Sprite.
	 */
	public String getName(){
		return this.name;
	}
	
	/**
	 * Sets the image at the specified index to
	 * be displayed currently.
	 */
	public void setCurrentImageIndex(int i){
		this.currImg = i;
	}
	
	/**
	 * Gets the index of the image being displayed currently.
	 */
	public int getCurrentImageIndex(){
		if(currImg>=simgs.size())
			currImg = 0;
		return currImg;
	}
	
	/**
	 * Gets the image being displayed currently.
	 */
	public ImageIcon getCurrentImage(){
		return simgs.get(getCurrentImageIndex()).img;
	}
	
	/**
	 * Returns the list of SpriteImages that this
	 * Sprite has.
	 */
	public ArrayList<SpriteImage> getSpriteImages(){
		return simgs;
	}
	
	/**
	 * Moves the sprite x pixels to the right and
	 * y pixels down.
	 */
	public void moveBy(int x, int y){
		this.setLocation(this.getX()+x, this.getY()+y);
	}
	
	/**
	 * Shows the next image of this Sprite.
	 * Called automatically by the engine every frame.
	 */
	public void advanceOneFrame(){
		SpriteImage si = simgs.get(this.getCurrentImageIndex());
		if(framesPassed>=si.frames){
			framesPassed=0;
			currImg=(currImg+1)%simgs.size();
			imgChanged = true;
		}else{
			framesPassed++;
			imgChanged = false;
		}
	}
	
	/**
	 * Places this sprite d pixels above the given sprite.
	 * Affects the vertical axis only.
	 */
	public void placeAbove(Sprite that, int d){
		this.setLocation(this.getX(), that.getY()-this.getHeight()-d);
	}
	
	/**
	 * Places this sprite d pixels below the given sprite.
	 * Affects the vertical axis only.
	 */
	public void placeBelow(Sprite that, int d){
		this.setLocation(this.getX(), that.getY()+that.getHeight()+d);
	}
	
	/**
	 * Places this sprite d pixels to the left of the given sprite.
	 * Affects the horizontal axis only.
	 */
	public void placeLeftOf(Sprite that, int d){
		this.setLocation(that.getX()-this.getWidth()-d, this.getY());
	}
	
	/**
	 * Places this sprite d pixels to the right of the given sprite.
	 * Affects the horizontal axis only.
	 */
	public void placeRightOf(Sprite that, int d){
		this.setLocation(that.getX()+that.getWidth()+d, this.getY());
	}
	
	/**
	 * Tests if this sprite is above the given sprite.
	 * Does not check the horizontal axis.
	 */
	public boolean isAbove(Sprite that){
		//return (this.getY()+this.getHeight() < that.getY()+that.getHeight()/2);
		return this.isAbove(that, that.getHeight()/2);
	}
	
	/**
	 * Tests if this sprite is below the given sprite.
	 * Does not check the horizontal axis.
	 */
	public boolean isBelow(Sprite that){
		return that.isAbove(this);
	}
	
	/**
	 * Tests if this sprite is to the left of the given sprite.
	 * Does not check the vertical axis.
	 */
	public boolean isLeftTo(Sprite that){
		//return (this.getX()+this.getWidth() < that.getX()+that.getWidth()/2);
		return this.isLeftTo(that, that.getWidth()/2);
	}
	
	/**
	 * Tests if this sprite is to the right of the given sprite.
	 * Does not check the vertical axis.
	 */
	public boolean isRightTo(Sprite that){
		return that.isLeftTo(this);
	}
	
	/**
	 * Tests if this sprite is above the given sprite.
	 * Does not check the horizontal axis.
	 */
	public boolean isAbove(Sprite that, int pix){
		return (this.getY()+this.getHeight() < that.getY()+pix);
	}
	
	/**
	 * Tests if this sprite is below the given sprite.
	 * Does not check the horizontal axis.
	 */
	public boolean isBelow(Sprite that, int pix){
		return that.isAbove(this, pix);
	}
	
	/**
	 * Tests if this sprite is to the left of the given sprite.
	 * Does not check the vertical axis.
	 */
	public boolean isLeftTo(Sprite that, int pix){
		return (this.getX()+this.getWidth() < that.getX()+pix);
	}
	
	/**
	 * Tests if this sprite is to the right of the given sprite.
	 * Does not check the vertical axis.
	 */
	public boolean isRightTo(Sprite that, int pix){
		return that.isLeftTo(this, pix);
	}
	
	/**
	 * Tests if the given point lies inside this sprite
	 */
	private boolean has(Point p) {
		int x = p.x,
			y = p.y;
		
		return x>=getX() 
			&& x<=getX()+getWidth() 
			&& y>=getY() 
			&& y<=getY()+getHeight();
	}
	
	/**
	 * Tests if the given sprite is colliding with this sprite.
	 */
	public boolean has(Sprite that){
		Point top_left     = that.getLocation(),
		      top_right    = new Point(that.getX()+that.getWidth(), that.getY()),
		      bottom_left  = new Point(that.getX(),that.getY()+that.getHeight()),
		      bottom_right = new Point(that.getX()+that.getWidth(), that.getY()+that.getHeight()),
		      center       = new Point(that.getX()+that.getWidth()/2, that.getY()+that.getHeight()/2);
		
		return this.has(top_left)
			|| this.has(top_right)
			|| this.has(bottom_left)
			|| this.has(bottom_right)
			|| this.has(center);
	}
	
	/**
	 * Returns a sprite with the given name if it is colliding with this sprite,
	 * or if this sprite is colliding with it, and null otherwise.
	 */
	public Sprite collidingWithSome(String spriteName){
		Sprite s=null;
		for(Sprite temp: this.getGamePane().getSpritesCalled(spriteName)){
			if(this.has(temp) || temp.has(this)){
				s = temp;
				break;
			}
		}
		return s;
	}
	
	/**
	 * Makes the Sprite invisible, and removes it from the GamePane.
	 */
	public void kill(){
		this.setVisible(false);
		this.getParent().remove(this);
	}
	
	/**
	 * Is called by the engine every frame.
	 * Override to add functionality.
	 */
	public void update(){}
}