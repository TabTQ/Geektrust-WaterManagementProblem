package com.mypack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class BillGenerator {
	private int totalWaterAmount;
	private int totalWaterPrice;
	
	@Autowired
	private ResidentComponentsGenerator rcg;
	
	@Autowired
	private GuestComponentsGenerator gcg;
	
	public void start(int corporationWaterRatio, int borewellWaterRatio, 
							int noOfResidents, int noOfGuests) {
		rcg.start(noOfResidents, corporationWaterRatio, borewellWaterRatio);
		gcg.start(noOfGuests);
		
		int tempAmount = rcg.getTotalWaterConsumption()+gcg.getTotalWaterConsumption();
		int tempPrice = rcg.getTotalResidentWaterPrice()+gcg.getTotalGuestWaterPrice();
		
		setTotalWaterAmount(tempAmount);
		setTotalWaterPrice(tempPrice);
	}

	public ResidentComponentsGenerator getRcg() {
		return rcg;
	}
	public void setRcg(ResidentComponentsGenerator rcg) {
		this.rcg = rcg;
	}
	public GuestComponentsGenerator getGcg() {
		return gcg;
	}
	public void setGcg(GuestComponentsGenerator gcg) {
		this.gcg = gcg;
	}
	public int getTotalWaterAmount() {
		return totalWaterAmount;
	}
	public void setTotalWaterAmount(int totalWaterAmount) {
		this.totalWaterAmount = totalWaterAmount;
	}
	public int getTotalWaterPrice() {
		return totalWaterPrice;
	}
	public void setTotalWaterPrice(int totalWaterPrice) {
		this.totalWaterPrice = totalWaterPrice;
	}
	
}