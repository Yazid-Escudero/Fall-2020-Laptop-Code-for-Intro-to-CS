//Author: Yazid Escudero
//Description:
//  This Java file simply tests the output and execution of the class Java file Fan.java in the same directory as this file

public class FanClassTester {

    public static void main(String[] args) {

        System.out.println("Begin Testing\n\n\n");

        Fan roomFan = new Fan();

        System.out.println(roomFan.toStringDescription());
        roomFan.setPowerState(true);
        System.out.println(roomFan.toStringDescription());
        roomFan.setColor("UGLY PINK ASS COLOR RUTAL TO THEEYERS");
        System.out.println(roomFan.toStringDescription());
        roomFan.setFanSpeed(3);
        roomFan.setColor("Magenta");
        System.out.println(roomFan.toStringDescription());
        roomFan.setRadius(94.1212);
        System.out.println(roomFan.toStringDescription());
        roomFan.setPowerState(false);
        System.out.println(roomFan.toStringDescription());
        roomFan.setFanSpeed(2);
        roomFan.setPowerState(true);
        System.out.println(roomFan.toStringDescription());


    }

}