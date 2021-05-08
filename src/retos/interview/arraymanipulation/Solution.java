package retos.interview.arraymanipulation;
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

/*https://www.hackerrank.com/challenges/crush/problem
 *TASK: Starting with a 1-indexed array of zeros and a list of operations,
 *for each operation add a value to each the array element between two 
 *given indices, inclusive. Once all operations have been performed, 
 *return the maximum value in the array. 
 *
 *WARNING: Problems of timeout
 */


class Result {

    

    public static long arrayManipulation(int n, List<List<Integer>> queries) {

    	Long [] array=new Long[n];
    	for (int i = 0; i < array.length; i++) {
			array[i]=0L;
		}
    	
    	for (List<Integer> list : queries) {
    		int number=list.get(2);
			for (int i = list.get(0)-1; i <= list.get(1)-1; i++) {
				array[i]+=number;
			}
		}
    	
    	return Collections.max(Arrays.asList(array));
    	
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                queries.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        long result = Result.arrayManipulation(n, queries);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
