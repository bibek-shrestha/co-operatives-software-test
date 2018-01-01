package com.kjjcsoft.model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptorClass {
	public static String encrypt(String value) throws NoSuchAlgorithmException{
		MessageDigest md= MessageDigest.getInstance("MD5");
		md.update(value.getBytes());
		byte[] digestedbyte = md.digest();
		StringBuffer sb= new StringBuffer();
		for (byte b : digestedbyte) {
			sb.append(Integer.toString((b & 0xff) + 0x100,16).substring(1));
		}
		return sb.toString();		
	}

}
