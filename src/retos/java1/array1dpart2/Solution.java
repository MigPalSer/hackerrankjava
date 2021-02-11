package retos.java1.array1dpart2;

import java.util.*;

/*https://www.hackerrank.com/challenges/java-1d-array/problem
 *INPUT: The first line contains an integer denoting the number 
 *of queries (i.e., function calls). The subsequent lines describe 
 *each query over two lines: The first line contains two space-separated 
 *integers describing the respective values of n and leap The second line 
 *contains space-separated binary integers (i.e., zeroes and ones) describing 
 *the respective values of each game.
 *OUTPUT: Return YES or NO if the game can be solved (see the rules at page)
 * */

public class Solution {

	public static boolean canWin(int leap, int[] game) {
		// Return true if you can win the game; otherwise, return false.
		ArrayList<Valley> valleys = scanValleys(game);

		// We try to "unlock" valleys, with that way we avoid recursive methods that
		// we would need to avoid "trap" valleys; and at the end obtain which valleys
		// we can reach
		valleys.get(0).setReach(true);
		for (Valley valley : valleys) {
			if (valley.isReach()) {
				for (int i = valley.getInit(); i <= valley.getEnd(); i++) {
					for (Valley valley2 : valleys) {
						valley2.tryLeap(leap + i);
					}
				}
			}
		}
		// We obtain the last possible position in our game, before we may do the
		// last win jump; then we see if it's enought to win
		int lastPosition = 0;
		for (Valley valley : valleys) {
			if (valley.isReach() && valley.getEnd() > lastPosition) {
				lastPosition = valley.getEnd();
			}
		}

		if (lastPosition + leap > (game.length - 1) || lastPosition == game.length - 1) {
			return true;
		} else {
			return false;
		}

	}

	static ArrayList<Valley> scanValleys(int[] game) {
		ArrayList<Valley> list = new ArrayList<Valley>();
		// We init the boolean true as the game conditions garanteed a 0 in n=0
		boolean isValley = true;
		int init = 0;
		int end = 0;
		for (int i = 0; i < game.length; i++) {
			if (game[i] != 0) {
				if (isValley) {
					end = i - 1;
					list.add(new Valley(init, end));
					isValley = false;
				}
			} else {
				if (!isValley) {
					init = i;
					isValley = true;
				}
				if (i == (game.length - 1)) {
					end = i;
					list.add(new Valley(init, end));
					isValley = false;
				}
			}
		}
		return list;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int q = scan.nextInt();
		while (q-- > 0) {
			int n = scan.nextInt();
			int leap = scan.nextInt();

			int[] game = new int[n];
			for (int i = 0; i < n; i++) {
				game[i] = scan.nextInt();
			}

			System.out.println((canWin(leap, game)) ? "YES" : "NO");
		}
		scan.close();
	}
}

class Valley {
	public int getInit() {
		return init;
	}

	public void setInit(int init) {
		this.init = init;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public boolean isReach() {
		return reach;
	}

	public void setReach(boolean reach) {
		this.reach = reach;
	}

	private int init, end;
	private boolean reach;

	public Valley(int init, int end) {
		this.init = init;
		this.end = end;
		reach = false;
	}

	public void tryLeap(int leap) {
		if (leap >= init && leap <= end) {
			reach = true;
		}
	}
}