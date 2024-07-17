

import java.util.ArrayList;

import EmployeeAndVisitor.EmployeeManager;
import EmployeeAndVisitor.PeopleManager;
import EmployeeAndVisitor.Visitor;
import Promotion.Promotion;
import Promotion.PromotionManager;
import Ticket.Ticket;
import Ticket.TicketManager;
import Ticket.TicketType;
import Utilities.DateUtil;
import Utilities.EntryManager;
import Utilities.Observable;
import Utilities.Observer;
import Utilities.PasswordManager;
import Utilities.VisitorException;

public class VisitorManager implements TicketManager, Observable, PeopleManager<Visitor, Integer> {

	private ArrayList<Visitor> visitorList;
	private ArrayList<Ticket> ticketList;
	private static VisitorManager instance;
	public EmployeeManager employeeManager;
	public PasswordManager passwordManager;
	public PromotionManager promotionManager;
	public TicketType ticketType;
	public EntryManager entryManager;

	private VisitorManager() {
		this.visitorList = new ArrayList<>();
		this.ticketList = new ArrayList<>();
		this.employeeManager = EmployeeManager.getInstance();
		this.passwordManager = PasswordManager.getInstance();
		this.promotionManager = PromotionManager.getInstance();
		this.ticketType = TicketType.getInstance();
		this.entryManager = EntryManager.getInstance();
	}

	public ArrayList<Ticket> getTicketList() {
		return ticketList;
	}

	public ArrayList<Visitor> getVisitorList() {
		return visitorList;
	}

	public static VisitorManager getInstance() {
		if (instance == null) {
			instance = new VisitorManager();
		}
		return instance;
	}

	public void isVisitorExist(int id) throws VisitorException {
		for (Visitor visitor : this.visitorList) {
			if (visitor.getId() == id) {
				return;
			}
		}
		throw new VisitorException("You're not registerd as a Visitor");
	}

	@Override
	public void buyTicket(int id, String type, Visitor visitor) {
		Ticket ticket = new Ticket(id, type);
		PromotionManager promotionManager = PromotionManager.getInstance();
		int newPrice = 0;
		double perc = 0;
		if (promotionManager.getIsActivePromotion() == true) {
			perc = (100.0 - promotionManager.getDiscountOfActivePromotion()) / 100.0;
			newPrice = (int) (ticket.getPrice() * perc);
			ticket.setPrice(newPrice);
		}
		visitor.setTicket(ticket);
		ticketList.add(ticket);
	}

	@Override
	public boolean cancelTicket(Visitor visitor) {
		if (visitor.getTicket().getCancellable() == true) {
			visitor.getTicket().setExpiration_date(new DateUtil());
			visitor.getTicket().setCancellable(false);
			visitor.setTicket(null);
			return true;
		}
		return false;
	}

// could be implemented but not needed because of addVisitor
//	@Override
//	public void addObserver(Observer observer) {
//		this.visitorList.add((Visitor) observer);
//	}

	@Override
	public void removeObserver(Observer observer) {
		this.visitorList.remove(observer);
	}

	@Override
	public String notifyObservers(Promotion promotion) {
		String str = "";
		for (Observer observer : this.visitorList) {
			str += observer.update(promotion);
		}
		return str;
	}

	@Override
	public String printHistoryById(int id) {
		String str = "";
		for (Ticket ticket : this.ticketList) {
			if (ticket.getPerson_id() == id)
				str += ticket + "\n";
		}
		return str;
	}

	public String printHistoryByDate(String date) {
		String str = "";
		for (Ticket ticket : this.ticketList) {
			if (ticket.getIssue_date().getDate().equals(date))
				str += ticket + "\n";
		}
		return str;
	}

	@Override
	public String toString() {
		String str = "";
		for (Visitor visitor : this.visitorList) {
			str += visitor + "\n";
		}
		for (Ticket ticket : this.ticketList) {
			str += ticket + "\n";
		}
		return str;
	}

	@Override
	public void add(Visitor item) {
		this.visitorList.add(item);
	}

	@Override
	public boolean remove(Integer identifier) throws VisitorException {
		Visitor visitor = findByIdentifier(identifier);
		if (visitor != null) {
			visitorList.remove(visitor);
			return true;
		}
		return false;
	}

	@Override
	public Visitor findByIdentifier(Integer identifier) throws VisitorException {
		isVisitorExist(identifier);
		for (Visitor visitor : this.visitorList) {
			if (visitor.getId() == identifier) {
				return visitor;
			}
		}
		return null; // Return null if no visitor with the given ID is found
	}

}
