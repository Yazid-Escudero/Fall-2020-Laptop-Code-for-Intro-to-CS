//Author: Yazid Escudero
//Course: CS1101 from CS1301
//Instructor: Dr. Daniel Mejia
//Description: 
//	This Java file contains the main method that can use the Tv.java file that contains TV class for the creation of TV objects. 
//	This Java file will ccontrol the TV class along with any other funcionality that comes with the objects created with it

public class Week13 {
	
	public static void main(String[] args) {
		
		System.out.println("Hello, TV");
		TV livingRoomTV = new TV();
		System.out.println(livingRoomTV.tvOn);
		livingRoomTV.turnOn();
		System.out.println(livingRoomTV.tvOn);
		System.out.println(livingRoomTV.channel);
		livingRoomTV.setChannel(62);
		System.out.println(livingRoomTV.channel);
		
	}
	
}