package studentmanagement;

public class Student extends Person implements Result {
    private int id;
    private double marks;
    private static int studentCount = 0;

    // Constructor 1
    public Student(int id, String name, int age, double marks) {
        super(name, age);
        this.id = id;
        this.marks = marks;
        studentCount++;
    }

    // Overloaded constructor 2
    public Student(int id, String name, double marks) {
        this(id, name, 18, marks);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getMarks() {
        return marks;
    }

    // Method overloading
    public void updateDetails(String name) {
        this.name = name;
    }

    public void updateDetails(String name, int age, double marks) {
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    @Override
    public String calculateGrade() {
        if (marks >= 90) return "A+";
        if (marks >= 80) return "A";
        if (marks >= 70) return "B";
        if (marks >= 60) return "C";
        if (marks >= 40) return "D";
        return "F";
    }

    @Override
    public void generateResult() {
        System.out.println("----- STUDENT RESULT -----");
        displayDetails();
        System.out.println("Grade: " + calculateGrade());
        System.out.println("Status: " + (marks >= 40 ? "PASS" : "FAIL"));
        System.out.println("--------------------------");
    }

    // Method overloading
    public void displayDetails() {
        System.out.println("Student ID: " + id);
        System.out.println("Name      : " + name);
        System.out.println("Age       : " + age);
        System.out.println("Marks     : " + marks + "/100");
    }

    public void displayDetails(boolean showGrade) {
        displayDetails();
        if (showGrade) {
            System.out.println("Grade     : " + calculateGrade());
        }
    }

    public static int getStudentCount() {
        return studentCount;
    }
}
