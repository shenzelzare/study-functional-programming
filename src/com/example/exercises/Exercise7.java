package com.example.exercises;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.example.domain.Department;
import com.example.domain.Employee;

public class Exercise7 {
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
		// Find the employee numbers in age groups [20-30), [30-40), [40-50), etc.
		
		Function<Employee, String> f = (e)-> {
				LocalDate now = LocalDate.now();
				int age = now.getYear() - e.getBirthYear();
				//35
				int start = (age/10) * 10;
				int end = ((age/10) + 1) * 10;
				return "["+start+","+end+")";
		};
			
		BiConsumer<String, Long> print = (key,value) -> System.out.println(key+": "+ value);


		var solution1 = employees.stream()
								 .collect(Collectors.groupingBy(f, Collectors.counting()));
		solution1.forEach(print);
		
		var solution2 = employees.stream()
								 .collect(Collectors.groupingBy(f))
								 .entrySet()
								 .stream()
								 .collect(Collectors.toMap(s -> s.getKey(),l ->Long.valueOf(l.getValue().size())));
		solution2.forEach(print);
		
		var solution3 = employees.stream()
								 .map((e)->f.apply(e)).collect(
										 Collectors.groupingBy(Function.identity(), Collectors.counting()));
		solution3.forEach(print); 
	}

}
