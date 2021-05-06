package retos.interview.minimumswaps;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.Collectors;

/*https://www.hackerrank.com/challenges/minimum-swaps-2/
 *TASK: Return the minimum number of swaps to order an array
 *WARN: Need to solve a time problem for the last testcases */

public class Solution {

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
    	
        ArrayList<Integer> list = (ArrayList<Integer>) Arrays.stream(arr).boxed().collect(Collectors.toList());
        
        int swaps=0;
        
        //No need to include the last element in the loop
        for (int i = 0; i < arr.length-1; i++) {
			if(list.get(i)!=i+1) {
				swaps++;
				Collections.swap(list, i, list.indexOf(i+1));
			}
		}
        
        return swaps;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
