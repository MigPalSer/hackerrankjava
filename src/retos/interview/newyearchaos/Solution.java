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
 *TODO: Solve the time limit problem
 * */

class Result {

    public static void minimumBribes(List<Integer> q) {
    int bribes=0;
    boolean toochaotic=false;
	HashSet<Integer> ticketspresentes=new HashSet<Integer>();

    for (int i = 0; i < q.size(); i++) {
		int numero=q.get(i);
		ticketspresentes.add(numero);
		if(q.get(i)-i>3)toochaotic=true;
		for (int j = numero-1; j >0; j--) {
			if(!ticketspresentes.contains(j))bribes++;
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
