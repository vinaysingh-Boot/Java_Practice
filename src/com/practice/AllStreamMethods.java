package com.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AllStreamMethods {

	public static void main(String[] args) {
		
		Projects project1 = new Projects("Commercial International Bank CLOS", "CIB_BBLO_CLOS", "EGYPT");
		Projects project2 = new Projects("Commercial International Bank RLOS", "CIB_BBLO_RLOS", "EGYPT");
		Projects project3 = new Projects("First Bank of Abu Dabi", "FAB_BBLO", "DUBAI");
		Projects project4 = new Projects("QATAR Central Bank", "QCB_BBLO", "QATAR");
		
			
		List<Employee> employees = Arrays.asList(
									new Employee(102, "Shubhi Gupta", "AP1-US", 50000,"Female", Arrays.asList(project1,project2)),
									new Employee(103, "Mohit Singh", "AP2-APRICA", 60000,"Male", Arrays.asList(project1,project3)),
									new Employee(104, "Sumani Kumari", "AP1-DELHI", 55000,"Female", Arrays.asList(project2,project3)),
									new Employee(105, "Chandan Kumar Singh", "AP1-APRICA", 70000,"Male", Arrays.asList(project1,project2,project4)),
									new Employee(101, "Vinay Singh", "AP2-APRICA", 75000,"Male", Arrays.asList(project1,project2,project3))					
				);
		
		// filter and collect
		Map<Integer, List<Projects>> collect = employees.stream().filter(emp -> emp.getSalary()>60000).collect(Collectors.toMap(Employee :: getId,
				Employee :: getProjects));
		//System.out.println(collect);
		//collect.entrySet().stream().forEach(System.out :: println);
		
		//map() and distinct()
		Set<String> collect2 = employees.stream().map(Employee :: getDepartment).distinct().collect(Collectors.toSet());
		
		// flatMap()
		List<String> collect3 = employees.stream().flatMap(emp -> emp.getProjects().stream().map(Projects :: getName))
								 .collect(Collectors.toList());
		
		// sorted()
		List<Employee> collect4_asc = employees.stream().sorted(Comparator.comparingDouble(emp -> emp.getSalary()))
								  .collect(Collectors.toList());
		List<Employee> collect4_desc = employees.stream().sorted(Comparator.comparingDouble(emp -> ((Employee) emp).getSalary()).reversed())
				  .collect(Collectors.toList());
		
		// min() && max() 
		
		Employee maxSalary = employees.stream().max(Comparator.comparingDouble(Employee :: getSalary)).orElse(null);
		System.out.println("Employee with max salary :-"+maxSalary);
		
		Employee minSalary = employees.stream().min(Comparator.comparingDouble(Employee :: getSalary)).orElse(null);
		System.out.println("Employee with min salary :-"+minSalary);
		
		System.out.println("\n");
		
		// groupBy()
		Map<String, List<String>> collect4 = employees.stream().collect(Collectors.groupingBy(Employee :: getGender,
												Collectors.mapping(Employee :: getName,Collectors.toList())));
		
		System.out.println("Grouped by Gender-"+collect4);
		
		//findFirst()
		 Optional<Double> firstSalary = employees.stream().sorted(Comparator.comparingDouble(emp -> -emp.getSalary())).findFirst()
				 					.map(Employee :: getSalary);
		 Optional<Double> findSalary = employees.stream().sorted(Comparator.comparingDouble(emp -> -emp.getSalary())).findAny()
					.map(Employee :: getSalary);
		System.out.println("firstSalary-"+firstSalary);
		
		// anyMatch(), allMatch() & noneMatch() -> return boolean value
		
		boolean anyMatch = employees.stream().anyMatch(emp -> emp.getDepartment().equalsIgnoreCase("AP2-APRICA"));
		System.out.println("anyMatch-"+anyMatch);
		
		boolean allMatch = employees.stream().anyMatch(emp -> emp.getDepartment().equalsIgnoreCase("AP2-APRICA"));
		System.out.println("allMatch-"+allMatch);
		
		boolean nonMatch = employees.stream().anyMatch(emp -> emp.getDepartment().equalsIgnoreCase("AP2-AMERICA"));
		System.out.println("nonMatch-"+nonMatch);
		
		
		
		//forEach
		//collect4_desc.stream().forEach(System.out :: println);
				
	}
}
