package retos.java1.arraylist;
import java.io.*;
import java.util.*;


/*https://www.hackerrank.com/challenges/java-arraylist/problem
*INPUT: The first line has an integer n. In each of the next n lines there will 
*be an integer d denoting number of integers on that line and then there will be d
*space-separated integers. In the next line there will be an integer q denoting 
*number of queries. Each query will consist of two integers x and y.
*OUTPUT: In each line, output the number located in y position of x line.
*If there is no such position, just print "ERROR!"
*/

public class Solution {

    public static void main(String[] args) {
       Scanner mainScanner=new Scanner(System.in);
       int linesNumber=mainScanner.nextInt();
       ArrayList<ArrayList<Integer>> listOfLines=new ArrayList<ArrayList<Integer>>(linesNumber);
       for (int i = 0; i < linesNumber; i++) {
		int lineAmountIntegers=mainScanner.nextInt();
		ArrayList<Integer> lineArray=new ArrayList<Integer>(lineAmountIntegers);
		for (int j = 0; j < lineAmountIntegers; j++) {
			lineArray.add(mainScanner.nextInt());
		}
		listOfLines.add(lineArray);
	}
       int querys=mainScanner.nextInt();
       for (int i = 0; i < querys; i++) {
           int x=mainScanner.nextInt();
           int y=mainScanner.nextInt();
           
          if (x<=listOfLines.size()) {
			if (y<=listOfLines.get(x-1).size()) {
				System.out.println(listOfLines.get(x-1).get(y-1));
			}else {
				System.out.println("ERROR!");
			}
		}else {
			System.out.println("ERROR!");
		}

	}
       
	   mainScanner.close();
    }
}