/*
 * This work is licensed under the Creative Commons Attribution-ShareAlike 3.0 Unported License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send 
 * a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041, USA.
 */

package com.kilvish.core;

import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

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
	
	public Sprite(String name){
		currImg=0;
		framesPassed=0;
		
		this.name = name;
		this.simgs = new ArrayList();
		
		this.setVisible(false);
	}
	
	public void addImage(ImageIcon img, int frames){
		this.addSpriteImage(new SpriteImage(img, frames));
	}
	
	public void addSpriteImage(SpriteImage simg){
		simgs.add(simg);
		if(currImg==0){
			this.setIcon(simg.img);
			this.setSize(simg.img.getIconWidth(), simg.img.getIconHeight());
		}
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setCurrentImageIndex(int i){
		this.currImg = i;
	}
	
	public int getCurrentIndex(){
		if(currImg>=simgs.size())
			currImg = 0;
		return currImg;
	}
	
	public ImageIcon getCurrentImage(){
		return simgs.get(getCurrentIndex()).img;
	}
	
	public ArrayList<SpriteImage> getSpriteImages(){
		return simgs;
	}
	
	public void moveBy(int x, int y){
		this.setLocation(this.getX()+x, this.getY()+y);
	}
	
	public void advanceOneFrame(){
		SpriteImage si = simgs.get(this.getCurrentIndex());
		if(framesPassed>=si.frames){
			framesPassed=0;
			currImg=(currImg+1)%simgs.size();
			imgChanged = true;
		}else{
			framesPassed++;
			imgChanged = false;
		}
	}
	
	public void placeAbove(Sprite that, int d){
		this.setLocation(this.getX(), that.getY()-this.getHeight()-d);
	}
	
	public void placeBelow(Sprite that, int d){
		this.setLocation(this.getX(), that.getY()+that.getHeight()+d);
	}
	
	public void placeLeftOf(Sprite that, int d){
		this.setLocation(that.getX()-this.getWidth()-d, this.getY());
	}
	
	public void placeRightOf(Sprite that, int d){
		this.setLocation(that.getX()+that.getWidth()+d, this.getY());
	}
	
	public boolean isAbove(Sprite that){
		return (this.getY()+this.getHeight() < that.getY()+that.getHeight()/2);
	}
	
	public boolean isBelow(Sprite that){
		return that.isAbove(this);
	}
	
	public boolean isLeftTo(Sprite that){
		return (this.getX()+this.getWidth() < that.getX()+that.getWidth()/2);
	}
	
	public boolean isRightTo(Sprite that){
		return that.isLeftTo(this);
	}
	
	public boolean has(Sprite that){
		Point top_left     = that.getLocation(),
		      top_right    = new Point(that.getX()+that.getWidth(), that.getY()),
		      bottom_left  = new Point(that.getX(), that.getY()+that.getHeight()),
		      bottom_right = new Point(that.getX()+that.getWidth(), that.getY()+that.getHeight());
		
		return this.has(top_left)
			|| this.has(top_right)
			|| this.has(bottom_left)
			|| this.has(bottom_right);
	}

	private boolean has(Point p) {
		int x = p.x,
			y = p.y;
		
		return (x>=getX() && x<=getX()+getWidth() && y>=getY() && y<=getY()+getHeight());
	}
	

	public void update(){}
}