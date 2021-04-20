package retos.java1.reflection;

import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/*https://www.hackerrank.com/challenges/sha-256/problem
*TASK: Create an SHA-256 implementation for hash one password and print in hexadecimal
*/

class Student {
	// Not part of the challenge, but useful for the IDE.

}

public class Solution {

	public static void main(String[] args) {
		Class student = Student.class;
		Method[] methods = student.getDeclaredMethods();

		ArrayList<String> methodList = new ArrayList<>();
		for (Method method : methods) {
			methodList.add(method.getName());
		}
		Collections.sort(methodList);
		for (String name : methodList) {
			System.out.println(name);
		}
	}

}