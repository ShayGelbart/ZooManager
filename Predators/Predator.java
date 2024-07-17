package Predators;

import Animal.Animal;

public abstract class Predator extends Animal{

	private final double FEMALE_RATIO = 0.03;
	private final double MALE_RATIO = 0.02;

	protected double weight;
	protected String name;
	protected double foodToEat;
	protected Gender gender;
	public final static int lifeSpan = 15;

	public Predator(int age, double weight, String name, Gender gender) {
		super(age);
		this.weight = weight;
		this.name = name;
		this.gender = gender;
		this.foodToEat = calculateFoodToEat(age, weight, gender);
	}

	private double calculateFoodToEat(int age, double weight, Gender gender) {

		double amountOfFood;
		// TODO Auto-generated method stub
		if (gender == Gender.FEMALE) {
			amountOfFood = ((age * weight) * FEMALE_RATIO);

		} else
			amountOfFood = ((age * weight) * MALE_RATIO);

		return amountOfFood;
	}

	public double feed() {
		return foodToEat;
	}

	public int getAge() {
		return age;
	}

	public double getWeight() {
		return weight;
	}

	public String getName() {
		return name;
	}

	public void ageOneYear() {
		age += 1;
	}

	public Gender getGender() {
		return gender;
	}

	public abstract String makeNoise();

}