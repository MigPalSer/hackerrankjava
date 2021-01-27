package retos.java1.sort;

import java.util.*;

/*https://www.hackerrank.com/challenges/java-sort/
 * INPUT: The first line of input contains an integer ,
 *  representing the total number of students.
 *  The next lines contains a list of student information
 *  in the following structure: ID Name CGPA
 * OUTPUT: Your task is to rearrange them according to their CGPA in
 * decreasing order. If two student have the same CGPA, then arrange
 * them according to their first name in alphabetical order. If those
 *  two students also have the same first name, then order them
 *  according to their ID. No two students have the same ID.
 *  After rearranging the students according to the above rules, 
 *  print the first name of each student on a separate line.
 * */

class Student {
	private int id;
	private String fname;
	private double cgpa;

	public Student(int id, String fname, double cgpa) {
		super();
		this.id = id;
		this.fname = fname;
		this.cgpa = cgpa;
	}

	public int getId() {
		return id;
	}

	public String getFname() {
		return fname;
	}

	public double getCgpa() {
		return cgpa;
	}
}

//Complete the code
public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());

		List<Student> studentList = new ArrayList<Student>();
		while (testCases > 0) {
			int id = in.nextInt();
			String fname = in.next();
			double cgpa = in.nextDouble();

			Student st = new Student(id, fname, cgpa);
			studentList.add(st);

			testCases--;
		}

		studentList.sort((s1, s2) -> {
			if (s1.getCgpa() == s2.getCgpa()) {
				if (s1.getFname().equals(s2.getFname())) {
					return s1.getId() - s2.getId();
				} else {
					return s1.getFname().compareTo(s2.getFname());
				}
			} else {
				// multiplicamos por 1000 para evitar que al realizar el cast a int
				// obtengamos un 0, si la diferencia era demasiado pequeña
				return (int) (1000 * (s2.getCgpa() - s1.getCgpa()));
			}

		});

		for (Student st : studentList) {
			System.out.println(st.getFname());
		}
	}
}
