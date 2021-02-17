package retos.mathematics.connectingtowns;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

/*https://www.hackerrank.com/challenges/connecting-towns/problem
 * TASK: Complete the connectingTowns function below for find the number of paths 
 * between cities while apply a modulo 1234567 (very weird challenge, I late to understand
 * what they demand) see the link for more details.
 */

public class Solution {

	static int connectingTowns(int n, int[] routes) {
		int paths = 1;
		for (int i = 0; i < routes.length; i++) {
			paths *= routes[i];
			paths %= 1234567;
		}
		return paths;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int t = Integer.parseInt(scanner.nextLine().trim());

		for (int tItr = 0; tItr < t; tItr++) {
			int n = Integer.parseInt(scanner.nextLine().trim());

			int[] routes = new int[n - 1];

			String[] routesItems = scanner.nextLine().split(" ");

			for (int routesItr = 0; routesItr < n - 1; routesItr++) {
				int routesItem = Integer.parseInt(routesItems[routesItr].trim());
				routes[routesItr] = routesItem;
			}

			int result = connectingTowns(n, routes);

			bufferedWriter.write(String.valueOf(result));
			bufferedWriter.newLine();
		}

		bufferedWriter.close();
	}
}
