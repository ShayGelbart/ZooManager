package EmployeeAndVisitor;

import java.util.ArrayList;

public class EmployeeManager implements PeopleManager<Employee, String> {
	private ArrayList<Employee> employeeList;
	private static EmployeeManager instance;

	private EmployeeManager() {
		this.employeeList = new ArrayList<Employee>();
	}

	public static EmployeeManager getInstance() {
		if (instance == null) {
			instance = new EmployeeManager();
		}
		return instance;
	}

	@Override
	public void add(Employee item) {
		employeeList.add(item);
	}

	@Override
	public boolean remove(String identifier) {
		Employee employee = findByIdentifier(identifier);
		if(employee != null) {
			employeeList.remove(employee);
			return true;
		}
		return false;
	}

	@Override
	public Employee findByIdentifier(String identifier) {
		for (Employee employee : employeeList) {
			if (employee.getUsername().equals(identifier)) {
				return employee;
			}
		}
		return null; // Employee not found
	}

	public String toString() {
		StringBuilder str = new StringBuilder();
		for (Employee employee : employeeList) {
			str.append(employee.toString()).append("\n");
		}
		return str.toString();
	}
}
