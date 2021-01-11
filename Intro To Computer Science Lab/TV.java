//Author: Yazid Escudero
//Instructor: Dr. Daniel Mejia
//Course: CS1101 from CS1301
//Description: IN CLASS EXERCISE for the 16th of November, 2020

public class TV {
	
	//attributes
	public int channel = 1;
	public int volumeLevel = 1;
	public boolean tvOn = false;
	
	//constructors
	public TV() {
		
	}
	
	//Methods
	public void turnOn() {
		this.tvOn = true;
	}
	
	public void turnOff() {
		this.tvOn = false;
	}
	
	public void setChannel(int newChannel) {
		
		if((newChannel >= 1 && newChannel <= 120) && tvOn) {
			this.channel = newChannel;
		}
		
	}
	
	public void setVolume(int newVolumeLevel) {
		if((newVolumeLevel >= 1 && newVolumeLevel <= 100) && tvOn) {
			this.volumeLevel = newVolumeLevel;
		}
	}
	
	public void channelUp() {
		if(tvOn && (channel < 120)) {
			++this.channel;	//increase chann
		}
	}
	
	public void channelDown() {
		if(tvOn && (channel > 1)) {
			--this.channel;
		}
	}
	
	public void volumeUp() {
		if(tvOn && (volumeLevel < 100)) {
			++this.volumeLevel;
		}
	}
	
	public void volumeDown() {
		if(tvOn && (volumeLevel > 1)) {
			--this.volumeLevel;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
}


