package retos.interview.counttriplets;

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

/*https://www.hackerrank.com/challenges/count-triplets-1
 *This doesnt work properly. Fail for the edge case of 1 and exceed the time limit of certain test case
 */

public class Solution {

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
    	    	
    	int triplets=0;
    	
    	HashMap<Long, Integer> power_to_exponent=new HashMap<Long, Integer>();
    	HashMap<Integer, HashSet<Integer>> exponent_to_indices=new HashMap<Integer, HashSet<Integer>>();
    	HashSet<Long> powerset=new HashSet<Long>();

    	for (int i = 0; i < arr.size(); i++) {
			long power=(long) Math.pow(r, i); // Will this work properly with long?
    		power_to_exponent.put(power, i);
			exponent_to_indices.put(i, new HashSet<Integer>());
			powerset.add(power);
		}
    	
    	for (int i = 0; i < arr.size(); i++) {
    		long number=arr.get(i);
			if(powerset.contains(number)) {
				exponent_to_indices.get(power_to_exponent.get(number)).add(i);
			}
		}
    	
    	for (int i = 0; i < arr.size()-2; i++) {
    		HashSet<Integer> first=exponent_to_indices.get(i);
    		HashSet<Integer> second=exponent_to_indices.get(i+1);
    		HashSet<Integer> third=exponent_to_indices.get(i+2);

    		for (Integer integer1 : first) {
    			for (Integer integer2 : second) {
    				for (Integer integer3 : third) {
    					if(validTriplet(integer1, integer2, integer3))triplets++;
    				}
    			}
			}
    		
		}
    	
    	return triplets;
    }
    
    static boolean validTriplet(int i, int j, int k) {
    	return (i<j)&&(j<k);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Long::parseLong)
            .collect(toList());

        long ans = countTriplets(arr, r);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
