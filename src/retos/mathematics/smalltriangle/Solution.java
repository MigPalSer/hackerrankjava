package retos.mathematics.smalltriangle;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

/*https://www.hackerrank.com/challenges/maximum-draws/problem
 *TASK: create the maximumDraws method for calculate the minimum number of 
 *socks removed in a drawer with n pairs for obtain a matching pair */

public class Solution {

    static int lowestTriangle(int base, int area){
    	//FAILING METHOD - TO CORRECT
        Double height= (((double)area*2)/(double)base);
        height=Math.rint(height);
        return height.intValue();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int base = in.nextInt();
        int area = in.nextInt();
        int height = lowestTriangle(base, area);
        System.out.println(height);
    }
}