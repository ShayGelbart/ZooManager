# Zoo Manager

## Submitter Details
- **Submitter 1 Name:** Shay Gelbart
- **Submitter 2 Name:** Arina Kuprina

## Software Details
- **Software Name:** Zoo Manager
- **Version:** 3.0
- **VisitorMenu Credentials:**
  - Username: shaygelbart | Password: 1234567
  - Username: arinakuprina | Password: 12345

## Short Description
Zoo Manager is a project developed during our object-oriented programming course, designed to manage a zoo with various animals. The program includes features such as aging animals, feeding them, listening to their sounds, and tracking their happiness and lifespan.

### Key Features:
- Age all animals by one year.
- Feed all animals and make them happy.
- Listen to all animals make sounds.
- Track animal lifespan; animals can die from old age or unhappiness.
- Happiness decreases each year; animals can die if they are not happy.

## Animal Details
- **Penguins**: 
  - Penguins have a "Big Mama" who is the tallest, and no penguin can be taller than her.
  - Sort penguins by height, name (alphabetically), or age.

- **Predators**:
  - Predators have specific food requirements based on gender, age, and weight.

- **Fish**:
  - Includes three types: aquarium fish, goldfish, and clownfish.

- **Bees**:
  - Includes queen bees and common bees.
  - Cannot add common bees to the hive; only queen bees.
  - Once common bees die, no new common bees can be added.

- **Alligators**:
  - Have strength and engage in yearly fights.
  - Two alligators are randomly chosen to fight; the weaker one dies.
  - Fights occur when the "one year later" function is used.

### Visitor Manager
Added in the latest version, the visitor manager handles visitor and ticket management. Functions include:
  - Adding a visitor to the zoo database.
  - Buying and canceling tickets.
  - Finding tickets.
  - Print the purchase and entrance history using the visitor ID or date.
  - Adding promotions and notifying all visitors.
  - Adding new ticket types.
  - Recording zoo entrances.

## Functions/Features
1. **Alligator Fight**: Randomly selects two alligators to fight; the stronger one wins.
2. **Arrange Penguins**: Rearrange penguins by height, name, or age.

## Design Patterns Implemented
1. **Memento**: Allows users to reverse the last penguin sort. Implemented in the PenguinMemento and PenguinsIgloo classes through the `createMemento` and `restoreFromMemento` functions.
2. **Template**: Consolidates duplicate code for iterating through animals. Implemented in specific animal aging classes and the AnimalAgingTemplate class. Used in the Zoo class within the `ageOneYearToAllAnimalsInTheZoo` function.
3. **Singleton**: Ensures only one instance and global access for classes: VisitorManager, EmployeeManager, EntryManager, PasswordManager, TicketType, and PromotionManager.

---
