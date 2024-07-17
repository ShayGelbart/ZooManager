package Penguin;

import Animal.Animal;

public class Penguin extends Animal {
	private final double FISH_EATEN_PER_DAY = 1;
	private double height;
	private String name;
	public final static int LIFE_SPAN = 6;

	public Penguin(int age, double height, String name) {
		super(age);
		this.height = height;
		this.name = name;
	}

	public double feed() {
		return this.FISH_EATEN_PER_DAY;
	}

	public int getAge() {
		return age;
	}

	public double getHeight() {
		return height;
	}

	public String getName() {
		return name;
	}

	public void ageOneYear() {
		age += 1;
	}
	
	public String toString() {
		return "Penguin " + name + " is " + age + " years old " + height + " cm,and eats " + FISH_EATEN_PER_DAY
				+ " fish per day, and happiness is: " + happiness + "\n";
	}

	public String makeNoise() {
		String noise = "squak";

		return noise;
	}

}