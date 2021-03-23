package retos.java1.exceptionhandling;

import java.util.Scanner;

/*https://www.hackerrank.com/challenges/java-exception-handling/problem
 *TASK: create a method to power two integers but throw exceptions if one of
 *them are negative or if borh are 0.
 * */

class MyCalculator {

	long power(int a, int b) throws Exception {
		if (a < 0 || b < 0) {
			throw new Exception("n or p should not be negative.");
		} else if (b == 0) {
			if (a == 0) {
				throw new Exception("n and p should not be zero.");
			} else {
				return 1;
			}
		} else {
			long base = a;
			for (int i = 1; i < b; i++) {
				base *= a;
			}
			return base;
		}
	}

}

public class Solution {
	public static final MyCalculator my_calculator = new MyCalculator();
	public static final Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		while (in.hasNextInt()) {
			int n = in.nextInt();
			int p = in.nextInt();

			try {
				System.out.println(my_calculator.power(n, p));
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
}