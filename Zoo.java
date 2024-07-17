import Penguin.Penguin;
import Penguin.PenguinMemento;
import Penguin.PenguinsIgloo;
import Predators.Gender;
import Predators.Lion;
import Predators.LionAging;
import Predators.Tiger;
import Predators.TigerAging;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import Aligators.Aligator;
import Aligators.AligatorsPit;
import Animal.AnimalAgingTemplate;
import Bees.BeeHive;
import Bees.QueenBee;
import Fish.ClownFish;
import Fish.Colour;
import Fish.Fish;
import Fish.FishAging;
import Fish.GoldFish;
import Fish.AquariumFish;
import Fish.Pattern;

public class Zoo {

	static Scanner scanner = new Scanner(System.in);
	//private final int SIZE_OF_ARRAY = 1000;
	private String name;
	private String address;

	private List<Lion> lionsInZoo = new ArrayList<>();
	private List<Tiger> tigersInZoo = new ArrayList<>();
	private List<Fish> fishInZoo = new ArrayList<>();
	private int numberOfLions;

	private int numberOfTigers;

	BeeHive theOnlyHive = new BeeHive();
	AligatorsPit pit = new AligatorsPit();

	PenguinsIgloo penguinsIgloo = new PenguinsIgloo();
	private int numberOfPenguins = penguinsIgloo.numberOfOurPenguins();

	private int numberOfBees = theOnlyHive.getCapacity();

	private int numberOfAllFish = 0;
	private int numberOfNoyFish = 0;
	private int numberOfGoldFish = 0;
	private int numberOfClownFish = 0;
	private double foodEatenByNoyFish = 0;
	private double foodEatenByClownFish = 0;
	private double foodEatenByGoldFish = 0;

	private boolean[] allFishColours = new boolean[10];
	private int numberOfAllColoursInFish = 0;
	public Colour[] allColours = Colour.values();
	private Pattern[] allPatterns = Pattern.values();

	private PenguinMemento memento;
	Random random = new Random(System.currentTimeMillis());

//Zoo functions start 
	public Zoo(String name, String address) {
		// this.numberOfAnimals = numberOfAnimals;
		this.address = address;
		this.name = name;

	}

	public Zoo() {
		this.address = "Default address ";
		this.name = "Default Name";
	}

	public String toString() {
		return "Our Zoo is called " + name + " and located at " + address + ".\n" + "It has " + numberOfLions
				+ " lions.\n" + "It has " + numberOfTigers + " tigers.\n" + "It has " + numberOfNoyFish + " noy fish.\n"
				+ "It has " + numberOfClownFish + " Clown Fish.\n" + "It has " + numberOfGoldFish
				+ " number of Gold Fish.\n" + "It has " + numberOfPenguins + " penguins.\n" + "It has " + numberOfBees
				+ " bees.\n" + "It has " + pit.aligatorsAmount() + " aligators\n";
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public void listenToAllAnimals() {
		// TODO Auto-generated method stub
		String text = "";
		for (int i = 0; i < numberOfLions; i++)
			text += " " + lionsInZoo.get(i).makeNoise();

		for (int j = 0; j < numberOfTigers; j++)
			text += " " + tigersInZoo.get(j).makeNoise();

		text += " " + penguinsIgloo.NoiseAllPenguins();

		for (int k = 0; k < numberOfAllFish; k++)
			text += " " + fishInZoo.get(k).makeNoise();

		text += theOnlyHive.makeNoise();

		text += pit.makeNoise();

		System.out.println(text);
	}

	public void ageOneYearToAllAnimalsInTheZoo() {
		AnimalAgingTemplate<Fish> fishAging = new FishAging(fishInZoo, fishInZoo.size());
		AnimalAgingTemplate<Lion> lionAging = new LionAging(lionsInZoo, numberOfLions);
		AnimalAgingTemplate<Tiger> tigerAging = new TigerAging(tigersInZoo, numberOfTigers);

		fishAging.ageOneYear();
		lionAging.ageOneYear();
		tigerAging.ageOneYear();

		// Handle the aging of other animals
		theOnlyHive.ageOneYear();
		pit.ageOneYear();
		penguinsIgloo.ageOneYearAllPenguins();

		System.out.println("One Year passed! All animals aged.");

//		int randomHappinessDecrease = 0;
//		for (int i = 0; i < numberOfLions; i++) {
//			lionsInZoo[i].ageOneYear();
//			if (lionsInZoo[i].getAge() > Lion.lifeSpan) {
//				removeFromZoo(i, lionsInZoo, numberOfLions);
//				numberOfLions--;
//			} else {
//				randomHappinessDecrease = 1 + random.nextInt(50);
//				lionsInZoo[i].changeHappiness(-randomHappinessDecrease);
//				if (lionsInZoo[i].getHappiness() <= 0) {
//					removeFromZoo(i, lionsInZoo, numberOfLions);
//					numberOfLions--;
//				}
//			}
//		}
//
//		for (int j = 0; j < numberOfTigers; j++) {
//			tigersInZoo[j].ageOneYear();
//			if (tigersInZoo[j].getAge() > Tiger.lifeSpan) {
//				removeFromZoo(j, tigersInZoo, numberOfTigers);
//				numberOfTigers--;
//			} else {
//				randomHappinessDecrease = 1 + random.nextInt(50);
//				tigersInZoo[j].changeHappiness(-randomHappinessDecrease);
//				if (tigersInZoo[j].getHappiness() <= 0) {
//					removeFromZoo(j, tigersInZoo, numberOfTigers);
//					numberOfTigers--;
//
//				}
//			}
//		}
//
//		for (int k = 0; k < numberOfAllFish; k++) {
//			fishInZoo[k].ageOneYear();
//			if (fishInZoo[k].getAge() > fishInZoo[k].lifeSpan) {
//				removeFromZoo(k, fishInZoo, numberOfAllFish);
//				numberOfAllFish--;
//			} else {
//				randomHappinessDecrease = 1 + random.nextInt(50);
//				fishInZoo[k].changeHappiness(-randomHappinessDecrease);
//				if (fishInZoo[k].getHappiness() <= 0) {
//					removeFromZoo(k, fishInZoo, numberOfAllFish);
//					numberOfAllFish--;
//
//				}
//			}
//		}
//		theOnlyHive.ageOneYear();
//		pit.ageOneYear();
//		penguinsIgloo.ageOneYearAllPenguins();
//
//		System.out.println("One Year passed!All animals aged.");

	}

	public <T> void removeFromZoo(int index, T[] animalsInZoo, int numberOfAnimals) {

		for (int i = index; i < numberOfAnimals - 1; i++) {
			animalsInZoo[i] = animalsInZoo[i + 1];
		}
		animalsInZoo[numberOfAnimals - 1] = null;

	}

	public void feedTheAnimalsInTheZoo() {

		System.out.println("Lions in the zoo ate " + theFoodEatenByLions(lionsInZoo) + " kg of meat");
		System.out.println("All Fish in the zoo ate " + theFoodEatenByAllFish(fishInZoo) + " portions of food");
		System.out.println("Penguins in the zoo ate " + penguinsIgloo.foodAllPenguinsEat() + " fish");
		System.out.println("Tigers in the zoo ate " + theFoodEatenByTigers(tigersInZoo) + " kg of meat");
		System.out.println("Gold Fish in the zoo ate " + foodEatenByGoldFish + "portions of food");
		System.out.println("Clown Fish in the zoo ate " + foodEatenByClownFish + " portions of food");
		System.out.println("Noy Fish in the zoo ate " + foodEatenByNoyFish + " portions of food");
		System.out.println("Bees in the zoo ate " + theOnlyHive.getFood() + " flowers ");
		System.out.println("Aligators ate " + pit.getFood() + " kg of meat");

		pit.happinessAfterFood();

		theOnlyHive.happinessAfterFood();

		for (int i = 0; i < numberOfLions; i++)
			lionsInZoo.get(i).setHappiness(100);

		for (int j = 0; j < numberOfTigers; j++)
			tigersInZoo.get(j).setHappiness(100);

		penguinsIgloo.changeHappiness(100);

		for (int k = 0; k < numberOfAllFish; k++)
			fishInZoo.get(k).setHappiness(100);

	}

//Zoo functions end
//Penguin functions start
	public void addPenguin(Penguin newPenguin) {
		// if(newPenguin.getHeight()==200)
		penguinsIgloo.addPenguin(newPenguin);
		numberOfPenguins++;
		penguinsIgloo.sortPenguins(2);

	}

	public void showAllPenguinsInZoo() {
		// TODO Auto-generated method stub
		System.out.println(penguinsIgloo.showAllPenguins());

	}

	public void checkInputForPenguin(int newPenguinAge, double newPenguinHeight, String newPenguinName)
			throws PenguinException {
		// TODO Auto-generated method stub
		if (newPenguinHeight < 10)
			throw new PenguinException("Your Penguin height is not correct!");
		else if (newPenguinHeight >= 200)
			throw new PenguinException("Your Penguin Height is bigger than our Big Mama!");
		else if (newPenguinAge < 1 || newPenguinAge > 6)
			throw new PenguinException("Your Penguin age is not correct.Try Again.");

	}

	public void rearangePenguinsInZoo(int choice) {
		// TODO Auto-generated method stub
		penguinsIgloo.sortPenguins(choice);
	}
//Penguins functions end

//Lions And Tigers functions start
	public Lion addLion(int newLionAge, double newLionWeight, String newLionName, Gender newLionGender) {

		Lion newLion = new Lion(newLionAge, newLionWeight, newLionName, newLionGender);
		lionsInZoo.add(newLion);
		numberOfLions++;
		return newLion;
	}

	public double theFoodEatenByLions(List<Lion> lionsInZoo2) {

		double allTheFood = 0;

		for (int i = 0; i < numberOfLions; i++) {

			allTheFood += (lionsInZoo2.get(i).feed());
		}

		return allTheFood;
	}

	public String getLionsInZoo() {
		String myText = "";

		for (int i = 0; i < numberOfLions; i++) {
			myText += lionsInZoo.get(i).toString() + "\n";
		}
		return myText;

	}

	public int getNumberOfLions() {
		return numberOfLions;
	}

	private double theFoodEatenByTigers(List<Tiger> tigersInZoo2) {
		// TODO Auto-generated method stub
		double allTheFood = 0;

		for (int i = 0; i < numberOfTigers; i++) {

			allTheFood += (tigersInZoo.get(i).feed());
		}

		return allTheFood;
	}

	public String getTigersInZoo() {
		String myText = "";

		for (int i = 0; i < numberOfTigers; i++) {
			myText += tigersInZoo.get(i).toString() + "\n";
		}
		return myText;

	}

	public int getNumberOfTigers() {
		return numberOfTigers;
	}

	public Tiger addTiger(int newTigerAge, double newTigerWeight, String newTigerName, Gender newTigerGender) {
		// TODO Auto-generated method stub

		Tiger newTiger = new Tiger(newTigerAge, newTigerWeight, newTigerName, newTigerGender);
		tigersInZoo.add(newTiger);
		numberOfTigers++;
		return newTiger;
	}

	// Lions and Tigers functions end

	// Fish functions start

	public String addFish(int numberOfFishToAddToOurZoo) {
		String text = "";
		int randomNumberOfFish = random.nextInt(numberOfFishToAddToOurZoo);

		// create random number of noy fish
		for (int i = 0; i < randomNumberOfFish; i++) {

			int age = 1 + random.nextInt(24);
			double length = random.nextDouble(50.0);
			int patternIndex = random.nextInt(allPatterns.length);
			Pattern pattern = allPatterns[patternIndex];
			int numberOfColours = 1 + random.nextInt(9);
			Colour[] coloursOfFish = new Colour[numberOfColours];
			for (int j = 0; j < numberOfColours; j++) {

				int colourIndex;
				do {
					colourIndex = random.nextInt(allColours.length);
				} while (colourAlreadyAdded(coloursOfFish, colourIndex, j));

				coloursOfFish[j] = allColours[colourIndex];
				allFishColours[colourIndex] = true;

			}
			fishInZoo.add(new AquariumFish(age, length, pattern, coloursOfFish));
			numberOfNoyFish++;
			text += fishInZoo.get(numberOfAllFish++).FishInfo();
		}

		numberOfFishToAddToOurZoo = numberOfFishToAddToOurZoo - randomNumberOfFish;
		randomNumberOfFish = random.nextInt(numberOfFishToAddToOurZoo);

		// create random number of gold fish
		for (int i = 0; i < randomNumberOfFish; i++) {

			int age = 1 + random.nextInt(11);
			double length = random.nextDouble(50.0);
			Colour[] colour = new Colour[1];

			Colour[] coloursOfGoldFish = { Colour.BLACK, Colour.ORANGE, Colour.GOLD, Colour.WHITE };

			int colourIndex = random.nextInt(coloursOfGoldFish.length - 1);
			colour[0] = coloursOfGoldFish[colourIndex];

			fishInZoo.add(new GoldFish(age, length, colour));
			numberOfGoldFish++;
			text += fishInZoo.get(numberOfAllFish++).FishInfo();
		}
		numberOfFishToAddToOurZoo -= randomNumberOfFish;

		// create remaining number of Clown fish
		for (int i = 0; i < numberOfFishToAddToOurZoo; i++) {

			int age = 1 + random.nextInt(7);
			double length = random.nextDouble(50.0);
			Colour[] colour = { Colour.ORANGE, Colour.BLACK, Colour.WHITE };

			fishInZoo.add(new ClownFish(age, length, colour));
			numberOfClownFish++;
			text += fishInZoo.get(numberOfAllFish++).FishInfo();
		}

		return text;

	}

	public double theFoodEatenByAllFish(List<Fish> fishInZoo2) {

		double allTheFood = 0;

		for (int i = 0; i < numberOfAllFish; i++) {
			if (fishInZoo2.get(i) instanceof AquariumFish) {
				foodEatenByNoyFish += fishInZoo2.get(i).feed();
				allTheFood += fishInZoo2.get(i).feed();
			}

			if (fishInZoo2.get(i) instanceof ClownFish) {
				foodEatenByClownFish += fishInZoo2.get(i).feed();
				allTheFood += fishInZoo2.get(i).feed();

			}

			if (fishInZoo2.get(i) instanceof GoldFish) {
				foodEatenByGoldFish += fishInZoo2.get(i).feed();
				allTheFood += fishInZoo2.get(i).feed();

			}

		}

		return allTheFood;
	}

	public String getFishInZoo() {
		String myText = "We have " + numberOfAllFish + " fish in our Aquarium.\n";

		for (int j = 0; j < numberOfAllFish; j++) {
			myText += fishInZoo.get(j).FishInfo();
		}
		myText += "All fish have ";
		for (int i = 0; i < allColours.length; i++) {
			if (allFishColours[i] == true)
				myText += " " + allColours[i];
		}
		myText += " colours.\n";

		myText += mainColours();

		return myText;

	}

	public boolean colourAlreadyAdded(Colour[] coloursOfFish, int colourIndex, int currentIndex) {
		for (int k = 0; k < currentIndex; k++) {
			if (coloursOfFish[k] == allColours[colourIndex]) {
				return true;
			}
		}
		return false;
	}

	public String mainColours() {
		int[] temp = new int[allColours.length];
		for (int i = 0; i < numberOfAllFish; i++) {

			for (int j = 0; j < fishInZoo.get(i).getColour().length; j++) {
				for (int k = 0; k < allColours.length; k++) {
					if (fishInZoo.get(i).getColour()[j] == allColours[k])
						temp[k]++;
				}
			}

		}

		String text = "The most common colours are: ";

		int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
		int maxIndex1 = -1, maxIndex2 = -1;

		for (int i = 0; i < temp.length; i++) {
			if (temp[i] > max1) {
				max2 = max1;
				maxIndex2 = maxIndex1;
				max1 = temp[i];
				maxIndex1 = i;
			} else if (temp[i] > max2) {
				max2 = temp[i];
				maxIndex2 = i;
			}
		}

		text += " " + allColours[maxIndex1];
		if (maxIndex2 != -1) {
			text += " " + allColours[maxIndex2];
		}

		return text;
	}

	public int getNumberOfFish() {
		return numberOfAllFish;
	}

	public int getNumberOfGoldFish() {
		return numberOfGoldFish;
	}

	public int getNumberOfClownFish() {

		return numberOfClownFish;
	}

	public Fish addNoyFish(int age, double length, Pattern pattern, Colour[] colours) {
		// TODO Auto-generated method stub
		AquariumFish A = new AquariumFish(age, length, pattern, colours);
		fishInZoo.add(A);
		numberOfAllFish++;
		numberOfNoyFish++;
		return A;
	}

	public Fish addClownFish(int age, double length) {
		// TODO Auto-generated method stub
		Colour[] colour = { Colour.ORANGE, Colour.BLACK, Colour.WHITE };

		ClownFish B = new ClownFish(age, length, colour);
		fishInZoo.add(B);
		numberOfAllFish++;
		numberOfClownFish++;
		return B;
	}

	public Fish addGoldFish(int age, double length, Colour[] colour) {
		// TODO Auto-generated method stub

		ClownFish B = new ClownFish(age, length, colour);
		fishInZoo.add(B);
		numberOfAllFish++;
		numberOfClownFish++;
		return B;
	}

	// Fish functions end
	// Bees function start

	public void addBeeToZoo(QueenBee q2) {
		// TODO Auto-generated method stub
		theOnlyHive.addBee(q2);
	}

	public String getBeesInZoo() {
		return theOnlyHive.toString();
	}

	// Bees function end
	// Aligators function start

	public void addAligator(Aligator newAligator) {
		// TODO Auto-generated method stub
		pit.addAligator(newAligator);
	}

	public String getAligatorsInPit() {
		return pit.toString();
	}

	// Aligators function end

	// Memento function start
	public void createMemento() {
		this.memento = this.penguinsIgloo.createMemento();
	}

	public void loadMemento() {
		this.penguinsIgloo.restoreFromMemento(this.memento);
	}

	public String printValuesOfPattern() {
		// TODO Auto-generated method stub
		String patterns = "";
		for (int i = 0; i < allPatterns.length; i++) {
			patterns += allPatterns[i] + " ";
		}
		return patterns;
	}

	public String printValuesOfColours() {
		// TODO Auto-generated method stub
		String colours = "";
		for (int i = 0; i < allColours.length; i++) {
			colours += allColours[i] + " ";
		}
		return colours;
	}
}