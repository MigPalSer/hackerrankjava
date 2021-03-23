package retos.java1.dequeue;

import java.util.*;

/*https://www.hackerrank.com/challenges/java-dequeue/problem
 *TASK: In this problem, you are given N integers. You need to find the maximum 
 *number of unique integers among all the possible contiguous subarrays of size M.
 *Note: Time limit is 3 second for this problem. */

/*Working, but fail the time limit for the last 3 cases*/

public class test {

	// I know.The name "test" for the class is a bad practice, but the challenge
	// provide that name.

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Deque<Integer> deque = new ArrayDeque<Integer>();
		Set<Integer> differentNumbers = new HashSet<>();
		int n = in.nextInt();
		int m = in.nextInt();
		int maximumuniques = 1;

		for (int i = 0; i < m - 1; i++) {
			Integer num = in.nextInt();

			deque.add(num);
			differentNumbers.add(num);
		}

		maximumuniques = differentNumbers.size();

		for (int i = 0; i < 1 + n - m; i++) {
			if (maximumuniques == m) {
				break;
			}
			Integer num = in.nextInt();

			deque.add(num);
			differentNumbers.add(num);

			maximumuniques = differentNumbers.size() > maximumuniques ? differentNumbers.size() : maximumuniques;

			Integer outnumber = deque.remove();
			if (!deque.contains(outnumber))
				differentNumbers.remove(outnumber);

		}

		System.out.println(maximumuniques);

	}
}
