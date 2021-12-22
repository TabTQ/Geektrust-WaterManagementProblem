package com.mypack;
import org.springframework.stereotype.Component;

@Component("po")
public class PrintOutput{
	public void start(int amount, int price){
		System.out.println(amount+" "+price);
	}
}
