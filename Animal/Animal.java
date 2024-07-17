package Animal;

public abstract class Animal {
	
	protected int age;
	protected int happiness;
	private final int HAPPINES_START = 100;
	
	public Animal(int age) {
		this.age = age;
		this.happiness = HAPPINES_START;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getHappiness() {
		return happiness;
	}
	public void setHappiness(int happiness) {
		this.happiness = happiness;
	}
	
	public void changeHappiness(int happiness) {
		this.happiness += happiness;
	}

	public void ageOneYear() {
		this.age++;
	}
}
