package Ticket;

import Utilities.DateUtil;

public class Ticket {
	private static int nextTicketNum = 1;
	private int ticket_num;
	private int person_id;
	private String type;
	private int price;
	private boolean cancellable;
	private DateUtil issue_date;
	private DateUtil expiration_date;
	private final int EXPIRATION_PERIOD = 90;

	public Ticket(int person_id, String type) {
		this.ticket_num = nextTicketNum++;
		this.person_id = person_id;
		this.type = type;
		this.price = TicketType.getInstance().getPriceByType(type);
		this.cancellable = true;
		this.issue_date = new DateUtil();
		this.expiration_date = new DateUtil(EXPIRATION_PERIOD);
	}

	public int getTicket_num() {
		return ticket_num;
	}

	public void setTicket_num(int ticket_num) {
		this.ticket_num = ticket_num;
	}

	public int getPerson_id() {
		return person_id;
	}

	public void setPerson_id(int person_id) {
		this.person_id = person_id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public boolean getCancellable() {
		return cancellable;
	}

	public void setCancellable(boolean cancellable) {
		this.cancellable = cancellable;
	}

	public DateUtil getIssue_date() {
		return issue_date;
	}

	public void setIssue_date(DateUtil issue_date) {
		this.issue_date = issue_date;
	}

	public DateUtil getExpiration_date() {
		return expiration_date;
	}

	public void setExpiration_date(DateUtil expiration_date) {
		this.expiration_date = expiration_date;
	}

	@Override
	public String toString() {
		return "Ticket:\n"+"number: " + ticket_num + ", customer id: " + person_id + ", Type: " + type
				+ ", price: " + price + "\n" +"Issued: " + issue_date
				+ ", expiration date: " + expiration_date;
	}

}
