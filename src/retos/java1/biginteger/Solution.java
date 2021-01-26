package retos.java1.biginteger;
import java.io.*;
import java.math.BigInteger;
import java.util.*;


/*https://www.hackerrank.com/challenges/java-biginteger/problem
INPUT: 2 lineas con números A y B (máximo 200 dígitos)
OUTPUT: la primera linea debe contener A+B, la segunda AxB
*/

public class Solution {

    public static void main(String[] args) {
       Scanner mainScanner=new Scanner(System.in);
       BigInteger a=new BigInteger(mainScanner.nextLine());
       BigInteger b=new BigInteger(mainScanner.nextLine());
       
       System.out.println(a.add(b));
       System.out.println(a.multiply(b));
	   
    }
}