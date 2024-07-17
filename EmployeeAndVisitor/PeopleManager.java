package EmployeeAndVisitor;

import Utilities.VisitorException;

public interface PeopleManager<T, U> {
	void add(T item);

	boolean remove(U identifier) throws VisitorException;

	T findByIdentifier(U identifier) throws VisitorException;

}
