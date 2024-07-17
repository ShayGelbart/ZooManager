package Fish;

public class GoldFish extends Fish {

	public GoldFish(int age, double length, Colour[] colour) {
		super(age, length);
		this.numberOfPortions = 1;
		this.pattern = Pattern.PLAIN;
		this.colour = colour;
		GoldFish.lifeSpan = 12;

		// TODO Auto-generated constructor stub
	}

	public String FishInfo() {
		String fish = "";
		fish = "The Gold fish is " + age + " years old, " + length + " cm length, and eats " + numberOfPortions
				+ " number of portions a day.\n " + " has " + pattern + " pattern, and happiness is: " + happiness
				+ " and has: ";
		for (int i = 0; i < colour.length; i++) {
			fish += colour[i] + " ";
		}
		fish += "colours.\n";
		return fish;
	}

}
