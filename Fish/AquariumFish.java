package Fish;

public class AquariumFish extends Fish {

	public AquariumFish(int age, double length, Pattern pattern, Colour[] colour) {
		super(age, length, pattern, colour);
		AquariumFish.lifeSpan = 25;

	}
	public String FishInfo() {
		String fish = "";
		fish = "The Noy fish is " + age + " years old, " + length + " cm length, and eats " + numberOfPortions
				+ " number of portions a day.\n " + " has " + pattern + " pattern, and happiness is: "+ super.happiness + " and has: ";
		for (int i = 0; i < colour.length; i++) {
			fish += colour[i] + " ";
		}
		fish += "colours.\n";
		return fish;
	}

}
