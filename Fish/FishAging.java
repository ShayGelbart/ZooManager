package Fish;

import java.util.List;

import Animal.AnimalAgingTemplate;

public class FishAging extends AnimalAgingTemplate<Fish> {
    private List<Fish> fishInZoo;
    private int numberOfFish;

    public FishAging(List<Fish> fishInZoo, int numberOfFish) {
        this.fishInZoo = fishInZoo;
        this.numberOfFish = numberOfFish;
    }

    @Override
    protected List<Fish> getAnimals() {
        return fishInZoo;
    }
    
    @Override
	protected int getNumberOfAnimals() {
		return this.numberOfFish;
	}
    
    @Override
    protected void removeFromZoo(int index) {
        fishInZoo.remove(index);
    }

    @Override
    protected int getLifeSpan(Fish fish) {
        return Fish.lifeSpan; // Assuming lifeSpan is an instance variable in Fish
    }
}

// Similarly, you can create classes for LionAging and TigerAging if needed
