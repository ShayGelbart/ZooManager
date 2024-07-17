package Promotion;

public class Promotion {

	private String name;
	private String description;
	private int discount;
	private boolean isActive;

	public Promotion(String name, String description, int discount) {
		this.name = name;
		this.description = description;
		this.discount = discount;
		this.isActive = true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		return description + "\n";
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
}
