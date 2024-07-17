package Predators;

import java.util.List;

import Animal.AnimalAgingTemplate;

public class LionAging extends AnimalAgingTemplate<Lion> {
    private List<Lion> lionsInZoo;
    private int numberOfLions;

    public LionAging(List<Lion> lionsInZoo, int numberOfLions) {
        this.lionsInZoo = lionsInZoo;
        this.numberOfLions = numberOfLions;
    }

    @Override
    protected List<Lion> getAnimals() {
        return lionsInZoo;
    }

    @Override
    protected int getNumberOfAnimals() {
        return numberOfLions;
    }

    @Override
    protected void removeFromZoo(int index) {
        this.lionsInZoo.remove(index);
    }

    @Override
    protected int getLifeSpan(Lion animal) {
        return Lion.lifeSpan;
    }
}
