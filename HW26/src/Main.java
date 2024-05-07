import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        //Task1
        Set<Set<String>> sets = new HashSet<>();
        Set<String> strings = new HashSet<>();
        strings.add("раз");
        strings.add("два");
        strings.add("три");
        Set<String> strings2 = new HashSet<>();
        strings2.add("Первое");
        strings2.add("Второе");
        strings2.add("Семьдесят шестое");
        Set<String> strings3 = new HashSet<>();
        strings3.add("12");
        strings3.add("783");
        strings3.add("37288736");
        Set<String> strings4 = new HashSet<>();
        strings4.add("Проверка");
        strings4.add("Струн");
        strings4.add("Раз-Два");

        sets.add(strings);
        sets.add(strings2);
        sets.add(strings3);
        sets.add(strings4);

        //todo Решение дз 1 тут

        task1(sets);
        List<Employee> employees = EmployeeFactory.createEmployee();
        //todo решения дз 2 тут
        task2(employees);

        Map<String, Employee> map = employees.stream()
                .filter(work -> work.getAge() < 35 && work.getSalary() > 10000)
                .collect(Collectors.toMap(Employee::getName, p -> p,(p1, p2) -> p1));
        map.forEach((s, e) -> System.out.println(s + " " + e.getSalary()));


    }

    private static void task1(Set<Set<String>> sets) {
        long quantityLetter = calculateQuantityLetters(sets);
        System.out.println("Количество букв во всех строках: " + quantityLetter);

        int maxLength = findMaxLength(sets);
        System.out.println("Максимальная длина строки: " + maxLength);
    }


    private static long calculateQuantityLetters(Set<Set<String>> sets) {
        return sets.stream()
                .flatMapToInt(strings -> strings.stream().mapToInt(String::length))
                .sum();
    }


    private static int findMaxLength(Set<Set<String>> sets) {
        return sets.stream()
                .flatMapToInt(set -> set.stream().mapToInt(String::length))
                .max().orElse(0);
    }


    private static void task2(List<Employee> employees) {
        findEmployeeWithMaxKPI(employees);
        findRetiredEmployee(employees);
        findEmployeeWithMaxSalary(employees);
        findNonRussianEmployee(employees);
        printEmployeesWithAboveAverageKPI(employees);
        findAverageKPIOfRussianEmployeesUnder45WithSalaryOver20000(employees);
    }

    private static void findEmployeeWithMaxKPI(List<Employee> employees) {
        int maxKPI = employees.stream()
                .mapToInt(Employee::getKpi)
                .max().orElse(0);
        System.out.println("Максимальный KPI: " + maxKPI);
    }


    private static void findRetiredEmployee(List<Employee> employees) {
        Employee retiredEmployee = employees.stream()
                .filter(worker -> worker.getAge() > 65)
                .findFirst().orElse(null);
        System.out.println("Работник, которому пора на пенсию: " + retiredEmployee);
    }


    private static void findEmployeeWithMaxSalary(List<Employee> employees) {
        Employee employeeWithMaxSalary = employees.stream()
                .max(Comparator.comparing(Employee::getSalary))
                .orElse(null);
        System.out.println("Работник с самой большой ЗП: " + employeeWithMaxSalary);
    }


    private static void findNonRussianEmployee(List<Employee> employees) {
        String pattern = "[a-zA-Z]+";
        Employee nonRussianEmployee = employees.stream()
                .filter(worker -> Pattern.matches(pattern, worker.getName()))
                .findFirst().orElse(null);
        System.out.println("Нерусский работник: " + nonRussianEmployee);
    }


    private static void printEmployeesWithAboveAverageKPI(List<Employee> employees) {
        double averageKPI = employees.stream()
                .mapToInt(Employee::getKpi)
                .average().orElse(0);
        System.out.println("Работники с KPI выше среднего:");
        employees.stream()
                .filter(worker -> worker.getKpi() > averageKPI)
                .forEach(System.out::println);
    }


    private static void findAverageKPIOfRussianEmployeesUnder45WithSalaryOver20000(List<Employee> employees) {
        String pattern = "[a-zA-Z]+";
        double averageKPIWithFilters = employees.stream()
                .filter(worker -> !Pattern.matches(pattern, worker.getName()) && worker.getAge() < 45 && worker.getSalary() > 20000)
                .mapToInt(Employee::getKpi)
                .average().orElse(0);
        System.out.println("Среднее значение KPI у русских работников, младше 45 лет и с ЗП больше 20000: " + averageKPIWithFilters);
    }
}