package retos.java1.bitset;

import java.io.*;
import java.util.*;

public class Solution {
	/*
	 * https://www.hackerrank.com/challenges/java-bitset/problem TASK: create a
	 * class to perform a series of operations on bitSet vectors. After each
	 * operation, print the number of set bits in the respective BitSets as two
	 * space-separated integers on a new line.
	 */

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		BitSetOperator operator = new BitSetOperator();

		// Use N to define the size of BitSets and instance them
		int bitSetSize = scan.nextInt();
		operator.setB1(new BitSet(bitSetSize));
		operator.setB2(new BitSet(bitSetSize));

		// Use M to declare the cycle of operations
		int numberOfOperations = scan.nextInt();

		for (int i = 0; i < numberOfOperations; i++) {
			// a and b are the arguments of operate method, which could mean
			// any of the BitSets or an index
			String operation = scan.next();
			int a = scan.nextInt();
			int b = scan.nextInt();

			operator.operate(operation, a, b);
		}

		scan.close();

	}
}

class BitSetOperator {
	// To reference the B1 and B2 BitSets
	private BitSet b1, b2;

	// Method to translate the operations required by the input
	public void operate(String operation, int a, int b) {
		// reference the first BitSet, which take the changes
		BitSet first = a == 1 ? b1 : b2;
		switch (operation) {
		case "AND":
			BitSet andSecond = b == 1 ? b1 : b2;
			first.and(andSecond);
			break;
		case "OR":
			BitSet orSecond = b == 1 ? b1 : b2;
			first.or(orSecond);
			break;
		case "XOR":
			BitSet xorSecond = b == 1 ? b1 : b2;
			first.xor(xorSecond);
			break;
		case "FLIP":
			int flipIndex = b;
			first.flip(flipIndex);
			break;
		case "SET":
			int setIndex = b;
			first.set(setIndex);
			break;
		default:
			break;
		}
		System.out.println(b1.cardinality() + " " + b2.cardinality());
	}

	public void setB1(BitSet b1) {
		this.b1 = b1;
	}

	public void setB2(BitSet b2) {
		this.b2 = b2;
	}

}