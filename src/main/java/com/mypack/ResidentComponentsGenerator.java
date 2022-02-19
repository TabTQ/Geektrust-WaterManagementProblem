package com.mypack;
import org.springframework.stereotype.Repository;
@Repository
public class ResidentComponentsGenerator {
	private final int ALLOTTED_WATER_PER_PERSON = 300;
	private int totalResidentWaterPrice;
	private int totalWaterConsumption;

	public void start(int noOfResidents, int corporationWaterRatio, int borewellWaterRatio) {
		waterConsumptionCalculator(noOfResidents);
		waterPriceCalculator(corporationWaterRatio, borewellWaterRatio);
	}
	private void waterConsumptionCalculator(int noOfResidents) {
		int totalWaterConsumption = noOfResidents * ALLOTTED_WATER_PER_PERSON;
		setTotalWaterConsumption(totalWaterConsumption);
	}
	private void waterPriceCalculator(int corporationWaterRatio, int borewellWaterRatio) {
		double corporationWaterPrice = (double)(corporationWaterRatio * totalWaterConsumption)
				/ (corporationWaterRatio + borewellWaterRatio);
		double borewellWaterPrice = (double)(borewellWaterRatio * totalWaterConsumption * 1.5)
				/ (corporationWaterRatio + borewellWaterRatio);
		setTotalResidentWaterPrice((int) (corporationWaterPrice + borewellWaterPrice));
	}
	public int getTotalResidentWaterPrice() {
		return totalResidentWaterPrice;
	}
	public void setTotalResidentWaterPrice(int totalResidentWaterPrice) {
		this.totalResidentWaterPrice = totalResidentWaterPrice;
	}
	public int getTotalWaterConsumption() {
		return totalWaterConsumption;
	}
	public void setTotalWaterConsumption(int totalWaterConsumption) {
		this.totalWaterConsumption = totalWaterConsumption;
	}
}
