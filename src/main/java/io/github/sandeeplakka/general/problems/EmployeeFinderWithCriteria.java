package io.github.sandeeplakka.general.problems;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeFinderWithCriteria {

    enum SortingOrder {
        ASCENDING,
        DESCENDING
    }

    private static final EmployeeFinderWithCriteria self = new EmployeeFinderWithCriteria();

//    public static void main(String[] args) {
//
//        List<Employee> employeeList = new ArrayList<>();
//        employeeList.add(new Employee("EmployeeWith30K",30_000,22));
//        employeeList.add(new Employee("EmployeeWith35K",35_000,24));
//        employeeList.add(new Employee("EmployeeWith100K",100_000,30));
//
//        System.out.println("Employees with salary greater than or " +
//                "equal to 35K are : "+self.getEmployees(employeeList,35_000));
//
//    }

    /**
     * Return list of employee names who matches the minimum Salary given in input.
     * List returned will be in ascending order fashion
     *
     * @param employees     Employee list
     * @param minimumSalary Condition to match all employees with salary greater than or equal to this
     * @return List of employee names in ascending order fashion who matches the condition
     */
    public List<String> getEmployees(List<Employee> employees, int minimumSalary) {
        return getEmployees(employees, minimumSalary, SortingOrder.ASCENDING);
    }


    /**
     * Return list of employee names who matches the minimum salary and sorting order as per input.
     *
     * @param employees     Employee list
     * @param minimumSalary Condition to match all employees with salary greater than or equal to this
     * @param sortingOrder  Sorting order
     * @return              List of employee names in ascending/descending order as per input
     */
    public List<String> getEmployees(List<Employee> employees, int minimumSalary, SortingOrder sortingOrder){

        Comparator<Employee> employeeComparator = Comparator.comparing(Employee::getName);

        if(sortingOrder == SortingOrder.DESCENDING) {
            employeeComparator = employeeComparator.reversed();
        }
        return  employees.stream()
                .filter(employee -> employee.getSalary() >= minimumSalary)
                .sorted(employeeComparator)
                .map(Employee::getName)
                .collect(Collectors.toList());
    }

}

class Employee {
    private String name;
    private int salary;
    private int age;

    public Employee(String name, int salary, int age) {
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

}