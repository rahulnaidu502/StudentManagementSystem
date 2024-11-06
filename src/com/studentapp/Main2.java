package com.studentapp;

import java.util.ArrayList; // Class
import java.util.Collections; //Interface
import java.util.Comparator; //Interface
import java.util.List; // Interface
import java.util.Scanner; //Class

public class Main2 {
	private static List<Student> studentList;  //static bcz static variable can be accessed in static methods

	public static void main(String[] args) {

		System.out.println("*********** Student Management System ***********");
		System.out.println("*********** Welcome ***********");
		
		studentList = new ArrayList<Student>(); //declared directly above as you wouldn't be allowed to access Studentlist outside method;
		//To Read Input from the Terminal!!!!
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Student Name....");
		String name = scanner.next();   //if we want to read in String format we use next() method.
		System.out.println("You have entered the name" +name);
		
		//To Read integer values from the terminal!!!
		System.out.println("Enter Student Age....");
		int age = scanner.nextInt();  //If we want to read in Integer format we use NextInt() method;
		System.out.println("The Student age is" +age);
		
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
		System.out.println(studentList);
	}



	public static Student findStudentById(String studentId)
	{
		//Student result; // implicit initialization
		Student result = null ; //Explicit Initialization as local variable are never initialized implicitly so add null.
	
		try {
	result	= studentList  //this list will be given to a stream()
				.stream() //then we will filter them on bases on studentID
				.filter(x -> x.getStudentId() //will filter and search for id which is S-11
				.equalsIgnoreCase(studentId)) //
		        .findFirst()  //if found will print if no will throw the below exception
		        .orElseThrow(()-> new RuntimeException("No data found")); //exception which we are throwing manually
		}
		catch(RuntimeException e) {
			System.out.println("Student with ID"+studentId+ "not found!");
		}
		return result;  //will return result, as method is static so return is added.
		
	}

}
