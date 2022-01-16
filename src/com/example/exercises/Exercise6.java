package com.example.exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import com.example.domain.Department;
import com.example.domain.Employee;

public class Exercise6 {
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
		var zeki = new Employee("5", "zeki aynal", 350_000, "tr5", true, 1995);
		zeki.addDepartments(Department.SALES, Department.FINANCE);
		var özlem = new Employee("6", "özlem aynal", 1_000_000, "tr6", true, 1995);
		özlem.addDepartments(Department.SALES, Department.FINANCE);
		employees.add(jack);
		employees.add(kate);
		employees.add(james);
		employees.add(jin);
		employees.add(zeki);
		employees.add(özlem);
	}

	public static void main(String[] args) {
		// Find the total number of Full-time and Part-time employees
		
		//Predicate Functions
		Predicate<Employee> isFullTime = employee -> employee.isFulltime();
		Predicate<Employee> isPartTime =isFullTime.negate();
		
		//Find the total number of Full-time employees
		var fulltimeResult = employees.stream().filter(isFullTime).count();
		System.err.println(fulltimeResult);
		
		//Find the total number of Part-time employees
		var parttimeResult = employees.stream().filter(isPartTime).count();
		System.err.println(parttimeResult);
	}

}
