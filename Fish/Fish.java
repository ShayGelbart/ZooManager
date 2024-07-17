package Fish;

import Animal.Animal;

public abstract class Fish extends Animal{
	protected double length;
	protected Pattern pattern;
	protected Colour[] colour;
	protected double numberOfPortions;
	protected final int FISH_PORTION_RATIO =3;
	public static int lifeSpan;

	public Fish(int age, double length) {
		super(age);
		this.age = age;
		this.length = length;
	}

	public Fish(int age, double length, Pattern pattern, Colour[] colour) {
		super(age);
		this.colour = colour;
		this.length = length;
		this.pattern = pattern;
		this.numberOfPortions = calculateFoodToEat(age, length);
	}

	public double feed() {
		return numberOfPortions;
	}

	private double calculateFoodToEat(int age, double length) {

		// TODO Auto-generated method stub
		if (age < FISH_PORTION_RATIO)
			return FISH_PORTION_RATIO;
		else
			return length + FISH_PORTION_RATIO;

	}

	public int getAge() {
		return age;
	}

	public double getLength() {
		return length;
	}

	public Pattern getPattern() {
		return pattern;
	}

	public Colour[] getColour() {
		return colour;
	}
	public void ageOneYear() {
		age+= 1;
	}
	
	public int getHappines() {
		return happiness;
	}
	
	public abstract String FishInfo() ;

	public String makeNoise() {
		String noise = "blob";
		return noise;
	}

}
