package Ticket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TicketType {

	private Map<String, Integer> ticketMap;
	private ArrayList<String> typeArr;

	private static TicketType instance;

	private TicketType() {
		this.ticketMap = new HashMap<>();
		this.typeArr = new ArrayList<>();
	}

	public static TicketType getInstance() {
		if (instance == null) {
			instance = new TicketType();
		}
		return instance;
	}

	public void addTicketType(String type, int price) {
		this.ticketMap.put(type, price);
		this.typeArr.add(type);
		
	}

	public boolean removeTicketType(String type) {
		if (ticketMap.containsKey(type)) {
			ticketMap.remove(type);
			return true;
		}
		return false;
	}

	public String allTicketTypes() {
		String str = "";
		for (int i = 0; i < this.typeArr.size(); i++) {
			str += i + 1 + ") " + this.typeArr.get(i) + "\n";
		}
		return str;
	}

	public int getPriceByIndex(int index) {
		String type = getTicketTypeByIndex(index);
		return ticketMap.get(type);
	}

	public int getPriceByType(String type) {
		return ticketMap.get(type);
	}

	public int getAmountOfTickets() {
		return this.typeArr.size();
	}

	public String getTicketTypeByIndex(int index) {
		return this.typeArr.get(index);
	}
}