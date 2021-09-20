package retos.interview.sherlockanagrams;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/*https://www.hackerrank.com/challenges/2d-array/
 * Same code I used in the java 2d array challenge
 * INPUT:There will be exactly 6 lines, each containing integers 
 * separated by spaces. Each integer will be between 9 and -9 inclusive.
 * OUTPUT: Print the largest sum among all "hourglasses" of the array (see web 
 * description).
 * */

public class Solution {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int[][] arr = new int[6][6];

		for (int i = 0; i < 6; i++) {
			String[] arrRowItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int j = 0; j < 6; j++) {
				int arrItem = Integer.parseInt(arrRowItems[j]);
				arr[i][j] = arrItem;
			}
		}

		// Need to be change for different size of array
		int maxSum = sumHourglass(0, 0, arr);

		for (int x = 0; x < 4; x++) {
			for (int y = 0; y < 4; y++) {
				int sum = sumHourglass(x, y, arr);
				maxSum = sum > maxSum ? sum : maxSum;
			}
		}

		System.out.println(maxSum);

		scanner.close();
	}

	/*
	 * Sum all element of a "hourglass" which superior left element is the [x][y] Be
	 * careful with arguments, in 6x6 matrix the maximum x and y is 3
	 */
	private static int sumHourglass(int x, int y, int[][] arr) throws ArrayIndexOutOfBoundsException {
		int sum = arr[x][y] + arr[x][y + 1] + arr[x][y + 2] + arr[x + 1][y + 1] + arr[x + 2][y] + arr[x + 2][y + 1]
				+ arr[x + 2][y + 2];
		return sum;
	}
}
