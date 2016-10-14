package com.nthread.outthere.projecteuler;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Each character on a computer is assigned a unique code and the preferred standard is ASCII 
 * (American Standard Code for Information Interchange). For example, uppercase A = 65, asterisk 
 * (*) = 42, and lowercase k = 107.
 * 
 * A modern encryption method is to take a text file, convert the bytes to ASCII, then XOR each 
 * byte with a given value, taken from a secret key. The advantage with the XOR function is that 
 * using the same encryption key on the cipher text, restores the plain text; for example, 
 * 65 XOR 42 = 107, then 107 XOR 42 = 65.
 * 
 * For unbreakable encryption, the key is the same length as the plain text message, and the key 
 * is made up of random bytes. The user would keep the encrypted message and the encryption key 
 * in different locations, and without both "halves", it is impossible to decrypt the message.
 * 
 * Unfortunately, this method is impractical for most users, so the modified method is to use a 
 * password as a key. If the password is shorter than the message, which is likely, the key is 
 * repeated cyclically throughout the message. The balance for this method is using a sufficiently 
 * long password key for security, but short enough to be memorable.
 * 
 * Your task has been made easy, as the encryption key consists of three lower case characters. 
 * Using cipher.txt (right click and 'Save Link/Target As...'), a file containing the encrypted 
 * ASCII codes, and the knowledge that the plain text must contain common English words, decrypt the 
 * message and find the sum of the ASCII values in the original text.

 * @author stephenbrown
 *
 */
public class Problem59 {

	public static void main(String[] args) throws IOException {
		String line1 = Files.readAllLines(Paths.get("/Users/stephenbrown/code/outthere/src/main/java/com/nthread/outthere/projecteuler/cipher.txt"), Charset.defaultCharset()).get(0);
		System.out.println(line1);
		String[] asciii = line1.split(",");
		byte first = Byte.MIN_VALUE;
		for (byte b = 0; b <= (Byte.MAX_VALUE - 3); b++ ) {
			boolean allGood = true;
			for ( int i = 0; i < asciii.length; i += 3 ) {
				if ( ! isGood(Byte.parseByte(asciii[i]) ^ b) ) {
					allGood = false;
					System.out.println("b <" + b + ", " + i + "> failed on " + asciii[i] + "==>" + 
							(Byte.parseByte(asciii[i]) ^ b));
					break;
				}
			}
			if ( allGood ) { 
				System.out.println("b was good: " + b);
			}
		}
	}
	
	public static boolean isGood(int num) { 
		return num == 32 || num == 33 || num == 34 || num == 63 || 
				(num >= 65 && num <= 90) ||
				(num >= 97 && num <= 122);
	}

}
