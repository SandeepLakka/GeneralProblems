package io.github.sandeeplakka.general.problems;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


class EmployeeFinderWithCriteriaTest {

    EmployeeFinderWithCriteria employeeFinderWithCriteria;
    @BeforeEach
    public void init(){
        employeeFinderWithCriteria = new EmployeeFinderWithCriteria();
    }

    @Test
    @DisplayName("Tests with no employee matching minimum salary criteria")
    void testsWithNoEmployeeMatchingMinimumSalaryCriteria() {
        List<String> emptyList = new ArrayList<>();
        List<Employee> tc1 = new ArrayList<>();
        tc1.add(new Employee("EmployeeWith30K",30_000,22));
        tc1.add(new Employee("EmployeeWith32K",32_000,24));
        tc1.add(new Employee("EmployeeWith35K",35_000,25));
        tc1.add(new Employee("EmployeeWith37K",37_000,26));

        assertEquals(emptyList, employeeFinderWithCriteria.getEmployees(tc1,50_000));
        assertEquals(emptyList, employeeFinderWithCriteria.getEmployees(tc1,50_000,
                EmployeeFinderWithCriteria.SortingOrder.DESCENDING));

        assertEquals(emptyList, employeeFinderWithCriteria.getEmployees(tc1,38_000));
        assertEquals(emptyList, employeeFinderWithCriteria.getEmployees(tc1,38_000,
                EmployeeFinderWithCriteria.SortingOrder.DESCENDING));

    }

    @Test
    @DisplayName("Test with Empty employee list with valid criteria")
    void testWithEmptyEmployeeListWithValidCriteria() {
        List<String> emptyList = new ArrayList<>();
        List<Employee> tc1 = new ArrayList<>();

        assertEquals(emptyList, employeeFinderWithCriteria.getEmployees(tc1,10_000));
        assertEquals(emptyList, employeeFinderWithCriteria.getEmployees(tc1,10_000,
                EmployeeFinderWithCriteria.SortingOrder.DESCENDING));
    }

    @Test
    @DisplayName("Test regular use cases")
    void testRegularUseCases() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("EmployeeWith30K",30_000,22));
        employees.add(new Employee("EmployeeWith32K",32_000,24));
        employees.add(new Employee("EmployeeWith35K",35_000,25));
        employees.add(new Employee("EmployeeWith37K",37_000,26));
        employees.add(new Employee("EmployeeWith150K",150_000,30));
        employees.add(new Employee("EmployeeWith170K",170_000,32));
        employees.add(new Employee("EmployeeWith200K",200_000,35));

        List<String> er1 = Arrays.asList(new String[]{
                "EmployeeWith150K", "EmployeeWith170K","EmployeeWith200K"
        });
        assertEquals(er1, employeeFinderWithCriteria.getEmployees(employees,50_000));

        List<String> er2 = Arrays.asList(new String[]{
                "EmployeeWith150K", "EmployeeWith170K", "EmployeeWith200K",
                "EmployeeWith30K", "EmployeeWith32K", "EmployeeWith35K",
                "EmployeeWith37K"
        });
        assertEquals(er2, employeeFinderWithCriteria.getEmployees(employees,20_000));


        List<String> er3 = Arrays.asList(new String[]{
                "EmployeeWith200K","EmployeeWith170K","EmployeeWith150K"
        });
        assertEquals(er3, employeeFinderWithCriteria.getEmployees(employees,50_000,
                EmployeeFinderWithCriteria.SortingOrder.DESCENDING));

        List<String> er4 = Arrays.asList(new String[]{
                "EmployeeWith37K", "EmployeeWith35K", "EmployeeWith32K", "EmployeeWith30K",
                "EmployeeWith200K", "EmployeeWith170K", "EmployeeWith150K"
        });
        assertEquals(er4, employeeFinderWithCriteria.getEmployees(employees,20_000,
                EmployeeFinderWithCriteria.SortingOrder.DESCENDING));

    }




}