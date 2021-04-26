package retos.interview.countvalleys;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/*https://www.hackerrank.com/challenges/counting-valleys/
 *TASK: Given a sequence of steps which elevate or down our level. Calculate the
 *number of regions (consecutive steps) below the level 0.
 *WARNING: the description is confusing, with that "consecutive" adjective,
 *I figure myself that a valley needs 2 or more steps under 0 level but it's ok
 *with only one.
 */

class Result {

	public static int countingValleys(int steps, String path) {
		int level = 0;
		int valleys = 0;
		char[] changes = path.toCharArray();

		for (char c : changes) {
			if (c == 'U') {
				level++;

				if (level == 0)
					valleys++;

			} else if (c == 'D') {
				level--;
			}
		}
		return valleys;
	}
}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int steps = Integer.parseInt(bufferedReader.readLine().trim());

		String path = bufferedReader.readLine();

		int result = Result.countingValleys(steps, path);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
