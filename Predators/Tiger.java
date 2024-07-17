package Predators;

public class Tiger extends Predator {

	public Tiger(int age, double weight, String name, Gender gender) {
		super(age, weight, name, gender);

	}

	@Override
	public String makeNoise() {
		// TODO Auto-generated method stub
		String noise = "roar";

		return noise;
	}
	public String toString() {
		return "Tiger "+ name + " is " + gender + ", " + age + " years old, " + weight + " kg,and eats " + foodToEat
				+ " kg of meat per day, and happiness is: " + happiness;
	}
}
