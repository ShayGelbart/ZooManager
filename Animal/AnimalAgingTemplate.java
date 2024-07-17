package Animal;

import java.util.List;
import java.util.Random;

public abstract class AnimalAgingTemplate<T extends Animal> {
    protected abstract List<T> getAnimals();
    protected abstract int getNumberOfAnimals();
    protected abstract void removeFromZoo(int index);
    protected abstract int getLifeSpan(T animal);

    public void ageOneYear() {
        List<T> animals = getAnimals();
        int numberOfAnimals = getNumberOfAnimals();
        int randomHappinessDecrease;

        for (int i = 0; i < numberOfAnimals; i++) {
            animals.get(i).ageOneYear();
            if (animals.get(i).getAge() > getLifeSpan(animals.get(i))) {
                removeFromZoo(i);
                numberOfAnimals--;
            } else {
                randomHappinessDecrease = 1 + new Random().nextInt(50);
                animals.get(i).changeHappiness(-randomHappinessDecrease);
                if (animals.get(i).getHappiness() <= 0) {
                    removeFromZoo(i);
                    numberOfAnimals--;
                }
            }
        }
    }
}
