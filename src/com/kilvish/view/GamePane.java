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

import javax.swing.JPanel;

import com.kilvish.core.Sprite;

/**
 * A Window to which Sprites can be added to make a game.
 * 
 * @author Divyansh Prakash
 */
public class GamePane extends JPanel {
	private static boolean[] keys = new boolean[300];
	private boolean paused=true;
	private long delay=50;
	
	private Thread gameThread = new Thread(){
		public void run(){
			while(true){
				if(!paused){
					for(Component c:GamePane.this.getComponents()){
						if(c instanceof Sprite){
							Sprite s = (Sprite)c;
							s.setIcon(s.getCurrentImage());
							s.setSize(s.getCurrentImage().getIconWidth(), s.getCurrentImage().getIconHeight());
							s.repaint();
							s.advanceOneFrame();
						}
					}
					repaint();
				}
				try {
					sleep(delay);
				} catch (Exception e) {}
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
		
		gameThread.start();
	}
	
	public void pause(){
		paused=true;
	}
	
	public void play(){
		paused=false;
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
