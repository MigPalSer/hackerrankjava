package retos.java1.tagextractor;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*https://www.hackerrank.com/challenges/tag-content-extractor/problem
 *TASK: generate a tag extractor for html type tags with regex */

public class Solution {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		while (testCases > 0) {
			String line = in.nextLine();

			tagExtractor(line);

			testCases--;
		}
	}

	public static void tagExtractor(String s) {
		//Method to extract the content between correct tags and print it
		
		Pattern pattern = Pattern.compile("<(.+)>([^<>]+)</\\1>");

		Matcher matcher = pattern.matcher(s);

		if (matcher.find()) {
			System.out.println(matcher.group(2));
			while (matcher.find()) {
				System.out.println(matcher.group(2));
			}
		} else {
			System.out.println("None");
		}

	}

}
