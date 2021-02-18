package retos.java1.hashset;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*https://www.hackerrank.com/challenges/java-hashset/problem
 * INPUT: In the first line, there will be an integer denoting number of pairs. 
 * Each of the next lines will contain two strings seperated by a single space.
 * OUTPUT: Print lines. In the i line, print number of unique pairs you have after 
 * i taking pair as input.*/

public class Solution {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		String[] pair_left = new String[t];
		String[] pair_right = new String[t];

		for (int i = 0; i < t; i++) {
			pair_left[i] = s.next();
			pair_right[i] = s.next();
		}

		class Pair {
			private String left, right;

			public Pair(String left, String right) {
				super();
				this.left = left;
				this.right = right;
			}

			@Override
			public int hashCode() {
				final int prime = 31;
				int result = 1;
				result = prime * result + ((left == null) ? 0 : left.hashCode());
				result = prime * result + ((right == null) ? 0 : right.hashCode());
				return result;
			}

			public boolean equals(Object obj) {
				if (this == obj)
					return true;
				if (obj == null)
					return false;
				if (getClass() != obj.getClass())
					return false;
				Pair other = (Pair) obj;
				if (left == null) {
					if (other.left != null)
						return false;
				} else if (!left.equals(other.left))
					return false;
				if (right == null) {
					if (other.right != null)
						return false;
				} else if (!right.equals(other.right))
					return false;
				return true;
			}

		}

		HashSet<Pair> pairsset = new HashSet<Pair>();

		int uniquepairs = 0;

		for (int i = 0; i < t; i++) {
			Pair pair = new Pair(pair_left[i], pair_right[i]);
			if (!pairsset.contains(pair)) {
				pairsset.add(pair);
				uniquepairs++;
			}
			System.out.println(uniquepairs);
		}
	}
}