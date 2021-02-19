package retos.mathematics.armygame;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

/*https://www.hackerrank.com/challenges/game-with-cells/problem
 *Luke is daydreaming in Math class. He has a sheet of graph paper with rows and 
 *columns, and he imagines that there is an army base in each cell. He wants to 
 *drop supplies at strategic points on the sheet, marking each drop point with a 
 *red dot. If a base contains at least one package inside or on top of its border 
 *fence, then it's considered to be supplied. Given rows and columns, what's the 
 *minimum number of packages that Luke must drop to supply all of his bases?  
 * */

public class Solution {

	static int gameWithCells(int n, int m) {

		int rowsquares = n / 2;
		int columnsquares = m / 2;
		if (n % 2 != 0) {
			rowsquares++;
		}
		if (m % 2 != 0) {
			columnsquares++;
		}
		return rowsquares * columnsquares;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String[] nm = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nm[0].trim());

		int m = Integer.parseInt(nm[1].trim());

		int result = gameWithCells(n, m);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();
	}
}
