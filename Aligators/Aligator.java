package Aligators;

import java.util.Random;

import Animal.Animal;

public class Aligator extends Animal {

	private int weight;
	private String name;
	private String BATTLE_CRY = " ratatatata ";
	private boolean alive;
	private int battlesWon;
	private int strength;
	private double MEAT_TO_EAT = 12.75;
	private final static int LIFE_SPAN = 50;
	Random random = new Random(System.currentTimeMillis());

	public Aligator(int weight, int age, String name) {
		super(age);
		this.weight = weight;
		this.name = name;
		this.battlesWon = 0;
		this.alive = true;
		this.strength = 50;

	}

	public int getWeight() {
		return weight;
	}

	public int getAge() {
		return age;
	}

	public int getStrengh() {
		this.strength = (age * 2) + (weight) + (happiness * 3);
		return strength;
	}

	public String getName() {
		return name;
	}

	public int getHappines() {
		return happiness;
	}

	public boolean Alive() {
		return alive;
	}

	public void ageOneYear() {
		age++;
		happiness -= 30;
		if (happiness <= 0 || age > LIFE_SPAN)
			alive = false;
	}

	public String getNoise() {
		return BATTLE_CRY;
	}

	public double foodEaten() {
		return MEAT_TO_EAT;
	}

	public void happinessAfterFood() {

		happiness += (20 + random.nextInt(30));
		if (happiness > 100)
			happiness = 100;
	}

	public String toString() {
		String text = "";
		text += "The aligator's name is " + this.name + " it's age is " + this.age + " it's strength is "
				+ this.strength + "\n" + "The aligator won " + this.battlesWon + " battles and happiness is "
				+ getHappines() + "\n";
		return text;

	}

	public int getBattlesWon() {
		return battlesWon;
	}

	public void setBattlesWon() {
		this.battlesWon++;
	}

}
