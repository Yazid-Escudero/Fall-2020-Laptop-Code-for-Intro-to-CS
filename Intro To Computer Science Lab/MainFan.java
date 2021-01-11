//Author: Yazid Escudero
//Course: CS1101 from CS1301
//Instructor: Dr. Daniel Mejia
//Description: To use Fan.java class to create Fan Objects. These fan objects will be created and their
//              attributes, methods, etc, will be tested in this MainFan.java file through the main method


public class MainFan {

    public static void main(String[] args) {

        /*
         *Create 3 fans. Each with different attirbutes. Print out descriptions for succesful demonstration
         *of functionalities of the methods, and overall class
        */
        System.out.println();

        //First Fan
        Fan livingroomFan = new Fan();
        livingroomFan.setFanSpeed(3);                   //fast setting
        livingroomFan.setPowerState(true);              //fan ON
        livingroomFan.setRadius(12.5);
        livingroomFan.setColor("Orange");
        System.out.println(livingroomFan.toString());   //prints fan description of attributes
        System.out.println();

        //Second Fan - default values used!
        Fan bedroomFan = new Fan();
        System.out.println(bedroomFan.toString());      //prints fan description of attributes
        System.out.println();

        //Third Fan - some values changed
        Fan kitchenFan = new Fan();
        kitchenFan.setPowerState(true);                 //fan ON
        kitchenFan.setFanSpeed(2);                      //medium setting
        kitchenFan.setColor("DARK GRAY");
        System.out.println(kitchenFan.toString());
        System.out.println();

    }

}