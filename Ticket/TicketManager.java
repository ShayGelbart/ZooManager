package Ticket;

import EmployeeAndVisitor.Visitor;

public interface TicketManager {

	public void buyTicket(int id, String type, Visitor visitor);

	public boolean cancelTicket(Visitor visitor);

	public String printHistoryById(int id);
	
	public String printHistoryByDate(String date);
}
