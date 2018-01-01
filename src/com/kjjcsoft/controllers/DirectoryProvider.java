/**
 * 
 */
package com.kjjcsoft.controllers;

/**
 * @author Seekraw
 *
 */
public interface DirectoryProvider {
//	this is for the photograph upload of the customer
	String PHOTO_UPLOAD_DIRECTORY="customer_photos/";
//	this is for the finger print upload of the customer
	String FINGER_PRINT_UPLOAD_DIRECTORY="customer_finger_prints/";
//	this is the temporary folder location for storing the files above threshold memory
	String TMP="tmp/";
//	defining the threshhold memory
	int MEMORY_THRESHOLD = 1024*1024*3 ;
	int  MAX_FILE_SIZE = 1024*1024*40;
	int MAX_REQUEST_SIZE = 1024*1024*50;
}
