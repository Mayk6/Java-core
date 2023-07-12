package Homework;

public class Supervisor extends Employee {


    public Supervisor(String fio, String position, String phone, Integer age, Integer salary) {
        super(fio, position, phone, age, salary);
    }

    public static void salaryUp(Employee[] employees, int age, int salaryUp) {
        for (Employee emp : employees) {
            if (emp.getAge() > age) {
                if (!(emp instanceof Supervisor)) emp.setSalary(emp.getSalary() + salaryUp);
            }
        }
    }
}
