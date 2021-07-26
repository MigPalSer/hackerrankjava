package retos.interview.ransomnote;

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

/*https://www.hackerrank.com/challenges/ctci-ransom-note
 *  *TASK: Check if a ransom note is makeable using the whole words of a magazine. In other words,
 *  check if a text can be make using only the whole words of another text.
 * */

class Result {

   
    public static void checkMagazine(List<String> magazine, List<String> note) {
    	HashMap<String, Integer> magazine_map=toHashMap(magazine);
    	HashMap<String, Integer> note_map=toHashMap(note);
    	boolean makeable=true;
    	
    	for (String string : note_map.keySet()) {
			int requirements=note_map.get(string);
			if(!magazine_map.containsKey(string)) {
				makeable=false;
			}else {
				if(requirements>magazine_map.get(string))makeable=false;
			}
			
			if(!makeable)break;
		}
    	
    	String answer=makeable?"Yes":"No";
    	System.out.println(answer);
    }
    
    public static HashMap<String, Integer> toHashMap(List<String> list){
    	HashMap<String, Integer> map=new HashMap<String, Integer>();
    	
    	for (String string : list) {
			if(!map.containsKey(string)) {
				map.put(string, 1);
			}else {
				map.put(string, map.get(string)+1);
			}
		}
    	
    	return map;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(firstMultipleInput[0]);

        int n = Integer.parseInt(firstMultipleInput[1]);

        List<String> magazine = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .collect(toList());

        List<String> note = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .collect(toList());

        Result.checkMagazine(magazine, note);

        bufferedReader.close();
    }
}
