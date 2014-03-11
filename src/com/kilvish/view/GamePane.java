/*
 * This work is licensed under the Creative Commons Attribution-ShareAlike 3.0 Unported License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send 
 * a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041, USA.
 */

package com.kilvish.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kilvish.core.Sprite;
import com.kilvish.media.ImageControl;
import com.kilvish.media.MediaLoader;

/**
 * A container to which Sprites can be added to make a game.
 * 
 * @author Divyansh Prakash
 */
public class GamePane extends JPanel {
	private static boolean[] keys = new boolean[300];
	private boolean paused=true;
	private long delay=50;
	
	private Thread gameThread = new Thread(){
		public void run(){
			long t_prev=new Date().getTime(), t_curr;
			while(true){
				t_curr = new Date().getTime(); 
				if(!paused){
					for(Component c:GamePane.this.getComponents()){
						if(c instanceof Sprite){
							Sprite s = (Sprite)c;
							s.setIcon(s.getCurrentImage());
							s.setSize(s.getCurrentImage().getIconWidth(), s.getCurrentImage().getIconHeight());
							s.repaint();
							s.update();
							s.advanceOneFrame();
						}
					}
					repaint();
					update();
				}
				try {
					sleep(delay-(t_curr-t_prev));
				} catch (Exception e) {}
				t_prev = t_curr;
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
	}
	
	private void showSplashScreen() {
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
		repaint();
	}

	public void pause(boolean state){
		paused=state;
	}
	
	public void play(){
		paused=false;
		showSplashScreen();
		gameThread.start();
	}
	
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
	
	public void setFPS(int frames){
		delay = 1000/frames;
	}
	
	public int getFPS(){
		return (int)(1000/delay);
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
