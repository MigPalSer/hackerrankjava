package retos.java1.stack;

import java.util.*;

/*https://www.hackerrank.com/challenges/java-stack/problem
 *TASK: Output true if a String is "balanced" or false if it's not.
 *A string containing only parentheses is balanced if the following 
 *is true: 1. if it is an empty string 2. if A and B are correct, 
 *AB is correct, 3. if A is correct, (A) and {A} and [A] are also correct.
 * */

class Solution {

	static Stack<Character> stack = new Stack<Character>();

	public static void main(String[] argh) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			String input = sc.next();
			boolean balanced = true;
			char[] charArray = input.toCharArray();
			for (int i = 0; i < charArray.length; i++) {
				if (charArray[i] == '(' || charArray[i] == '[' || charArray[i] == '{') {
					stack.push(charArray[i]);
				} else {
					if (!isOpositeParentheses(charArray[i])) {
						balanced = false;
					}
				}
			}
			System.out.println(balanced && stack.empty());
			stack.clear();
		}

	}

	static boolean isOpositeParentheses(char ch) {
		Character oposite = ' ';
		switch (ch) {
		case ')':
			oposite = '(';
			break;
		case ']':
			oposite = '[';
			break;
		case '}':
			oposite = '{';
			break;
		default:
			break;
		}

		if (!stack.empty()) {
			return oposite.equals(stack.pop());
		} else {
			return false;
		}
	}
}
