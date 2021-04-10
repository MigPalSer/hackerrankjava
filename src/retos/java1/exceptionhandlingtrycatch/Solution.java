package retos.java1.exceptionhandlingtrycatch;

import java.util.InputMismatchException;
import java.util.Scanner;

/*https://www.hackerrank.com/challenges/java-exception-handling-try-catch/problem
 *TASK: compute, for integers, a method for x/y, throwing exceptions if the arguments
 *are not integers or if y is a zero.  
 * */

class MyCalculator {

	public int division(String x, String y) throws InputMismatchException, ArithmeticException {
		int a = 0;
		int b = 0;
		try {
			a = Integer.parseInt(x);
			b = Integer.parseInt(y);
		} catch (Exception e) {
			throw new InputMismatchException();
		}

		if (b == 0) {
			throw new ArithmeticException("/ by zero");
		} else {
			return a / b;
		}
	}

}

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		MyCalculator my_calculator = new MyCalculator();

		String x = in.nextLine();
		String y = in.nextLine();

		try {
			System.out.println(my_calculator.division(x, y));
		} catch (Exception e) {
			System.out.println(e);
		}

		in.close();
	}
}