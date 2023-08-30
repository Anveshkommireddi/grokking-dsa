package com.learn.java.misc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Employee {

	private String name;

	private Integer value;

	public Employee(String name, Integer value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", value=" + value + "]";
	}
	
}

class TestComparator {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TestComparator.class);
	
	public static void main(String[] args) {
		Employee emp1 = new Employee("anvesh", 3);
		Employee emp2 = new Employee("aarya", 2);
		Employee emp3 = new Employee("aarya", 1);
		List<Employee> empList = Arrays.asList(emp1, emp2, emp3);
		
		List<Employee> empSortList = empList.stream()
									.sorted(Comparator.comparing(Employee::getName).thenComparing(Employee::getValue))
									.collect(Collectors.toList());
		
		empSortList.stream().forEach(emp -> LOGGER.info("Sorted EmpLst :: {}", emp));
	}
}

