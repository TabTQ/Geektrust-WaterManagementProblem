package com.mypack;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component("bc")
@Scope("prototype")
@Lazy
public class Calculator {
	private List<String> input;
	private String allotCommand;
	private List<String> guestCommands;
	private int noOfResidents;
	private int noOfGuest;
	private int corporationWaterRatio;
	private int borewellWaterRatio;
	
	@Autowired
	@Qualifier("rf")
	private ReadFile readFile;
	
	@Autowired
	@Qualifier("ace")
	private CommandExtractor commandExtractor;
	
	@Autowired
	@Qualifier("res")
	private ResidentFinder resFind;
	
	@Autowired
	@Qualifier("guest")
	private GuestFinder guestFind;
	
	@Autowired
	@Qualifier("po")
	private PrintOutput po;
	
	@Autowired
	private BillGenerator billGenerator;
	
	public void start(String name) throws IOException {
		setInput(readFile.inputCommands(name));
		commandExtractor.start(input);
		setAllotCommand(commandExtractor.getAllotCommand());
		setGuestCommands(commandExtractor.getGuestCommands());
		setCorporationWaterRatio(commandExtractor.getCorporationWaterRatio());
		setBorewellWaterRatio(commandExtractor.getBorewellWaterRatio());
		setNoOfResidents(resFind.resFind(allotCommand));
		int temp = (guestCommands.size()!=0) ?
				guestFind.guestFind(guestCommands) : 0;
		setNoOfGuest(temp);
		billGenerator.start(getCorporationWaterRatio(),
								getBorewellWaterRatio(),
									getNoOfResidents(),
										getNoOfGuest());
		po.start(billGenerator.getTotalWaterAmount(), billGenerator.getTotalWaterPrice());
	}
	

	
	public String getAllotCommand() {
		return allotCommand;
	}
	public void setAllotCommand(String allotCommand) {
		this.allotCommand = allotCommand;
	}
	public List<String> getInput() {
		return input;
	}
	public void setInput(List<String> input) {
		this.input = input;
	}
	public List<String> getGuestCommands() {
		return guestCommands;
	}
	public void setGuestCommands(List<String> guestCommands) {
		this.guestCommands = guestCommands;
	}
	public int getNoOfResidents() {
		return noOfResidents;
	}
	public void setNoOfResidents(int noOfResidents) {
		this.noOfResidents = noOfResidents;
	}
	public ResidentFinder getResFind() {
		return resFind;
	}
	public void setResFind(ResidentFinder resFind) {
		this.resFind = resFind;
	}
	public ReadFile getReadFile() {
		return readFile;
	}
	public void setReadFile(ReadFile readFile) {
		this.readFile = readFile;
	}
	public CommandExtractor getCommandExtractor() {
		return commandExtractor;
	}
	public void setCommandExtractor(CommandExtractor commandExtractor) {
		this.commandExtractor = commandExtractor;
	}
	public BillGenerator getBillGenerator() {
		return billGenerator;
	}
	public void setBillGenerator(BillGenerator billGenerator) {
		this.billGenerator = billGenerator;
	}
	public int getNoOfGuest() {
		return noOfGuest;
	}
	public void setNoOfGuest(int noOfGuest) {
		this.noOfGuest = noOfGuest;
	}
	public GuestFinder getGuestFind() {
		return guestFind;
	}
	public void setGuestFind(GuestFinder guestFind) {
		this.guestFind = guestFind;
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
	public PrintOutput getPo() {
		return po;
	}
	public void setPo(PrintOutput po) {
		this.po = po;
	}
}