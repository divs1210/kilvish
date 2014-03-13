/*
 * This work is licensed under the Creative Commons Attribution-ShareAlike 3.0 Unported License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send 
 * a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041, USA.
 */

package com.kilvish.util;

import java.io.BufferedWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Provides an error-logging facility.
 * 
 * @author Divyansh Prakash
 */
public class Logger {
	
	/**
	 * Writes the error details into the util/log.txt file
	 */
	public static void log(Exception e){
		e.printStackTrace();
		
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(".log", true));
			
			bw.write(e+"\n");
			bw.write("\n");
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally{
			if(bw!=null)
				try {
					bw.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
		}
	}

}