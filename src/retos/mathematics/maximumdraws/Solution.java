package retos.mathematics.maximumdraws;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

/*https://www.hackerrank.com/challenges/maximum-draws/problem
 *TASK: create the maximumDraws method for calculate the minimum number of 
 *socks removed in a drawer with n pairs for obtain a matching pair */

public class Solution {

	static int maximumDraws(int n) {
		return n + 1;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int t = Integer.parseInt(scanner.nextLine().trim());

		for (int tItr = 0; tItr < t; tItr++) {
			int n = Integer.parseInt(scanner.nextLine().trim());

			int result = maximumDraws(n);

			bufferedWriter.write(String.valueOf(result));
			bufferedWriter.newLine();
		}

		bufferedWriter.close();
	}
}
