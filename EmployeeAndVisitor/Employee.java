package EmployeeAndVisitor;

import java.util.Objects;

public class Employee extends Person {
	private int employee_num;
	private String username;

	public Employee(int id, String first_name, String last_name, int day_of_birth, int month_of_birth,
			int year_of_birth, String phone_num, int employee_num, String username) {
		super(id, first_name, last_name, day_of_birth, month_of_birth, year_of_birth, phone_num);
		this.employee_num = employee_num;
		this.username = username;
	}

	public int getEmployee_num() {
		return employee_num;
	}

	public void setEmployee_num(int employee_num) {
		this.employee_num = employee_num;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Employee employee = (Employee) o;
		return Objects.equals(id, employee.id) && Objects.equals(username, employee.username);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, username);
	}

	@Override
	public String toString() {
		return "Employee:\n" + super.toString() + "\nemployee number = " + employee_num + ", username:" + username
				+ "\n";
	}
}
