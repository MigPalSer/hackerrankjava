package retos.java1.map;

import java.util.*;
import java.io.*;

/*https://www.hackerrank.com/challenges/phone-book/problem
 * TASK: You are given a phone book that consists of people's 
 * names and their phone number. After that you will be given some 
 * person's name as query. For each query, print the phone number 
 * of that person.
 * */

class Solution {
	public static void main(String[] argh) {
		HashMap<String, Integer> phonebook = new HashMap<String, Integer>();

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.nextLine();
		for (int i = 0; i < n; i++) {
			String name = in.nextLine();
			int phone = in.nextInt();
			phonebook.put(name, (Integer) phone);
			in.nextLine();
		}
		while (in.hasNext()) {
			String s = in.nextLine();
			String r;
			if (phonebook.containsKey(s)) {
				r = s + "=" + phonebook.get(s);
			} else {
				r = "Not found";
			}
			System.out.println(r);
		}

		in.close();
	}
}
