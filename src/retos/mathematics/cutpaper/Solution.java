package retos.mathematics.cutpaper;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/*https://www.hackerrank.com/challenges/p1-paper-cutting/problem
 *TASK: Given a nxm paper, find and print the minimum number of cuts Mary 
 *must make to cut the paper into squares of 1x1 without fold the paper or 
 *layer already-cut pieces on top of one another. .  
 * */

public class Solution {

	static long solve(int n, int m) {
		long a = n;
		long b = m;
		long c = a * b;
		c--;
		return c;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String[] nm = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nm[0]);

		int m = Integer.parseInt(nm[1]);

		long result = solve(n, m);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
