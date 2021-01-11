//Author: Yazid Escudero
//Course: CS1101 from CS1301
//Instructor: Dr. Danile Mejia
//Description: In class/lab excercies follow along coding. Examples of creating classes and objects from classes


//main file, main java code

public class ObjExercise {
	
	public static void main(String[] args) {
		
		/*
		Student id88080 = new Student("Ali", "Nouri", "CS", 3.0, 4.0);
		System.out.println(id88080.firstName);
		System.out.println(id88080.major);
		System.out.println(id88080.firstName + " " + id88080.familyName + ", the GPA is: " + id88080.GAPCalculator());
		id88080.age = 120;
		System.out.println(id88080.age);
		System.out.println(id88080.CS1101Grade);		
		id88080.CS1101Grade = 4.0;
		System.out.println(id88080.CS1101Grade);
		*/
		
		Student id8801 = new Student();
		//assing values by ourselves
		id8801.firstName  = "Bob";
		id8801.familyName = "Robinson";
		System.out.println(id8801.firstName + " " + id8801.familyName + " ");
		id8801.setAge(23);
		System.out.println(id8801.getAge());
		
		
		
	}
	
	
}