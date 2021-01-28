package retos.java1.comparator;

import java.util.*;

/*https://www.hackerrank.com/challenges/java-comparator/
 * INPUT:The first line contains an integer, n, denoting the number of players.
 * Each of the subsequent lines contains a player's name and score, respectively.
 * OUTPUT: Sort them in order of decreasing score; if 2 or more players have 
 * the same score, sort those players alphabetically by name. Then stub code print them.
 * */

class Checker implements Comparator<Player> {

	public int compare(Player o1, Player o2) {
		if (o1.score == o2.score) {
			return o1.name.compareTo(o2.name);
		} else {
			return o2.score - o1.score;
		}
	}

}

class Player {
	String name;
	int score;

	Player(String name, int score) {
		this.name = name;
		this.score = score;
	}
}

public class Solution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		Player[] player = new Player[n];
		Checker checker = new Checker();

		for (int i = 0; i < n; i++) {
			player[i] = new Player(scan.next(), scan.nextInt());
		}
		scan.close();

		Arrays.sort(player, checker);
		for (int i = 0; i < player.length; i++) {
			System.out.printf("%s %s\n", player[i].name, player[i].score);
		}
	}
}