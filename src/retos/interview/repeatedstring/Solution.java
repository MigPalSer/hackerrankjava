package retos.interview.repeatedstring;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/*https://www.hackerrank.com/challenges/repeated-string/
 *TASK: There is a string of lowercase English letters that is repeated 
 *infinitely many times. Given an integer n, find and print the number 
 *of letter a's in the first letters of the infinite string. 
 * */

class Result {

	public static long repeatedString(String s, long n) {

		/*We are going to divide the problem in a series of complete cycles
		 *(which full iterate the string) and the last "incomplete" cycle (which
		 *only iterate partially). With that solution, we only iterate the string
		 *twice at maximum. 
		*/
		char[] char_array = s.toCharArray();
		long string_size = (long) char_array.length;
		long complete_cycles = n / string_size;
		long uncomplete_cycle_size = n % string_size;
		long a = 0;

		if (complete_cycles >= 1) {
			// Iterate the first complete cycle
			for (char c : char_array) {
				if (c == 'a')
					a++;
			}

			// Multiply by the number of complete cycles
			a *= complete_cycles;
		}

		// Iterate the uncomplete cycle
		for (int i = 0; i < uncomplete_cycle_size; i++) {
			if (char_array[i] == 'a')
				a++;
		}
		return a;

	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String s = bufferedReader.readLine();

		long n = Long.parseLong(bufferedReader.readLine().trim());

		long result = Result.repeatedString(s, n);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}