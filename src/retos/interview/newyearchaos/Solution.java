package retos.interview.newyearchaos;

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

/*https://www.hackerrank.com/challenges/new-year-chaos/problem
 *TASK: with the rules of the challenge, print the number of bribes to obtain a
 *certain queue. 
 *The code is a bit complex because I needed to solve the time limit problem
 * */

class Result {

    public static void minimumBribes(List<Integer> q) {
    int bribes=0;
    boolean toochaotic=false;
	//We catch every number that appear at the queue
    HashSet<Integer> ticketspresentes=new HashSet<Integer>();
	//Lowest index for the internal loop, we will up it for shorting that loop
    int index=0;

    for (int i = 0; i < q.size(); i++) {
		int numero=q.get(i);
		//Test the chaotic condition and, if it's true, break the loop
		if(numero-i>3)toochaotic=true;
		if(toochaotic)break;
		ticketspresentes.add(numero);
		//Internal loop, for every lower number that NOT appear in the previous numbers
		//a bribe (by actual person or not) must be did.
		for (int j = numero-1; j >index; j--) {
			if(!ticketspresentes.contains(j)) {bribes++;
			//If the last number appear, we can up the index for shorting our loop
			}else if(j==index+1) {
				index++;
			}
		}
	}
    
    if(toochaotic) {
    	System.out.println("Too chaotic");
    }else {
    	System.out.println(bribes);
    }

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                Result.minimumBribes(q);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
