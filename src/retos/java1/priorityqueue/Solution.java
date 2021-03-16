package retos.java1.priorityqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.PriorityQueue;
/*https://www.hackerrank.com/challenges/java-priority-queue/problem
 *TASK: There are a number of students in a school who wait to be served. 
 *Two types of events, ENTER and SERVED, can take place which are described below.
 *ENTER: A student with some priority enters the queue to be served.
 *SERVED: The student with the highest priority is served (removed) from the queue.
 *A unique id is assigned to each student entering the queue. The queue serves the students 
 *based on the following criteria (priority criteria):
 *The student having the highest Cumulative Grade Point Average (CGPA) is served first.
 *Any students having the same CGPA will be served by name in ascending case-sensitive alphabetical order.
 *Any students having the same CGPA and name will be served in ascending order of the id.
 *The locked stub code prints the names of the students yet to be served in the priority order. 
 *If there are no such student, then the code prints EMPTY.
 */

class Priorities {

	List<Student> getStudents(List<String> events) {

		// We use a PriorityQueue with the challenge rules as comparator to manage the
		// students
		PriorityQueue<Student> queue = new PriorityQueue<Student>(10, (a, b) -> {
			if (a.getCgpa() != b.getCgpa()) {
				// We add that multiplication for avoid a 0 cast to integer with near values of
				// cgpa
				return (int) (1000 * (b.getCgpa() - a.getCgpa()));
			} else if (a.getName() != b.getName()) {
				return a.getName().compareTo(b.getName());
			} else {
				return b.getId() - a.getId();
			}
		});

		for (String s : events) {

			try {
				if (s.equals("SERVED")) {
					queue.remove();
				} else {
					String[] splited = s.split("\\s+");
					Student student = new Student(Integer.parseInt(splited[3]), splited[1],
							Double.parseDouble(splited[2]));
					queue.add(student);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		ArrayList<Student> list = new ArrayList<Student>();
		list.addAll(queue);
		list.sort(queue.comparator());
		return list;

	}
}

class Student {
	private int id;
	private String name;
	private double cgpa;

	public Student(int id, String name, double cgpa) {
		super();
		this.id = id;
		this.name = name;
		this.cgpa = cgpa;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getCgpa() {
		return cgpa;
	}
}

public class Solution {
	private final static Scanner scan = new Scanner(System.in);
	private final static Priorities priorities = new Priorities();

	public static void main(String[] args) {
		int totalEvents = Integer.parseInt(scan.nextLine());
		List<String> events = new ArrayList<>();

		while (totalEvents-- != 0) {
			String event = scan.nextLine();
			events.add(event);
		}

		List<Student> students = priorities.getStudents(events);

		if (students.isEmpty()) {
			System.out.println("EMPTY");
		} else {
			for (Student st : students) {
				System.out.println(st.getName());
			}
		}
	}
}