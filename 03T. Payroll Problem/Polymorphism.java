package polymorphism;

import java.util.Scanner;

class employee {

    private String name;
    private String id;
    employee[] arr;

    public employee(String name, String id) {
        this.name = name;
        this.id = id;
    }

    employee() {

    }

    @Override
    public String toString() {
        return "Employee{ Name: " + name + ", Id: " + id + " } ";
    }

    public double earnings() {
        return 0;
    }

    public void main(employee[] arr) {
        for (int i = 0; i < arr.length; i++) {
            Scanner employee = new Scanner(System.in);
            System.out.print("Press 1 for HE: \nPress 2 for SE: \nPress 3 for CE: ");
            int typeOfEmployee = employee.nextInt();

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter name of employee: ");
            String name1 = sc.nextLine();
            System.out.println("Enter id of employee: ");
            String id1 = sc.nextLine();

            if (typeOfEmployee == 1) {
                System.out.println("Enter per hour rate of hourly employee: ");
                int perHourRate1 = sc.nextInt();
                System.out.println("Enter total Hours of hourly employee: ");
                int totalHours1 = sc.nextInt();

                arr[i] = new hourlyEmployee(name1, id1, perHourRate1, totalHours1);

            } else if (typeOfEmployee == 2) {
                System.out.println("Enter total Salary of Salary Employee: ");
                double totalSalary1 = sc.nextDouble();

                arr[i] = new salaryEmployee(name1, id1, totalSalary1);
            } else if (typeOfEmployee == 3) {
                System.out.println("Enter percentage of commission of commission employee: ");
                int percentage1 = sc.nextInt();
                System.out.println("Enter total sales price of commission employee: ");
                double salesprice1 = sc.nextDouble();

                arr[i] = new commissionEmployee(name1, id1, percentage1, salesprice1);
            }
        }
    }

    public void print(employee[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }
}

class hourlyEmployee extends employee {

    private int perHourRate;
    private int totalHours;

    public hourlyEmployee(String name, String id, int perHourRate, int totalHours) {
        super(name, id);
        this.perHourRate = perHourRate;
        this.totalHours = totalHours;
    }

    @Override
    public double earnings() {
        return perHourRate * totalHours;
    }

    @Override
    public String toString() {
        return super.toString() + " HE {Per hour rate: " + perHourRate + ", Total hours: " + totalHours + " } ";
    }
}

class salaryEmployee extends employee {

    private double totalSalary;

    public salaryEmployee(String name, String id, double totalSalary) {
        super(name, id);
        this.totalSalary = totalSalary;
    }

    @Override
    public double earnings() {
        return totalSalary;
    }

    @Override
    public String toString() {
        return super.toString() + " SE {Total Salary: " + totalSalary + " }";
    }
}

class commissionEmployee extends employee {

    private int percentage;
    private double salesPrice;

    public commissionEmployee(String name, String id, int percentage, double salesPrice) {
        super(name, id);
        this.percentage = percentage;
        this.salesPrice = salesPrice;
    }

    @Override
    public double earnings() {
        return (salesPrice * percentage) / 100;
    }

    @Override
    public String toString() {
        return super.toString() + " CE {Sales Price: " + salesPrice + ", Percentage of commission: " + percentage + " }";
    }
}

public class Polymorphism {

    public static void main(String[] args) {
        double total = 0;

        System.out.println("How many employee's data you want to add?");
        Scanner a = new Scanner(System.in);
        int noOfEmployees = a.nextInt();

        employee[] arr = new employee[noOfEmployees];

        employee emp = new employee();
        emp.main(arr);

        System.out.println("Press 1 for total Employees information\nPress 2 for total paid salary to empolyees\nPress 3 for both");
        System.out.println("> ");
        int b = a.nextInt();
        if (b == 1) {
            emp.print(arr);
        } else if (b == 2) {
            for (int i = 0; i < arr.length; i++) {
                total += arr[i].earnings();
//                System.out.println(arr[i].earnings());
            }
            System.out.println("Total paid to all employees: " + total);
        } else if (b == 3) {
            emp.print(arr);
            for (int i = 0; i < arr.length; i++) {
                total += arr[i].earnings();
//                System.out.println(arr[i].earnings());
            }
            System.out.println("Total paid to all employees: " + total);
        }
    }
}
