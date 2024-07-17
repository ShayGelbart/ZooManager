package EmployeeAndVisitor;

import Utilities.DateUtil;

public abstract class Person {
	protected int id;
	protected String first_name;
	protected String last_name;
	protected DateUtil birth_date;
	protected String phone_num;

	public Person(int id, String first_name, String last_name, int day_of_birth, int month_of_birth, int year_of_birth,
			String phone_num) {
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.birth_date = new DateUtil(year_of_birth, month_of_birth, day_of_birth);
		this.phone_num = phone_num;
	}

	public int getId() {
		return id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public DateUtil getBirth_date() {
		return this.birth_date;
	}

	public String getPhone_num() {
		return phone_num;
	}

	@Override
	public String toString() {
		return "id: " + id + " name: " + first_name + last_name + "\ndate of birth: " + birth_date + ", phone number = "
				+ phone_num + "\n";
	}

}
