package retos.java1.covarianttypes;

import java.util.*;

/*https://www.hackerrank.com/challenges/java-1d-array-introduction/problem
*INPUT: The first line contains a single integer denoting the size of the array.
Each line of the subsequent lines contains a single integer denoting the value of
an element.
*OUTPUT: Prints each sequential element on a new line.
*/
public class Solution {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scan.nextInt();
		}

		scan.close();

		// Prints each sequential element in array a
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}