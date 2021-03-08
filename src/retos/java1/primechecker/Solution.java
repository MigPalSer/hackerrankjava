package retos.java1.primechecker;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.lang.reflect.*;

import static java.lang.System.in;

/*https://www.hackerrank.com/challenges/prime-checker/problem
 *TASK: Create a class which check if inputs are prime numbers and, if they are,
 *print them.
 * */

class Prime {

	Prime() {

	}

	public void checkPrime(int... inputs) {
		for (int in : inputs) {
			boolean prime = true;
			for (int i = in - 1; i > 1; i--) {
				if (in % i == 0)
					prime = false;
			}
			if (in == 1)
				prime = false;
			if (prime) {
				System.out.print(in + " ");
			}
		}
		System.out.println("");
	}

}

public class Solution {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			int n1 = Integer.parseInt(br.readLine());
			int n2 = Integer.parseInt(br.readLine());
			int n3 = Integer.parseInt(br.readLine());
			int n4 = Integer.parseInt(br.readLine());
			int n5 = Integer.parseInt(br.readLine());
			Prime ob = new Prime();
			ob.checkPrime(n1);
			ob.checkPrime(n1, n2);
			ob.checkPrime(n1, n2, n3);
			ob.checkPrime(n1, n2, n3, n4, n5);
			Method[] methods = Prime.class.getDeclaredMethods();
			Set<String> set = new HashSet<>();
			boolean overload = false;
			for (int i = 0; i < methods.length; i++) {
				if (set.contains(methods[i].getName())) {
					overload = true;
					break;
				}
				set.add(methods[i].getName());

			}
			if (overload) {
				throw new Exception("Overloading not allowed");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
