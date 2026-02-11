package com.java.java8.employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeTest {
	
	public static void main(String[] args) {
		
List<Employee> list = new ArrayList<Employee>();
        
		list.add(new Employee(111, "Jiya", 32, "Female", "HR", 2011, 25000.0));
		list.add(new Employee(122, "Paul", 25, "Male", "Sales And Marketing", 2015, 13500.0));
		list.add(new Employee(133, "Jyothi", 29, "Male", "Infrastructure", 2012, 18000.0));
		list.add(new Employee(144, "Murali", 28, "Male", "Product Development", 2014, 32500.0));
		list.add(new Employee(155, "Nima", 27, "Female", "HR", 2013, 22700.0));
		list.add(new Employee(166, "Jyothi", 43, "Male", "Security And Transport", 2016, 10500.0));
		list.add(new Employee(177, "Manu", 35, "Male", "Account And Finance", 2010, 27000.0));
		list.add(new Employee(188, "Wang", 31, "Male", "Product Development", 2015, 34500.0));
		list.add(new Employee(199, "Amelia", 24, "Female", "Sales And Marketing", 2016, 11500.0));
		list.add(new Employee(200, "Jaden", 38, "Male", "Security And Transport", 2015, 11000.5));
		list.add(new Employee(211, "Jasna", 27, "Female", "Infrastructure", 2014, 15700.0));
		list.add(new Employee(222, "Nitin", 25, "Male", "Product Development", 2016, 28200.0));
		list.add(new Employee(233, "Jyothi", 27, "Female", "Account And Finance", 2013, 21300.0));
		list.add(new Employee(244, "Jiya", 24, "Male", "Sales And Marketing", 2017, 10700.5));
		list.add(new Employee(255, "Nima", 23, "Male", "Infrastructure", 2018, 12700.0));
		list.add(new Employee(266, "Sanvi", 26, "Female", "Product Development", 2015, 28900.0));
		list.add(new Employee(277, "Anuj", 31, "Male", "Product Development", 2012, 35700.0));
		
		
	
		
		
		
		
// 1. Group the employee objects according to employee names
		
		Map<String, List<Employee>> result1 = list.stream().collect(Collectors.groupingBy(emp -> emp.getName()));
		
		result1.entrySet().forEach(System.out::println);
		
		System.out.println("################# 1 #################\n");
		
		
// find out the numbers of male and female among employee list
		
		Map<String, Long> result2 = list.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		
		System.out.println(result2);
		
		System.out.println("################# 1 #################\n");
		
// 2. print all the names of departments from the list
		
		List<String> result3 = list.stream().map(e -> e.getDepartment()).distinct().toList();
		
		System.out.println(result3);
		
		System.out.println("################# 2 #################\n");
		
		
// 3. find out the average of the ages of the male and female employee
		
		Map<String, Double> result4 = list.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
		
		System.out.println(result4);
		
		System.out.println("################# 3 #################\n");
		
		
// 4. find out the numbers of employees in the employee list
		
		Long result5 = list.stream().count();
		
		System.out.println(result5);
		
		System.out.println("################# 4 #################\n");
		
		
// 5. find out the numbers of females in the list
		
		Long result6 = list.stream().filter(e -> e.getGender().toLowerCase().equals("female")).count();
		
		System.out.println(result6);
		
		System.out.println("################# 5 #################\n");
		
		
// 6. sort the employee list in ascending order according to their salary.
		
		List<Employee> result7 = list.stream().sorted((a,b) -> (int)(a.getSalary() - b.getSalary())).toList();
		List<Employee> result7Opt = list.stream().sorted(Comparator.comparing(Employee::getSalary)).toList();
		
		result7.forEach(System.out::println);
		
		System.out.println("################# 6 #################\n");
		
	// 6.1  sort the employee list in descending order according to their salary.	
		
		List<Employee> result7dot1 = list.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).toList();
		result7dot1.forEach(System.out::println);

		System.out.println("################# 6.1 #################\n");
		
// 7. find out the highest salary of male and female employee
		
		Map<String, Optional<Employee>> result8 = list.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.maxBy((a,b) -> (int)(a.getSalary()-b.getSalary()))));
		
		Map<String, Optional<Employee>> result8Opt = list.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
		
		result8.forEach((k,v) -> System.out.println(k+" = "+v.get().getSalary()+","+v.get().getName()));
		
		System.out.println("################# 7 #################\n");

		
// 8. find out the highest paid employee in each department
		
		Map<String, Optional<Employee>> result9Opt = list.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy((a,b) -> (int)(a.getSalary() - b.getAge()))));
		
		Map<String, Optional<Employee>> result9 = list.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
		
		result9.entrySet().forEach(e -> System.out.println(e.getKey()+" = "+e.getValue().get().getName()+" : "+e.getValue().get().getSalary()));
		
		System.out.println("################# 8 #################\n");

// 9. find out the highest paid employee in the list
		
		Employee result10 = list.stream().max(Comparator.comparing(Employee::getSalary)).get();
		
		Employee result10Opt = list.stream().max((a,b) -> (int)(a.getSalary()-b.getSalary())).get();
		
		Employee Optional_result10 = list.stream().max(Comparator.comparingDouble(Employee::getSalary)).get();
		
		System.out.println(result10);
		
		System.out.println("################# 9 #################\n");
		

// 10. find the youngest employee in the list		
		
		Employee result11 = list.stream().min((a,b) -> a.getAge() - b.getAge()).get();
		
		Employee Optional_Result11 = list.stream().min(Comparator.comparingInt(Employee::getAge)).get();
		
		System.out.println(result11);
		
		System.out.println("################# 10 #################\n");
		
		
// 11. who is the most experienced employee in the list
		
		Employee result12 = list.stream().min((a,b) -> a.getYearOfJoining() - b.getYearOfJoining()).get();
		
		Employee Optional_Result12 = list.stream().min(Comparator.comparingInt(Employee::getYearOfJoining)).get();
		
		System.out.println(result12);
		
		System.out.println("################# 11 #################\n");
		
// 12. find the youngest MALE employee in Product Development department.
		
		Employee result13 = list.stream().filter(e -> e.getGender().equals("Male") && e.getDepartment().equals("Product Development")).min(Comparator.comparingInt(Employee::getAge)).get();
		
		System.out.println(result13);
		
		System.out.println("################# 12 #################\n");
		
	
// 13. find the oldest employee in the list
		
		Employee result14 = list.stream().max(Comparator.comparingInt(Employee::getAge)).get();
		
		System.out.println(result14);
		
		System.out.println("################# 13 #################\n");
		

// 14. find average salary of employee and total salary of the employees in single line
		
		DoubleSummaryStatistics stats = list.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
		
		System.out.println("Average Salary of the employee : "+stats.getAverage());
		System.out.println("Total Salary of all employees : "+stats.getSum());
		
		System.out.println("################# 14 #################\n");

		
// 15. List down the names of all employees in each department?
		
		Map<String, List<String>> result15 = list.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.mapping(Employee::getName, Collectors.toList())));
		
		result15.entrySet().forEach(System.out::println);
		
		System.out.println("################# 15 #################\n");
		

// 16. Group the employees according to ages above and below 30.	
		
		Map<String, List<String>> result16 = list.stream().collect(Collectors.groupingBy(e -> e.getAge() > 30 ? "Above 30" : "Below 30", Collectors.mapping(Employee::getName, Collectors.toList())));
		
		result16.entrySet().forEach(System.out::println);
		
		System.out.println("################# 16 #################\n");
		
		
// 17. find the list of employees of smallest age
		
		// approach 1
		
			// find the minimum/lowest age
			Integer lowestAge = list.stream().mapToInt(Employee::getAge).min().getAsInt();
			// filter all the employee with lowest age
			List<Employee> result17 = list.stream().filter(e -> e.getAge() == lowestAge).toList();
			//result17.forEach(System.out::println);
			
		// approach 2 (one liner code)
			
			List<Employee> result17Opt = list.stream().filter(e -> e.getAge() == list.stream().mapToInt(Employee::getAge).min().getAsInt()).toList();
		
			result17Opt.forEach(System.out::println);
		
			System.out.println("################# 17 #################\n");
		
		
		
		
	}

}
