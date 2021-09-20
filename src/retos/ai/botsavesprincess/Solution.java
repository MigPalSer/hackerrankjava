package retos.ai.botsavesprincess;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*https://www.hackerrank.com/challenges/saveprincess
 * */

public class Solution {

static void displayPathtoPrincess(int n, String [] grid){
	
	int filep = 0, rowp = 0, filem = 0, rowm = 0, vertical, horizontal;
	
	String svertical="", shorizontal="";
	
	for (int i = 0; i < grid.length; i++) {
		int file=i, row;

		char[] filechars=grid[i].toCharArray();
		for (int j = 0; j < filechars.length; j++) {
			if(filechars[j]!='-') {
				row=j%n;
				if(filechars[j]=='p') {
					filep=file;
					rowp=row;
				}else {
					filem=file;
					rowm=row;
				}	
			}
		}
		
	}
	
	vertical=filem-filep;
	horizontal=rowm-rowp;
	
	svertical=vertical>0?"UP":"DOWN";
	shorizontal=horizontal<0?"RIGHT":"LEFT";
	
	for (int i = 0; i < Math.abs(vertical); i++) {
		System.out.println(svertical);
	}
	for (int i = 0; i < Math.abs(horizontal); i++) {
		System.out.println(shorizontal);
	}
  }

public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m;
        m = in.nextInt();
        String grid[] = new String[m];
        for(int i = 0; i < m; i++) {
            grid[i] = in.next();
        }

    displayPathtoPrincess(m,grid);
    }

}