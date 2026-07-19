import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private int marks;

    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }
}

public class StudentGradeTracker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {

            System.out.println("\nStudent " + (i + 1));

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            int marks;
            while (true) {
                System.out.print("Enter Marks (0-100): ");
                marks = sc.nextInt();

                if (marks >= 0 && marks <= 100)
                    break;

                System.out.println("Invalid marks! Please enter between 0 and 100.");
            }
            sc.nextLine();

            students.add(new Student(name, marks));
        }

        int total = 0;
        Student highest = students.get(0);
        Student lowest = students.get(0);

        for (Student s : students) {

            total += s.getMarks();

            if (s.getMarks() > highest.getMarks()) {
                highest = s;
            }

            if (s.getMarks() < lowest.getMarks()) {
                lowest = s;
            }
        }

        double average = (double) total / students.size();

        System.out.println("\n========== STUDENT REPORT ==========");
        System.out.printf("%-20s %-10s%n", "Student Name", "Marks");
        System.out.println("------------------------------------");

        for (Student s : students) {
            System.out.printf("%-20s %-10d%n", s.getName(), s.getMarks());
        }

        System.out.println("------------------------------------");
        System.out.printf("Average Marks : %.2f%n", average);
        System.out.println("Highest Marks : " + highest.getMarks() + " (" + highest.getName() + ")");
        System.out.println("Lowest Marks  : " + lowest.getMarks() + " (" + lowest.getName() + ")");

        sc.close();
    }
}