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
 */



public class Solution3 {
    public static void main(String[] args) throws IOException {
        Scanner miscan=new Scanner(System.in);
        int n = miscan.nextInt();

        int m = miscan.nextInt();

        long [] array=new long[n+1];
        for (int i = 0; i <= n; i++) {
            array[i]=0L;
        }
        int initial, end, number;
        for (int i = 0; i < m; i++) {
            initial=miscan.nextInt()-1;
            end=miscan.nextInt();
            number=miscan.nextInt();
            array[initial]+=number;
            array[end]-=number;
        }

        
        
        long result=0;
        long actual=0;
        
        for (int i = 0; i < array.length; i++) {
            actual += array[i];
            if(actual>result)result=actual;
        }

        System.out.println(result);
 
        miscan.close();
        
    }
}