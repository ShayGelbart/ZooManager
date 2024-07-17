package Utilities;


import Promotion.Promotion;

public interface Observable {
	// could be implemented but not needed because of addVisitor in VisitorManager
	//void addObserver(Observer observer);

	void removeObserver(Observer observer);

	String notifyObservers(Promotion promotion);
}