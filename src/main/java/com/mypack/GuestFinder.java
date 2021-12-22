package com.mypack;
import java.util.List;

import org.springframework.stereotype.Component;

@Component("guest")
public class GuestFinder{
	public int guestFind(List<String> guestCommand){
		int noOfGuests=0;
		for(String a:guestCommand) {
			noOfGuests += Integer.parseInt(a.substring(11, a.length()));
		}
		return noOfGuests;
	}
}
