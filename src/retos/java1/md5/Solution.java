package retos.java1.md5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/*https://www.hackerrank.com/challenges/java-md5/problem
*TASK: Create an MD5 implementation for hash one password and print in hexadecimal
*/
public class Solution {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		String input = scan.nextLine();

		try {
			printHexadecimal(md5(input));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		scan.close();
	}

	static byte[] md5(String password) throws NoSuchAlgorithmException {
		MessageDigest hasher = MessageDigest.getInstance("MD5");
		byte[] hashbytes = hasher.digest(password.getBytes());
		return hashbytes;
	}

	static void printHexadecimal(byte[] hash) {
		for (byte bt : hash) {
			System.out.printf("%02x", bt);
		}
	}

}