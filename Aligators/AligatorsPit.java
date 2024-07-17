package Aligators;

import java.util.ArrayList;
import java.util.Random;

public class AligatorsPit {

	public ArrayList<Aligator> Aligators = new ArrayList<Aligator>();
	Random random = new Random(System.currentTimeMillis());
	private String pitName;

	public AligatorsPit() {
		this.pitName = "Aligators Zen";

	}

	public void addAligator(Aligator newAligator) {
		Aligators.add(newAligator);
	}

	public void ageOneYear() {
		for (int i = 0; i < Aligators.size(); i++) {
			Aligators.get(i).ageOneYear();
			if (Aligators.get(i).Alive() == false)
				removeDead(i);
		}

		if (Aligators.size() > 3) {
			System.out.println("A year have passed a new battle will begin " + " at the " + this.pitName);
			fight(chooseDuo());
		}
	}

	public int aligatorsAmount() {
		return Aligators.size();
	}

	public String makeNoise() {
		String text = "";
		for (int i = 0; i < Aligators.size(); i++) {
			text += Aligators.get(i).getNoise();
		}
		return text;
	}

	public String toString() {
		String text = "Our pit is called " + pitName + " and has " + aligatorsAmount() + " aligators \n";
		for (int i = 0; i < Aligators.size(); i++) {
			text += " " + Aligators.get(i).toString();
		}

		return text;
	}
	//choose 2 aligators for fighting 
	public int[] chooseDuo() {
		int[] aligatorDuo = new int[2];
		boolean aligatorChosen = false;
		int possibeBattle = 0;
		aligatorDuo[0] = random.nextInt(Aligators.size());
		do {
			aligatorDuo[1] = random.nextInt(Aligators.size());
			if (aligatorDuo[1] != aligatorDuo[0])
				aligatorChosen = true;
			else
				possibeBattle++;
		} while (aligatorChosen == false || possibeBattle == 10);
		if (possibeBattle == 10)
			return null;

		return aligatorDuo;

	}
	
	//a function that makes two random aligators from our pit fight the strongest aligator wins

	public void fight(int[] chosenDuo) {
		if (chosenDuo == null)
			System.out.println("Fight is canceledv this year.Sorry!");
		else {

			Aligator firstAligator = Aligators.get(chosenDuo[0]);
			Aligator secondALigator = Aligators.get(chosenDuo[1]);
			int tempStrengthIncrease1 = random.nextInt(3);
			int tempStrengthIncrease2 = random.nextInt(3);

			System.out.println(
					" The battle between " + firstAligator.getName() + " and " + secondALigator.getName() + " begins ");
			// random.nextInt
			if ((firstAligator.getStrengh() * tempStrengthIncrease1) > (secondALigator.getStrengh()
					* tempStrengthIncrease2)) {
				firstAligator.setBattlesWon();
				removeDead(chosenDuo[1]);
				System.out.println(firstAligator.getName() + " won ");
			} else if ((firstAligator.getStrengh() * tempStrengthIncrease1) == (secondALigator.getStrengh()
					* tempStrengthIncrease2)) {
				System.out.println(" No one won both are equaly strong ");

			} else {
				secondALigator.setBattlesWon();
				removeDead(chosenDuo[0]);
				System.out.println(secondALigator.getName() + " won ");
			}
		}

	}

	public double getFood() {
		if (aligatorsAmount() > 0)
			return aligatorsAmount() * Aligators.get(0).foodEaten();
		else
			return 0;
	}

	public void happinessAfterFood() {
		for (int i = 0; i < Aligators.size(); i++) {
			Aligators.get(i).happinessAfterFood();
		}
	}

	public void removeDead(int deadAligator) {
		Aligators.remove(deadAligator);

	}

}
