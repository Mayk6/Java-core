package Homework;

public class Employee {

    private String fio;
    private String position;
    private String phone;
    private Integer age;
    private Integer salary;

    public Employee(String fio, String position, String phone, Integer age, Integer salary) {
        this.fio = fio;
        this.position = position;
        this.phone = phone;
        this.age = age;
        this.salary = salary;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    @Override
    public String toString() {
        return "Employee{" +
                "FIO='" + fio + '\'' +
                ", position='" + position + '\'' +
                ", phone='" + phone + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

    public String viewInfo() {
        return String.format("Fio %s, position %s, phone %s, age %d, salary %d.", fio, position, phone, age, salary);
    }

    public static void main(String[] args) {
        Employee[] employees = {new Employee("Ivan", "manager", "558585", 35, 30000),
                new Employee("Petya", "manager", "558585", 47, 45000),
                new Employee("Vasa", "manager", "558585", 46, 35000),
                new Employee("Lexa", "manager", "558585", 50, 35000),
                new Supervisor("Ilia", "manager", "558585", 48, 100000)};

        Supervisor.salaryUp(employees, 45, 10000);
        AgeComparator ageComparator = new AgeComparator();
        compareSalary(employees[1], employees[2]);
        compareAge(employees[1], employees[2]);


        for (Employee emp : employees) {
            System.out.println(emp.viewInfo());
        }
        System.out.println(avgAge(employees));
        System.out.println(avgSalary(employees));
    }

    public static Float avgAge(Employee[] employees) {
        float sum = 0;
        for (Employee emp : employees) {
            sum += emp.getAge();
        }
        return sum / employees.length;
    }

    public static Float avgSalary(Employee[] employees) {
        float sum = 0;
        for (Employee emp : employees) {
            sum += emp.getSalary();
        }
        return sum / employees.length;
    }

    public static void compareSalary(Employee emp1, Employee emp2) {
        SalaryComparator salaryComparator = new SalaryComparator();
        int result = salaryComparator.compare(emp1, emp2);
        if (result < 0) {
            System.out.println("У сотрудника " + emp2.getFio() + " зарплата болше чем у " + emp1.getFio());
        } else if (result > 0) {
            System.out.println("У сотрудника " + emp1.getFio() + " зарплата болше чем у " + emp2.getFio());
        } else {
            System.out.println("У сотрудников одинаковые зарплаты.");
        }
    }

    public static void compareAge(Employee emp1, Employee emp2) {
        AgeComparator salaryComparator = new AgeComparator();
        int result = salaryComparator.compare(emp1, emp2);
        if (result < 0) {
            System.out.println("Cотрудник " + emp2.getFio() + " старше чем " + emp1.getFio());
        } else if (result > 0) {
            System.out.println("Cотрудник " + emp1.getFio() + " старше чем " + emp2.getFio());
        } else {
            System.out.println("У сотрудников одинаковый возраст.");
        }
    }
}
