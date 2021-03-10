package retos.java1.factory;

import java.util.*;

/*https://www.hackerrank.com/challenges/java-interface/problem
 *TASK: You are given an interface AdvancedArithmetic which contains a method 
 *signature int divisor_sum(int n). You need to write a class called MyCalculator 
 *which implements the interface. divisorSum function just takes an integer as 
 *input and return the sum of all its divisors. 
 * */

interface AdvancedArithmetic {
	int divisor_sum(int n);
}

class MyCalculator implements AdvancedArithmetic {

	@Override
	public int divisor_sum(int n) {
		int divisorsum = 0;
		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				divisorsum += i;
			}
		}
		return divisorsum;
	}

}

class Solution {
	public static void main(String[] args) {
		MyCalculator my_calculator = new MyCalculator();
		System.out.print("I implemented: ");
		ImplementedInterfaceNames(my_calculator);
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.print(my_calculator.divisor_sum(n) + "\n");
		sc.close();
	}

	/*
	 * ImplementedInterfaceNames method takes an object and prints the name of the
	 * interfaces it implemented
	 */
	static void ImplementedInterfaceNames(Object o) {
		Class[] theInterfaces = o.getClass().getInterfaces();
		for (int i = 0; i < theInterfaces.length; i++) {
			String interfaceName = theInterfaces[i].getName();
			System.out.println(interfaceName);
		}
	}
}
