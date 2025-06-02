package ch01;

public class Company {
    public static void main(String[] args) {
        Employee[] employees = new Employee[2];
        employees[0] = new Secretary("Duke", 1, "secretary", 800);
        employees[1] = new Sales("Tuxi", 2, "sales     ", 1200);

        printEmployee(employees, false);

        for (Employee e : employees) {
            ((Bonus) e).incentive(100);  
        }

        printEmployee(employees, true);
    }

    public static void printEmployee(Employee[] emp, boolean isTax) {
        if (!isTax) {
            System.out.println("name \t department \t salary \t extra pay \t");
            System.out.println("--------------------------------------------------");

            for (Employee e : emp) {
                System.out.printf("%s \t %s \t %d \t %.1f \t \n",
                        e.name, e.department, e.salary, e.getExtraPay());
            }
        } else  {
            System.out.println("");
            System.out.println("name \t department \t salary \t tax \t extra pay");
           System.out.println("----------------------------------------------------------");
            for (Employee e : emp) {
                System.out.printf("%s \t %s \t %d \t %.1f  \t %.1f  \t \n",
                        e.name, e.department, e.salary, e.tax(), e.getExtraPay());
            }
        }
    }
}

abstract class Employee {
    String name;
    int number;
    String department;
    int salary;

    Employee() {}

    Employee(String name, int number, String department, int salary) {
        this.name = name;
        this.number = number;
        this.department = department;
        this.salary = salary;
    }

    public abstract double tax();

    public double getExtraPay() {
       return 0.0;  
    }
}

interface Bonus {
    void incentive(int pay);
}

class Secretary extends Employee implements Bonus {
    Secretary() {}

    Secretary(String name, int number, String department, int salary) {
        super(name, number, department, salary);
    }

    @Override
    public void incentive(int pay) {
        this.salary += pay * 0.8;
    }

    @Override
    public double tax() {
        return salary * 0.1;
    }
}

class Sales extends Employee implements Bonus {
    Sales() {}

    Sales(String name, int number, String department, int salary) {
        super(name, number, department, salary);
    }

    @Override
    public void incentive(int pay) {
        this.salary += pay * 1.2;
    }

    @Override
    public double tax() {
        return salary * 0.13;
    }

    @Override
    public double getExtraPay() {
        return salary * 0.03;
    }
}