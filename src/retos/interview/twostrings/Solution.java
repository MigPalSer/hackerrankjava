package retos.interview.twostrings;

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

/*https://www.hackerrank.com/challenges/two-strings
 *  *TASK: Check if exist any possible substring between two strings.
 * */

class Result {

	public static String twoStrings(String s1, String s2) {

		HashSet<Character> string1content = new HashSet<Character>();

		for (Character character : s1.toCharArray()) {
			string1content.add(character);
		}

		boolean coincidence = false;

		for (Character character : s2.toCharArray()) {
			if (string1content.contains(character)) {
				coincidence = true;
				break;
			}

		}
		
		return coincidence ? "YES" : "NO";
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int q = Integer.parseInt(bufferedReader.readLine().trim());

		IntStream.range(0, q).forEach(qItr -> {
			try {
				String s1 = bufferedReader.readLine();

				String s2 = bufferedReader.readLine();

				String result = Result.twoStrings(s1, s2);

				bufferedWriter.write(result);
				bufferedWriter.newLine();
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		bufferedReader.close();
		bufferedWriter.close();
	}
}