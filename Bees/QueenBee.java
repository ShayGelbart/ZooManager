package Bees;

import Animal.Animal;

public class QueenBee extends Animal{

	private String name;
	private String noise;
	private int food;
	private String text = "";
	private boolean alive;
	private final static int LIFE_SPAN = 5;

	public QueenBee(int age, String name) {
		super(age);
		this.name = name;
		this.noise = "qabzzzzzz";
		this.food = 3;
		this.alive = true;
	}

	public int getHappines() {
		return happiness;
	}

	public boolean getAlive() {
		return alive;
	}

	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	public String getNoise() {
		return noise;
	}

	public int getFood() {
		return food;
	}

	public void ageOneYear() {
		age++;
		happiness -= 10;
		if (happiness <= 0 || age > LIFE_SPAN) {
			alive = false;
		}

	}

	public void feed() {
		happiness = 100;
	}

	public String toString() {

		text = "The name of the Queen bee is " + this.name + " and it is " + this.age + " years old "
				+ " and happiness is " + getHappines() + "\n";
		return text;

	}
}
