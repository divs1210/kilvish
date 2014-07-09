/*
 * This work is licensed under the Creative Commons Attribution-ShareAlike 3.0 Unported License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send 
 * a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041, USA.
 */

package com.kilvish.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kilvish.core.Actor;
import com.kilvish.core.Sprite;
import com.kilvish.media.ImageControl;
import com.kilvish.util.Logger;
import com.kilvish.util.MediaLoader;

/**
 * A container to which Sprites can be added to make a game. 
 * This is the de-facto game container.
 * Extend to write your own game.
 * 
 * @author Divyansh Prakash
 */
public class GamePane extends JPanel {
	private static boolean[] keys = new boolean[300];
	private boolean paused=true;
	private long delay=0;
	
	private Thread gameThread = new Thread(){
		public void run(){
			for(Component c:GamePane.this.getComponents())
				if(c instanceof Sprite)
					c.setVisible(true);
			
			long t_beg=new Date().getTime(), t_end;
			while(true){
				t_beg = new Date().getTime();
				if(!paused){
					for(Component c:GamePane.this.getComponents()){
						if(c instanceof Sprite){
							Sprite s = (Sprite)c;
							if(s.imgChanged){
								s.setIcon(s.getCurrentImage());
								s.setSize(s.getCurrentImage().getIconWidth(), 
										  s.getCurrentImage().getIconHeight());
								s.repaint();
							}
							s.update();
							s.advanceOneFrame();
						}
					}
					repaint();
					update();
				}
				t_end = new Date().getTime();
				try {
					long t=delay-(t_end-t_beg);
					sleep(t<0?0:t);
				} catch(Exception e){}
			}
		}
	};
	
	/**
	 * Creates a new GamePane with the given
	 * width and height.
	 */
	public GamePane(int width, int height){
		super(true);
		
		setSize(width, height);
		setLayout(null);
		setBackground(Color.WHITE);
		
		setFocusable(true);
		addKeyListener(new KA());
		
		setFPS(30);
	}
	
	private void showSplashScreen() {
		Color bg = this.getBackground();
		this.setBackground(Color.WHITE);
		
	    int scr_w = getWidth(),
			scr_h = getHeight();
		
	    BufferedImage sp = MediaLoader.getBufferedImage("media/engine/sp.lp");
		ImageIcon img = new ImageIcon( ImageControl.scaleToFit(sp, scr_w, scr_h) );
	    
		int img_w = img.getIconWidth(),
			img_h = img.getIconHeight();
		
	    JLabel splash=new JLabel(img);
		splash.setSize(img_w, img_h);
		splash.setLocation((scr_w-img_w)/2, (scr_h-img_h)/2);
		add(splash);
		repaint();
		try {
			Thread.sleep(2000);
		} catch (Exception e) {}
		splash.setVisible(false);
		remove(splash);
		this.setBackground(bg);
		
		repaint();
	}

	/**
	 * Pause/Unpause this game.
	 */
	public void pause(boolean paused){
		this.paused=paused;
	}
	
	/**
	 * Start this game.
	 * Use pause(false) to unpause a game.
	 */
	public void play(){
		if(!gameThread.isAlive()){
			this.paused=false;
			showSplashScreen();
			gameThread.start();
		}else Logger.log(new Exception("Trying to start a started game!"));
	}
	
	/**
	 * Tests if this game is paused.
	 */
	public boolean isPaused(){
		return paused;
	}
	
	/**
	 * Shifts all the Sprites on-screen
	 * by the given pixels.
	 */
	public void shiftScreenBy(int x, int y){
		for(Component c : this.getComponents())
			if(c instanceof Sprite){
				Sprite s = (Sprite)c;
				s.moveBy(x, y);
			}
	}
	
	/**
	 * Method to check if a key is pressed.
	 * Takes the KeyEvent.keyCode as input parameter.
	 */
	public static boolean isKeyDown(int key){
		return keys[key];
	}
	
	/**
	 * This method is called again and again by the system.
	 * Override to implement functionality.
	 */
	public void update(){
	}
	
	/**
	 * Will make the engine update the game fps times every second.
	 * Not exact.
	 * FPS=Frames per second
	 */
	public void setFPS(int fps){
		delay = 1000/fps;
	}
	
	/**
	 * Returns the frame-rate of the game.
	 */
	public int getFPS(){
		return (int)(1000/delay);
	}
	
	@Override
	public Dimension getPreferredSize(){
		return this.getSize();
	}
	
	class KA extends KeyAdapter{
		public void keyPressed(KeyEvent e){
			keys[e.getKeyCode()] = true;
		}
		
		public void keyTyped(KeyEvent e){
			keys[e.getKeyCode()] = true;
		}
		
		public void keyReleased(KeyEvent e){
			keys[e.getKeyCode()] = false;
		}
	}
	
}
