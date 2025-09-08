class Employee {
    protected String name;
    protected double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public void displayDetails() {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee Salary: " + salary);
    }
}

class Manager extends Employee {
    private String department;

    public Manager(String name, double salary, String department) {
        super(name, salary); 
        this.department = department;
    }

    @Override
    public void displayDetails() {
        System.out.println("Manager Name: " + name);
        System.out.println("Manager Salary: " + salary);
        System.out.println("Department: " + department);
    }
}

public class lab3 {
    public static void main(String[] args) {
        Employee emp = new Employee("Shreya", 50000);
        emp.displayDetails();
        System.out.println();

        Manager mgr = new Manager("John", 80000, "IT");
        mgr.displayDetails();
    }
}
