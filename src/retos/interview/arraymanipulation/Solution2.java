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
 * *WARNING: Problems of timeout
 */



public class Solution2 {
    public static void main(String[] args) throws IOException {
    	Scanner miscan=new Scanner(System.in);
    	int n = miscan.nextInt();

        int m = miscan.nextInt();

        Long [] array=new Long[n];
    	for (int i = 0; i < n; i++) {
			array[i]=0L;
		}
    	
    	for (int i = 0; i < m; i++) {
            int initial=miscan.nextInt()-1;
            int end=miscan.nextInt()-1;
            int number=miscan.nextInt();
            for (int j = initial; j <= end; j++) {
                array[j]+=number;
            }
        }

        long result = Collections.max(Arrays.asList(array));;

        System.out.println(result);
 
    }
}
