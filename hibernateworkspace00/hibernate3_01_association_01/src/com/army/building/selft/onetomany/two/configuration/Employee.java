package com.army.building.selft.onetomany.two.configuration;

import java.util.Set;

public class Employee {
	private int id;
	private String name;
	private Employee manger;
	private Set<Employee> staffs;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Employee getManger() {
		return manger;
	}

	public void setManger(Employee manger) {
		this.manger = manger;
	}

	public Set<Employee> getStaffs() {
		return staffs;
	}

	public void setStaffs(Set<Employee> staffs) {
		this.staffs = staffs;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
