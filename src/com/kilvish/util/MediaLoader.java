/*
 * This work is licensed under the Creative Commons Attribution-ShareAlike 3.0 Unported License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send 
 * a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041, USA.
 */

package com.kilvish.util;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;


/**
 * @author Divyansh Prakash
 */
public class MediaLoader {

	/**
	 * Converts the given system path to a URL
	 */
	public static URL getURL(String path){
		return MediaLoader.class.getClassLoader().getResource(path);
	}
	
	/**
	 * Returns an AudioClip object instance
	 * from the given .wav/.au file.
	 */
	public static AudioClip getSound(String path) {
		return getSound(getURL(path));
	}
	
	/**
	 * Returns an AudioClip object instance
	 * from the given .wav/.au file.
	 */
	public static AudioClip getSound(URL url) {
		AudioClip c = null;
    	
    	try {
			c = Applet.newAudioClip(url);
		} catch (Exception e) {
			e.printStackTrace();
			Logger.log(e);
		}
    	
    	return c;
    }
	
	/**
	 * Returns an ImageIcon object instance
	 * from the given image file.
	 */
	public static ImageIcon getImageIcon(String path) {
		return getImageIcon(getURL(path));
	}
	
	/**
	 * Returns an ImageIcon object instance
	 * from the given image file.
	 */
	public static ImageIcon getImageIcon(URL url) {
		return new ImageIcon(url);
    }
	
	/**
	 * Returns a BufferedImage object instance
	 * from the given image file.
	 */
	public static BufferedImage getBufferedImage(String path) {
		return getBufferedImage(getURL(path));
	}
	
	/**
	 * Returns a BufferedImage object instance
	 * from the given image file.
	 */
	public static BufferedImage getBufferedImage(URL url) {
		BufferedImage img = null;
    	
    	try {
			img = ImageIO.read(url);
		} catch (Exception e) {
			e.printStackTrace();
			Logger.log(e);
		}
    	
    	return img;
    }
	
}