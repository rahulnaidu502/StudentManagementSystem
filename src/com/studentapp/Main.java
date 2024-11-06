package com.studentapp;

public class Main {

	public static void main(String[] args) {

		System.out.println("*********** Student Management System ***********");
		System.out.println("*********** Welcome ***********");
		
		Student s1;
		s1 = new Student("Rahul Nayak", 22, "S-21");
		s1.enrollCourse("Java");
		s1.enrollCourse("DSA");
		s1.enrollCourse("Devops");
		s1.enrollCourse("C#");

		//System.out.println(s1);
		s1.printStudentInfo();
		
		Student s2 = new Student("Akshay", 23, "S-11");
		s2.enrollCourse("Java");
		//System.out.println(s2);
		s2.printStudentInfo();

		
		Student s3 = new Student("Umesh", 22, "S-12");
		s3.enrollCourse("Devops");
		//System.out.println(s3);
		s3.printStudentInfo();
	}

}
