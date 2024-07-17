package Bees;

import java.util.ArrayList;

public class BeeHive {

	private final int STARTING_CAPACITY = 40;
	private final int FLOWERS_PER_QUEEN = 3;
	private int commonBees;
	private ArrayList<QueenBee> queenBees = new ArrayList<QueenBee>();

	public BeeHive() {
		this.commonBees = STARTING_CAPACITY;
	}

	public int getCapacity() {
		return commonBees + queenBees.size();
	}

	public void setCapacity(int capacity) {
		this.commonBees = capacity;
	}

	public int getMaxCapacity() {
		return STARTING_CAPACITY + queenBees.size() * 40;

	}

	public int getFood() {
		return commonBees * 2 + queenBees.size() * FLOWERS_PER_QUEEN;
	}

	public int getHappines() {
		int totalHappines = 0;
		for (int i = 0; i < queenBees.size(); i++) {
			totalHappines += queenBees.get(i).getHappines();
		}
		return totalHappines;
	}

	public String queenToString() {
		String text = "";

		for (int i = 0; i < queenBees.size(); i++) {
			text += i + "." + queenBees.get(i).toString();
		}
		return text;

	}

	public String makeNoise() {
		String text = "";
		for (int i = 0; i < queenBees.size(); i++) {
			text += queenBees.get(i).getNoise() + " - ";
		}
		text += " bzbz";

		return text;

	}

	public void ageOneYear() {
		for (int i = 0; i < queenBees.size(); i++) {
			queenBees.get(i).ageOneYear();
			if (queenBees.get(i).getAlive() == false) {
				removeDead(i);
				i--;
			}

		}

		if (getHappines() >= 200) {
			double possibleExpantion = commonBees * (1 + getHappines() * 0.1);
			if (getMaxCapacity() >= possibleExpantion)
				commonBees = (int) possibleExpantion;
			else
				commonBees = getMaxCapacity();

		} else {
			commonBees = (int) (commonBees * 0.8);
		}
	}

	public void happinessAfterFood() {
		for (int i = 0; i < queenBees.size(); i++) {
			queenBees.get(i).feed();
		}
	}

	public void addBee(QueenBee newQueen) {
		queenBees.add(newQueen);

	}

	public String toString() {
		String text = "";
		text += "The hive has " + queenBees.size() + " queen bee's and it has " + commonBees + " common bee's\n";
		for (int i = 0; i < queenBees.size(); i++) {
			text += " " + queenBees.get(i).toString();
		}

		return text;

	}

	public void removeDead(int deadBee) {
		queenBees.remove(deadBee);

	}

}
