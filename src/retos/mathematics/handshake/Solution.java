package retos.mathematics.handshake;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

/*https://www.hackerrank.com/challenges/handshake/problem
 * TASK: At the annual meeting of Board of Directors of Acme Inc. If everyone 
 * attending shakes hands exactly one time with every other attendee, how 
 * many handshakes are there?
 */

public class Solution {

	static int handshake(int n) {
		int total = 0;

		for (int i = n; i > 1; i--) {
			total += (i - 1);
		}

		return total;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int t = Integer.parseInt(scanner.nextLine().trim());

		for (int tItr = 0; tItr < t; tItr++) {
			int n = Integer.parseInt(scanner.nextLine().trim());

			int result = handshake(n);

			bufferedWriter.write(String.valueOf(result));
			bufferedWriter.newLine();
		}

		bufferedWriter.close();
	}
}
