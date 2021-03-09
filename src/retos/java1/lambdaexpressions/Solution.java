package retos.java1.lambdaexpressions;

import java.io.*;
import java.util.*;

/*https://www.hackerrank.com/challenges/java-lambda-expressions/problem
 *TASK: Complete MyMath class with lambda expression to define the PerformOperation
 *interface for different purposes */

interface PerformOperation {
	boolean check(int a);
}

class MyMath {
	public static boolean checker(PerformOperation p, int num) {
		return p.check(num);
	}

	public PerformOperation isOdd() {
		PerformOperation po = (a) -> (a % 2) != 0;
		return po;
	}

	public PerformOperation isPrime() {
		PerformOperation po = (a) -> {
			if (a == 2) {
				return true;
			} else if (a <= 1) {
				return false;
			} else if ((a % 2) == 0) {
				return false;
			} else {
				boolean prime = true;
				for (int i = a - 1; i > 1; i -= 2) {
					if (a % i == 0)
						prime = false;
				}
				return prime;
			}
		};
		return po;
	}

	public PerformOperation isPalindrome() {
		PerformOperation po = (a) -> {
			String direct = Integer.valueOf(a).toString();
			boolean palindrome = true;
			for (int i = 0; i < direct.length(); i++) {
				if (direct.charAt(i) != direct.charAt(direct.length() - i - 1)) {
					palindrome = false;
				}
			}
			return palindrome;
		};
		return po;
	}

}

public class Solution {

	public static void main(String[] args) throws IOException {
		MyMath ob = new MyMath();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		PerformOperation op;
		boolean ret = false;
		String ans = null;
		while (T-- > 0) {
			String s = br.readLine().trim();
			StringTokenizer st = new StringTokenizer(s);
			int ch = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			if (ch == 1) {
				op = ob.isOdd();
				ret = ob.checker(op, num);
				ans = (ret) ? "ODD" : "EVEN";
			} else if (ch == 2) {
				op = ob.isPrime();
				ret = ob.checker(op, num);
				ans = (ret) ? "PRIME" : "COMPOSITE";
			} else if (ch == 3) {
				op = ob.isPalindrome();
				ret = ob.checker(op, num);
				ans = (ret) ? "PALINDROME" : "NOT PALINDROME";

			}
			System.out.println(ans);
		}
	}
}
