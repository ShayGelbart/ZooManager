

---

# ReadMe.txt

## Submitter Details
- Submitter 1 Name: Shay Gelbart
- Submitter 2 Name: Arina Kuprina


## Software Details
- Software Name: Zoo Manager
- Version: 3.0
- Username and Password for VisitorMenu:
	1. shaygelbart	1234567
	2. arinakuprina	12345
- Short Description:
Our program is based on a project we developed in an object-oriented programming course. The project involves managing a zoo with various animals, such as penguins, predators (lions and tigers), alligators, bees, and fish. 
  - You can age all animals by one year.
  - You can feed all animals and make them happy.
  - You can listen to all the animals make sounds.
  - All animals have a lifespan and can die.
  - Animals can also die if they’re not happy. Happiness depends on whether they’ve eaten, and each year they spend in the zoo, they become less happy.

### Animal Details
- **Penguins**: 
  - Our penguins in the zoo have a Big Mama, and no penguin can be taller than her.
  - You can sort penguins by height, name (alphabetically), and age.
  
- **Predators**:
  - All our predators have a certain amount of food they eat, which depends on their gender, age, and weight.
  
- **Fish**:
  - We have three types of fish: aquarium fish, goldfish, and clownfish.
  
- **Bees**:
  - We have queen bees and common bees.
  - You cannot add a common bee to the hive, but you can add a queen bee.
  - Once common bees die, you cannot add new common bees.
  
- **Alligators**:
  - Our alligators have strength, and they have a yearly fight.
  - We randomly choose two alligators to fight; the weaker one dies.
  - Every time you use the "one year later" function, an alligator fight occurs.

### Visitor Manager
In this course, we added a visitor manager to our program. The visitor manager is responsible for visitors and their tickets. You can:
  - Add a visitor to the database of our zoo.
  - Buy a ticket.
  - Cancel a ticket.
  - Find a ticket.
  - Print the history of purchases and entrances by visitor ID number or by date.
  - Add a promotion and notify all visitors about it.
  - Add a new type of ticket.
  - Record an entrance to the Zoo.

## Functions/Features
1. **Alligator Fight**: Randomly chooses two alligators and makes them fight based on their strength; the stronger one wins.
2. **Arrange Penguins**: You can rearrange penguins based on their height, name, or age.


## Added design patterns:
1. **Memento**: Gives the user an option to reverse the last penguin sort. Implemented in PenguinMemento class and in PenguinsIgloo class in functions createMemento and restoreFromMemento. 
2. **Template**: Instead of having duplicate code and iterating through every type of animal, the code is now written only one time and every type of animal uses it. Implemented in every (Insert type of animal)Aging class and in the AnimalAgingTemplate class. Used in Zoo class in function ageOneYearToAllAnimalsInTheZoo.
3. **Singleton**: All of the following classes have only one instance and a global access point: VisitorManager, EmployeeManager, EntryManager, PasswordManager, TicketType, PromotionManager.
---
