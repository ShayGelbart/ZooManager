
import java.util.InputMismatchException;
import java.util.Scanner;

import Aligators.Aligator;
import Bees.QueenBee;
import EmployeeAndVisitor.Employee;
import EmployeeAndVisitor.Visitor;
import Fish.Colour;
import Fish.Fish;
import Fish.Pattern;
import Penguin.Penguin;
import Predators.Gender;
import Promotion.Promotion;
import Promotion.PromotionManager;
import Ticket.Ticket;
import Ticket.TicketType;
import Utilities.DateUtil;

import Utilities.EntryManager;
import Utilities.PasswordManager;

import Utilities.VisitorException;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	// github
	public static void main(String[] args) throws InputMismatchException, VisitorException {
		// TODO Auto-generated method stub
		Zoo myZoo = new Zoo("Safari", "Ramat Gan");
		VisitorManager visitorManager = VisitorManager.getInstance();
		hardcodedInitialize(myZoo, visitorManager);
		System.out.println("Hello,welcome to our project!\n");
		int choice;
		do {
			showMenu();

			choice = readInRange(0, 16, scanner);
			switch (choice) {
			case 1:
				zooDetails(myZoo);
				break;
			case 2:
				seeAllPenguins(myZoo);
				break;
			case 3:
				addPenguinMenu(myZoo);
				break;
			case 4:
				showAllPredatorsInZoo(myZoo);
				break;
			case 5:
				addPredatorMenu(myZoo);
				break;
			case 6:
				seeAllFish(myZoo);
				break;
			case 7:
				addFishToZoo(myZoo);
				break;
			case 8:
				seeAllBeesinHive(myZoo);
				break;
			case 9:
				addBeeToHive(myZoo);
				break;
			case 10:
				seeAllAligatorsInPit(myZoo);
				break;
			case 11:
				addAligatorToPit(myZoo);
				break;
			case 12:
				myZoo.feedTheAnimalsInTheZoo();
				break;
			case 13:
				myZoo.listenToAllAnimals();
				break;
			case 14:
				myZoo.ageOneYearToAllAnimalsInTheZoo();
				break;
			case 15:
				rearangePenguins(myZoo);
				break;
			case 16:
				visitorMenu(visitorManager);
				break;
			}
		} while (choice != 0);
	}

	// Visitor management system
	public static void visitorMenu(VisitorManager visitorManager) throws VisitorException {
		String employeeUserName, pass;

		boolean check = false;
		do {
			System.out.println("Please enter your user name:");
			employeeUserName = checkString(scanner);
			System.out.println("Enter your Password:");
			pass = checkString(scanner);
			check = visitorManager.passwordManager.checkPassword(pass, employeeUserName);
			if (!check)
				System.out.println("Password doesn't match the username. Try again");

		} while (!check);

//		  System.out.println(employeeManager.toString());
//		  System.out.println(passwordManager.toString());

		int choice;
		do {
			showVisitorMenu();
			choice = readInRange(0, 7, scanner);
			switch (choice) {
			case 1:
				buyTicket(visitorManager);
				break;
			case 2:
				cancelTicket(visitorManager);
				break;
			case 3:
				findTicket(visitorManager);
				break;
			case 4:
				printInformation(visitorManager);
				break;
			case 5:
				addPromotion(visitorManager);
				break;
			case 6:
				addNewTicketType(visitorManager);
				break;
			case 7:
				enterZoo(visitorManager);
				break;
			default:
				System.out.println("Try a different number");
			}
		} while (choice != 0);
	}

	private static void showVisitorMenu() {
		System.out.println("1.Purchase a ticket.\n" + "2.Cancel a ticket.\n" + "3.Find a ticket.\n" + "4.Information.\n"
				+ "5.Add a new promotion.\n" + "6.Add new ticket type.\n" + "7.Enter the Zoo.\n"
				+ "0.Exit back to main menu.\n");
	}

	private static void printInformation(VisitorManager visitorManager) {
		int id = 0, choiceFirst = 0, choiceSecond = 0, day, month, year;
		System.out.println("Search by:\n1.Purchase\n2.Entrance");
		choiceFirst = readInRange(1, 2, scanner);
		System.out.println("Search by:\n1.Visitor ID\n2.Date");
		choiceSecond = readInRange(1, 2, scanner);
		if (choiceSecond == 1) {
			System.out.println("Enter your ID");
			id = readInRange(0, 1000000000, scanner);
			if (choiceFirst == 1)
				System.out.println(visitorManager.printHistoryById(id));
			else
				System.out.println(visitorManager.entryManager.visitorEntrancesById(id));
		} else {
			System.out.println("Enter the year of purchase");
			year = readInRange(1900, 2024, scanner);
			System.out.println("Enter the month of purchase");
			month = readInRange(1, 12, scanner);
			System.out.println("Enter the day of purchase");
			day = readInRange(1, checkDate(year, month), scanner);
			DateUtil date = new DateUtil(year, month, day);
			if (choiceFirst == 1)
				System.out.println(visitorManager.printHistoryByDate(date.getDate()));
			else
				System.out.println(visitorManager.entryManager.entrancesOnDate(date));
		}

	}

	// Ticket functions
	private static void buyTicket(VisitorManager visitorManager) throws VisitorException {
		int id = 0;
		System.out.println("Enter your ID");
		id = readInRange(0, 1000000000, scanner);
		Visitor visitor = null;
		try {
			visitor = visitorManager.findByIdentifier(id);
		} catch (VisitorException e) {
			System.out.println("Add a new visitor");
		}
		if (visitor == null)
			visitor = addVisitor(visitorManager);
		System.out.println("What type of ticket do you want?");
		String type = getType(scanner);
		if (visitor.getTicket() != null) {
			visitorManager.cancelTicket(visitor);
		}
		visitorManager.buyTicket(id, type, visitor);
	}

	private static String getType(Scanner scanner) {
		TicketType ticketType = TicketType.getInstance();
		System.out.println(ticketType.allTicketTypes());
		int choice = readInRange(1, ticketType.getAmountOfTickets(), scanner);
		return ticketType.getTicketTypeByIndex(choice - 1);
	}

	private static void cancelTicket(VisitorManager visitorManager) throws InputMismatchException {
		int id;
		boolean finished = false;
		Visitor visitor = null;
		while (!finished) {
			try {
				System.out.println("Enter your ID");
				id = readInRange(0, 1000000000, scanner);
				visitor = visitorManager.findByIdentifier(id);
				finished = true;
			} catch (VisitorException e) {
				System.out.println("Try entering a different ID");
			}
		}
		if (visitorManager.cancelTicket(visitor) == false)
			System.out.println("Failed to cancel ticket");
		else
			System.out.println("Your ticket was successfully cancelled");
	}

	private static void findTicket(VisitorManager visitorManager) throws VisitorException {
		int id = 0;
		System.out.println("Enter your ID");
		id = readInRange(0, 1000000000, scanner);
		Visitor visitor = visitorManager.findByIdentifier(id);
		if (visitor == null) {
			System.out.println("There isn't a visitor with your ID, try again");
			return;
		}
		if (visitor.getTicket() == null)
			System.out.println("You don't have a valid ticket, try purchasing one.");
		else
			System.out.println("Here is your ticket:\n" + visitor.getTicket().toString());
		return;
	}

	// Promotions functions
	private static void addPromotion(VisitorManager visitorManager) {
		System.out.println("What is the name of your promotion?");
		String name = checkString(scanner);
		System.out.println("What is the description of your promotion?");
		String description = checkString(scanner);
		System.out.println("What percentage of discount does your promotion have?");
		int discount = readInRange(1, 99, scanner);
		Promotion promotion = new Promotion(name, description, discount);
		visitorManager.promotionManager.addPromotion(promotion);
		System.out.println(VisitorManager.getInstance().notifyObservers(promotion));
				
	}

	public static void addNewTicketType(VisitorManager visitorManager) {
		System.out.println("What is the Title of the ticket?");
		String description = checkString(scanner);
		System.out.println("How much does the ticket cost?");
		int cost = readInRange(1, 1000, scanner);
		visitorManager.ticketType.addTicketType(description, cost);
	}

	// Visitor functions
	private static Visitor addVisitor(VisitorManager visitorManager) {
		System.out.println("Enter visitor's ID:");
		int id = readInRange(0, 1000000000, scanner);
		System.out.println("Enter first name:");
		String firstName = checkString(scanner);
		System.out.println("Enter last name:");
		String lastName = checkString(scanner);
		System.out.println("Enter year of birth:");
		int year = readInRange(1900, 2024, scanner);
		System.out.println("Enter month of birth:");
		int month = readInRange(1, 12, scanner);
		System.out.println("Enter day of birth:");
		int day = readInRange(1, checkDate(year, month), scanner);
		System.out.println("Enter phone number:");
		String phoneNum = checkString(scanner);
		Visitor visitor = new Visitor(id, firstName, lastName, day, month, year, phoneNum, null);
		visitorManager.getVisitorList().add(visitor);
		return visitor;
	}

	// entrance functions
	private static void enterZoo(VisitorManager visitorManager) throws VisitorException {
		int id = 0;
		System.out.println("Enter your ID");
		id = readInRange(0, 1000000000, scanner);
		Visitor visitor = visitorManager.findByIdentifier(id);
		visitorManager.entryManager.addTicket(visitor.getTicket());
		visitorManager.entryManager.recordVisit(id);
	}

	// Zoo functions
	/**
	 * 
	 * @author Arinushka
	 */
	private static void addAligatorToPit(Zoo myZoo) {
		// TODO Auto-generated method stub

		System.out.println("Choose a name for your aligator:");
		String name = checkString(scanner);
		System.out.println("What is the age of the aligator(1-50):");
		int age = readInRange(1, 50, scanner);
		System.out.println("What is the weight of the aligator(91-200):");
		int weight = readInRange(91, 200, scanner);

		Aligator newAligator = new Aligator(weight, age, name);
		myZoo.addAligator(newAligator);
		System.out.println(newAligator.toString() + " was succesfully added to our Pit!");
	}

	private static void seeAllAligatorsInPit(Zoo myZoo) {
		// TODO Auto-generated method stub
		System.out.println(myZoo.getAligatorsInPit());
	}

	/**
	 * 
	 * @author Andrey
	 */

	private static void addBeeToHive(Zoo myZoo) {
		// TODO Auto-generated method stub

		// theOnlyHive.addBee(q1);
		System.out.println("What is the name of the bee:");
		String queenName = checkString(scanner);
		System.out.println("What is the age of the bee(1-3):");
		int queenAge = readInRange(1, 3, scanner);
		QueenBee q2 = new QueenBee(queenAge, queenName);
		myZoo.addBeeToZoo(q2);
		System.out.println(q2.toString() + " was succesufully added");

	}

	private static void seeAllBeesinHive(Zoo myZoo) {
		// TODO Auto-generated method stub
		System.out.println(myZoo.getBeesInZoo());
	}

	private static void zooDetails(Zoo myZoo) {
		// TODO Auto-generated method stub
		System.out.println(myZoo.toString());

	}

	private static void seeAllPenguins(Zoo myZoo) {

		// TODO Auto-generated method stub
		myZoo.showAllPenguinsInZoo();

	}

	private static void addPenguinMenu(Zoo myZoo) throws InputMismatchException {
		// TODO Auto-generated method stub
		String newPenguinName = null;
		double newPenguinHeight = 0;
		int newPenguinAge = 0;

		boolean finished = false;
		while (!finished) {

			try {
				System.out.println("Please enter the name of the Penguin: ");
				newPenguinName = scanner.nextLine();
				scanner.nextLine();

				System.out.println(
						"Please enter the height of the Penguin, in our Zoo you cannot add penguin that heigher than our Big Mama(200 cm)(10.0-199.9): ");

				newPenguinHeight = scanner.nextDouble();

				System.out.println("Please enter the age of the Penguin(1-6): ");
				newPenguinAge = scanner.nextInt();

				myZoo.checkInputForPenguin(newPenguinAge, newPenguinHeight, newPenguinName);
				finished = true;

			} catch (PenguinException e) {
				System.out.println("Something went wrong.One or more inputs are incorrect.Try again!");

			} catch (InputMismatchException e) {
				System.out.println("Input mismatch exception.Try again!");
			}

		}
		Penguin newPenguin = new Penguin(newPenguinAge, newPenguinHeight, newPenguinName);
		System.out.println(newPenguin.toString() + " was successfully added to our Zoo!");
		myZoo.addPenguin(newPenguin);

	}

	private static void rearangePenguins(Zoo myZoo) {
		int choice = 0;
		// TODO Auto-generated method stub
		myZoo.createMemento();
		System.out.println("Please choose how you want to arange our penguins: \n" + "1.By Name (alphabetically)\n"
				+ "2.By Height(the tallest penguins first)\n" + "3.By Age(the youngest penguins first)");
		choice = readInRange(1, 3, scanner);
		myZoo.rearangePenguinsInZoo(choice);
		System.out.print("Now penguins arranged by ");
		if (choice == 1)
			System.out.println("Name");
		if (choice == 2)
			System.out.println("Height");
		if (choice == 3)
			System.out.println("Age");
		System.out.println("Would you like to undo your sort?Choose:\n1.Yes\n2.No");
		choice = readInRange(1, 2, scanner);
		if(choice == 1) {
			myZoo.loadMemento();
		}
		
		myZoo.showAllPenguinsInZoo();
	}

	private static void showAllPredatorsInZoo(Zoo myZoo) {
		// TODO Auto-generated method stub
		System.out.println("These are our Lions: \n");
		System.out.println(myZoo.getLionsInZoo());
		System.out.println("These are our Tigers: \n");
		System.out.println(myZoo.getTigersInZoo());
	}

	private static void addPredatorMenu(Zoo myZoo) {
		// TODO Auto-generated method stub
		System.out.println("If you want to add a Lion press 1: \n" + "If you want to add a Tiger press 2: \n");
		int choice = scanner.nextInt();

		if (choice == 1) {
			System.out.println("Please enter the name of the Lion: ");

			String newLionName = checkString(scanner);
			System.out.println("Please enter the weight of the Lion(10.0-199.9): ");
			double newLionWeight = readInRange(10.0, 199.9, scanner);
			System.out.println("Please enter the age of the Lion(1-15): ");
			int newLionAge = readInRange(1, 15, scanner);
			System.out.println("If your Lion is male press 1, if female press 2 ");
			Gender newLionGender = null;
			int input = scanner.nextInt();
			if (input == 2)
				newLionGender = Gender.FEMALE;
			if (input == 1)
				newLionGender = Gender.MALE;

			System.out.println(myZoo.addLion(newLionAge, newLionWeight, newLionName, newLionGender).toString()
					+ "was successfully added to our Zoo ");

		} else {

			System.out.println("Please enter the name of the Tiger: ");
			String newTigerName = checkString(scanner);
			System.out.println("Please enter the weight of the Tiger(30.0-310.0): ");
			double newTigerWeight = readInRange(30.0, 310.0, scanner);
			System.out.println("Please enter the age of the Tiger(1-15): ");
			int newTigerAge = readInRange(1, 15, scanner);
			System.out.println("If your Tiger is male press 1, if female press 2 ");
			Gender newTigerGender = null;
			int input = scanner.nextInt();
			if (input == 2)
				newTigerGender = Gender.FEMALE;
			if (input == 1)
				newTigerGender = Gender.MALE;

			System.out.println(myZoo.addTiger(newTigerAge, newTigerWeight, newTigerName, newTigerGender).toString()
					+ "was successfully added to our Zoo ");
		}

	}

	private static void seeAllFish(Zoo myZoo) {
		// TODO Auto-generated method stub

		System.out.println(myZoo.getFishInZoo());
	}

	private static void addFishToZoo(Zoo myZoo) {

		int newchoice;
		int numberOfFishYouWantToAdd;
		Fish B = null;
		System.out.println("If you want to add a fish with your parameters enter 1:\n "
				+ "If you want to add a sertain number of fish enter 2: ");
		newchoice = scanner.nextInt();

		if (newchoice == 1) {

			System.out.println("What type of fish you want to add: " + "1.Aquarium Fish \n" + "2.Gold Fish \n"
					+ "3.Clown Fish \n ");
			newchoice = scanner.nextInt();
			if (newchoice == 1) {
				addAquariumFish(myZoo);

			} else if (newchoice == 2) {
				addGoldFish(myZoo);

			} else if (newchoice == 3) {
				addClownFish(myZoo);
			}

		} else

		{

			System.out.println("Please enter the number of fish you want to add to our Zoo: ");
			numberOfFishYouWantToAdd = scanner.nextInt();

			System.out.println(myZoo.addFish(numberOfFishYouWantToAdd) + " successfully added to our aquarium.\n");

		}
	}

	public static void addClownFish(Zoo myZoo) {
		// TODO Auto-generated method stub
		int age;
		double length = 0;

		System.out.println("Please enter the age of your fish(1-8): ");

		age = readInRange(1, 8, scanner);
		System.out.println("Please enter the length of your fish(1.0-50.0): ");
		length = readInRange(1.0, 50.0, scanner);

		System.out.println(
				"Fish " + myZoo.addClownFish(age, length).FishInfo() + " was successfully added to our aquarium");
	}

	public static void addGoldFish(Zoo myZoo) {
		// TODO Auto-generated method stub
		int age;
		double length = 0;
		Colour[] colour = new Colour[1];

		System.out.println("Please enter the age of your fish(1-12): ");
		age = readInRange(1, 12, scanner);
		System.out.println("Please enter the length of your fish(1.0-50.0): ");
		length = readInRange(1.0, 50.0, scanner);

		System.out.println("Please enter the colour of your fish: " + "BLACK , ORANGE, YELLOW, GOLD");
		colour[0] = Colour.valueOf(scanner.nextLine());

		System.out.println("Fish " + myZoo.addGoldFish(age, length, colour).FishInfo()
				+ " was successfully added to our aquarium");

	}

	public static void addAquariumFish(Zoo myZoo) {
		// TODO Auto-generated method stub
		int age;
		double length = 0;
		Pattern pattern = null;

		System.out.println("Please enter the age of your fish(1-25): ");
		age = readInRange(1, 25, scanner);
		System.out.println("Please enter the length of your fish(1.0-50.0): ");
		length = readInRange(1.0, 50.0, scanner);
		System.out.println("Please enter the pattern of your fish: \n" + myZoo.printValuesOfPattern());

		pattern = Pattern.valueOf(scanner.nextLine());

		System.out.println("Please enter the number of colors your fish has(1-10): ");
		int numberOfColours = readInRange(1, 10, scanner);
		Colour[] colours = new Colour[numberOfColours];
		boolean[] existingColour = new boolean[myZoo.allColours.length];

		for (int i = 0; i < numberOfColours; i++) {
			int colourIndex;

			do {
				System.out.println("Please enter the Colour of your fish: \n"
						+ "1.BLACK 2.WHITE 3.GREEN 4.ORANGE 5.BLUE 6.YELLOW 7.BROWN 8.GOLD 9.RED 10.CYAN");
				colourIndex = readInRange(1, 10, scanner) - 1;

				if (!existingColour[colourIndex]) {
					existingColour[colourIndex] = true;
					colours[i] = myZoo.allColours[colourIndex];
					break;
				} else {
					System.out.println("This color has already been selected. Please choose another one.");
				}
			} while (true);

		}

		System.out.println("Fish " + myZoo.addNoyFish(age, length, pattern, colours).FishInfo()
				+ " was successfully added to our aquarium");
	}

	public static <T extends Number> T readInRange(T min, T max, Scanner scanner) {
		// TODO Auto-generated method stub
		T value = null;
		boolean finished = false;
		while (!finished) {
			try {
				if (min instanceof Integer) {
					value = (T) Integer.valueOf(scanner.nextInt());
				} else if (min instanceof Double) {
					value = (T) Double.valueOf(scanner.nextDouble());
				} else if (min instanceof Long) {
					value = (T) Long.valueOf(scanner.nextLong());
				} else {
					System.out.println("I don't know what type of number this is...");
				}

				if (min.doubleValue() <= value.doubleValue() && value.doubleValue() <= max.doubleValue()) {
					finished = true;
				} else {
					System.out.println("Please enter a valid number: ");
					scanner.nextLine();
				}
			} catch (InputMismatchException e) {
				System.out.println("Please enter a valid number: ");
				scanner.nextLine();
			}

		}
		scanner.nextLine();
		return value;
	}

	public static String checkString(Scanner scanner) {
		String text = null;

		text = scanner.nextLine();

		while (text == null || text.isEmpty()) {
			System.out.println("Please enter a valid string: ");
			text = scanner.nextLine();
		}
		return text;
	}

	private static void showMenu() {
		// TODO Auto-generated method stub
		System.out.println(
				"1.Zoo details.\n" + "2.Information about our penguins.\n" + "3.Add a new penguin to our Zoo.\n"
						+ "4.Information about our predators.\n" + "5.Add a new predator to our Zoo.\n"
						+ "6.Information about our fish.\n" + "7.Add a new fish to our Zoo.\n"
						+ "8.Information about our Bees in The Hive.\n" + "9.Add a new bee to the hive.\n"
						+ "10.Information about our Aligators int the Pit.\n" + "11.Add a new aligator to the pit.\n"
						+ "12.Feed our animals.\n" + "13.Listen to our animals in the Zoo.\n" + "14.ONE YEAR LATER!\n"
						+ "15.Rearange our penguins.\n" + "16.Visitor management system.\n" + "0.EXIT.\n");
	}

	private static int checkDate(int year, int month) {
		int maxDaysInMonth = 0;
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			maxDaysInMonth = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			maxDaysInMonth = 30;
			break;
		case 2:
			if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
				maxDaysInMonth = 29; // Leap year
			} else {
				maxDaysInMonth = 28; // Non-leap year
			}
			break;
		}
		return maxDaysInMonth;
	}

	private static void hardcodedInitialize(Zoo myZoo, VisitorManager visitorManager) {
		// hardcoded zoo
		Penguin BigMama = new Penguin(5, 200, "Big Mama");
		Penguin Archie = new Penguin(2, 160, "Archie");
		Penguin Lily = new Penguin(6, 180, "Lily");
		Penguin p1 = new Penguin(1, 161, "Uku");
		Penguin p2 = new Penguin(4, 120, "Pingu");
		myZoo.addPenguin(p2);
		myZoo.addPenguin(p1);
		myZoo.addPenguin(BigMama);
		myZoo.addPenguin(Archie);
		myZoo.addPenguin(Lily);

		myZoo.addLion(5, 100, "Simba", Gender.MALE);
		myZoo.addLion(13, 160, "Mufasa", Gender.MALE);
		myZoo.addLion(4, 96, "Nala", Gender.FEMALE);
		myZoo.addLion(12, 190, "Sarabi", Gender.FEMALE);

		myZoo.addTiger(7, 79.79, "Lola", Gender.FEMALE);

		myZoo.addFish(10);
		Aligator Joji = new Aligator(115, 15, "Joji");
		Aligator Jiji = new Aligator(160, 12, "Jiji");
		Aligator Jaji = new Aligator(198, 10, "Jaji");
		Aligator Juju = new Aligator(150, 40, "Juju");

		myZoo.addAligator(Joji);
		myZoo.addAligator(Juju);
		myZoo.addAligator(Jiji);
		myZoo.addAligator(Jaji);

		QueenBee q1 = new QueenBee(2, "Maya");
		QueenBee q2 = new QueenBee(1, "Popa");
		QueenBee q3 = new QueenBee(1, "Jopa");
		QueenBee q4 = new QueenBee(1, "Riki");

		myZoo.addBeeToZoo(q1);
		myZoo.addBeeToZoo(q2);
		myZoo.addBeeToZoo(q3);
		myZoo.addBeeToZoo(q4);

		// hardcoded employees
		Employee e1 = new Employee(1, "Arina", "Kuprina", 29, 9, 1999, "0543094030", 1, "arinakuprina");
		Employee e2 = new Employee(2, "Shay", "Gelbart", 3, 7, 2004, "0507343536", 2, "shaygelbart");
		visitorManager.employeeManager.add(e1);
		visitorManager.employeeManager.add(e2);
		visitorManager.passwordManager.addPassword("12345", e1);// addPassword("arinakuprina", "12345");
		visitorManager.passwordManager.addPassword("1234567", e2);// addPassword("shaygelbart", "1234567");

		// hardcoded ticket types
		visitorManager.ticketType.addTicketType("Adult", 71);
		visitorManager.ticketType.addTicketType("Discount", 54);
		visitorManager.ticketType.addTicketType("Disabled", 35);
		visitorManager.ticketType.addTicketType("AdultSubscription", 330);
		visitorManager.ticketType.addTicketType("DiscountSubscription", 245);
		visitorManager.ticketType.addTicketType("CoupleSubscription", 570);
		visitorManager.ticketType.addTicketType("CouplePlus1Subscription", 690);
		visitorManager.ticketType.addTicketType("CouplePlus2Subscription", 750);
		visitorManager.ticketType.addTicketType("CouplePlus3Subscription", 810);
		visitorManager.ticketType.addTicketType("CouplePlus4Subscription", 860);
		visitorManager.ticketType.addTicketType("CouplePlus5Subscription", 915);
		visitorManager.ticketType.addTicketType("CouplePlus6andMoreSubscription", 970);
		visitorManager.ticketType.addTicketType("ParentPlus1Subscription", 515);
		visitorManager.ticketType.addTicketType("ParentPlus2Subscription", 665);
		visitorManager.ticketType.addTicketType("ParentPlus3Subscription", 735);
		visitorManager.ticketType.addTicketType("ParentPlus4Subscription", 755);
		visitorManager.ticketType.addTicketType("ParentPlus5Subscription", 795);
		visitorManager.ticketType.addTicketType("ParentPlus6andMoreSubscription", 830);

		// hardcoded visitors
		Ticket t1 = new Ticket(1, "Adult");
		visitorManager.getTicketList().add(t1);
		visitorManager.add(new Visitor(1, "Shay", "Gelbart", 3, 7, 2004, "0507376784", t1));

		Ticket t2 = new Ticket(2, "Discount");
		visitorManager.getTicketList().add(t2);
		visitorManager.add(new Visitor(2, "Arina", "Kuprina", 12, 5, 1999, "0507556784", t2));

		Ticket t3 = new Ticket(3, "Disabled");
		visitorManager.getTicketList().add(t3);
		visitorManager.add(new Visitor(3, "Yossi", "Cohen", 23, 9, 2001, "0507556784", t3));

		// promotionManager.addPromotion(new Promotion("Default", "No discount", 0));
	}

}
