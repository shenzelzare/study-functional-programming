package com.example.exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.domain.Department;
import com.example.domain.Employee;

public class Exercise8 {
	public static List<Employee> employees;
	static { // static initializer
		employees = new ArrayList<>();
		var jack = new Employee("1", "jack bauer", 100_000, "tr1", true, 1956);
		jack.addDepartments(Department.HR, Department.FINANCE, Department.IT);
		var kate = new Employee("2", "kate austen", 200_000, "tr2", false, 1986);
		kate.addDepartments(Department.HR, Department.IT);
		var james = new Employee("3", "james sawyer", 150_000, "tr3", true, 1978);
		james.addDepartments(Department.SALES, Department.FINANCE);
		var jin = new Employee("4", "jin kwon", 250_000, "tr4", false, 1987);
		jin.addDepartments(Department.IT);
		employees.add(jack);
		employees.add(kate);
		employees.add(james);
		employees.add(jin);
	}

	public static void main(String[] args) {
		// Find the minimum, the maximum and the average salaries
		
		//Find the minimum
		var minSalary = employees.stream()
								 .mapToDouble(Employee::getSalary)
								 .min()
								 .getAsDouble();
		System.err.println(minSalary);
		
		//Find the maximum
		var maxSalary = employees.stream()
								 .mapToDouble(Employee::getSalary)
								 .max()
								 .getAsDouble();
		System.err.println(maxSalary);
		
		//Find the average
		var averageSalary = employees.stream()
									 .mapToDouble(Employee::getSalary)
									 .average()
									 .getAsDouble();
		System.err.println(averageSalary);
		
		//Another Solution using Collectors.summarizingDouble
		var summarizingSalaries = employees.stream()
										   .collect(Collectors.summarizingDouble(Employee::getSalary));
		System.err.println(summarizingSalaries);
		
	}

}
