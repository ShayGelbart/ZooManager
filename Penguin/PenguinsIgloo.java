package Penguin;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Random;

public class PenguinsIgloo {
	LinkedList<Penguin> penguinsList = new LinkedList<Penguin>();
	private String name;
	Random random = new Random(System.currentTimeMillis());
	private final int HAPPINESS_DECREASE_BEACAUSE_OF_ANOTHER_YEAR = -random.nextInt(30);

	public PenguinsIgloo() {
		this.name = "Penguins in Antarctica";
	}

	public void addPenguin(Penguin newPenguin) {
		penguinsList.add(newPenguin);
	}

	public String showAllPenguins() {
		String text = "Our penguins Igloo name is " + this.name + " and has a " + penguinsList.size() + " penguins\n";

		for (int i = 0; i < penguinsList.size(); i++) {
			text += " " + penguinsList.get(i).toString();
		}
		return text;
	}

	public String NoiseAllPenguins() {
		String text = "";
		for (int i = 0; i < penguinsList.size(); i++) {
			text += " " + penguinsList.get(i).makeNoise();
		}
		return text;
	}

	public void ageOneYearAllPenguins() {
		changeHappiness(HAPPINESS_DECREASE_BEACAUSE_OF_ANOTHER_YEAR);
		for (int i = 0; i < penguinsList.size(); i++) {
			penguinsList.get(i).ageOneYear();
			if (penguinsList.get(i).getAge() > Penguin.LIFE_SPAN || penguinsList.get(i).getHappiness() <= 0)
				penguinsList.remove(i);

		}

	}

	public void changeHappiness(int change) {
		for (int i = 0; i < penguinsList.size(); i++) {
			penguinsList.get(i).changeHappiness(change);
			if (penguinsList.get(i).getHappiness() >= 100)
				penguinsList.get(i).setHappiness(100);
		}
	}

	public double foodAllPenguinsEat() {
		double numberOfFishAllPenguinsEatPerDay = 0;
		for (int i = 0; i < penguinsList.size(); i++) {
			numberOfFishAllPenguinsEatPerDay += penguinsList.get(i).feed();
		}
		return numberOfFishAllPenguinsEatPerDay;
	}

	public int numberOfOurPenguins() {
		return penguinsList.size();
	}

	public void sortPenguins(int choice) {
		// sort alphabetically
		if (choice == 1) {
			penguinsList.sort(Comparator.comparing(Penguin::getName));

		}
		// sort by height decrease
		if (choice == 2) {
			penguinsList.sort(Comparator.comparing(Penguin::getHeight).reversed());

		}
		// sort by age increase
		if (choice == 3) {
			penguinsList.sort(Comparator.comparingInt(Penguin::getAge));

		}

	}

	public PenguinMemento createMemento() {
		return new PenguinMemento(this.penguinsList);
	}

	public void restoreFromMemento(PenguinMemento memento) {
		this.penguinsList = memento.getSavedContent();
	}
}
