package no.hvl.dat110.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash { 
	
	
	public static BigInteger hashOf(String entity) {	
		
		BigInteger hashint = null;
		
		// Task: Hash a given string using MD5 and return the result as a BigInteger.
		
		// we use MD5 with 128 bits digest
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			
		// compute the hash of the input 'entity'
			byte[] digest = md.digest(entity.getBytes());
		
		// convert the hash into hex format
			String hexString = toHex(digest);
		
		// convert the hex into BigInteger
			hashint = new BigInteger(hexString, 16);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		// return the BigInteger
		
		return hashint;
	}
	
	public static BigInteger addressSize() {
		
		// Task: compute the address size of MD5
	
		
		// compute the number of bits = bitSize()
		int numBits = bitSize();
		
		// compute the address size = 2 ^ number of bits
		BigInteger adressSize = BigInteger.TWO.pow(numBits);
		
		// return the address size
		
		return adressSize;
	}
	
	public static int bitSize() {
		
		int digestlen = 16;
		
		// find the digest length
		
		return digestlen*8;
	}
	
	public static String toHex(byte[] digest) {
		StringBuilder strbuilder = new StringBuilder();
		for(byte b : digest) {
			strbuilder.append(String.format("%02x", b&0xff));
		}
		return strbuilder.toString();
	}

}
