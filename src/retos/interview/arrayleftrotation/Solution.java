package retos.interview.arrayleftrotation;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/*https://www.hackerrank.com/challenges/ctci-array-left-rotation/
 *TASK: do a certain amount of left rotations in an integer array 
 * */

public class Solution {
  
    static int[] rotLeft(int[] a, int d) {

    	int length=a.length;
    	
    	//Ignore the "complete" rotation which left the array without change
        int modification= d % length;

        int [] result=new int[length];
        
        //decrease length for adjust to 0-index array
        length--;
        
        for (int i = 0; i <= length; i++) {
			if(modification>length)modification=0;
        	result[i]=a[modification];
			modification++;
        }
        
        return result;
		
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] result = rotLeft(a, d);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
