package Penguin;

import java.util.LinkedList;

public class PenguinMemento {
	LinkedList<Penguin> penguinsList;

	public PenguinMemento(LinkedList<Penguin> penguinsList) {
		this.penguinsList = new LinkedList<Penguin>(penguinsList);
	}

	public LinkedList<Penguin> getSavedContent() {
		return this.penguinsList;
	}
}
