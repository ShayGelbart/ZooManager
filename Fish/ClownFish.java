package Fish;

public class ClownFish extends Fish {

	public ClownFish(int age, double length, Colour[] colour) {
		super(age, length);
		this.colour = colour;
		this.numberOfPortions = 2;
		this.pattern = Pattern.LINES;
		ClownFish.lifeSpan = 8;

		// TODO Auto-generated constructor stub
	}
	public String FishInfo() {
		String fish = "";
		fish = "The Clown fish is " + age + " years old, " + length + " cm length, and eats " + numberOfPortions
				+ " number of portions a day.\n " + " has " + pattern + " pattern, and happiness is: "+happiness  + " and has: ";
		for (int i = 0; i < colour.length; i++) {
			fish += colour[i] + " ";
		}
		fish += "colours.\n";
		return fish;
	}

}
