package EmployeeAndVisitor;

import Promotion.Promotion;
import Ticket.Ticket;
import Utilities.Observer;

public class Visitor extends Person implements Observer{
	private Ticket ticket;

	public Visitor(int id, String first_name, String last_name, int day_of_birth, int month_of_birth, int year_of_birth,
			String phone_num, Ticket ticket) {
		super(id, first_name, last_name, day_of_birth, month_of_birth, year_of_birth, phone_num);
		this.ticket = ticket;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	@Override
	public String toString() {
		return "Visitor:\n" + super.toString();
	}

	@Override
	public String update(Promotion promotion) {
		return "Hello " + super.first_name + ",\nNew promotion is available:\n" + promotion.toString() + "\n";
	}
	
	
}
