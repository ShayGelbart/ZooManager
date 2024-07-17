package Predators;

import java.util.List;

import Animal.AnimalAgingTemplate;

public class TigerAging extends AnimalAgingTemplate<Tiger> {
	private List<Tiger> tigersInZoo;
	private int numberOfTigers;

	public TigerAging(List<Tiger> tigersInZoo, int numberOfTigers) {
        this.tigersInZoo = tigersInZoo;
        this.numberOfTigers = numberOfTigers;
    }

	@Override
	protected List<Tiger> getAnimals() {
		return tigersInZoo;
	}

	@Override
	protected int getNumberOfAnimals() {
		return numberOfTigers;
	}

	@Override
	protected void removeFromZoo(int index) {
		this.tigersInZoo.remove(index);
	}

	@Override
	protected int getLifeSpan(Tiger animal) {
		return Tiger.lifeSpan;
	}
}

