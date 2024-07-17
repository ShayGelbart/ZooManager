package Utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Ticket.Ticket;
import Ticket.TicketType;


public class EntryManager {
	private ArrayList<Ticket> usedTickets;
	private Map<Integer, ArrayList<DateUtil>> visitHistory; // Maps Visitor ID to list of visit dates
	private static EntryManager instance;

	private EntryManager() {
		this.usedTickets = new ArrayList<>();
		this.visitHistory = new HashMap<>();
	}

	public static EntryManager getInstance() {
		if (instance == null) {
			instance = new EntryManager();
		}
		return instance;
	}

	public void addTicket(Ticket ticket) {
		this.usedTickets.add(ticket);
		ticket.setCancellable(false);
		if (TicketType.getInstance().getPriceByType(ticket.getType()) <= 100) { // if it isn't a subscription
			ticket.setExpiration_date(new DateUtil());
		}
	}

	public void recordVisit(int visitorId) {
		DateUtil visitDate = new DateUtil();
		if (!visitHistory.containsKey(visitorId)) {
			visitHistory.put(visitorId, new ArrayList<>());
		}
		visitHistory.get(visitorId).add(visitDate);
	}

	public ArrayList<Ticket> getUsedTickets() {
		return usedTickets;
	}

	public ArrayList<DateUtil> getVisitorHistory(int visitorId) {
		return visitHistory.getOrDefault(visitorId, new ArrayList<>());
	}

	public int getVisitorCountOnDate(DateUtil date) {
		int count = 0;
		for (ArrayList<DateUtil> visits : visitHistory.values()) {
			for (DateUtil visitDate : visits) {
				if (visitDate.equals(date)) {
					count++;
				}
			}
		}
		return count;
	}

	public String visitorEntrancesById(int visitorId) {
		ArrayList<DateUtil> visitorVisits = visitHistory.getOrDefault(visitorId, new ArrayList<>());
		if(visitorVisits.size() == 0)
			return "No visits recorded for this ID";
		StringBuilder str = new StringBuilder("Visitor Entrances (ID: " + visitorId + "):\n");
		for (DateUtil visitDate : visitorVisits) {
			str.append(visitDate).append("\n");
		}
		return str.toString();
	}

	public String entrancesOnDate(DateUtil date) {
	    StringBuilder str = new StringBuilder("Entrances on " + date + ":\n");
	    boolean foundVisits = false;

	    for (Map.Entry<Integer, ArrayList<DateUtil>> entry : visitHistory.entrySet()) {
	        for (DateUtil visitDate : entry.getValue()) {
	            if (visitDate.getDate().equals(date.getDate())) {
	                str.append("Visitor ID: ").append(entry.getKey()).append(", Visit Date: ").append(visitDate)
	                        .append("\n");
	                foundVisits = true;
	            }
	        }
	    }

	    if (!foundVisits) {
	        str.append("No visits recorded on ").append(date).append("\n");
	    }

	    return str.toString();
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder("Used Tickets:\n");
		for (Ticket ticket : usedTickets) {
			str.append(ticket).append("\n");
		}
		str.append("Visit History:\n");
		for (Map.Entry<Integer, ArrayList<DateUtil>> entry : visitHistory.entrySet()) {
			str.append("Visitor ID: ").append(entry.getKey()).append(", Visits: ").append(entry.getValue())
					.append("\n");
		}
		return str.toString();
	}
}
