//Author: Yazid Escudero
//Course: CS1101 from CS1301
//Instructor: Dr. Daniel Mejia
//Description:
//  This is a class that provides the outline of a fan. It contains attributes and functionalities that mimic the real life behavior and functionality
//  of a real fan.

public class Fan {

    //Fan speed options implemented as enumerators in enumeration
    //public enum FanSpeeds {SLOW, MEDIUM, FAST}
    //Power State on/off implemented as enumerators in enumerations
    //public  enum PowerState {ON, OFF} 

    //Attributes
    private int currentSpeed = 1;                           //SLOW is default speed
    private boolean fanOn = false;                          //OFF is default power setting
    private double radius = 5.0;
    private String color = "BLUE";

    private final int SLOW = 1;                             //represent fan speeds
    private final int MEDIUM = 2;                           //
    private final int FAST = 3;                             //
    
    //Constructors
    public Fan() {
        //empty fan constructor
    }

    /*
    *For the sake of interaction with the user and the main method in another file:
    *For the fan speed
    *   integer value 1 corresponds to enumerator SLOW
    *   integer value 2 corresponds to enumerator MEDIUM
    *   integer value 3 corresponds to enumerator FAST
    *For the PowerStates
    *   boolean value true corresponds to ON
    *   boolean value false corresponds to OFF
    *
    */

    //Getters
    public int getFanSpeed() {

        int speedValue = 0; //default value 9 before inevitable assignment
        
        if(this.currentSpeed == SLOW) {
            speedValue = SLOW;
        }
        else if(this.currentSpeed == MEDIUM) {
            speedValue = MEDIUM;
        }
        else if(this.currentSpeed == FAST) {
            speedValue = FAST;
        }

        return speedValue;

    }

    public boolean getPowerState() {
        return this.fanOn;
    }

    public double getRadius() {
        return this.radius;
    }

    public String getColor() {
        return this.color;
    }

    //SETTERS
    public void setFanSpeed(int fanSpeed) {

        if(fanSpeed == 1) {
            this.currentSpeed = SLOW;
        }
        else if(fanSpeed == 2) {
            this.currentSpeed = MEDIUM;
        }
        else if(fanSpeed == 3) {
            this.currentSpeed = FAST;
        }

    }

    public void setPowerState(boolean powerState) {
        this.fanOn = powerState;
    }

    public void setRadius(double newRadius) {

        //valid radius values are 1.0 through 100.0
        if((newRadius > 1.0) && (newRadius < 100.0)) {
            this.radius = newRadius;
        }

    }

    public void setColor(String newColor) {
        this.color = newColor;
    }

    //Remaining Methods
    public String toString() {
        
        //will concatenate this string according to fan attributes
        String fanDescription = "";

        //if fan is on
        if(this.fanOn) {

            //begin concatenating information into string

            //Determine Speed
            if(this.currentSpeed == SLOW) {
                fanDescription += "The fan speed is currently SLOW, ";
            }
            else if(this.currentSpeed == MEDIUM) {
                fanDescription += "The fan speed is currently MEDIUM, ";
            }
            else if(this.currentSpeed == FAST) {
                fanDescription += "The fan speed is currently FAST, ";
            }

            //Determine Color
            fanDescription += "and the fan is a " + this.color + " colored fan ";

            //Determine Radius
            fanDescription += "with a radius of " + this.radius + "!";

        }
        //else, if fan is off
        else {
            
            //Determine Color
            fanDescription += "The fan is a " + this.color + " colored fan ";
            //Determine Radius
            fanDescription += "with a radius of " + this.radius + "!";

        }


        return fanDescription;

    }



}