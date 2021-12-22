package com.mypack;
import org.springframework.stereotype.Component;

@Component("res")
public class ResidentFinder{
	public int resFind(String allotCommand){
		int noOfResidents;
		char noOfRooms = allotCommand.charAt(12);
		String numOfRooms = String.valueOf(noOfRooms);
		int numberOfRooms = Integer.parseInt(numOfRooms);
		noOfResidents = (numberOfRooms < 3) ? 3 : 5;
		return noOfResidents;
	}
}
