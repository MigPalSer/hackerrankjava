package retos.interview.minimumabsolutdifference;

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

/*https://www.hackerrank.com/challenges/minimum-absolute-difference-in-an-array
 * first approach, it fails two cases because an exceed of time limits.
 */

class Result {

    public static int minimumAbsoluteDifference(List<Integer> arr) {

    	int minimum_difference=Integer.MAX_VALUE;
    	
    	Collections.sort(arr);
    	
    	int previous=arr.get(0);
    	int actual, difference;
    	
    	for (int i = 1; i < arr.size(); i++) {
			actual=arr.get(i);
			difference=Math.abs(actual-previous);
			if(difference<minimum_difference)minimum_difference=difference;
			previous=actual;
		}
    	
    	
    	return minimum_difference;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.minimumAbsoluteDifference(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
