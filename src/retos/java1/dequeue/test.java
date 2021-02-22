package retos.java1.dequeue;

import java.util.*;

/*https://www.hackerrank.com/challenges/java-dequeue/problem
 *TASK: In this problem, you are given N integers. You need to find the maximum 
 *number of unique integers among all the possible contiguous subarrays of size M.
 *Note: Time limit is 3 second for this problem. */

/*NOT FINISHED YET!*/

public class test {
	
	// I know.The name "test" for the class is a bad practice, but the challenge
	// provide that name.
	
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque deque = new ArrayDeque<Integer>();
        int n = in.nextInt();
        int m = in.nextInt();
        int maximumuniques=1;
        int lastuniques=1;
        
        
        int num0 = in.nextInt();
        deque.add((Integer)num0);
        
        for (int i = 0; i < m-1; i++) {
            Integer num = in.nextInt();
            
            if(!deque.contains(num)) {
            	lastuniques++;
            	maximumuniques++;
            }
            
            deque.add(num);
		}
        
        //*** arreglar esta condición para el caso de los 10 - 1
        while (maximumuniques!=m||!in.hasNext()) {
			
		
        for (int i = 0; i < n-m; i++) {
            Integer num = in.nextInt();
            Integer pop = (Integer) deque.removeFirst();
            if(!deque.contains(pop)) {
            	lastuniques--;
            }
            if(!deque.contains(num)) {
            	lastuniques++;
            }
            deque.add(num);
            maximumuniques=lastuniques>maximumuniques?lastuniques:maximumuniques;
        }
        
        
        }
       
        System.out.println(maximumuniques);
        
    }
}

