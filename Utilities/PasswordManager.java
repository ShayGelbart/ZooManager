package Utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import EmployeeAndVisitor.Employee;

public class PasswordManager {
	private Map<String, ArrayList<Employee>> passwordMap;

	private static PasswordManager instance;

	private PasswordManager() {
		this.passwordMap = new HashMap<>();
	}

	public static PasswordManager getInstance() {
		if (instance == null) {
			synchronized (PasswordManager.class) {
				if (instance == null) {
					instance = new PasswordManager();
				}
			}
		}
		return instance;
	}

	public Map<String, ArrayList<Employee>> getPasswordMap() {
		return passwordMap;
	}

	// Method to add an employee with a specific password
	public void addPassword(String password, Employee employee) {
		passwordMap.computeIfAbsent(password, k -> new ArrayList<>()).add(employee);
	}

	// Method to get employees associated with a specific password
	public ArrayList<Employee> getEmployees(String password) {
		return passwordMap.getOrDefault(password, new ArrayList<>());
	}

	// Method to remove an employee from a specific password
	public void removeEmployee(String password, int employeeId) {
		ArrayList<Employee> employees = passwordMap.get(password);
		if (employees != null) {
			employees.removeIf(e -> e.getId() == employeeId);
			if (employees.isEmpty()) {
				passwordMap.remove(password);
			}
		}
	}

	public boolean checkPassword(String pass, String employeeUserName) {
		ArrayList<Employee> employees = passwordMap.get(pass);
		if (employees != null) {
			for (Employee employee : employees) {
				if (employee.getUsername().equals(employeeUserName)) {
					return true;
				}
			}
		}
		return false;
	}

	// Method to display all passwords and associated employees
	public String toString() {
		String s1 = "";
		for (Map.Entry<String, ArrayList<Employee>> entry : passwordMap.entrySet()) {
			s1 += "Password: " + entry.getKey();
			for (Employee employee : entry.getValue()) {
				s1 += "  " + employee;
			}
		}
		return s1;
	}
}
