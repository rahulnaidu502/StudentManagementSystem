package com.studentapp;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {

	private String name;
	private int age;
	private String studentId;
	private List<String> courses;

	public Student(String name, int age, String studentId) {
		super();
		if (validateAge(age) && validateName(name) && validateStudentID(studentId)) {
			this.name = name;
			this.age = age;
			this.studentId = studentId;
			courses = new ArrayList<String>(); // Initialization of courses!!
		}
	}

	private boolean validateStudentID(String studentId) {
		String studentIdRegex = "S-[0-9]+$";// S-123 //it will only allow Id starting with S and between 0-9 + will
											// allow any combination
		Pattern studentIdPattern = Pattern.compile(studentIdRegex);
		Matcher studentIdMatcher = studentIdPattern.matcher(studentId);
		if (studentIdMatcher.matches()) {
			return true;
		} else {
			System.out.println("Invalid StudentId !! Use the format Eg- S-1234");
		}
		return false;
	}

	public void enrollCourse(String course) {
		if (validateCourseName(course)) { // will check if course is valid
			if (!courses.contains(course)) // ! should not be duplicate course which already exsist
			{
				courses.add(course);
				System.out.println("Student is enrolled to " + course + " successfully!!");
			} else {
				System.err.println("Student is already enrolled to the Course " + course);
			}
		}
	}

	public void printStudentInfo() {
		System.out.println("======= Student Information ========");
		System.out.println("Student Name: " + name);
		System.out.println("Student Age: " + age);
		System.out.println("Student Id: " + studentId);
		System.out.println("Enrolled for:  " + courses);

	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", studentId=" + studentId + ", courses=" + courses + "]";
	}

	public boolean validateAge(int age) {
		if (age >= 19 && age <= 35) {
			return true;
		} else {
			System.err.println("Invalid age !! Student age needs to be between 19 & 35");
			return false;
		}
	}

	public boolean validateName(String name) {
		String nameRegex = "^[a-zA-Z\\s]+$"; // it indicate that the string need to start with an alphabet between a-z;
												// A-Z can have any combination on A-Z in upper or lower case
												// "\\s" will allow having white spaces & ^ denotes start of the string
												// $ will denote ending & "+" means n number of combination
		Pattern namePattern = Pattern.compile(nameRegex);
		Matcher nameMatcher = namePattern.matcher(name);
		if (nameMatcher.matches()) {
			return true;
		} else {
			System.out.println("Invalid name !! Please enter alphabets only");
			return false;
		}
	}

	public boolean validateCourseName(String course) {
		if (course.equalsIgnoreCase("Java") || course.equalsIgnoreCase("DSA") || course.equalsIgnoreCase("Devops")) {
			return true;
		} else {
			System.err.println(
					"Invalid Course Name !!! Please select Courses from the available list!! [Java,Devops,DSA]");
			return false;
		}
	}

	//using getter setter method as we have are variables as private
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getStudentId() {
		return studentId;
	}

	public List<String> getCourses() {
		return courses;
	}

}
