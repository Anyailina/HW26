import java.util.ArrayList;
import java.util.List;

public class  EmployeeFactory {
    public static List<Employee> createEmployee() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Иван", "Петров", 32, 20000, 1));
        employees.add(new Employee("Василий", "Маркелов", 47, 21000, 7));
        employees.add(new Employee("Демьян", "Ивлиев", 22, 10000, 4));
        employees.add(new Employee("Андрей", "Васько", 47, 33500, 2));
        employees.add(new Employee("Иван", "Демченко", 22, 17000, 1));
        employees.add(new Employee("Максим", "Петров", 18, 13000, 8));
        employees.add(new Employee("Jon", "Palmer", 25, 27000, 5));
        employees.add(new Employee("Тарас", "Бульба", 75, 7000, 1));
        employees.add(new Employee("Артем", "Михайлов", 45, 20323, 6));
        employees.add(new Employee("Сергей", "Иванов", 37, 12343, 7));
        return employees;
    }
}
