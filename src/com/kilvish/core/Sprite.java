/*
 * This work is licensed under the Creative Commons Attribution-ShareAlike 3.0 Unported License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send 
 * a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041, USA.
 */

package com.kilvish.core;

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
	
	String name;
	
	ArrayList<SpriteImage> simgs;
	
	public Sprite(String name){
		currImg=0;
		framesPassed=0;
		
		this.name = name;
		this.simgs = new ArrayList();
	}
	
	public void addImage(ImageIcon img, int frames){
		this.addSpriteImage(new SpriteImage(img, frames));
	}
	
	public void addSpriteImage(SpriteImage simg){
		simgs.add(simg);
		if(currImg==0)
			this.setIcon(simg.img);
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setCurrentIndex(int i){
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
		}else{
			framesPassed++;
		}
	}
	
	public void update(){
	}
}