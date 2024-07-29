package org.lavendra.com.streamApi;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeMain {


    public static void main(String[] args) {
        Employee employee1 = new Employee("John", 25, "HR", 30000);
        Employee employee2 = new Employee("Martin", 30, "Finance", 40000);
        Employee employee3 = new Employee("Sam", 28, "IT", 50000);
        Employee employee4 = new Employee("John", 25, "HR", 30000);
        Employee employee5 = new Employee("Martin", 30, "Finance", 40000);
        Employee employee6 = new Employee("Sam", 28, "IT", 50000);
        Employee employee7 = new Employee("John", 25, "HR", 30000);
        List<Employee> employeeList = List.of(employee1, employee2, employee3, employee4, employee5, employee6, employee7);
        employeeList.forEach(x -> System.out.println(x.getName()));
        List<Employee> employee = employeeList.stream().filter(x -> x.getAge() == 30).collect(Collectors.toList());
        Optional<Employee> highestSalaryEmployee = employeeList.stream().max(Comparator.comparingDouble(Employee::getSalary));
        highestSalaryEmployee.ifPresent(System.out::println);
        Optional<Employee> lowestEmployee = employeeList.stream().min(Comparator.comparingDouble(Employee::getSalary));
        lowestEmployee.ifPresent(System.out::println);

        List<Employee> sortedEmployee = employeeList.stream().sorted(Comparator.comparingInt(Employee::getAge)).collect(Collectors.toList());
        System.out.println(sortedEmployee);

        List<Employee> sortedEmployeeName = employeeList.stream().sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toList());
        System.out.println(sortedEmployeeName);

        List<Employee> sortedEmployeeDepartment = employeeList.stream().sorted(Comparator.comparing(Employee::getDepartment)).collect(Collectors.toList());
        System.out.println(sortedEmployeeDepartment);

        List<Employee> sortedEmployeeSalary = employeeList.stream().sorted(Comparator.comparingDouble(Employee::getSalary)).collect(Collectors.toList());
        System.out.println(sortedEmployeeSalary);

        List<Employee> employeeNameUpperCaseList = employeeList.stream().map(x -> {
            x.setName(x.getName().toUpperCase());
            return x;
        }).collect(Collectors.toList());
        System.out.println(employeeNameUpperCaseList);
    }
}
