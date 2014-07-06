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
import java.util.Date;

/**
 * Provides an error-logging facility.
 * 
 * @author Divyansh Prakash
 */
public class Logger {
	
	/**
	 * Writes the error details into the kilvish.log file,
	 * and prints the stack trace if not suppressed.
	 */
	public static void log(final Exception e, boolean suppress){
		if(!suppress)
			e.printStackTrace();
		
		//write concurrently to file.
		new Thread(){
			public void run(){
				BufferedWriter bw = null;
				try {
					bw = new BufferedWriter(new FileWriter("kilvish.log", true));
					
					bw.write(new Date()+": "+e+"\n");
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
		}.start();
	}
	
	/**
	 * Writes the error details into the kilvish.log file,
	 * and prints the stack trace.
	 */
	public static void log(final Exception e){
		log(e, false);
	}
	
	/**
	 * Writes the error details into the kilvish.log file,
	 * and prints the stack trace if not suppressed.
	 */
	public static void log(final String s, boolean suppress){
		if(!suppress)
			System.out.println(s);
		
		//write concurrently to file.
		new Thread(){
			public void run(){
				BufferedWriter bw = null;
				try {
					bw = new BufferedWriter(new FileWriter("kilvish.log", true));
					
					bw.write(new Date()+": "+s+"\n");
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
		}.start();
	}
	
	/**
	 * Writes the error details into the kilvish.log file,
	 * and prints the stack trace.
	 */
	public static void log(final String s){
		log(s, false);
	}

}