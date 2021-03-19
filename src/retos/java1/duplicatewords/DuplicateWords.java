package retos.java1.duplicatewords;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*https://www.hackerrank.com/challenges/duplicate-word/problem
 *TASK: Use regex to remove instances of words that are repeated more 
 *than once, but retain the first occurrence of any case-insensitive 
 *repeated word.
 *WARNING: The challenge allow only to modify 3 lines of the original code
 *and fail the trial if you modify any other line, so don't copy and paste 
 *all this class with the comments.
 * */

public class DuplicateWords {

	public static void main(String[] args) {

		String regex = "\\b(\\w+)(\\W\\1\\b)*";
		Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

		Scanner in = new Scanner(System.in);
		int numSentences = Integer.parseInt(in.nextLine());

		while (numSentences-- > 0) {
			String input = in.nextLine();

			Matcher m = p.matcher(input);

			// Check for subsequences of input that match the compiled pattern
			while (m.find()) {
				input = input.replaceAll(m.group(), m.group(1));
			}

			// Prints the modified sentence.
			System.out.println(input);
		}

		in.close();
	}
}
