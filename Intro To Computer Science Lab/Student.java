//Class of Students

public class Student {

	//Attributes
	public String firstName;
	public String familyName;
	public String major;
	private int age;
	public double CS1101Grade;
	public double CS1301Grade;
	
	//Constructor
	public Student () {
		
	}
	
	public Student (String firstName, String familyName, String major, double CS1101Grade, double CS1301Grade) {
		
		//assign values to attribute
		this.firstName = firstName;
		this.familyName = familyName;
		this.major = major;
		this.CS1101Grade = CS1101Grade;
		this.CS1301Grade = CS1301Grade;
		
	}
	
	//functions
	public /*no static*/ double GAPCalculator () {
		
		return (CS1101Grade + CS1301Grade) / 2;
		
	}
	
	public void setAge(int age) {
		
		this.age = age;
		
	}
	
	public int getAge() {
		
		return this.age;
		
	}












	
}