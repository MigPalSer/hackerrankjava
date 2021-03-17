package retos.java1.regexusername;

import java.util.Scanner;

/*https://www.hackerrank.com/challenges/valid-username-checker/problem
 *TASK: use regular expressions to validate usernames with certain constraints
 * */

class UsernameValidator {
 
    public static final String regularExpression = "[A-Za-z][\\w[_]]{7,29}";
}


public class Solution {
    private static final Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) {
        int n = Integer.parseInt(scan.nextLine());
        while (n-- != 0) {
            String userName = scan.nextLine();

            if (userName.matches(UsernameValidator.regularExpression)) {
                System.out.println("Valid");
            } else {
                System.out.println("Invalid");
            }           
        }
    }
}