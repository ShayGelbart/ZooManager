package Predators;

public class Lion extends Predator {
	private final int MAX_MEAT_PER_DAY = 25;

	public Lion(int age, double weight, String name, Gender gender) {
		super(age, weight, name, gender);
		if (this.foodToEat >= MAX_MEAT_PER_DAY)
			this.foodToEat = MAX_MEAT_PER_DAY;

	}

	@Override
	public String toString() {
		return "Lion " + name + " is " + gender + ", " + age + " years old, " + weight + " kg,and eats " + foodToEat
				+ " kg of meat per day, and happiness is: " + happiness;
	}

	@Override
	public String makeNoise() {
		// TODO Auto-generated method stub
		String noise = "ROAR";

		return noise;
	}

}
