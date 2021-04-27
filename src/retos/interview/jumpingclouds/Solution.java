package retos.interview.jumpingclouds;

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

/*https://www.hackerrank.com/challenges/jumping-on-the-clouds
 *TASK: Return the minimum amount of jumps (with length 2 or 1) on cumulus (0)
 *to reach the final cloud avoiding the thunderclouds (1) 
 * */

class Result {

	public static int jumpingOnClouds(List<Integer> c) throws IOException {

		int jumps=0;
		int position=0;
		int lastIndex=c.size()-1;
		
		//Since the range of jumps is 1 and 2, we have no risk of getting "trapped"
		//so we can advance at full capacity every time is possible.
		
		do {
			//Final jump, avoiding an exception of try to get an inexistent index at the list
			if (position==lastIndex-2||position==lastIndex-1) {
				position=lastIndex;
				jumps++;
			}
			else if(c.get(position+2)==0) {
				position+=2;
				jumps++;
			}else if(c.get(position+1)==0) {
				position++;
				jumps++;
			}else {
				throw new IOException("Input break the rules of challenge");
			}
		} while (position!=lastIndex);
		
		return jumps;
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> c = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt)
				.collect(toList());

		int result = Result.jumpingOnClouds(c);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
