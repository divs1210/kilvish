/*
 * This work is licensed under the Creative Commons Attribution-ShareAlike 3.0 Unported License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send 
 * a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041, USA.
 */

package com.kilvish.media;

import java.awt.image.BufferedImage;

import org.imgscalr.Scalr;

/**
 * Provides static methods for Image manipulation.
 * 
 * @author Divyansh Prakash
 */
public class ImageControl
{
	public static BufferedImage scaleWidthTo(BufferedImage orig, int w){
		return Scalr.resize(orig, w, (w/orig.getWidth())*orig.getHeight());
	}
	
	public static BufferedImage scaleHeightTo(BufferedImage orig, int h){
		return Scalr.resize(orig, (h/orig.getHeight())*orig.getWidth(), h);
	}
	
	public static BufferedImage scaleToFit(BufferedImage orig, int w, int h){
		BufferedImage n_img=orig;
		if(orig.getWidth()>w)
			n_img = scaleWidthTo(orig, w);
		if(n_img.getHeight()>h)
			n_img = scaleHeightTo(n_img, h);
		return n_img;
	}
}
