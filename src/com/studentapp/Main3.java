package com.studentapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main3 {
	private static List<Student> studentList;  //static bcz static variable can be accessed in static methods

	public static void main(String[] args) {

		System.out.println("*********** Student Management System ***********");
		System.out.println("*********** Welcome ***********");
		
		studentList = new ArrayList<Student>(); //declared directly above as you wouldn't be allowed to access Studentlist outside method;
		Student s1;
		s1 = new Student("Rahul Nayak", 22, "S-21");
		s1.enrollCourse("Java");
		s1.enrollCourse("DSA");
		s1.enrollCourse("Devops");
		s1.enrollCourse("C#");

	
		
		Student s2 = new Student("Akshay", 23, "S-11");
		s2.enrollCourse("Java");
		

		
		Student s3 = new Student("Umesh", 22, "S-12");
		s3.enrollCourse("Devops");
		
		Student s4 = new Student("Shubham", 27, "S-13");
		s4.enrollCourse("DSA");
		
		studentList.add(s1);  //each memory location hear serves as an reference variable
		studentList.add(s2);
		studentList.add(s3);
		studentList.add(s4);
		
		Student result = findStudentById("S-11"); //it will only find S-11 id if not found will through exception
		System.out.println("Result" +result);  //will print the exception which we want to throw.
		
		sortByName(); //This will sort all method alphabetically 
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
