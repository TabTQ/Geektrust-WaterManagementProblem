package com.mypack;
import java.util.List;

import org.springframework.stereotype.Component;

@Component("ace")
public class CommandExtractor{
	private List<String> inputCommands;
	private List<String> guestCommands;
	private String allotCommand;
	private int corporationWaterRatio;
	private int borewellWaterRatio;

	public void start(List<String> commands) {
		inputCommands=commands;
		allotCommandExtractor();
		guestCommandsExtractor();
		findRatio();
	}
	private void allotCommandExtractor(){
		List<String> commands = getInputCommands();
		setAllotCommand(commands.get(0));
	}
	private void guestCommandsExtractor() {
		List<String> commands = getInputCommands();
		commands.remove(0);
		commands.remove(inputCommands.size()-1);
		setGuestCommands(commands);
	}
	private void findRatio() {
		String corporationBorewellRatio = allotCommand.substring(14, allotCommand.length());
		String[] arr = corporationBorewellRatio.split(":");
		setCorporationWaterRatio(Integer.parseInt(arr[0]));
		setBorewellWaterRatio(Integer.parseInt(arr[1]));
	}
	
	public List<String> getGuestCommands() {
		return guestCommands;
	}
	public void setGuestCommands(List<String> guestCommands) {
		this.guestCommands = guestCommands;
	}
	public int getCorporationWaterRatio() {
		return corporationWaterRatio;
	}
	public void setCorporationWaterRatio(int corporationWaterRatio) {
		this.corporationWaterRatio = corporationWaterRatio;
	}
	public int getBorewellWaterRatio() {
		return borewellWaterRatio;
	}
	public void setBorewellWaterRatio(int borewellWaterRatio) {
		this.borewellWaterRatio = borewellWaterRatio;
	}
	public List<String> getInputCommands() {
		return inputCommands;
	}
	public void setInputCommands(List<String> inputCommands) {
		this.inputCommands = inputCommands;
	}
	public String getAllotCommand() {
		return allotCommand;
	}
	public void setAllotCommand(String allotCommand) {
		this.allotCommand = allotCommand;
	}
}
