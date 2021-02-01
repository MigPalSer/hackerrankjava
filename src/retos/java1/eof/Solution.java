package retos.java1.eof;

import java.util.*;
import java.io.*;

/*https://www.hackerrank.com/challenges/java-end-of-file/problem
*INPUT: Read some unknown lines of input from stdin(System.in) 
*until you reach EOF; each line of input contains a non-empty String.
*OUTPUT: For each line, print the line number, followed by a single space, 
*and then the line content received as input.
*/
public class Solution {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int n = 0;
		while (scan.hasNext()) {
			n++;
			String line = scan.nextLine();
			System.out.println(n + " " + line);
		}

		scan.close();

	}
}