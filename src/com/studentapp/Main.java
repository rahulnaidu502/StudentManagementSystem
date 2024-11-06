package com.studentapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
	private static List<Student> studentList;  //static bcz static variable can be accessed in static methods
	private static Scanner scanner;

	public static void main(String[] args) {

		System.out.println("*********** Student Management System ***********");
		studentList = new ArrayList<Student>(); //declared directly above as you wouldn't be allowed to access Studentlist outside method;
		 scanner = new Scanner(System.in);
		while(true) {
			System.out.println("*********** Welcome ***********");

		System.out.println(" Select an Option");
		System.out.println("1. Register a Student");
		System.out.println("2. Find Student with StudentId ");
		System.out.println("3. List All student Information");
		System.out.println("4. List Student Information in Sorted Order");
		System.out.println("5. exit");
		
		int option = scanner.nextInt();
		
		switch(option){
		case 1:
			enrollStudent(scanner);
		break;
		
		case 2:
			findStudentById(scanner);
			break;
			
		case 3:
			printAllStudentData();
			break;
			
		case 4:
			sortByName();
			break;
			
		case 5:
			exit();
			break;
			
			default:
				System.out.println("Invalid option selected!... Enter between 1 to 5");
		}
		
		}
	}


	private static void exit() {

		System.out.println("GoodBye");
		System.exit(0);
	}


	private static void printAllStudentData() {
		
		if(studentList.size()>0) {
		
		System.out.println("----------------PRINTING ALL STUDENT INFORMATION------------");
            for (Student student : studentList) {
			student.printStudentInfo();
			
		}
		System.out.println("---------**************--------------------");
	}else {
		System.err.println("Student List is Empty !!! No Student Record found");
	}
	}
	
	private static void findStudentById(Scanner scanner2) {

		Student studentFound = null ; //Explicit Initialization as local variable are never initialized implicitly so add null.
		System.out.println("Enter the student Id");
		String studentId = scanner2.next();
		
		try {
			studentFound	= studentList  //this list will be given to a stream()
				.stream() //then we will filter them on bases on studentID
				.filter(student -> student.getStudentId() //will filter and search for id which is S-11
				.equalsIgnoreCase(studentId)) //
		        .findFirst()  //if found will print if no will throw the below exception
		        .orElseThrow(()-> new RuntimeException("No data found")); //exception which we are throwing manually
		}
		catch(RuntimeException e) {
			System.out.println("Student with ID"+scanner2+ "not found!");
		}
		studentFound.printStudentInfo();

	}


	private static void enrollStudent(Scanner scanner2) {
		
		System.out.println("Enter the student Name");
		String studentName = scanner2.next();
		
		System.out.println("Enter the student age");
		int studentage = scanner2.nextInt();
		
		System.out.println("Enter the student Id");
		String studentId = scanner2.next();
		
		Student newStudent = new Student(studentName, studentage, studentId);
		studentList.add(newStudent);
		

			while(true) {
			System.out.println("Enter the course to be enrolled!!...Type Done to exit");
			String courseName = scanner2.next();
			if(courseName.equalsIgnoreCase("done")) {
				break;  //to exit from the loop
			}
			newStudent.enrollCourse(courseName);
		}
		newStudent.printStudentInfo();
		
	}





	private static void sortByName() {  //comparator method 

		Comparator<Student> studentNameComparator = (o1,o2) -> o1.getName().compareTo(o2.getName()); //Lamda expression
		
		/*  //another way
		 @Override
			public int compare(Student o1, Student o2) {
				return o1.getName().compareTo(o2.getName()); //lexographical comparition is happening here
			}
		};
		 */
			
		Collections.sort(studentList,studentNameComparator);
		printAllStudentData();
	}



	public static Student findStudentById(String scanner2)
	{
		//Student result; // implicit initialization
		Student result = null ; //Explicit Initialization as local variable are never initialized implicitly so add null.
	
		try {
	result	= studentList  //this list will be given to a stream()
				.stream() //then we will filter them on bases on studentID
				.filter(x -> x.getStudentId() //will filter and search for id which is S-11
				.equalsIgnoreCase(scanner2)) //
		        .findFirst()  //if found will print if no will throw the below exception
		        .orElseThrow(()-> new RuntimeException("No data found")); //exception which we are throwing manually
		}
		catch(RuntimeException e) {
			System.out.println("Student with ID"+scanner2+ "not found!");
		}
		return result;  //will return result, as method is static so return is added.
		
	}

}
