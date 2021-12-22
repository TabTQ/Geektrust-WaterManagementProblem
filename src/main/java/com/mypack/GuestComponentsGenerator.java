package com.mypack;
import org.springframework.stereotype.Repository;
@Repository
public class GuestComponentsGenerator {
	private final int ALLOTTED_WATER_PER_PERSON = 300;
	private int totalGuestWaterPrice;
	private int totalWaterConsumption;

	public void start(int noOfGuests) {
		setTotalWaterConsumption(noOfGuests * ALLOTTED_WATER_PER_PERSON);
		waterPriceCalculator();
	}
	private void waterPriceCalculator() {
		int temp = getTotalWaterConsumption();
		int price = (temp<501) ? (temp*2) :
						(temp<1501) ? (1000 + ((temp - 500) * 3)) :
							(temp<3001) ? (4000 + ((temp - 1500) * 5)) :
								(11500 + ((temp - 3000) * 8));
		setTotalGuestWaterPrice(price);
	}
	public int getTotalGuestWaterPrice() {
		return totalGuestWaterPrice;
	}
	public void setTotalGuestWaterPrice(int totalGuestWaterPrice) {
		this.totalGuestWaterPrice = totalGuestWaterPrice;
	}
	public int getTotalWaterConsumption() {
		return totalWaterConsumption;
	}
	public void setTotalWaterConsumption(int totalWaterConsumption) {
		this.totalWaterConsumption = totalWaterConsumption;
	}
	
}