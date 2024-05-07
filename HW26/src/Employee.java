import java.util.Objects;

public class Employee {
    private String name;
    private String surname;
    private Integer age;
    private Integer salary;
    private Integer kpi;

    public Employee() {
    }

    public Employee(String name, String surname, Integer age, Integer salary, Integer kpi) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.salary = salary;
        this.kpi = kpi;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getKpi() {
        return kpi;
    }

    public void setKpi(Integer kpi) {
        this.kpi = kpi;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", kpi=" + kpi +
                '}';
    }
}
