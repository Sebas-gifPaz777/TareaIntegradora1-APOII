package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Room2 {
private Seat[] seats;
	
	public Room2(LocalTime lt, LocalTime lt2, String text, LocalDate date) {
		seats=new Seat[42];
		
		for(int i=0;i<seats.length;i++) {
			seats[i]= new Seat(lt, lt2, text,"", date);
		}
	}
	
	public Seat[] getArray() {
		return seats;
	}
}
