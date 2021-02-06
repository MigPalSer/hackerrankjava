package retos.java1.list;

import java.util.*;

/*https://www.hackerrank.com/challenges/java-list/problem
 *TASK: Follow a pack of instructions to add or delete elements on a list and
 *at the end print the updated list.
 * */

class Solution {

	public static void main(String[] args) {
		Scanner miscan = new Scanner(System.in);
		ArrayList<Integer> lista = new ArrayList<Integer>();
		int initialSize = miscan.nextInt();
		for (int i = 0; i < initialSize; i++) {
			lista.add(miscan.nextInt());
		}

		int numberInstructions = miscan.nextInt();

		for (int i = 0; i < numberInstructions; i++) {
			String instruction = miscan.next();
			if (instruction.equals("Insert")) {
				lista.add(miscan.nextInt(), miscan.nextInt());
			} else {
				lista.remove(miscan.nextInt());
			}
		}

		for (Integer integer : lista) {
			System.out.print(integer + " ");
		}

		miscan.close();

	}

}
