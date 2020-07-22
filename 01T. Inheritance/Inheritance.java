package inheritance;

import java.util.*;

class person {

    private String name;
    private String address;

    public person(String n, String a) {
        name = n;
        address = a;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return ("Name: " + name + "\nAddress: " + address);
    }
}

class student extends person {

    private String program;
    private int year;
    private double fee;

    public student(String name, String address, String p, int y, double f) {
        super(name, address);
        program = p;
        year = y;
        fee = f;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getfee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return (super.toString() + "\nProgram: " + program + "\nYear: " + year + "\nFee: " + fee);
    }
}

class staff extends person {

    private String school;
    private double pay;

    public staff(String name, String address, String s, double p) {
        super(name, address);
        school = s;
        pay = p;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public double getPay() {
        return pay;
    }

    public void setPay(int pay) {
        this.pay = pay;
    }

    @Override
    public String toString() {
        return (super.toString() + "\nSchool: " + school + "\nPay: " + pay);
    }
}

public class Inheritance {

    public static void main(String[] args) {
        boolean flag = true;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the attribute(Student or Staff) you want to add data in?");
            System.out.println("");
            System.out.print("> ");
            String attri = sc.next();

            if ("student".equals(attri)) {

                System.out.print("How many students data you want to add? ");
                int noOfStds = sc.nextInt();
                student[] std = new student[noOfStds];

                for (int i = 0; i < std.length; i++) {
                    Scanner in = new Scanner(System.in);
                    System.out.print("Enter name: ");
                    String name1 = in.nextLine();
                    System.out.print("Enter address: ");
                    String address1 = in.nextLine();
                    System.out.print("Enter program: ");
                    String program1 = in.nextLine();
                    System.out.print("Enter year: ");
                    int year1 = in.nextInt();
                    System.out.print("Enter fee: ");
                    double fee1 = in.nextDouble();

                    student std1 = new student(name1, address1, program1, year1, fee1);
                    System.out.println(std1 + "\n");

                    System.out.println("Do u want to cont ...");
                    char c = in.next().charAt(0);
                    if (c == 'y') {
                        flag = true;
                    } else {
                        flag = false;
                    }
                }
            } else if ("staff".equals(attri)) {
                System.out.print("How many staff data you want to add? ");
                int noOfStaffs = sc.nextInt();
                staff[] staf = new staff[noOfStaffs];
                for (int j = 0; j < staf.length; j++) {
                    Scanner in = new Scanner(System.in);
                    System.out.print("Enter name: ");
                    String name1 = in.nextLine();
                    System.out.print("Enter address: ");
                    String address1 = in.nextLine();
                    System.out.print("Enter school: ");
                    String school1 = in.nextLine();
                    System.out.print("Enter pay: ");
                    double pay1 = in.nextDouble();

                    staff staff1 = new staff(name1, address1, school1, pay1);
                    System.out.println(staff1 + "\n");

                    System.out.println("Do u want to cont ...");
                    char c = in.next().charAt(0);
                    if (c == 'y') {
                        flag = true;
                    } else {
                        flag = false;
                    }
                }

            }

        } while (flag);
    }
}
