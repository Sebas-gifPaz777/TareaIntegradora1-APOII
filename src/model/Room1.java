package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Room1 {
	
	private Seat[] seats;
	
	public Room1(LocalTime lt, LocalTime lt2, String text, LocalDate date) {
		seats=new Seat[28];
		
		for(int i=0;i<seats.length;i++) {
			seats[i]= new Seat(lt, lt2, text,"", date);
		}
	}
	
	public Seat[] getArray() {
		return seats;
	}
}
