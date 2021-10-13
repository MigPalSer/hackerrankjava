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
 */

public class Solution {

    static long countTriplets(List<Long> arr, long r) {
    	    	
    	long triplets=0;
    	
    	HashMap<Long, Long> firstmap=new HashMap<Long, Long>();
    	HashMap<Long, Long> secondmap=new HashMap<Long, Long>();

    	for (Long n : arr) {
			long next=n*r;
			
			
			//If the number os searched by the second map, we achieve as many triplets as the stored in secondmap
			if(secondmap.keySet().contains(n)) {
				triplets+=secondmap.get(n);
			}
			
			//If the number is part of the next, we have as many two number combination (in search for next) as the coincidences of the first map. We add that to the second.
			if(firstmap.keySet().contains(n)) {
				if(secondmap.keySet().contains(next)) {
					secondmap.put(next, secondmap.get(next)+firstmap.get(n));
				}else {
					secondmap.put(next, firstmap.get(n));
				}
			}
			//Always we add the next required number for triplet to our first map, with a value of number of coincidences
			if(firstmap.keySet().contains(next)) {
				firstmap.put(next, firstmap.get(next)+1L);
			}else {
				firstmap.put(next, 1L);
			}
			
		}
    	
    	return triplets;
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
